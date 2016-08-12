package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by dell on 2016/8/12.
 */
@Entity
@Table(name = "user_temper_prefer", schema = "citi", catalog = "")
public class UserTemperPrefer {
    private int id;
    private BigDecimal money;
    private Timestamp beginTime;
    private Timestamp endTime;
    private BigDecimal bearLoss;
    private BigDecimal stopProfit;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "money")
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Basic
    @Column(name = "begin_time")
    public Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "end_time")
    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Basic
    @Column(name = "bear_loss")
    public BigDecimal getBearLoss() {
        return bearLoss;
    }

    public void setBearLoss(BigDecimal bearLoss) {
        this.bearLoss = bearLoss;
    }

    @Basic
    @Column(name = "stop_profit")
    public BigDecimal getStopProfit() {
        return stopProfit;
    }

    public void setStopProfit(BigDecimal stopProfit) {
        this.stopProfit = stopProfit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserTemperPrefer that = (UserTemperPrefer) o;

        if (id != that.id) return false;
        if (money != null ? !money.equals(that.money) : that.money != null) return false;
        if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (bearLoss != null ? !bearLoss.equals(that.bearLoss) : that.bearLoss != null) return false;
        if (stopProfit != null ? !stopProfit.equals(that.stopProfit) : that.stopProfit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (money != null ? money.hashCode() : 0);
        result = 31 * result + (beginTime != null ? beginTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (bearLoss != null ? bearLoss.hashCode() : 0);
        result = 31 * result + (stopProfit != null ? stopProfit.hashCode() : 0);
        return result;
    }
}
