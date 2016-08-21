package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
@Entity
@Table(name = "product_fund", schema = "citi", catalog = "")
public class ProductFund {
    private int id;
    private String title;
    private String productCode;
    private BigDecimal dayRate;
    private BigDecimal yearRate;
    private Byte fundType;
    private Byte bondState;
    private Timestamp releaseDate;
    private Timestamp establishmentDate;
    private String manager;
    private BigDecimal manageExpense;
    private BigDecimal sellServiceExpenses;
    private BigDecimal maxBuyExpense;
    private BigDecimal maxRedemption;
    private BigDecimal maxApplyBuyExpense;
    private String riskIncomeDescription;
    private BigDecimal fundSize;
    private Integer shareSize;

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
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Basic
    @Column(name = "day_rate")
    public BigDecimal getDayRate() {
        return dayRate;
    }

    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
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
    @Column(name = "fund_type")
    public Byte getFundType() {
        return fundType;
    }

    public void setFundType(Byte fundType) {
        this.fundType = fundType;
    }

    @Basic
    @Column(name = "bond_state")
    public Byte getBondState() {
        return bondState;
    }

    public void setBondState(Byte bondState) {
        this.bondState = bondState;
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
    @Column(name = "establishment_date")
    public Timestamp getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Timestamp establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    @Basic
    @Column(name = "manager")
    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Basic
    @Column(name = "manage_expense")
    public BigDecimal getManageExpense() {
        return manageExpense;
    }

    public void setManageExpense(BigDecimal manageExpense) {
        this.manageExpense = manageExpense;
    }

    @Basic
    @Column(name = "sell_service_expenses")
    public BigDecimal getSellServiceExpenses() {
        return sellServiceExpenses;
    }

    public void setSellServiceExpenses(BigDecimal sellServiceExpenses) {
        this.sellServiceExpenses = sellServiceExpenses;
    }

    @Basic
    @Column(name = "max_buy_expense")
    public BigDecimal getMaxBuyExpense() {
        return maxBuyExpense;
    }

    public void setMaxBuyExpense(BigDecimal maxBuyExpense) {
        this.maxBuyExpense = maxBuyExpense;
    }

    @Basic
    @Column(name = "max_redemption")
    public BigDecimal getMaxRedemption() {
        return maxRedemption;
    }

    public void setMaxRedemption(BigDecimal maxRedemption) {
        this.maxRedemption = maxRedemption;
    }

    @Basic
    @Column(name = "max_apply_buy_expense")
    public BigDecimal getMaxApplyBuyExpense() {
        return maxApplyBuyExpense;
    }

    public void setMaxApplyBuyExpense(BigDecimal maxApplyBuyExpense) {
        this.maxApplyBuyExpense = maxApplyBuyExpense;
    }

    @Basic
    @Column(name = "risk_income_description")
    public String getRiskIncomeDescription() {
        return riskIncomeDescription;
    }

    public void setRiskIncomeDescription(String riskIncomeDescription) {
        this.riskIncomeDescription = riskIncomeDescription;
    }

    @Basic
    @Column(name = "fund_size")
    public BigDecimal getFundSize() {
        return fundSize;
    }

    public void setFundSize(BigDecimal fundSize) {
        this.fundSize = fundSize;
    }

    @Basic
    @Column(name = "share_size")
    public Integer getShareSize() {
        return shareSize;
    }

    public void setShareSize(Integer shareSize) {
        this.shareSize = shareSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductFund that = (ProductFund) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (dayRate != null ? !dayRate.equals(that.dayRate) : that.dayRate != null) return false;
        if (yearRate != null ? !yearRate.equals(that.yearRate) : that.yearRate != null) return false;
        if (fundType != null ? !fundType.equals(that.fundType) : that.fundType != null) return false;
        if (bondState != null ? !bondState.equals(that.bondState) : that.bondState != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (establishmentDate != null ? !establishmentDate.equals(that.establishmentDate) : that.establishmentDate != null)
            return false;
        if (manager != null ? !manager.equals(that.manager) : that.manager != null) return false;
        if (manageExpense != null ? !manageExpense.equals(that.manageExpense) : that.manageExpense != null)
            return false;
        if (sellServiceExpenses != null ? !sellServiceExpenses.equals(that.sellServiceExpenses) : that.sellServiceExpenses != null)
            return false;
        if (maxBuyExpense != null ? !maxBuyExpense.equals(that.maxBuyExpense) : that.maxBuyExpense != null)
            return false;
        if (maxRedemption != null ? !maxRedemption.equals(that.maxRedemption) : that.maxRedemption != null)
            return false;
        if (maxApplyBuyExpense != null ? !maxApplyBuyExpense.equals(that.maxApplyBuyExpense) : that.maxApplyBuyExpense != null)
            return false;
        if (riskIncomeDescription != null ? !riskIncomeDescription.equals(that.riskIncomeDescription) : that.riskIncomeDescription != null)
            return false;
        if (fundSize != null ? !fundSize.equals(that.fundSize) : that.fundSize != null) return false;
        if (shareSize != null ? !shareSize.equals(that.shareSize) : that.shareSize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (dayRate != null ? dayRate.hashCode() : 0);
        result = 31 * result + (yearRate != null ? yearRate.hashCode() : 0);
        result = 31 * result + (fundType != null ? fundType.hashCode() : 0);
        result = 31 * result + (bondState != null ? bondState.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (establishmentDate != null ? establishmentDate.hashCode() : 0);
        result = 31 * result + (manager != null ? manager.hashCode() : 0);
        result = 31 * result + (manageExpense != null ? manageExpense.hashCode() : 0);
        result = 31 * result + (sellServiceExpenses != null ? sellServiceExpenses.hashCode() : 0);
        result = 31 * result + (maxBuyExpense != null ? maxBuyExpense.hashCode() : 0);
        result = 31 * result + (maxRedemption != null ? maxRedemption.hashCode() : 0);
        result = 31 * result + (maxApplyBuyExpense != null ? maxApplyBuyExpense.hashCode() : 0);
        result = 31 * result + (riskIncomeDescription != null ? riskIncomeDescription.hashCode() : 0);
        result = 31 * result + (fundSize != null ? fundSize.hashCode() : 0);
        result = 31 * result + (shareSize != null ? shareSize.hashCode() : 0);
        return result;
    }
}
