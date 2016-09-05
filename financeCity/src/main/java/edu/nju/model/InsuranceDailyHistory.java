package edu.nju.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Sun YuHao on 2016/9/5.
 */
@Entity
@javax.persistence.Table(name = "insurance_daily_history", schema = "citi", catalog = "")
public class InsuranceDailyHistory {
    private int id;

    @Id
    @javax.persistence.Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Date date;

    @Basic
    @javax.persistence.Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private BigDecimal historyRate;

    @Basic
    @javax.persistence.Column(name = "history_rate")
    public BigDecimal getHistoryRate() {
        return historyRate;
    }

    public void setHistoryRate(BigDecimal historyRate) {
        this.historyRate = historyRate;
    }

    private Integer insuranceId;

    @Basic
    @javax.persistence.Column(name = "insurance_id")
    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsuranceDailyHistory that = (InsuranceDailyHistory) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (historyRate != null ? !historyRate.equals(that.historyRate) : that.historyRate != null) return false;
        if (insuranceId != null ? !insuranceId.equals(that.insuranceId) : that.insuranceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (historyRate != null ? historyRate.hashCode() : 0);
        result = 31 * result + (insuranceId != null ? insuranceId.hashCode() : 0);
        return result;
    }
}
