package edu.nju.service.POJO;

/**
 * Created by Sun YuHao on 2016/9/15.
 */
public class CommonProductInfo {
    private int id;
    private double amount;
    private String name;
    private String productType;
    private double percentage;
    private boolean risk;
    private int length;
    private boolean flow;
    private double Rtr;

    public boolean isFlow() {
        return flow;
    }

    public void setFlow(boolean flow) {
        this.flow = flow;
    }

    public double getRtr() {
        return Rtr;
    }

    public void setRtr(double rtr) {
        Rtr = rtr;
    }

    public boolean isRisk() {
        return risk;
    }

    public void setRisk(boolean risk) {
        this.risk = risk;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
