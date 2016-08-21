package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/18.
 */
@Entity
@Table(name = "unpaid_item", schema = "citi", catalog = "")
public class UnpaidItem {
    private int id;
    private int productId;
    private String unit;
    private int amount;
    private BigDecimal price;
    private String checkCode;
    private Timestamp expirationTime;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
    @Column(name = "expiration_time")
    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnpaidItem that = (UnpaidItem) o;

        if (id != that.id) return false;
        if (productId != that.productId) return false;
        if (amount != that.amount) return false;
        if (userId != that.userId) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (checkCode != null ? !checkCode.equals(that.checkCode) : that.checkCode != null) return false;
        if (expirationTime != null ? !expirationTime.equals(that.expirationTime) : that.expirationTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productId;
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (checkCode != null ? checkCode.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
