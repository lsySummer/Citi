package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
@Entity
@IdClass(HistoryPK.class)
@Table(name = "history", schema = "citi", catalog = "")
public class History {
    private int commodityId;
    private int productId;
    private Timestamp date;
    private BigDecimal price;

    @Id
    @Column(name = "commodity_id")
    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
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
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        History history = (History) o;

        if (commodityId != history.commodityId) return false;
        if (productId != history.productId) return false;
        if (date != null ? !date.equals(history.date) : history.date != null) return false;
        if (price != null ? !price.equals(history.price) : history.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commodityId;
        result = 31 * result + productId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
