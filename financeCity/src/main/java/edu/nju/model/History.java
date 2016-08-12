package edu.nju.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by dell on 2016/8/11.
 */
@Entity
public class History {
    private Integer commodityId;
    private Timestamp date;
    private BigDecimal price;

    @Basic
    @Column(name = "commodity_id")
    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
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

        if (commodityId != null ? !commodityId.equals(history.commodityId) : history.commodityId != null) return false;
        if (date != null ? !date.equals(history.date) : history.date != null) return false;
        if (price != null ? !price.equals(history.price) : history.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commodityId != null ? commodityId.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
