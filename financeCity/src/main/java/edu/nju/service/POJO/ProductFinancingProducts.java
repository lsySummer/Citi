package edu.nju.service.POJO;

/**
 * Created by Sun YuHao on 2016/8/18.
 */
public class ProductFinancingProducts {
    private int id;
    private int increasingAmount;
    private String unit;
    private double yield;
    private int threshold;
    private double price;
    private int duration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getIncreasingAmount() {
        return increasingAmount;
    }

    public void setIncreasingAmount(int increasingAmount) {
        this.increasingAmount = increasingAmount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        this.yield = yield;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
