package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/28.
 */
@Entity
@Table(name = "invest_status", schema = "citi", catalog = "")
public class InvestStatus {
    private int userId;
    private Integer amount;
    private BigDecimal buyingPrice;
    private int productId;
    private BigDecimal totalValue;
    private Timestamp date;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "buying_price")
    public BigDecimal getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(BigDecimal buyingPrice) {
        this.buyingPrice = buyingPrice;
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
    @Column(name = "total_value")
    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestStatus that = (InvestStatus) o;

        if (userId != that.userId) return false;
        if (productId != that.productId) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (buyingPrice != null ? !buyingPrice.equals(that.buyingPrice) : that.buyingPrice != null) return false;
        if (totalValue != null ? !totalValue.equals(that.totalValue) : that.totalValue != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (buyingPrice != null ? buyingPrice.hashCode() : 0);
        result = 31 * result + productId;
        result = 31 * result + (totalValue != null ? totalValue.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
