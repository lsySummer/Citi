package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
@Entity
@Table(name = "product_bank", schema = "citi", catalog = "")
public class ProductBank {
    private long id;
    private String title;
    private Long institution;
    private Byte type;
    private Integer threshold;
    private BigDecimal increasingAmount;
    private Timestamp dateLimit;
    private Byte incomeType;
    private BigDecimal yearRate;
    private BigDecimal netWorth;
    private Timestamp onSaleDate;
    private Timestamp offSaleDate;
    private Timestamp releaseDate;
    private String salesTerritory;
    private String productCode;
    private String registerCode;
    private String salesCode;
    private Byte currency;
    private Integer investScope;
    private Integer investRate;
    private Integer obejctOriented;
    private BigDecimal expenseSell;
    private BigDecimal expenseManage;
    private String descriptionIncomeSource;
    private String descriptionRiskEvent;
    private BigDecimal mockYearIncomeRate;
    private Byte state;
    private Byte riskGrade;
    private Integer duration;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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
    @Column(name = "institution")
    public Long getInstitution() {
        return institution;
    }

    public void setInstitution(Long institution) {
        this.institution = institution;
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
    public BigDecimal getIncreasingAmount() {
        return increasingAmount;
    }

    public void setIncreasingAmount(BigDecimal increasingAmount) {
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
    @Column(name = "year_rate")
    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
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
    @Column(name = "release_date")
    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = releaseDate;
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
    @Column(name = "sales_code")
    public String getSalesCode() {
        return salesCode;
    }

    public void setSalesCode(String salesCode) {
        this.salesCode = salesCode;
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
    public Integer getInvestScope() {
        return investScope;
    }

    public void setInvestScope(Integer investScope) {
        this.investScope = investScope;
    }

    @Basic
    @Column(name = "invest_rate")
    public Integer getInvestRate() {
        return investRate;
    }

    public void setInvestRate(Integer investRate) {
        this.investRate = investRate;
    }

    @Basic
    @Column(name = "obejct_oriented")
    public Integer getObejctOriented() {
        return obejctOriented;
    }

    public void setObejctOriented(Integer obejctOriented) {
        this.obejctOriented = obejctOriented;
    }

    @Basic
    @Column(name = "expense_sell")
    public BigDecimal getExpenseSell() {
        return expenseSell;
    }

    public void setExpenseSell(BigDecimal expenseSell) {
        this.expenseSell = expenseSell;
    }

    @Basic
    @Column(name = "expense_manage")
    public BigDecimal getExpenseManage() {
        return expenseManage;
    }

    public void setExpenseManage(BigDecimal expenseManage) {
        this.expenseManage = expenseManage;
    }

    @Basic
    @Column(name = "description_income_source")
    public String getDescriptionIncomeSource() {
        return descriptionIncomeSource;
    }

    public void setDescriptionIncomeSource(String descriptionIncomeSource) {
        this.descriptionIncomeSource = descriptionIncomeSource;
    }

    @Basic
    @Column(name = "description_risk_event")
    public String getDescriptionRiskEvent() {
        return descriptionRiskEvent;
    }

    public void setDescriptionRiskEvent(String descriptionRiskEvent) {
        this.descriptionRiskEvent = descriptionRiskEvent;
    }

    @Basic
    @Column(name = "mock_year_income_rate")
    public BigDecimal getMockYearIncomeRate() {
        return mockYearIncomeRate;
    }

    public void setMockYearIncomeRate(BigDecimal mockYearIncomeRate) {
        this.mockYearIncomeRate = mockYearIncomeRate;
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
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductBank that = (ProductBank) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (institution != null ? !institution.equals(that.institution) : that.institution != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (threshold != null ? !threshold.equals(that.threshold) : that.threshold != null) return false;
        if (increasingAmount != null ? !increasingAmount.equals(that.increasingAmount) : that.increasingAmount != null)
            return false;
        if (dateLimit != null ? !dateLimit.equals(that.dateLimit) : that.dateLimit != null) return false;
        if (incomeType != null ? !incomeType.equals(that.incomeType) : that.incomeType != null) return false;
        if (yearRate != null ? !yearRate.equals(that.yearRate) : that.yearRate != null) return false;
        if (netWorth != null ? !netWorth.equals(that.netWorth) : that.netWorth != null) return false;
        if (onSaleDate != null ? !onSaleDate.equals(that.onSaleDate) : that.onSaleDate != null) return false;
        if (offSaleDate != null ? !offSaleDate.equals(that.offSaleDate) : that.offSaleDate != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (salesTerritory != null ? !salesTerritory.equals(that.salesTerritory) : that.salesTerritory != null)
            return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (registerCode != null ? !registerCode.equals(that.registerCode) : that.registerCode != null) return false;
        if (salesCode != null ? !salesCode.equals(that.salesCode) : that.salesCode != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (investScope != null ? !investScope.equals(that.investScope) : that.investScope != null) return false;
        if (investRate != null ? !investRate.equals(that.investRate) : that.investRate != null) return false;
        if (obejctOriented != null ? !obejctOriented.equals(that.obejctOriented) : that.obejctOriented != null)
            return false;
        if (expenseSell != null ? !expenseSell.equals(that.expenseSell) : that.expenseSell != null) return false;
        if (expenseManage != null ? !expenseManage.equals(that.expenseManage) : that.expenseManage != null)
            return false;
        if (descriptionIncomeSource != null ? !descriptionIncomeSource.equals(that.descriptionIncomeSource) : that.descriptionIncomeSource != null)
            return false;
        if (descriptionRiskEvent != null ? !descriptionRiskEvent.equals(that.descriptionRiskEvent) : that.descriptionRiskEvent != null)
            return false;
        if (mockYearIncomeRate != null ? !mockYearIncomeRate.equals(that.mockYearIncomeRate) : that.mockYearIncomeRate != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (riskGrade != null ? !riskGrade.equals(that.riskGrade) : that.riskGrade != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (threshold != null ? threshold.hashCode() : 0);
        result = 31 * result + (increasingAmount != null ? increasingAmount.hashCode() : 0);
        result = 31 * result + (dateLimit != null ? dateLimit.hashCode() : 0);
        result = 31 * result + (incomeType != null ? incomeType.hashCode() : 0);
        result = 31 * result + (yearRate != null ? yearRate.hashCode() : 0);
        result = 31 * result + (netWorth != null ? netWorth.hashCode() : 0);
        result = 31 * result + (onSaleDate != null ? onSaleDate.hashCode() : 0);
        result = 31 * result + (offSaleDate != null ? offSaleDate.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (salesTerritory != null ? salesTerritory.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (registerCode != null ? registerCode.hashCode() : 0);
        result = 31 * result + (salesCode != null ? salesCode.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (investScope != null ? investScope.hashCode() : 0);
        result = 31 * result + (investRate != null ? investRate.hashCode() : 0);
        result = 31 * result + (obejctOriented != null ? obejctOriented.hashCode() : 0);
        result = 31 * result + (expenseSell != null ? expenseSell.hashCode() : 0);
        result = 31 * result + (expenseManage != null ? expenseManage.hashCode() : 0);
        result = 31 * result + (descriptionIncomeSource != null ? descriptionIncomeSource.hashCode() : 0);
        result = 31 * result + (descriptionRiskEvent != null ? descriptionRiskEvent.hashCode() : 0);
        result = 31 * result + (mockYearIncomeRate != null ? mockYearIncomeRate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (riskGrade != null ? riskGrade.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}
