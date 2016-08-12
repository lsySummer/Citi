package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by dell on 2016/8/12.
 */
@Entity
@Table(name = "invest_status", schema = "citi", catalog = "")
public class InvestStatus {
    private long userId;
    private Integer investmentAmount;
    private BigDecimal initialPrice;
    private BigDecimal currentPrice;
    private BigDecimal futurePrice;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "investment_amount")
    public Integer getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount(Integer investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    @Basic
    @Column(name = "initial_price")
    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    @Basic
    @Column(name = "current_price")
    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Basic
    @Column(name = "future_price")
    public BigDecimal getFuturePrice() {
        return futurePrice;
    }

    public void setFuturePrice(BigDecimal futurePrice) {
        this.futurePrice = futurePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestStatus that = (InvestStatus) o;

        if (userId != that.userId) return false;
        if (investmentAmount != null ? !investmentAmount.equals(that.investmentAmount) : that.investmentAmount != null)
            return false;
        if (initialPrice != null ? !initialPrice.equals(that.initialPrice) : that.initialPrice != null) return false;
        if (currentPrice != null ? !currentPrice.equals(that.currentPrice) : that.currentPrice != null) return false;
        if (futurePrice != null ? !futurePrice.equals(that.futurePrice) : that.futurePrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (investmentAmount != null ? investmentAmount.hashCode() : 0);
        result = 31 * result + (initialPrice != null ? initialPrice.hashCode() : 0);
        result = 31 * result + (currentPrice != null ? currentPrice.hashCode() : 0);
        result = 31 * result + (futurePrice != null ? futurePrice.hashCode() : 0);
        return result;
    }
}
