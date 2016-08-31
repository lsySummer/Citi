package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
@Entity
@Table(name = "user_asset", schema = "citi", catalog = "")
public class UserAsset {
    private long userId;
    private BigDecimal initialPrice;
    private BigDecimal currentPrice;
    private BigDecimal futurePrice;
    private BigDecimal cashAssets;
    private BigDecimal longTermAssets;
    private BigDecimal emergencyAssets;

    @Id
    @Column(name = "user_id")
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    @Basic
    @Column(name = "cash_assets")
    public BigDecimal getCashAssets() {
        return cashAssets;
    }

    public void setCashAssets(BigDecimal cashAssets) {
        this.cashAssets = cashAssets;
    }

    @Basic
    @Column(name = "long_term_assets")
    public BigDecimal getLongTermAssets() {
        return longTermAssets;
    }

    public void setLongTermAssets(BigDecimal longTermAssets) {
        this.longTermAssets = longTermAssets;
    }

    @Basic
    @Column(name = "emergency_assets")
    public BigDecimal getEmergencyAssets() {
        return emergencyAssets;
    }

    public void setEmergencyAssets(BigDecimal emergencyAssets) {
        this.emergencyAssets = emergencyAssets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAsset userAsset = (UserAsset) o;

        if (userId != userAsset.userId) return false;
        if (initialPrice != null ? !initialPrice.equals(userAsset.initialPrice) : userAsset.initialPrice != null)
            return false;
        if (currentPrice != null ? !currentPrice.equals(userAsset.currentPrice) : userAsset.currentPrice != null)
            return false;
        if (futurePrice != null ? !futurePrice.equals(userAsset.futurePrice) : userAsset.futurePrice != null)
            return false;
        if (cashAssets != null ? !cashAssets.equals(userAsset.cashAssets) : userAsset.cashAssets != null) return false;
        if (longTermAssets != null ? !longTermAssets.equals(userAsset.longTermAssets) : userAsset.longTermAssets != null)
            return false;
        if (emergencyAssets != null ? !emergencyAssets.equals(userAsset.emergencyAssets) : userAsset.emergencyAssets != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (initialPrice != null ? initialPrice.hashCode() : 0);
        result = 31 * result + (currentPrice != null ? currentPrice.hashCode() : 0);
        result = 31 * result + (futurePrice != null ? futurePrice.hashCode() : 0);
        result = 31 * result + (cashAssets != null ? cashAssets.hashCode() : 0);
        result = 31 * result + (longTermAssets != null ? longTermAssets.hashCode() : 0);
        result = 31 * result + (emergencyAssets != null ? emergencyAssets.hashCode() : 0);
        return result;
    }
}
