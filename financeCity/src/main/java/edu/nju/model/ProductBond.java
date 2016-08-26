package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/21.
 */
@Entity
@Table(name = "product_bond", schema = "citi", catalog = "")
public class ProductBond {
    private int id;
    private String title;
    private String institution;
    private String productCode;
    private String abbreviation;
    private Timestamp onSaleDate;
    private Timestamp offSaleDate;
    private Timestamp startInterestDate;
    private Integer dateLimit;
    private Integer releaseAmount;
    private Timestamp releaseDate;
    private String whereIntoMarket;
    private Byte creditGrade;
    private String institutionUnderwriter;
    private Byte type;
    private BigDecimal denomination;
    private BigDecimal releasePrice;
    private BigDecimal currenctValue;
    private BigDecimal yearRate;
    private Byte releaseObject;
    private Byte interestCalculate;
    private Byte paymentFrequency;
    private Timestamp dueDate;
    private Timestamp onCurrencyDate;
    private Integer paymentPrice;
    private String objectApplyBuy;
    private Byte riskGrade;
    private String releaseWay;
    private String objectOriented;
    private Byte taxState;
    private Integer nominalRate;
    private Integer advanceRedeemDate;
    private Integer advanceRedeemInterestDate;
    private Byte state;

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
    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
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
    @Column(name = "abbreviation")
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
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
    @Column(name = "start_interest_date")
    public Timestamp getStartInterestDate() {
        return startInterestDate;
    }

    public void setStartInterestDate(Timestamp startInterestDate) {
        this.startInterestDate = startInterestDate;
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
    @Column(name = "release_amount")
    public Integer getReleaseAmount() {
        return releaseAmount;
    }

    public void setReleaseAmount(Integer releaseAmount) {
        this.releaseAmount = releaseAmount;
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
    @Column(name = "institution_underwriter")
    public String getInstitutionUnderwriter() {
        return institutionUnderwriter;
    }

    public void setInstitutionUnderwriter(String institutionUnderwriter) {
        this.institutionUnderwriter = institutionUnderwriter;
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
    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
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
    @Column(name = "interest_calculate")
    public Byte getInterestCalculate() {
        return interestCalculate;
    }

    public void setInterestCalculate(Byte interestCalculate) {
        this.interestCalculate = interestCalculate;
    }

    @Basic
    @Column(name = "payment_frequency")
    public Byte getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(Byte paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    @Basic
    @Column(name = "due_date")
    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    @Basic
    @Column(name = "on_currency_date")
    public Timestamp getOnCurrencyDate() {
        return onCurrencyDate;
    }

    public void setOnCurrencyDate(Timestamp onCurrencyDate) {
        this.onCurrencyDate = onCurrencyDate;
    }

    @Basic
    @Column(name = "payment_price")
    public Integer getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(Integer paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    @Basic
    @Column(name = "object_apply_buy")
    public String getObjectApplyBuy() {
        return objectApplyBuy;
    }

    public void setObjectApplyBuy(String objectApplyBuy) {
        this.objectApplyBuy = objectApplyBuy;
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
    @Column(name = "release_way")
    public String getReleaseWay() {
        return releaseWay;
    }

    public void setReleaseWay(String releaseWay) {
        this.releaseWay = releaseWay;
    }

    @Basic
    @Column(name = "object_oriented")
    public String getObjectOriented() {
        return objectOriented;
    }

    public void setObjectOriented(String objectOriented) {
        this.objectOriented = objectOriented;
    }

    @Basic
    @Column(name = "tax_state")
    public Byte getTaxState() {
        return taxState;
    }

    public void setTaxState(Byte taxState) {
        this.taxState = taxState;
    }

    @Basic
    @Column(name = "nominal_rate")
    public Integer getNominalRate() {
        return nominalRate;
    }

    public void setNominalRate(Integer nominalRate) {
        this.nominalRate = nominalRate;
    }

    @Basic
    @Column(name = "advance_redeem_date")
    public Integer getAdvanceRedeemDate() {
        return advanceRedeemDate;
    }

    public void setAdvanceRedeemDate(Integer advanceRedeemDate) {
        this.advanceRedeemDate = advanceRedeemDate;
    }

    @Basic
    @Column(name = "advance_redeem_interest_date")
    public Integer getAdvanceRedeemInterestDate() {
        return advanceRedeemInterestDate;
    }

    public void setAdvanceRedeemInterestDate(Integer advanceRedeemInterestDate) {
        this.advanceRedeemInterestDate = advanceRedeemInterestDate;
    }

    @Basic
    @Column(name = "state")
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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
        if (abbreviation != null ? !abbreviation.equals(that.abbreviation) : that.abbreviation != null) return false;
        if (onSaleDate != null ? !onSaleDate.equals(that.onSaleDate) : that.onSaleDate != null) return false;
        if (offSaleDate != null ? !offSaleDate.equals(that.offSaleDate) : that.offSaleDate != null) return false;
        if (startInterestDate != null ? !startInterestDate.equals(that.startInterestDate) : that.startInterestDate != null)
            return false;
        if (dateLimit != null ? !dateLimit.equals(that.dateLimit) : that.dateLimit != null) return false;
        if (releaseAmount != null ? !releaseAmount.equals(that.releaseAmount) : that.releaseAmount != null)
            return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (whereIntoMarket != null ? !whereIntoMarket.equals(that.whereIntoMarket) : that.whereIntoMarket != null)
            return false;
        if (creditGrade != null ? !creditGrade.equals(that.creditGrade) : that.creditGrade != null) return false;
        if (institutionUnderwriter != null ? !institutionUnderwriter.equals(that.institutionUnderwriter) : that.institutionUnderwriter != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (denomination != null ? !denomination.equals(that.denomination) : that.denomination != null) return false;
        if (releasePrice != null ? !releasePrice.equals(that.releasePrice) : that.releasePrice != null) return false;
        if (currenctValue != null ? !currenctValue.equals(that.currenctValue) : that.currenctValue != null)
            return false;
        if (yearRate != null ? !yearRate.equals(that.yearRate) : that.yearRate != null) return false;
        if (releaseObject != null ? !releaseObject.equals(that.releaseObject) : that.releaseObject != null)
            return false;
        if (interestCalculate != null ? !interestCalculate.equals(that.interestCalculate) : that.interestCalculate != null)
            return false;
        if (paymentFrequency != null ? !paymentFrequency.equals(that.paymentFrequency) : that.paymentFrequency != null)
            return false;
        if (dueDate != null ? !dueDate.equals(that.dueDate) : that.dueDate != null) return false;
        if (onCurrencyDate != null ? !onCurrencyDate.equals(that.onCurrencyDate) : that.onCurrencyDate != null)
            return false;
        if (paymentPrice != null ? !paymentPrice.equals(that.paymentPrice) : that.paymentPrice != null) return false;
        if (objectApplyBuy != null ? !objectApplyBuy.equals(that.objectApplyBuy) : that.objectApplyBuy != null)
            return false;
        if (riskGrade != null ? !riskGrade.equals(that.riskGrade) : that.riskGrade != null) return false;
        if (releaseWay != null ? !releaseWay.equals(that.releaseWay) : that.releaseWay != null) return false;
        if (objectOriented != null ? !objectOriented.equals(that.objectOriented) : that.objectOriented != null)
            return false;
        if (taxState != null ? !taxState.equals(that.taxState) : that.taxState != null) return false;
        if (nominalRate != null ? !nominalRate.equals(that.nominalRate) : that.nominalRate != null) return false;
        if (advanceRedeemDate != null ? !advanceRedeemDate.equals(that.advanceRedeemDate) : that.advanceRedeemDate != null)
            return false;
        if (advanceRedeemInterestDate != null ? !advanceRedeemInterestDate.equals(that.advanceRedeemInterestDate) : that.advanceRedeemInterestDate != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (institution != null ? institution.hashCode() : 0);
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        result = 31 * result + (onSaleDate != null ? onSaleDate.hashCode() : 0);
        result = 31 * result + (offSaleDate != null ? offSaleDate.hashCode() : 0);
        result = 31 * result + (startInterestDate != null ? startInterestDate.hashCode() : 0);
        result = 31 * result + (dateLimit != null ? dateLimit.hashCode() : 0);
        result = 31 * result + (releaseAmount != null ? releaseAmount.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + (whereIntoMarket != null ? whereIntoMarket.hashCode() : 0);
        result = 31 * result + (creditGrade != null ? creditGrade.hashCode() : 0);
        result = 31 * result + (institutionUnderwriter != null ? institutionUnderwriter.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (denomination != null ? denomination.hashCode() : 0);
        result = 31 * result + (releasePrice != null ? releasePrice.hashCode() : 0);
        result = 31 * result + (currenctValue != null ? currenctValue.hashCode() : 0);
        result = 31 * result + (yearRate != null ? yearRate.hashCode() : 0);
        result = 31 * result + (releaseObject != null ? releaseObject.hashCode() : 0);
        result = 31 * result + (interestCalculate != null ? interestCalculate.hashCode() : 0);
        result = 31 * result + (paymentFrequency != null ? paymentFrequency.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (onCurrencyDate != null ? onCurrencyDate.hashCode() : 0);
        result = 31 * result + (paymentPrice != null ? paymentPrice.hashCode() : 0);
        result = 31 * result + (objectApplyBuy != null ? objectApplyBuy.hashCode() : 0);
        result = 31 * result + (riskGrade != null ? riskGrade.hashCode() : 0);
        result = 31 * result + (releaseWay != null ? releaseWay.hashCode() : 0);
        result = 31 * result + (objectOriented != null ? objectOriented.hashCode() : 0);
        result = 31 * result + (taxState != null ? taxState.hashCode() : 0);
        result = 31 * result + (nominalRate != null ? nominalRate.hashCode() : 0);
        result = 31 * result + (advanceRedeemDate != null ? advanceRedeemDate.hashCode() : 0);
        result = 31 * result + (advanceRedeemInterestDate != null ? advanceRedeemInterestDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
