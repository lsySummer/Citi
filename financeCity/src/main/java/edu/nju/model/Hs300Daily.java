package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Sun YuHao on 2016/9/25.
 */
@Entity
@Table(name = "Hs300_daily", schema = "citi", catalog = "")
public class Hs300Daily {
    private int id;
    private BigDecimal hs300Return;
    private Date date;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "HS300_return")
    public BigDecimal getHs300Return() {
        return hs300Return;
    }

    public void setHs300Return(BigDecimal hs300Return) {
        this.hs300Return = hs300Return;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hs300Daily that = (Hs300Daily) o;

        if (id != that.id) return false;
        if (hs300Return != null ? !hs300Return.equals(that.hs300Return) : that.hs300Return != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hs300Return != null ? hs300Return.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
