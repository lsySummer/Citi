package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.model.ProductBond;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.POJO.AmountAndLeft;
import edu.nju.service.POJO.AssetCategoryAllocation;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.TradeService.TradeItem;
import edu.nju.service.Utils.TimeTransformation;
import edu.nju.service.Utils.UnitTransformation;

import java.util.*;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public class BondInvest implements CategoryInvest{
    public static final String categoryName = "Bond";

    @Override
    public InvestResult invest(UserTemperPrefer userInfo, SearchService searchService, AssetCategoryAllocation allocation) {
        boolean mayRedeem;
        double investTime;
        double capital;
        double interestRatio;

        capital = userInfo.getExpectedCapital().doubleValue();
        mayRedeem = userInfo.getMayRedeemAmount().doubleValue() > 0;
        investTime = TimeTransformation.getTimeFromNow(userInfo.getEndDate(), 'y');
        interestRatio = searchService.getCategoryIndex().getRiskFreeInterest().doubleValue();

        if (mayRedeem) {
            return investMayRedeem(capital, investTime, searchService, interestRatio);
        }
        else {
            return investNoRedeem(capital, investTime, searchService, interestRatio);
        }
    }

    private InvestResult investMayRedeem(double capital, double investTime, SearchService searchService,
                                         double interestRatio) {
        return investModel(capital, investTime, searchService, "", interestRatio);
    }

    private InvestResult investNoRedeem(double capital, double investTime, SearchService searchService,
                                        double interestRatio) {
        return investModel(capital, investTime, searchService, "p.type='固定收益债券'", interestRatio);
    }

    private InvestResult investModel(double capital, double investTime, SearchService searchService, String typeLimit,
                                     double interestRatio) {
        List<Product> productList = null;
        InvestResult investResult = new InvestResult();

        if (investTime <= 1) {
            productList = searchService.searchProductsByCondition(categoryName, typeLimit + " AND p.dateLimit=1");
        }
        else if(investTime > 1 && investTime <= 3) {
            productList = searchService.searchProductsByCondition(categoryName, typeLimit + " AND p.dateLimit BETWEEN 1 AND 3");
        }
        else if(investTime > 3 && investTime <= 5) {
            productList = searchService.searchProductsByCondition(categoryName, typeLimit + " AND p.dateLimit BETWEEN 3 AND 5");
        }
        else if(investTime > 5 && investTime <= 10) {
            productList = searchService.searchProductsByCondition(categoryName, typeLimit + " AND p.dateLimit BETWEEN 5 AND 10");
        }

        List<Product> selectedProductList = selectProducts(productList, interestRatio);

        Product investProduct = findHighestYieldBond(selectedProductList);

        AmountAndLeft amountAndLeft = UnitTransformation.getAmountAndLeft(capital, investProduct);

        investResult.addTradItem(new TradeItem(amountAndLeft.getTradingVolume(), investProduct, null));
        investResult.addUnusedCapital(amountAndLeft.getLeft(), categoryName);

        return investResult;
    }

    private Product findHighestYieldBond(List<Product> productList) {
        Product wanted = productList.get(0);
        for (Product product : productList) {
            if (((ProductBond)product.getProduct()).getAdjustYearlyRate().doubleValue() > ((ProductBond)wanted.getProduct()).getAdjustYearlyRate().doubleValue()) {
                wanted = product;
            }
        }

        return wanted;
    }

    private double getPA(double returnRatio, int timeLimit) {
        double temp = Math.pow(returnRatio + 1, (double)timeLimit);
        temp = 1 / temp;
        temp = 1 - temp;
        temp /= returnRatio;

        return temp;
    }

    private double getPF(double returnRatio, int timeLimit) {
        double temp = Math.pow(returnRatio + 1, (double)timeLimit);
        temp = 1 / temp;
        return temp;
    }

    private List<Product> selectProducts(List<Product> productList, final double interestRatio) {
        List<ICV_Product> list = new ArrayList<>();
        for (Product product : productList) {
            list.add(new ICV_Product(product, interestRatio));
        }

        list.sort(((o1, o2) -> ((Double)o2.getInterestCurrentValue()).compareTo(o1.getInterestCurrentValue())));

        double maxInterestCurrentValue = list.get(0).getInterestCurrentValue();
        List<Product> ret = new ArrayList<>();
        for (ICV_Product icv_product : list) {
            if (icv_product.getInterestCurrentValue() == maxInterestCurrentValue) {
                ret.add(icv_product.getProduct());
            }
            else {
                break;
            }
        }

        return ret;
    }

    private class ICV_Product {
        private double interestCurrentValue;
        private Product product;

        private ICV_Product(Product product, double interestRatio) {
            setProduct(product, interestRatio);
        }

        private double getInterestCurrentValue() {
            return interestCurrentValue;
        }

        public Product getProduct() {
            return product;
        }

        private void setProduct(Product product, double interestRatio) {
            this.product = product;
            interestCurrentValue = calcuInterestCurrentValue((ProductBond) product.getProduct(), interestRatio);
        }
    }

    private double calcuInterestCurrentValue(ProductBond productBond, double interestRatio) {
        boolean ifPayInterest = ProductCategoryManager.getBondInterestType(productBond).equals("附息债");
        boolean ifZeroInterest = ProductCategoryManager.getBondInterestType(productBond).equals("零息债");
        int payFrequency = productBond.getCouponFreq();
        double yearRate = productBond.getAdjustYearlyRate().doubleValue();
        double faceValue = productBond.getDenomination().doubleValue();
        double issuePrice = productBond.getIssuePrice().doubleValue();
        int investTime = productBond.getLength();

        if (ifPayInterest) {
            if (payFrequency == 1) {
                return yearRate * getPA(interestRatio, investTime);
            }
            else if(payFrequency == 2) {
                return yearRate / 2 * getPA(interestRatio, 2 * investTime);
            }
            else {
                if (ifZeroInterest) {
                    return yearRate * investTime * getPF(interestRatio, investTime);
                }
                else {
                    return (faceValue - issuePrice) / issuePrice * getPA(interestRatio, investTime);
                }
            }
        }

        return 0;
    }

    @Override
    public String getCategoryName() {
        return categoryName;
    }
}
