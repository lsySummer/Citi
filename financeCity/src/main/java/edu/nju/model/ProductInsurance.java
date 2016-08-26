package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/21.
 */
@Entity
@Table(name = "product_insurance", schema = "citi", catalog = "")
public class ProductInsurance {
    private int id;
    private String title;
    private Long institution;
    private String riskDesctiption;
    private Integer warrantyPeriod;
    private Integer denomination;
    private Integer indemnityPerUnit;
    private Integer indemnity;
    private BigDecimal dayRate;
    private BigDecimal yearRate;
    private Integer dateLimit;
    private Byte payType;
    private Timestamp dayBuy;
    private Timestamp dayDue;
    private BigDecimal expectedRate;
    private BigDecimal guaranteedRate;
    private Integer productPeriod;
    private String abbreviation;

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
    @Column(name = "institution")
    public Long getInstitution() {
        return institution;
    }

    public void setInstitution(Long institution) {
        this.institution = institution;
    }

    @Basic
    @Column(name = "risk_desctiption")
    public String getRiskDesctiption() {
        return riskDesctiption;
    }

    public void setRiskDesctiption(String riskDesctiption) {
        this.riskDesctiption = riskDesctiption;
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
    @Column(name = "denomination")
    public Integer getDenomination() {
        return denomination;
    }

    public void setDenomination(Integer denomination) {
        this.denomination = denomination;
    }

    @Basic
    @Column(name = "indemnity_per_unit")
    public Integer getIndemnityPerUnit() {
        return indemnityPerUnit;
    }

    public void setIndemnityPerUnit(Integer indemnityPerUnit) {
        this.indemnityPerUnit = indemnityPerUnit;
    }

    @Basic
    @Column(name = "indemnity")
    public Integer getIndemnity() {
        return indemnity;
    }

    public void setIndemnity(Integer indemnity) {
        this.indemnity = indemnity;
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
    @Column(name = "date_limit")
    public Integer getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Integer dateLimit) {
        this.dateLimit = dateLimit;
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
    @Column(name = "day_buy")
    public Timestamp getDayBuy() {
        return dayBuy;
    }

    public void setDayBuy(Timestamp dayBuy) {
        this.dayBuy = dayBuy;
    }

    @Basic
    @Column(name = "day_due")
    public Timestamp getDayDue() {
        return dayDue;
    }

    public void setDayDue(Timestamp dayDue) {
        this.dayDue = dayDue;
    }

    @Basic
    @Column(name = "expected_rate")
    public BigDecimal getExpectedRate() {
        return expectedRate;
    }

    public void setExpectedRate(BigDecimal expectedRate) {
        this.expectedRate = expectedRate;
    }

    @Basic
    @Column(name = "guaranteed_rate")
    public BigDecimal getGuaranteedRate() {
        return guaranteedRate;
    }

    public void setGuaranteedRate(BigDecimal guaranteedRate) {
        this.guaranteedRate = guaranteedRate;
    }

    @Basic
    @Column(name = "product_period")
    public Integer getProductPeriod() {
        return productPeriod;
    }

    public void setProductPeriod(Integer productPeriod) {
        this.productPeriod = productPeriod;
    }

    @Basic
    @Column(name = "abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInsurance that = (ProductInsurance) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (institution != null ? !institution.equals(that.institution) : that.institution != null) return false;
        if (riskDesctiption != null ? !riskDesctiption.equals(that.riskDesctiption) : that.riskDesctiption != null)
            return false;
        if (warrantyPeriod != null ? !warrantyPeriod.equals(that.warrantyPeriod) : that.warrantyPeriod != null)
            return false;
        if (denomination != null ? !denomination.equals(that.denomination) : that.denomination != null) return false;
        if (indemnityPerUnit != null ? !indemnityPerUnit.equals(that.indemnityPerUnit) : that.indemnityPerUnit != null)
            return false;
        if (indemnity != null ? !indemnity.equals(that.indemnity) : that.indemnity != null) return false;
        if (dayRate != null ? !dayRate.equals(that.dayRate) : that.dayRate != null) return false;
        if (yearRate != null ? !yearRate.equals(that.yearRate) : that.yearRate != null) return false;
        if (dateLimit != null ? !dateLimit.equals(that.dateLimit) : that.dateLimit != null) return false;
        if (payType != null ? !payType.equals(that.payType) : that.payType != null) return false;
        if (dayBuy != null ? !dayBuy.equals(that.dayBuy) : that.dayBuy != null) return false;
        if (dayDue != null ? !dayDue.equals(that.dayDue) : that.dayDue != null) return false;
        if (expectedRate != null ? !expectedRate.equals(that.expectedRate) : that.expectedRate != null) return false;
        if (guaranteedRate != null ? !guaranteedRate.equals(that.guaranteedRate) : that.guaranteedRate != null)
            return false;
        if (productPeriod != null ? !productPeriod.equals(that.productPeriod) : that.productPeriod != null)
            return false;
        if (abbreviation != null ? !abbreviation.equals(that.abbreviation) : that.abbreviation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        result = 31 * result + (riskDesctiption != null ? riskDesctiption.hashCode() : 0);
        result = 31 * result + (warrantyPeriod != null ? warrantyPeriod.hashCode() : 0);
        result = 31 * result + (denomination != null ? denomination.hashCode() : 0);
        result = 31 * result + (indemnityPerUnit != null ? indemnityPerUnit.hashCode() : 0);
        result = 31 * result + (indemnity != null ? indemnity.hashCode() : 0);
        result = 31 * result + (dayRate != null ? dayRate.hashCode() : 0);
        result = 31 * result + (yearRate != null ? yearRate.hashCode() : 0);
        result = 31 * result + (dateLimit != null ? dateLimit.hashCode() : 0);
        result = 31 * result + (payType != null ? payType.hashCode() : 0);
        result = 31 * result + (dayBuy != null ? dayBuy.hashCode() : 0);
        result = 31 * result + (dayDue != null ? dayDue.hashCode() : 0);
        result = 31 * result + (expectedRate != null ? expectedRate.hashCode() : 0);
        result = 31 * result + (guaranteedRate != null ? guaranteedRate.hashCode() : 0);
        result = 31 * result + (productPeriod != null ? productPeriod.hashCode() : 0);
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        return result;
    }
}
