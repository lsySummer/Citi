package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.model.ProductBank;
import edu.nju.service.Exceptions.MissRequiredInfoException;
import edu.nju.service.POJO.AmountAndLeft;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.POJO.Product;
import edu.nju.service.SearchService.ProductManager.ProductFilter;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.TradeService.TradeItem;
import edu.nju.service.Utils.UnitTransformation;

import java.util.*;

/**
 * Created by Sun YuHao on 2016/8/18.
 */
@SuppressWarnings("unchecked")
public class BankInvest implements CategoryInvest {
    static final String categoryName = "Bank";
    static final String paramCapital = "capital";
    static final String paramFlowAmount = "flowAmount";
    static final String paramTimeLimit = "timeLimit";

    private int[] thresholdList = {
            50000, 100000, 200000,
            300000, 500000, 1000000
    };

    private int[] durationList = {
        31, 93, 185, 365
    };

    @Override
    public InvestResult invest(Map<String, Object> metaInfo, SearchService searchService) throws MissRequiredInfoException {
        InvestResult investResult = new InvestResult();

        int threshold = findMinThreshold(searchService);
        metaInfo.put("minThreshold", threshold);

        //invest
        InvestResult flowInvestResult = investFlowAmount(metaInfo, searchService);
        InvestResult leftInvestResult = investLeftAmount(metaInfo, searchService);

        investResult.addInvestResult(flowInvestResult);
        investResult.addInvestResult(leftInvestResult);

        return investResult;
    }

    private Product findMaxYieldProduct(List<Product> products) {
        Product wanted = products.get(0);
        for (Product product : products) {
            if (((ProductBank)product.getProduct()).getYearRate().compareTo(((ProductBank)wanted.getProduct()).getYearRate()) > 0) {
                wanted = product;
            }
        }

        return  wanted;
    }

    private int findMinThreshold(SearchService searchService) {
            return  (int)searchService.searchMin("Product" + categoryName, "threshold");
    }

    private int findMaxThresholdIndex(int flowAmount) {
        return findFloorIndex(flowAmount, thresholdList);
    }

    private int findMaxDurationIndex(int timeLimit) {
        return findFloorIndex(timeLimit, durationList);
    }

    private int findFloorIndex(int target, int[] list) {
        int index = 0;
        for (int i = 0; i < list.length; ++i) {
            if (list[i] > target) {
                break;
            }

            index = i;
        }

        return index;
    }

    private InvestResult investLeftAmount(Map<String, Object> metaInfo, SearchService searchService) throws MissRequiredInfoException {
        int threshold;
        int flowAmount;
        int capital;
        int leftAmount;
        InvestResult investResult = new InvestResult();

        //get meta info
        try {
            capital = (int)metaInfo.get(paramCapital);
            flowAmount = (int)metaInfo.get(paramFlowAmount);
            threshold = (int)metaInfo.get("minThreshold");
        }
        catch (NullPointerException n) {
            n.printStackTrace();
            throw new MissRequiredInfoException(categoryName);
        }

        leftAmount = capital - flowAmount;

        //if can invest (threshold)
        if (threshold > leftAmount) {
            investResult.addUnusedCapital(leftAmount, "leftAmount");
            return investResult;
        }

        //find max floor threshold
        int max_threshold = findMaxThresholdIndex(leftAmount);

        //find candidate products by threshold and time limit
        List<Product> candidateList = null;
        //TODO:make sure that products are selected
        while (max_threshold >= 0) {
            ProductFilter productFilter = new ProductFilter() {
                int leftAmount;
                int floor_threshold;

                @Override
                public boolean isChosen(Object product) {
                    int threshold = ((ProductBank)product).getThreshold();
                    return threshold < leftAmount && threshold > floor_threshold;
                }

                @Override
                public List<String> getSearchScope() {
                    List<String> list = new ArrayList<>();
                    list.add(categoryName);
                    return list;
                }

                public ProductFilter setMetaInfo(int leftAmount, int floor_threshold) {
                    this.leftAmount = leftAmount;
                    this.floor_threshold = floor_threshold;
                    return this;
                }
            }.setMetaInfo(leftAmount, thresholdList[max_threshold]);

            candidateList = searchService.searchProductByFilter(productFilter);
        }

        //TODO:the same
        if (max_threshold < 0) {
            throw new MissRequiredInfoException(categoryName);
        }

        //buy product 1//cash category
        //TODO:check left product
        Product product = findMaxYieldProduct(candidateList);
        ProductBank productFinancingProducts = (ProductBank) product.getProduct();

        Map map = new HashMap();
        map.put("increasingAmount", productFinancingProducts.getIncreasingAmount());
        AmountAndLeft amountAndLeft = UnitTransformation.getAmountAndLeft(leftAmount, "Yuan",
                productFinancingProducts.getThreshold(), map);

        TradeItem tradeItem = new TradeItem((int)amountAndLeft.getAmount(), categoryName, product, null);

        investResult.addTradItem(tradeItem);
        investResult.addUnusedCapital(amountAndLeft.getLeft(), "leftAmount");

        return investResult;
    }

    private InvestResult investFlowAmount(Map<String, Object> metaInfo, SearchService searchService) throws MissRequiredInfoException {
        int threshold;
        int flowAmount;
        int timeLimit;
        InvestResult investResult = new InvestResult();

        //get meta info
        try {
            flowAmount = (int)metaInfo.get(paramFlowAmount);
            threshold = (int)metaInfo.get("minThreshold");
            timeLimit = (int)metaInfo.get(paramTimeLimit);
        }
        catch (NullPointerException n) {
            n.printStackTrace();
            throw new MissRequiredInfoException(categoryName);
        }

        //if can invest (threshold)
        if (threshold > flowAmount) {
            investResult.addUnusedCapital(flowAmount, "flowAmount");
            return investResult;
        }

        //find max threshold and duration for such capital
        int max_threshold = findMaxThresholdIndex(flowAmount);
        int floorDuration = findMaxDurationIndex(timeLimit);

        //find candidate products by threshold and time limit
        List<Product> candidateList = null;
        //TODO:make sure that products are selected
        while (max_threshold >= 0) {
            ProductFilter productFilter = new ProductFilter() {
                int flowAmount;
                int floor_threshold;
                int timeLimit;
                int floorDuration;

                @Override
                public boolean isChosen(Object product) {
                    int threshold = ((ProductBank)product).getThreshold();
                    int duration = ((ProductBank) product).getDuration();
                    return threshold < flowAmount && threshold > floor_threshold &&
                            timeLimit > duration && floorDuration < duration;
                }

                @Override
                public List<String> getSearchScope() {
                    List<String> list = new ArrayList<>();
                    list.add(categoryName);
                    return list;
                }

                public ProductFilter setMetaInfo(int flowAmount, int floor_threshold, int timeLimit, int floorDuration) {
                    this.flowAmount = flowAmount;
                    this.floor_threshold = floor_threshold;
                    this.timeLimit = timeLimit;
                    this.floorDuration = floorDuration;
                    return this;
                }
            }.setMetaInfo(flowAmount, thresholdList[max_threshold], timeLimit, floorDuration);

            candidateList = searchService.searchProductByFilter(productFilter);
        }

        //TODO:the same
        if (max_threshold < 0) {
            throw new MissRequiredInfoException(categoryName);
        }

        //buy product 1//cash category
        //TODO:check left product
        Product product = findMaxYieldProduct(candidateList);
        ProductBank productFinancingProducts = (ProductBank) product.getProduct();

        Map map = new HashMap();
        map.put("increasingAmount", productFinancingProducts.getIncreasingAmount());
        AmountAndLeft amountAndLeft = UnitTransformation.getAmountAndLeft(flowAmount, "Yuan",
                productFinancingProducts.getThreshold(), map);

        TradeItem tradeItem = new TradeItem((int)amountAndLeft.getAmount(), categoryName, product, null);

        investResult.addTradItem(tradeItem);
        investResult.addUnusedCapital(amountAndLeft.getLeft(), "flowAmount");

        return investResult;
    }
}
