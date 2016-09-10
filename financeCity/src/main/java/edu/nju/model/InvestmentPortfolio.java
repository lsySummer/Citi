package edu.nju.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/9/10.
 */
@Entity
@Table(name = "investment_portfolio", schema = "citi", catalog = "")
public class InvestmentPortfolio {
    private int id;
    private Timestamp date;
    private Integer tradeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "trade_id")
    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvestmentPortfolio that = (InvestmentPortfolio) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (tradeId != null ? !tradeId.equals(that.tradeId) : that.tradeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (tradeId != null ? tradeId.hashCode() : 0);
        return result;
    }
}
