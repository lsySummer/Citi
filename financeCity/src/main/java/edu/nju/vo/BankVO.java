package edu.nju.vo;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class BankVO {
    private Integer productId;
    private String productType;
    private Integer pid;
    private String name;
    private Double yearly_income_rate;
    private String product_type;
    private String income_type;
    private Integer initial_money;
    private String open_date;
    private String distributor_bank;
    private String distributor_institution;

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

    public Double getYearly_income_rate() {
        return yearly_income_rate;
    }

    public void setYearly_income_rate(Double yearly_income_rate) {
        this.yearly_income_rate = yearly_income_rate;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getIncome_type() {
        return income_type;
    }

    public void setIncome_type(String income_type) {
        this.income_type = income_type;
    }

    public Integer getInitial_money() {
        return initial_money;
    }

    public void setInitial_money(Integer initial_money) {
        this.initial_money = initial_money;
    }

    public String getOpen_date() {
        return open_date;
    }

    public void setOpen_date(String open_date) {
        this.open_date = open_date;
    }

    public String getDistributor_bank() {
        return distributor_bank;
    }

    public void setDistributor_bank(String distributor_bank) {
        this.distributor_bank = distributor_bank;
    }

    public String getDistributor_institution() {
        return distributor_institution;
    }

    public void setDistributor_institution(String distributor_institution) {
        this.distributor_institution = distributor_institution;
    }
}
