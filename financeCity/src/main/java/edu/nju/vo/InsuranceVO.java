package edu.nju.vo;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class InsuranceVO {
    private int pid;
    private String name;
    private String insurance_lift;
    private int insurance_age;
    private int[] amount_in_force;
    private String way_of_charge;
    private String distributor;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInsurance_lift() {
        return insurance_lift;
    }

    public void setInsurance_lift(String insurance_lift) {
        this.insurance_lift = insurance_lift;
    }

    public int getInsurance_age() {
        return insurance_age;
    }

    public void setInsurance_age(int insurance_age) {
        this.insurance_age = insurance_age;
    }

    public int[] getAmount_in_force() {
        return amount_in_force;
    }

    public void setAmount_in_force(int[] amount_in_force) {
        this.amount_in_force = amount_in_force;
    }

    public String getWay_of_charge() {
        return way_of_charge;
    }

    public void setWay_of_charge(String way_of_charge) {
        this.way_of_charge = way_of_charge;
    }

    public String getDistributor() {
        return distributor;
    }

    public void setDistributor(String distributor) {
        this.distributor = distributor;
    }
}
