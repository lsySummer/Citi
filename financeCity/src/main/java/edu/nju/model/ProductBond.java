package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/20.
 */
@Entity
@Table(name = "product_bond", schema = "citi", catalog = "")
public class ProductBond {
    private int id;
    private String title;
    private Long institution;
    private String productCode;
    private Timestamp releaseDate;
    private Timestamp onSaleDate;
    private Timestamp offSaleDate;
    private Timestamp cashedDate;
    private Timestamp startInterestDate;
    private Timestamp dateLimit;
    private Byte releaseType;
    private Byte releaseObject;
    private Byte subscribedObject;
    private String guarantor;
    private String whereIntoMarket;
    private Byte creditGrade;
    private Long underwritingInstitution;
    private Byte bondType;
    private BigDecimal denomination;
    private BigDecimal releasePrice;
    private BigDecimal currenctValue;
    private Integer yearRate;
    private BigDecimal dayRate;

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
    @Column(name = "product_code")
    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
    @Column(name = "cashed_date")
    public Timestamp getCashedDate() {
        return cashedDate;
    }

    public void setCashedDate(Timestamp cashedDate) {
        this.cashedDate = cashedDate;
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
    @Column(name = "date_limit")
    public Timestamp getDateLimit() {
        return dateLimit;
    }

    public void setDateLimit(Timestamp dateLimit) {
        this.dateLimit = dateLimit;
    }

    @Basic
    @Column(name = "release_type")
    public Byte getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(Byte releaseType) {
        this.releaseType = releaseType;
    }

    @Basic
    @Column(name = "release_object")
    public Byte getReleaseObject() {
        return releaseObject;
    }

    public void setReleaseObject(Byte releaseObject) {
        this.releaseObject = releaseObject;
    }

    @Basic
    @Column(name = "subscribed_object")
    public Byte getSubscribedObject() {
        return subscribedObject;
    }

    public void setSubscribedObject(Byte subscribedObject) {
        this.subscribedObject = subscribedObject;
    }

    @Basic
    @Column(name = "guarantor")
    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor;
    }

    @Basic
    @Column(name = "where_into_market")
    public String getWhereIntoMarket() {
        return whereIntoMarket;
    }

    public void setWhereIntoMarket(String whereIntoMarket) {
        this.whereIntoMarket = whereIntoMarket;
    }

    @Basic
    @Column(name = "credit_grade")
    public Byte getCreditGrade() {
        return creditGrade;
    }

    public void setCreditGrade(Byte creditGrade) {
        this.creditGrade = creditGrade;
    }

    @Basic
    @Column(name = "underwriting_institution")
    public Long getUnderwritingInstitution() {
        return underwritingInstitution;
    }

    public void setUnderwritingInstitution(Long underwritingInstitution) {
        this.underwritingInstitution = underwritingInstitution;
    }

    @Basic
    @Column(name = "bond_type")
    public Byte getBondType() {
        return bondType;
    }

    public void setBondType(Byte bondType) {
        this.bondType = bondType;
    }

    @Basic
    @Column(name = "denomination")
    public BigDecimal getDenomination() {
        return denomination;
    }

    public void setDenomination(BigDecimal denomination) {
        this.denomination = denomination;
    }

    @Basic
    @Column(name = "release_price")
    public BigDecimal getReleasePrice() {
        return releasePrice;
    }

    public void setReleasePrice(BigDecimal releasePrice) {
        this.releasePrice = releasePrice;
    }

    @Basic
    @Column(name = "currenct_value")
    public BigDecimal getCurrenctValue() {
        return currenctValue;
    }

    public void setCurrenctValue(BigDecimal currenctValue) {
        this.currenctValue = currenctValue;
    }

    @Basic
    @Column(name = "year_rate")
    public Integer getYearRate() {
        return yearRate;
    }

    public void setYearRate(Integer yearRate) {
        this.yearRate = yearRate;
    }

    @Basic
    @Column(name = "day_rate")
    public BigDecimal getDayRate() {
        return dayRate;
    }

    public void setDayRate(BigDecimal dayRate) {
        this.dayRate = dayRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductBond that = (ProductBond) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (institution != null ? !institution.equals(that.institution) : that.institution != null) return false;
        if (productCode != null ? !productCode.equals(that.productCode) : that.productCode != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (onSaleDate != null ? !onSaleDate.equals(that.onSaleDate) : that.onSaleDate != null) return false;
        if (offSaleDate != null ? !offSaleDate.equals(that.offSaleDate) : that.offSaleDate != null) return false;
        if (cashedDate != null ? !cashedDate.equals(that.cashedDate) : that.cashedDate != null) return false;
        if (startInterestDate != null ? !startInterestDate.equals(that.startInterestDate) : that.startInterestDate != null)
            return false;
        if (dateLimit != null ? !dateLimit.equals(that.dateLimit) : that.dateLimit != null) return false;
        if (releaseType != null ? !releaseType.equals(that.releaseType) : that.releaseType != null) return false;
        if (releaseObject != null ? !releaseObject.equals(that.releaseObject) : that.releaseObject != null)
            return false;
        if (subscribedObject != null ? !subscribedObject.equals(that.subscribedObject) : that.subscribedObject != null)
            return false;
        if (guarantor != null ? !guarantor.equals(that.guarantor) : that.guarantor != null) return false;
        if (whereIntoMarket != null ? !whereIntoMarket.equals(that.whereIntoMarket) : that.whereIntoMarket != null)
            return false;
        if (creditGrade != null ? !creditGrade.equals(that.creditGrade) : that.creditGrade != null) return false;
        if (underwritingInstitution != null ? !underwritingInstitution.equals(that.underwritingInstitution) : that.underwritingInstitution != null)
            return false;
        if (bondType != null ? !bondType.equals(that.bondType) : that.bondType != null) return false;
        if (denomination != null ? !denomination.equals(that.denomination) : that.denomination != null) return false;
        if (releasePrice != null ? !releasePrice.equals(that.releasePrice) : that.releasePrice != null) return false;
        if (currenctValue != null ? !currenctValue.equals(that.currenctValue) : that.currenctValue != null)
            return false;
        if (yearRate != null ? !yearRate.equals(that.yearRate) : that.yearRate != null) return false;
        if (dayRate != null ? !dayRate.equals(that.dayRate) : that.dayRate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (onSaleDate != null ? onSaleDate.hashCode() : 0);
        result = 31 * result + (offSaleDate != null ? offSaleDate.hashCode() : 0);
        result = 31 * result + (cashedDate != null ? cashedDate.hashCode() : 0);
        result = 31 * result + (startInterestDate != null ? startInterestDate.hashCode() : 0);
        result = 31 * result + (dateLimit != null ? dateLimit.hashCode() : 0);
        result = 31 * result + (releaseType != null ? releaseType.hashCode() : 0);
        result = 31 * result + (releaseObject != null ? releaseObject.hashCode() : 0);
        result = 31 * result + (subscribedObject != null ? subscribedObject.hashCode() : 0);
        result = 31 * result + (guarantor != null ? guarantor.hashCode() : 0);
        result = 31 * result + (whereIntoMarket != null ? whereIntoMarket.hashCode() : 0);
        result = 31 * result + (creditGrade != null ? creditGrade.hashCode() : 0);
        result = 31 * result + (underwritingInstitution != null ? underwritingInstitution.hashCode() : 0);
        result = 31 * result + (bondType != null ? bondType.hashCode() : 0);
        result = 31 * result + (denomination != null ? denomination.hashCode() : 0);
        result = 31 * result + (releasePrice != null ? releasePrice.hashCode() : 0);
        result = 31 * result + (currenctValue != null ? currenctValue.hashCode() : 0);
        result = 31 * result + (yearRate != null ? yearRate.hashCode() : 0);
        result = 31 * result + (dayRate != null ? dayRate.hashCode() : 0);
        return result;
    }
}
