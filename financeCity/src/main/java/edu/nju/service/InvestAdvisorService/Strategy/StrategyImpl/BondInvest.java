package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.model.ProductBond;
import edu.nju.service.Exceptions.MissRequiredInfoException;
import edu.nju.service.POJO.AmountAndLeft;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.POJO.Product;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.TradeService.TradeItem;
import edu.nju.service.Utils.UnitTransformation;

import java.util.*;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public class BondInvest implements CategoryInvest{
    static final String categoryName = "Bond";
    static final String paramMayRedeem = "MayRedeem";
    static final String paramInvestTime = "investTime";
    static final String paramCapital = "capital";
    static final String paramInterestRatio = "interestRatio";

    @Override
    public InvestResult invest(Map<String, Object> metaInfo, SearchService searchService) throws MissRequiredInfoException {
        boolean mayRedeem;
        int investTime;
        int capital;
        double interestRatio;

        try {
            capital = (int)metaInfo.get(paramCapital);
            mayRedeem = (boolean)metaInfo.get(paramMayRedeem);
            investTime = (int)metaInfo.get(paramInvestTime);
            interestRatio = (double)metaInfo.get(paramInterestRatio);
        }
        catch (NullPointerException n) {
            n.printStackTrace();
            throw new MissRequiredInfoException(categoryName);
        }

        if (mayRedeem) {
            return investMayRedeem(capital, investTime, searchService, interestRatio);
        }
        else {
            return investNoRedeem(capital, investTime, searchService, interestRatio);
        }
    }

    private InvestResult investMayRedeem(int capital, int investTime, SearchService searchService,
                                         double interestRatio) throws MissRequiredInfoException {
        return investModel(capital, investTime, searchService, "", interestRatio);
    }

    private InvestResult investNoRedeem(int capital, int investTime, SearchService searchService,
                                        double interestRatio) throws MissRequiredInfoException {
        return investModel(capital, investTime, searchService, "p.bondType='固定收益债券'", interestRatio);
    }

    private InvestResult investModel(int capital, int investTime, SearchService searchService, String typeLimit,
                                     double interestRatio) throws MissRequiredInfoException {
        List<Product> productList = null;
        InvestResult investResult = new InvestResult();

        if (investTime <= 1) {
            productList = searchService.searchProductsByCondition("Bond", typeLimit + " AND p.dateLimit=1");
        }
        else if(investTime > 1 && investTime <= 3) {
            productList = searchService.searchProductsByCondition("Bond", typeLimit + " AND p.dateLimit BETWEEN 1 AND 3");
        }
        else if(investTime > 3 && investTime <= 5) {
            productList = searchService.searchProductsByCondition("Bond", typeLimit + " AND p.dateLimit BETWEEN 3 AND 5");
        }
        else if(investTime > 5 && investTime <= 10) {
            productList = searchService.searchProductsByCondition("Bond", typeLimit + " AND p.dateLimit BETWEEN 5 AND 10");
        }

        List<Product> selectedProductList = selectProducts(productList, interestRatio);

        Product investProduct = findHighestYieldBond(selectedProductList);

        Map<String, Object> map = new HashMap();
        map.put("price", (((ProductBond)investProduct.getProduct()).getCurrenctValue().doubleValue()));
        AmountAndLeft amountAndLeft = UnitTransformation.getAmountAndLeft(capital, "份", 0, map);
        double tradVolume = capital - amountAndLeft.getLeft();

        investResult.addTradItem(new TradeItem(tradVolume, categoryName, investProduct, null));
        investResult.addUnusedCapital(amountAndLeft.getLeft(), "Bond");

        return investResult;
    }

    private Product findHighestYieldBond(List<Product> productList) {
        Product wanted = productList.get(0);
        for (Product product : productList) {
            if (((ProductBond)product.getProduct()).getYearRate() > ((ProductBond)wanted.getProduct()).getYearRate()) {
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

    private List<Product> selectProducts(List<Product> productList, double interestRatio) {
        List<ICV_Product> list = new ArrayList<>();
        for (Product product : productList) {
            list.add(new ICV_Product(product, interestRatio));
        }

        list.sort(new Comparator<ICV_Product>() {
            @Override
            public int compare(ICV_Product o1, ICV_Product o2) {
                return -((Double)o1.getInterestCurrentValue()).compareTo(o2.getInterestCurrentValue());
            }
        });

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

    class ICV_Product {
        private double interestCurrentValue;
        private Product product;

        public ICV_Product(Product product, double interestRatio) {
            setProduct(product, interestRatio);
        }

        public double getInterestCurrentValue() {
            return interestCurrentValue;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product, double interestRatio) {
            this.product = product;
            interestCurrentValue = calcuInterestCurrentValue((ProductBond) product.getProduct(), interestRatio);
        }
    }

    private double calcuInterestCurrentValue(ProductBond productBond, double interestRatio) {
        boolean ifPayInterest = false;
        boolean ifZeroInterest = false;
        int payFrequency = 0;
        double yearRate = 0;
        int faceValue = 0;
        int issuePrice = 0;
        int investTime = 0;

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
}
