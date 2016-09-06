package edu.nju.service.InvestAdvisorService.Strategy.StrategyImpl;

import edu.nju.model.ProductBank;
import edu.nju.model.UserTemperPrefer;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.POJO.AmountAndLeft;
import edu.nju.service.POJO.InvestResult;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.TradeService.TradeItem;
import edu.nju.service.Utils.TimeTransformation;
import edu.nju.service.Utils.UnitTransformation;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Sun YuHao on 2016/8/18.
 */
@SuppressWarnings("unchecked")
public class BankInvest implements CategoryInvest {
    public static final String categoryName = "Bank";

    private int[] thresholdList = {
            50000, 100000, 200000,
            300000, 500000, 1000000
    };

    private int[] durationList = {
        31, 93, 185, 365
    };

    @Override
    public InvestResult invest(UserTemperPrefer userInfo, SearchService searchService) {
        InvestResult investResult = new InvestResult();

        int threshold = findMinThreshold(searchService);

        //invest
        InvestResult flowInvestResult = investFlowAmount(userInfo, searchService, threshold);
        InvestResult leftInvestResult = investLeftAmount(userInfo, searchService, threshold);

        investResult.addInvestResult(flowInvestResult);
        investResult.addInvestResult(leftInvestResult);

        return investResult;
    }

    private Product findMaxYieldProduct(List<Product> products) {
        Product wanted = products.get(0);
        for (Product product : products) {
            if (((ProductBank)product.getProduct()).getExpectedRate().compareTo(((ProductBank)wanted.getProduct()).getExpectedRate()) > 0) {
                wanted = product;
            }
        }

        return  wanted;
    }

    private int findMinThreshold(SearchService searchService) {
            return  (int)searchService.searchMin(categoryName, "threshold");
    }

    private int findMaxThresholdIndex(double flowAmount) {
        return findFloorIndex(flowAmount, thresholdList);
    }

    private int findMaxDurationIndex(double timeLimit) {
        return findFloorIndex(timeLimit, durationList);
    }

    private int findFloorIndex(double target, int[] list) {
        int index = 0;
        for (int i = 0; i < list.length; ++i) {
            if (list[i] > target) {
                break;
            }

            index = i;
        }

        return index;
    }

    private InvestResult investLeftAmount(UserTemperPrefer userInfo, SearchService searchService, int threshold) {
        double flowAmount;
        double capital;
        double leftAmount;
        InvestResult investResult = new InvestResult();

        capital = userInfo.getExpectedCapital().doubleValue();
        flowAmount = capital - userInfo.getMayRedeemAmount().doubleValue();

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
        while (max_threshold >= 0) {
            candidateList = searchService.searchProductsByCondition(categoryName, "p.threshold BETWEEN " + thresholdList[max_threshold] +
            " AND " + leftAmount);

            if (candidateList != null) {
                break;
            }

            max_threshold--;
        }

        if (max_threshold < 0) {
            InvestResult investResult1 = new InvestResult();
            investResult1.addUnusedCapital(capital, categoryName);
            return investResult1;
        }

        Product product = findMaxYieldProduct(candidateList);

        AmountAndLeft amountAndLeft = UnitTransformation.getAmountAndLeft(leftAmount, product);

        TradeItem tradeItem = new TradeItem(amountAndLeft.getTradingVolume(), categoryName, product, null);

        investResult.addTradItem(tradeItem);
        investResult.addUnusedCapital(amountAndLeft.getLeft(), categoryName + "leftAmount");
        return investResult;
    }

    private InvestResult investFlowAmount(UserTemperPrefer userInfo, SearchService searchService, int threshold) {
        double flowAmount;
        double timeLimit;
        InvestResult investResult = new InvestResult();

        //get meta info
        double capital = userInfo.getExpectedCapital().doubleValue();
        flowAmount = userInfo.getExpectedCapital().doubleValue() - userInfo.getMayRedeemAmount().doubleValue();
        timeLimit = TimeTransformation.getTimeFromNow(userInfo.getEndDate(), 'y');

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

        while (floorDuration >= 0) {
            candidateList = searchService.searchProductsByCondition(categoryName, "p.threshold BETWEEN " + thresholdList[max_threshold] + " AND " +
            flowAmount + " AND p.dateLimit BETWEEN " + durationList[floorDuration] + " AND " + timeLimit);

            if (candidateList != null) {
                break;
            }

            if (max_threshold > 0) {
                max_threshold--;
            }
            else {
                floorDuration--;
            }
        }

        if (floorDuration < 0) {
            InvestResult investResult1 = new InvestResult();
            investResult1.addUnusedCapital(capital, categoryName);
            return investResult1;
        }

        Product product = findMaxYieldProduct(candidateList);

        AmountAndLeft amountAndLeft = UnitTransformation.getAmountAndLeft(flowAmount, product);

        TradeItem tradeItem = new TradeItem(amountAndLeft.getTradingVolume(), categoryName, product, null);

        investResult.addTradItem(tradeItem);
        investResult.addUnusedCapital(amountAndLeft.getLeft(), categoryName + "flowAmount");

        return investResult;
    }

    @Override
    public String getCategoryName() {
        return categoryName;
    }
}
