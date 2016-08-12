package edu.nju.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by dell on 2016/8/11.
 */
@Entity
@Table(name = "invest_history", schema = "citi", catalog = "")
@IdClass(InvestHistoryPK.class)
public class InvestHistory {
    private int userId;
    private int productId;
    private int price;
    private Integer amount;
    private Timestamp createdAt;
    private Timestamp updateAt;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "amount")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Id
    @Column(name = "created_at")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "update_at")
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestHistory that = (InvestHistory) o;

        if (userId != that.userId) return false;
        if (productId != that.productId) return false;
        if (price != that.price) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + productId;
        result = 31 * result + price;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
