package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
@Entity
@Table(name = "product_insurance", schema = "citi", catalog = "")
public class ProductInsurance {
    private long id;
    private String title;
    private Long institution;
    private Byte ageLower;
    private Byte ageUpper;
    private String riskInstruction;
    private BigDecimal maxAmount;
    private BigDecimal minAmount;
    private Integer warrantyPeriod;
    private BigDecimal dayRate;
    private BigDecimal yearRate;
    private Timestamp balanceDate;
    private Byte tradeMinUnit;
    private Byte tradeMaxUnit;
    private Byte payType;
    private BigDecimal payPrice;

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
    @Column(name = "age_lower")
    public Byte getAgeLower() {
        return ageLower;
    }

    public void setAgeLower(Byte ageLower) {
        this.ageLower = ageLower;
    }

    @Basic
    @Column(name = "age_upper")
    public Byte getAgeUpper() {
        return ageUpper;
    }

    public void setAgeUpper(Byte ageUpper) {
        this.ageUpper = ageUpper;
    }

    @Basic
    @Column(name = "risk_instruction")
    public String getRiskInstruction() {
        return riskInstruction;
    }

    public void setRiskInstruction(String riskInstruction) {
        this.riskInstruction = riskInstruction;
    }

    @Basic
    @Column(name = "max_amount")
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Basic
    @Column(name = "min_amount")
    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    @Basic
    @Column(name = "warranty_period")
    public Integer getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(Integer warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
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
    @Column(name = "balance_date")
    public Timestamp getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Timestamp balanceDate) {
        this.balanceDate = balanceDate;
    }

    @Basic
    @Column(name = "trade_min_unit")
    public Byte getTradeMinUnit() {
        return tradeMinUnit;
    }

    public void setTradeMinUnit(Byte tradeMinUnit) {
        this.tradeMinUnit = tradeMinUnit;
    }

    @Basic
    @Column(name = "trade_max_unit")
    public Byte getTradeMaxUnit() {
        return tradeMaxUnit;
    }

    public void setTradeMaxUnit(Byte tradeMaxUnit) {
        this.tradeMaxUnit = tradeMaxUnit;
    }

    @Basic
    @Column(name = "pay_type")
    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    @Basic
    @Column(name = "pay_price")
    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInsurance that = (ProductInsurance) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (institution != null ? !institution.equals(that.institution) : that.institution != null) return false;
        if (ageLower != null ? !ageLower.equals(that.ageLower) : that.ageLower != null) return false;
        if (ageUpper != null ? !ageUpper.equals(that.ageUpper) : that.ageUpper != null) return false;
        if (riskInstruction != null ? !riskInstruction.equals(that.riskInstruction) : that.riskInstruction != null)
            return false;
        if (maxAmount != null ? !maxAmount.equals(that.maxAmount) : that.maxAmount != null) return false;
        if (minAmount != null ? !minAmount.equals(that.minAmount) : that.minAmount != null) return false;
        if (warrantyPeriod != null ? !warrantyPeriod.equals(that.warrantyPeriod) : that.warrantyPeriod != null)
            return false;
        if (dayRate != null ? !dayRate.equals(that.dayRate) : that.dayRate != null) return false;
        if (yearRate != null ? !yearRate.equals(that.yearRate) : that.yearRate != null) return false;
        if (balanceDate != null ? !balanceDate.equals(that.balanceDate) : that.balanceDate != null) return false;
        if (tradeMinUnit != null ? !tradeMinUnit.equals(that.tradeMinUnit) : that.tradeMinUnit != null) return false;
        if (tradeMaxUnit != null ? !tradeMaxUnit.equals(that.tradeMaxUnit) : that.tradeMaxUnit != null) return false;
        if (payType != null ? !payType.equals(that.payType) : that.payType != null) return false;
        if (payPrice != null ? !payPrice.equals(that.payPrice) : that.payPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        result = 31 * result + (ageLower != null ? ageLower.hashCode() : 0);
        result = 31 * result + (ageUpper != null ? ageUpper.hashCode() : 0);
        result = 31 * result + (riskInstruction != null ? riskInstruction.hashCode() : 0);
        result = 31 * result + (maxAmount != null ? maxAmount.hashCode() : 0);
        result = 31 * result + (minAmount != null ? minAmount.hashCode() : 0);
        result = 31 * result + (warrantyPeriod != null ? warrantyPeriod.hashCode() : 0);
        result = 31 * result + (dayRate != null ? dayRate.hashCode() : 0);
        result = 31 * result + (yearRate != null ? yearRate.hashCode() : 0);
        result = 31 * result + (balanceDate != null ? balanceDate.hashCode() : 0);
        result = 31 * result + (tradeMinUnit != null ? tradeMinUnit.hashCode() : 0);
        result = 31 * result + (tradeMaxUnit != null ? tradeMaxUnit.hashCode() : 0);
        result = 31 * result + (payType != null ? payType.hashCode() : 0);
        result = 31 * result + (payPrice != null ? payPrice.hashCode() : 0);
        return result;
    }
}
