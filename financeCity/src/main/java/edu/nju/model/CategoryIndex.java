package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Sun YuHao on 2016/9/5.
 */
@Entity
@Table(name = "category_index", schema = "citi", catalog = "")
public class CategoryIndex {
    private int id;
    private BigDecimal riskFreeInterest;
    private BigDecimal baseRate;
    private Date updateAt;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "risk_free_interest")
    public BigDecimal getRiskFreeInterest() {
        return riskFreeInterest;
    }

    public void setRiskFreeInterest(BigDecimal riskFreeInterest) {
        this.riskFreeInterest = riskFreeInterest;
    }

    @Basic
    @Column(name = "base_rate")
    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    @Basic
    @Column(name = "update_at")
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryIndex that = (CategoryIndex) o;

        if (id != that.id) return false;
        if (riskFreeInterest != null ? !riskFreeInterest.equals(that.riskFreeInterest) : that.riskFreeInterest != null)
            return false;
        if (baseRate != null ? !baseRate.equals(that.baseRate) : that.baseRate != null) return false;
        if (updateAt != null ? !updateAt.equals(that.updateAt) : that.updateAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (riskFreeInterest != null ? riskFreeInterest.hashCode() : 0);
        result = 31 * result + (baseRate != null ? baseRate.hashCode() : 0);
        result = 31 * result + (updateAt != null ? updateAt.hashCode() : 0);
        return result;
    }
}
