package edu.nju.vo;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class BondVO {
    private Integer productId;
    private String productType;
    private Integer pid;
    private String name;
    private Double yearly_interest_rate;
    private Double nominal_interest_rate;
    private Integer life;
    private String type;
    private String code;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getYearly_interest_rate() {
        return yearly_interest_rate;
    }

    public void setYearly_interest_rate(Double yearly_interest_rate) {
        this.yearly_interest_rate = yearly_interest_rate;
    }

    public Double getNominal_interest_rate() {
        return nominal_interest_rate;
    }

    public void setNominal_interest_rate(Double nominal_interest_rate) {
        this.nominal_interest_rate = nominal_interest_rate;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
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
