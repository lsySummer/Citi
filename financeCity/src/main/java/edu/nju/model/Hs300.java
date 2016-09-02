package edu.nju.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by Sun YuHao on 2016/9/2.
 */
@Entity
public class Hs300 {
    private int id;
    private BigDecimal hs300Return;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hs300 hs300 = (Hs300) o;

        if (id != hs300.id) return false;
        if (hs300Return != null ? !hs300Return.equals(hs300.hs300Return) : hs300.hs300Return != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (hs300Return != null ? hs300Return.hashCode() : 0);
        return result;
    }
}
