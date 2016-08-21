package edu.nju.service.POJO;

import edu.nju.service.TradeService.TradeItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/18.
 */
public class InvestResult {
    private double unusedAmount = 0;
    private List<TradeItem> tradeItemList;
    private Map<String, Double> unusedCapitalList;

    public InvestResult() {
        tradeItemList = new ArrayList<>();
        unusedCapitalList = new HashMap<>();
    }

    public void addUnusedCapital(double capital, String comment) {
        if (unusedCapitalList.containsKey(comment)) {
            double countAll = capital + unusedCapitalList.get(comment);
            unusedCapitalList.put(comment, countAll);
        }
        else {
            unusedCapitalList.put(comment, capital);
        }

        unusedAmount += capital;
    }

    public void addUnusedCapital(Map<String, Double> unusedCapitalList) {
        for (String comment : unusedCapitalList.keySet()) {
            this.addUnusedCapital(unusedCapitalList.get(comment), comment);
        }
    }

    public void addTradItem(TradeItem tradeItem) {
        tradeItemList.add(tradeItem);
    }

    public void addTradItem(List<TradeItem> tradeItemList) {
        this.tradeItemList.addAll(tradeItemList);
    }

    public double getUnusedAmount() {
        return unusedAmount;
    }

    public List<TradeItem> getTradeItemList() {
        return tradeItemList;
    }

    public Map<String, Double> getUnusedCapitalList() {
        return unusedCapitalList;
    }

    public void addInvestResult(InvestResult investResult) {
        this.addTradItem(investResult.getTradeItemList());

        this.addUnusedCapital(investResult.getUnusedCapitalList());
    }


}
