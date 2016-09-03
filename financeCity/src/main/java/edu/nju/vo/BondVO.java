package edu.nju.vo;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class BondVO {
    int pid;
    String name;
    double yearly_interest_rate;
    double nominal_interest_rate;
    int life;
    String type;
    String code;

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

    public double getYearly_interest_rate() {
        return yearly_interest_rate;
    }

    public void setYearly_interest_rate(double yearly_interest_rate) {
        this.yearly_interest_rate = yearly_interest_rate;
    }

    public double getNominal_interest_rate() {
        return nominal_interest_rate;
    }

    public void setNominal_interest_rate(double nominal_interest_rate) {
        this.nominal_interest_rate = nominal_interest_rate;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
