package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/17.
 */
@Entity
@Table(name = "trade_history", schema = "citi", catalog = "")
public class TradeHistory {
    private int userId;
    private int productId;
    private String tradingUnit;
    private int amount;
    private BigDecimal price;
    private String checkCode;
    private Timestamp tradeAt;
    private String tradeType;

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
    @Column(name = "trading_unit")
    public String getTradingUnit() {
        return tradingUnit;
    }

    public void setTradingUnit(String tradingUnit) {
        this.tradingUnit = tradingUnit;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradeHistory that = (TradeHistory) o;

        if (userId != that.userId) return false;
        if (productId != that.productId) return false;
        if (amount != that.amount) return false;
        if (tradingUnit != null ? !tradingUnit.equals(that.tradingUnit) : that.tradingUnit != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (checkCode != null ? !checkCode.equals(that.checkCode) : that.checkCode != null) return false;
        if (tradeAt != null ? !tradeAt.equals(that.tradeAt) : that.tradeAt != null) return false;
        if (tradeType != null ? !tradeType.equals(that.tradeType) : that.tradeType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + productId;
        result = 31 * result + (tradingUnit != null ? tradingUnit.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (checkCode != null ? checkCode.hashCode() : 0);
        result = 31 * result + (tradeAt != null ? tradeAt.hashCode() : 0);
        result = 31 * result + (tradeType != null ? tradeType.hashCode() : 0);
        return result;
    }
}
