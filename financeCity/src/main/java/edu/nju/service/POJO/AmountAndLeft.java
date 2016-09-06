package edu.nju.service.POJO;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
public class AmountAndLeft {
    private double amount;
    private double tradingVolume;
    private double left;
    private String unit;

    public String getUnit() {
        return unit;
    }

    public double getTradingVolume() {
        return tradingVolume;
    }

    public void setTradingVolume(double tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getLeft() {
        return left;
    }

    public void setLeft(double left) {
        this.left = left;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
