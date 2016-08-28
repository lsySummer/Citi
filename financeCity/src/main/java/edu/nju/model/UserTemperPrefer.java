package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/27.
 */
@Entity
@Table(name = "user_temper_prefer", schema = "citi", catalog = "")
public class UserTemperPrefer {
    private int userId;
    private BigDecimal expectedCapital;
    private Timestamp endDate;
    private BigDecimal stopProfit;
    private Byte ifBigExpense;
    private BigDecimal mayRedeemAmount;
    private Timestamp redeemTime;
    private BigDecimal insuranceAmount;
    private Byte expenseType;
    private BigDecimal riskViolence;
    private BigDecimal expectedRetrunRate;
    private Byte ifConfigBigExpense;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "expected_capital")
    public BigDecimal getExpectedCapital() {
        return expectedCapital;
    }

    public void setExpectedCapital(BigDecimal expectedCapital) {
        this.expectedCapital = expectedCapital;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "stop_profit")
    public BigDecimal getStopProfit() {
        return stopProfit;
    }

    public void setStopProfit(BigDecimal stopProfit) {
        this.stopProfit = stopProfit;
    }

    @Basic
    @Column(name = "if_big_expense")
    public Byte getIfBigExpense() {
        return ifBigExpense;
    }

    public void setIfBigExpense(Byte ifBigExpense) {
        this.ifBigExpense = ifBigExpense;
    }

    @Basic
    @Column(name = "may_redeem_amount")
    public BigDecimal getMayRedeemAmount() {
        return mayRedeemAmount;
    }

    public void setMayRedeemAmount(BigDecimal mayRedeemAmount) {
        this.mayRedeemAmount = mayRedeemAmount;
    }

    @Basic
    @Column(name = "redeem_time")
    public Timestamp getRedeemTime() {
        return redeemTime;
    }

    public void setRedeemTime(Timestamp redeemTime) {
        this.redeemTime = redeemTime;
    }

    @Basic
    @Column(name = "insurance_amount")
    public BigDecimal getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(BigDecimal insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    @Basic
    @Column(name = "expense_type")
    public Byte getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(Byte expenseType) {
        this.expenseType = expenseType;
    }

    @Basic
    @Column(name = "risk_violence")
    public BigDecimal getRiskViolence() {
        return riskViolence;
    }

    public void setRiskViolence(BigDecimal riskViolence) {
        this.riskViolence = riskViolence;
    }

    @Basic
    @Column(name = "expected_retrun_rate")
    public BigDecimal getExpectedRetrunRate() {
        return expectedRetrunRate;
    }

    public void setExpectedRetrunRate(BigDecimal expectedRetrunRate) {
        this.expectedRetrunRate = expectedRetrunRate;
    }

    @Basic
    @Column(name = "if_config_big_expense")
    public Byte getIfConfigBigExpense() {
        return ifConfigBigExpense;
    }

    public void setIfConfigBigExpense(Byte ifConfigBigExpense) {
        this.ifConfigBigExpense = ifConfigBigExpense;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTemperPrefer that = (UserTemperPrefer) o;

        if (userId != that.userId) return false;
        if (expectedCapital != null ? !expectedCapital.equals(that.expectedCapital) : that.expectedCapital != null)
            return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (stopProfit != null ? !stopProfit.equals(that.stopProfit) : that.stopProfit != null) return false;
        if (ifBigExpense != null ? !ifBigExpense.equals(that.ifBigExpense) : that.ifBigExpense != null) return false;
        if (mayRedeemAmount != null ? !mayRedeemAmount.equals(that.mayRedeemAmount) : that.mayRedeemAmount != null)
            return false;
        if (redeemTime != null ? !redeemTime.equals(that.redeemTime) : that.redeemTime != null) return false;
        if (insuranceAmount != null ? !insuranceAmount.equals(that.insuranceAmount) : that.insuranceAmount != null)
            return false;
        if (expenseType != null ? !expenseType.equals(that.expenseType) : that.expenseType != null) return false;
        if (riskViolence != null ? !riskViolence.equals(that.riskViolence) : that.riskViolence != null) return false;
        if (expectedRetrunRate != null ? !expectedRetrunRate.equals(that.expectedRetrunRate) : that.expectedRetrunRate != null)
            return false;
        if (ifConfigBigExpense != null ? !ifConfigBigExpense.equals(that.ifConfigBigExpense) : that.ifConfigBigExpense != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (expectedCapital != null ? expectedCapital.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (stopProfit != null ? stopProfit.hashCode() : 0);
        result = 31 * result + (ifBigExpense != null ? ifBigExpense.hashCode() : 0);
        result = 31 * result + (mayRedeemAmount != null ? mayRedeemAmount.hashCode() : 0);
        result = 31 * result + (redeemTime != null ? redeemTime.hashCode() : 0);
        result = 31 * result + (insuranceAmount != null ? insuranceAmount.hashCode() : 0);
        result = 31 * result + (expenseType != null ? expenseType.hashCode() : 0);
        result = 31 * result + (riskViolence != null ? riskViolence.hashCode() : 0);
        result = 31 * result + (expectedRetrunRate != null ? expectedRetrunRate.hashCode() : 0);
        result = 31 * result + (ifConfigBigExpense != null ? ifConfigBigExpense.hashCode() : 0);
        return result;
    }
}
