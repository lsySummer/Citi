package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Sun YuHao on 2016/9/2.
 */
@Entity
@Table(name = "category_index", schema = "citi", catalog = "")
public class CategoryIndex {
    private int id;
    private BigDecimal fundReturnRate;
    private BigDecimal bondReturnRate;
    private BigDecimal bankReturnRate;
    private BigDecimal insuraceReturnRate;
    private BigDecimal fundMarketValue;
    private BigDecimal bankMarketValue;
    private BigDecimal insuranceMarketValue;
    private BigDecimal bondMarketValue;
    private BigDecimal riskFreeInterest;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fund_return_rate")
    public BigDecimal getFundReturnRate() {
        return fundReturnRate;
    }

    public void setFundReturnRate(BigDecimal fundReturnRate) {
        this.fundReturnRate = fundReturnRate;
    }

    @Basic
    @Column(name = "bond_return_rate")
    public BigDecimal getBondReturnRate() {
        return bondReturnRate;
    }

    public void setBondReturnRate(BigDecimal bondReturnRate) {
        this.bondReturnRate = bondReturnRate;
    }

    @Basic
    @Column(name = "bank_return_rate")
    public BigDecimal getBankReturnRate() {
        return bankReturnRate;
    }

    public void setBankReturnRate(BigDecimal bankReturnRate) {
        this.bankReturnRate = bankReturnRate;
    }

    @Basic
    @Column(name = "insurace_return_rate")
    public BigDecimal getInsuraceReturnRate() {
        return insuraceReturnRate;
    }

    public void setInsuraceReturnRate(BigDecimal insuraceReturnRate) {
        this.insuraceReturnRate = insuraceReturnRate;
    }

    @Basic
    @Column(name = "fund_market_value")
    public BigDecimal getFundMarketValue() {
        return fundMarketValue;
    }

    public void setFundMarketValue(BigDecimal fundMarketValue) {
        this.fundMarketValue = fundMarketValue;
    }

    @Basic
    @Column(name = "bank_market_value")
    public BigDecimal getBankMarketValue() {
        return bankMarketValue;
    }

    public void setBankMarketValue(BigDecimal bankMarketValue) {
        this.bankMarketValue = bankMarketValue;
    }

    @Basic
    @Column(name = "insurance_market_value")
    public BigDecimal getInsuranceMarketValue() {
        return insuranceMarketValue;
    }

    public void setInsuranceMarketValue(BigDecimal insuranceMarketValue) {
        this.insuranceMarketValue = insuranceMarketValue;
    }

    @Basic
    @Column(name = "bond_market_value")
    public BigDecimal getBondMarketValue() {
        return bondMarketValue;
    }

    public void setBondMarketValue(BigDecimal bondMarketValue) {
        this.bondMarketValue = bondMarketValue;
    }

    @Basic
    @Column(name = "risk_free_interest")
    public BigDecimal getRiskFreeInterest() {
        return riskFreeInterest;
    }

    public void setRiskFreeInterest(BigDecimal riskFreeInterest) {
        this.riskFreeInterest = riskFreeInterest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryIndex that = (CategoryIndex) o;

        if (id != that.id) return false;
        if (fundReturnRate != null ? !fundReturnRate.equals(that.fundReturnRate) : that.fundReturnRate != null)
            return false;
        if (bondReturnRate != null ? !bondReturnRate.equals(that.bondReturnRate) : that.bondReturnRate != null)
            return false;
        if (bankReturnRate != null ? !bankReturnRate.equals(that.bankReturnRate) : that.bankReturnRate != null)
            return false;
        if (insuraceReturnRate != null ? !insuraceReturnRate.equals(that.insuraceReturnRate) : that.insuraceReturnRate != null)
            return false;
        if (fundMarketValue != null ? !fundMarketValue.equals(that.fundMarketValue) : that.fundMarketValue != null)
            return false;
        if (bankMarketValue != null ? !bankMarketValue.equals(that.bankMarketValue) : that.bankMarketValue != null)
            return false;
        if (insuranceMarketValue != null ? !insuranceMarketValue.equals(that.insuranceMarketValue) : that.insuranceMarketValue != null)
            return false;
        if (bondMarketValue != null ? !bondMarketValue.equals(that.bondMarketValue) : that.bondMarketValue != null)
            return false;
        if (riskFreeInterest != null ? !riskFreeInterest.equals(that.riskFreeInterest) : that.riskFreeInterest != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fundReturnRate != null ? fundReturnRate.hashCode() : 0);
        result = 31 * result + (bondReturnRate != null ? bondReturnRate.hashCode() : 0);
        result = 31 * result + (bankReturnRate != null ? bankReturnRate.hashCode() : 0);
        result = 31 * result + (insuraceReturnRate != null ? insuraceReturnRate.hashCode() : 0);
        result = 31 * result + (fundMarketValue != null ? fundMarketValue.hashCode() : 0);
        result = 31 * result + (bankMarketValue != null ? bankMarketValue.hashCode() : 0);
        result = 31 * result + (insuranceMarketValue != null ? insuranceMarketValue.hashCode() : 0);
        result = 31 * result + (bondMarketValue != null ? bondMarketValue.hashCode() : 0);
        result = 31 * result + (riskFreeInterest != null ? riskFreeInterest.hashCode() : 0);
        return result;
    }
}
