package edu.nju.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by dell on 2016/8/11.
 */
public class InvestPK implements Serializable {
    private int userId;
    private int productId;
    private Timestamp createdAt;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "product_id")
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "created_at")
    @Id
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestPK investPK = (InvestPK) o;

        if (userId != investPK.userId) return false;
        if (productId != investPK.productId) return false;
        if (createdAt != null ? !createdAt.equals(investPK.createdAt) : investPK.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + productId;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
