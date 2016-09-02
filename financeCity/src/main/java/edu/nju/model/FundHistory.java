package edu.nju.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Sun YuHao on 2016/9/2.
 */
@Entity
@Table(name = "fund_history", schema = "citi", catalog = "")
public class FundHistory {
    private int id;
    private int fundId;
    private BigDecimal dailyReturn;
    private BigDecimal stockRatio;
    private BigDecimal fundSize;
    private BigDecimal debtRatio;
    private BigDecimal institutionalRatio;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fund_id")
    public int getFundId() {
        return fundId;
    }

    public void setFundId(int fundId) {
        this.fundId = fundId;
    }

    @Basic
    @Column(name = "daily_return")
    public BigDecimal getDailyReturn() {
        return dailyReturn;
    }

    public void setDailyReturn(BigDecimal dailyReturn) {
        this.dailyReturn = dailyReturn;
    }

    @Basic
    @Column(name = "stock_ratio")
    public BigDecimal getStockRatio() {
        return stockRatio;
    }

    public void setStockRatio(BigDecimal stockRatio) {
        this.stockRatio = stockRatio;
    }

    @Basic
    @Column(name = "fund_size")
    public BigDecimal getFundSize() {
        return fundSize;
    }

    public void setFundSize(BigDecimal fundSize) {
        this.fundSize = fundSize;
    }

    @Basic
    @Column(name = "debt_ratio")
    public BigDecimal getDebtRatio() {
        return debtRatio;
    }

    public void setDebtRatio(BigDecimal debtRatio) {
        this.debtRatio = debtRatio;
    }

    @Basic
    @Column(name = "institutional_ratio")
    public BigDecimal getInstitutionalRatio() {
        return institutionalRatio;
    }

    public void setInstitutionalRatio(BigDecimal institutionalRatio) {
        this.institutionalRatio = institutionalRatio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FundHistory that = (FundHistory) o;

        if (id != that.id) return false;
        if (fundId != that.fundId) return false;
        if (dailyReturn != null ? !dailyReturn.equals(that.dailyReturn) : that.dailyReturn != null) return false;
        if (stockRatio != null ? !stockRatio.equals(that.stockRatio) : that.stockRatio != null) return false;
        if (fundSize != null ? !fundSize.equals(that.fundSize) : that.fundSize != null) return false;
        if (debtRatio != null ? !debtRatio.equals(that.debtRatio) : that.debtRatio != null) return false;
        if (institutionalRatio != null ? !institutionalRatio.equals(that.institutionalRatio) : that.institutionalRatio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fundId;
        result = 31 * result + (dailyReturn != null ? dailyReturn.hashCode() : 0);
        result = 31 * result + (stockRatio != null ? stockRatio.hashCode() : 0);
        result = 31 * result + (fundSize != null ? fundSize.hashCode() : 0);
        result = 31 * result + (debtRatio != null ? debtRatio.hashCode() : 0);
        result = 31 * result + (institutionalRatio != null ? institutionalRatio.hashCode() : 0);
        return result;
    }
}
