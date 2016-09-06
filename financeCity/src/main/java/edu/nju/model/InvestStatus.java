package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/9/5.
 */
@Entity
@Table(name = "invest_status", schema = "citi", catalog = "")
public class InvestStatus {
    private int userId;
    private int productId;
    private Timestamp date;
    private BigDecimal tradingVolume;
    private BigDecimal nav;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "trading_volume")
    public BigDecimal getTradingVolume() {
        return tradingVolume;
    }

    public void setTradingVolume(BigDecimal tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

    @Basic
    @Column(name = "NAV")
    public BigDecimal getNav() {
        return nav;
    }

    public void setNav(BigDecimal nav) {
        this.nav = nav;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestStatus that = (InvestStatus) o;

        if (userId != that.userId) return false;
        if (productId != that.productId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (tradingVolume != null ? !tradingVolume.equals(that.tradingVolume) : that.tradingVolume != null)
            return false;
        if (nav != null ? !nav.equals(that.nav) : that.nav != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + productId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (tradingVolume != null ? tradingVolume.hashCode() : 0);
        result = 31 * result + (nav != null ? nav.hashCode() : 0);
        return result;
    }
}
