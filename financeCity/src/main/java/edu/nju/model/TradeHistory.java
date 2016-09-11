package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/9/10.
 */
@Entity
@Table(name = "trade_history", schema = "citi", catalog = "")
public class TradeHistory {
    private int userId;
    private int productId;
    private String checkCode;
    private Timestamp tradeAt;
    private String tradeType;
    private BigDecimal tradingVolume;
    private BigDecimal nav;
    private Timestamp date;
    private BigDecimal buyingPrice;
    private int id;
    private Integer portfolioId;

    @Basic
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
    @Column(name = "check_code")
    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Basic
    @Column(name = "trade_at")
    public Timestamp getTradeAt() {
        return tradeAt;
    }

    public void setTradeAt(Timestamp tradeAt) {
        this.tradeAt = tradeAt;
    }

    @Basic
    @Column(name = "trade_type")
    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
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

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "buying_price")
    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "portfolio_id")
    public Integer getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Integer portfolioId) {
        this.portfolioId = portfolioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradeHistory that = (TradeHistory) o;

        if (userId != that.userId) return false;
        if (productId != that.productId) return false;
        if (id != that.id) return false;
        if (checkCode != null ? !checkCode.equals(that.checkCode) : that.checkCode != null) return false;
        if (tradeAt != null ? !tradeAt.equals(that.tradeAt) : that.tradeAt != null) return false;
        if (tradeType != null ? !tradeType.equals(that.tradeType) : that.tradeType != null) return false;
        if (tradingVolume != null ? !tradingVolume.equals(that.tradingVolume) : that.tradingVolume != null)
            return false;
        if (nav != null ? !nav.equals(that.nav) : that.nav != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (buyingPrice != null ? !buyingPrice.equals(that.buyingPrice) : that.buyingPrice != null) return false;
        if (portfolioId != null ? !portfolioId.equals(that.portfolioId) : that.portfolioId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + productId;
        result = 31 * result + (checkCode != null ? checkCode.hashCode() : 0);
        result = 31 * result + (tradeAt != null ? tradeAt.hashCode() : 0);
        result = 31 * result + (tradeType != null ? tradeType.hashCode() : 0);
        result = 31 * result + (tradingVolume != null ? tradingVolume.hashCode() : 0);
        result = 31 * result + (nav != null ? nav.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (buyingPrice != null ? buyingPrice.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (portfolioId != null ? portfolioId.hashCode() : 0);
        return result;
    }
}
