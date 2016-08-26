package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/21.
 */
@Entity
@Table(name = "product_bank", schema = "citi", catalog = "")
public class ProductBank {
    private int id;
    private String title;
    private Long institutionManage;
    private Byte type;
    private Integer threshold;
    private Integer increasingAmount;
    private Timestamp dateLimit;
    private Byte incomeType;
    private BigDecimal netWorth;
    private Timestamp onSaleDate;
    private Timestamp offSaleDate;
    private String salesTerritory;
    private String productCode;
    private String registerCode;
    private Byte currency;
    private String investScope;
    private BigDecimal investRate;
    private Byte state;
    private Byte riskGrade;
    private String productPeriod;
    private String institutionTrusteeship;
    private BigDecimal expectedYearRate;
    private BigDecimal rateApplyBuy;
    private BigDecimal rateRedemption;
    private BigDecimal rateManage;
    private Timestamp startInterestDate;
    private Timestamp onRedemptionDate;
    private Integer redemptionRate;
    private String scopeUpper;
    private String cashedWay;
    private String objectOriented;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "institution_manage")
    public Long getInstitutionManage() {
        return institutionManage;
    }

    public void setInstitutionManage(Long institutionManage) {
        this.institutionManage = institutionManage;
    }

    @Basic
    @Column(name = "type")
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "threshold")
    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    @Basic
    @Column(name = "increasing_amount")
    public Integer getIncreasingAmount() {
        return increasingAmount;
    }

    public void setIncreasingAmount(Integer increasingAmount) {
        this.increasingAmount = increasingAmount;
    }

    @Basic
    @Column(name = "date_limit")
    public Timestamp getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Timestamp dateLimit) {
        this.dateLimit = dateLimit;
    }

    @Basic
    @Column(name = "income_type")
    public Byte getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(Byte incomeType) {
        this.incomeType = incomeType;
    }

    @Basic
    @Column(name = "net_worth")
    public BigDecimal getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(BigDecimal netWorth) {
        this.netWorth = netWorth;
    }

    @Basic
    @Column(name = "on_sale_date")
    public Timestamp getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Timestamp onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    @Basic
    @Column(name = "off_sale_date")
    public Timestamp getOffSaleDate() {
        return offSaleDate;
    }

    public void setOffSaleDate(Timestamp offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    @Basic
    @Column(name = "sales_territory")
    public String getSalesTerritory() {
        return salesTerritory;
    }

    public void setSalesTerritory(String salesTerritory) {
        this.salesTerritory = salesTerritory;
    }

    @Basic
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "register_code")
    public String getRegisterCode() {
        return registerCode;
    }

    public void setRegisterCode(String registerCode) {
        this.registerCode = registerCode;
    }

    @Basic
    @Column(name = "currency")
    public Byte getCurrency() {
        return currency;
    }

    public void setCurrency(Byte currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "invest_scope")
    public String getInvestScope() {
        return investScope;
    }

    public void setInvestScope(String investScope) {
        this.investScope = investScope;
    }

    @Basic
    @Column(name = "invest_rate")
    public BigDecimal getInvestRate() {
        return investRate;
    }

    public void setInvestRate(BigDecimal investRate) {
        this.investRate = investRate;
    }

    @Basic
    @Column(name = "state")
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Basic
    @Column(name = "risk_grade")
    public Byte getRiskGrade() {
        return riskGrade;
    }

    public void setRiskGrade(Byte riskGrade) {
        this.riskGrade = riskGrade;
    }

    @Basic
    @Column(name = "product_period")
    public String getProductPeriod() {
        return productPeriod;
    }

    public void setProductPeriod(String productPeriod) {
        this.productPeriod = productPeriod;
    }

    @Basic
    @Column(name = "institution_trusteeship")
    public String getInstitutionTrusteeship() {
        return institutionTrusteeship;
    }

    public void setInstitutionTrusteeship(String institutionTrusteeship) {
        this.institutionTrusteeship = institutionTrusteeship;
    }

    @Basic
    @Column(name = "expected_year_rate")
    public BigDecimal getExpectedYearRate() {
        return expectedYearRate;
    }

    public void setExpectedYearRate(BigDecimal expectedYearRate) {
        this.expectedYearRate = expectedYearRate;
    }

    @Basic
    @Column(name = "rate_apply_buy")
    public BigDecimal getRateApplyBuy() {
        return rateApplyBuy;
    }

    public void setRateApplyBuy(BigDecimal rateApplyBuy) {
        this.rateApplyBuy = rateApplyBuy;
    }

    @Basic
    @Column(name = "rate_redemption")
    public BigDecimal getRateRedemption() {
        return rateRedemption;
    }

    public void setRateRedemption(BigDecimal rateRedemption) {
        this.rateRedemption = rateRedemption;
    }

    @Basic
    @Column(name = "rate_manage")
    public BigDecimal getRateManage() {
        return rateManage;
    }

    public void setRateManage(BigDecimal rateManage) {
        this.rateManage = rateManage;
    }

    @Basic
    @Column(name = "start_interest_date")
    public Timestamp getStartInterestDate() {
        return startInterestDate;
    }

    public void setStartInterestDate(Timestamp startInterestDate) {
        this.startInterestDate = startInterestDate;
    }

    @Basic
    @Column(name = "on_redemption_date")
    public Timestamp getOnRedemptionDate() {
        return onRedemptionDate;
    }

    public void setOnRedemptionDate(Timestamp onRedemptionDate) {
        this.onRedemptionDate = onRedemptionDate;
    }

    @Basic
    @Column(name = "redemption_rate")
    public Integer getRedemptionRate() {
        return redemptionRate;
    }

    public void setRedemptionRate(Integer redemptionRate) {
        this.redemptionRate = redemptionRate;
    }

    @Basic
    @Column(name = "scope_upper")
    public String getScopeUpper() {
        return scopeUpper;
    }

    public void setScopeUpper(String scopeUpper) {
        this.scopeUpper = scopeUpper;
    }

    @Basic
    @Column(name = "cashed_way")
    public String getCashedWay() {
        return cashedWay;
    }

    public void setCashedWay(String cashedWay) {
        this.cashedWay = cashedWay;
    }

    @Basic
    @Column(name = "object_oriented")
    public String getObjectOriented() {
        return objectOriented;
    }

    public void setObjectOriented(String objectOriented) {
        this.objectOriented = objectOriented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductBank that = (ProductBank) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (institutionManage != null ? !institutionManage.equals(that.institutionManage) : that.institutionManage != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (threshold != null ? !threshold.equals(that.threshold) : that.threshold != null) return false;
        if (increasingAmount != null ? !increasingAmount.equals(that.increasingAmount) : that.increasingAmount != null)
            return false;
        if (dateLimit != null ? !dateLimit.equals(that.dateLimit) : that.dateLimit != null) return false;
        if (incomeType != null ? !incomeType.equals(that.incomeType) : that.incomeType != null) return false;
        if (netWorth != null ? !netWorth.equals(that.netWorth) : that.netWorth != null) return false;
        if (onSaleDate != null ? !onSaleDate.equals(that.onSaleDate) : that.onSaleDate != null) return false;
        if (offSaleDate != null ? !offSaleDate.equals(that.offSaleDate) : that.offSaleDate != null) return false;
        if (salesTerritory != null ? !salesTerritory.equals(that.salesTerritory) : that.salesTerritory != null)
            return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (registerCode != null ? !registerCode.equals(that.registerCode) : that.registerCode != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (investScope != null ? !investScope.equals(that.investScope) : that.investScope != null) return false;
        if (investRate != null ? !investRate.equals(that.investRate) : that.investRate != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (riskGrade != null ? !riskGrade.equals(that.riskGrade) : that.riskGrade != null) return false;
        if (productPeriod != null ? !productPeriod.equals(that.productPeriod) : that.productPeriod != null)
            return false;
        if (institutionTrusteeship != null ? !institutionTrusteeship.equals(that.institutionTrusteeship) : that.institutionTrusteeship != null)
            return false;
        if (expectedYearRate != null ? !expectedYearRate.equals(that.expectedYearRate) : that.expectedYearRate != null)
            return false;
        if (rateApplyBuy != null ? !rateApplyBuy.equals(that.rateApplyBuy) : that.rateApplyBuy != null) return false;
        if (rateRedemption != null ? !rateRedemption.equals(that.rateRedemption) : that.rateRedemption != null)
            return false;
        if (rateManage != null ? !rateManage.equals(that.rateManage) : that.rateManage != null) return false;
        if (startInterestDate != null ? !startInterestDate.equals(that.startInterestDate) : that.startInterestDate != null)
            return false;
        if (onRedemptionDate != null ? !onRedemptionDate.equals(that.onRedemptionDate) : that.onRedemptionDate != null)
            return false;
        if (redemptionRate != null ? !redemptionRate.equals(that.redemptionRate) : that.redemptionRate != null)
            return false;
        if (scopeUpper != null ? !scopeUpper.equals(that.scopeUpper) : that.scopeUpper != null) return false;
        if (cashedWay != null ? !cashedWay.equals(that.cashedWay) : that.cashedWay != null) return false;
        if (objectOriented != null ? !objectOriented.equals(that.objectOriented) : that.objectOriented != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (institutionManage != null ? institutionManage.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (threshold != null ? threshold.hashCode() : 0);
        result = 31 * result + (increasingAmount != null ? increasingAmount.hashCode() : 0);
        result = 31 * result + (dateLimit != null ? dateLimit.hashCode() : 0);
        result = 31 * result + (incomeType != null ? incomeType.hashCode() : 0);
        result = 31 * result + (netWorth != null ? netWorth.hashCode() : 0);
        result = 31 * result + (onSaleDate != null ? onSaleDate.hashCode() : 0);
        result = 31 * result + (offSaleDate != null ? offSaleDate.hashCode() : 0);
        result = 31 * result + (salesTerritory != null ? salesTerritory.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (registerCode != null ? registerCode.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (investScope != null ? investScope.hashCode() : 0);
        result = 31 * result + (investRate != null ? investRate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (riskGrade != null ? riskGrade.hashCode() : 0);
        result = 31 * result + (productPeriod != null ? productPeriod.hashCode() : 0);
        result = 31 * result + (institutionTrusteeship != null ? institutionTrusteeship.hashCode() : 0);
        result = 31 * result + (expectedYearRate != null ? expectedYearRate.hashCode() : 0);
        result = 31 * result + (rateApplyBuy != null ? rateApplyBuy.hashCode() : 0);
        result = 31 * result + (rateRedemption != null ? rateRedemption.hashCode() : 0);
        result = 31 * result + (rateManage != null ? rateManage.hashCode() : 0);
        result = 31 * result + (startInterestDate != null ? startInterestDate.hashCode() : 0);
        result = 31 * result + (onRedemptionDate != null ? onRedemptionDate.hashCode() : 0);
        result = 31 * result + (redemptionRate != null ? redemptionRate.hashCode() : 0);
        result = 31 * result + (scopeUpper != null ? scopeUpper.hashCode() : 0);
        result = 31 * result + (cashedWay != null ? cashedWay.hashCode() : 0);
        result = 31 * result + (objectOriented != null ? objectOriented.hashCode() : 0);
        return result;
    }
}
