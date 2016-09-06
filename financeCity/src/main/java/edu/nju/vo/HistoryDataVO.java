package edu.nju.vo;

import java.util.Map;

/**
 * @author lsy
 * 历史数据
 */
public class HistoryDataVO {
	/**历史发行过多少期*/
	private Integer term;
	
	/**波动率*/
	private Map<String,Double> volatility;
	
	/**收益率*/
	private Map<String,Double> incomeRate;
	
	/**成立时价值*/
	private Double builtValue;
	
	/**当前价值*/
	private Double currentValue;

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Map<String, Double> getVolatility() {
		return volatility;
	}

	public void setVolatility(Map<String, Double> volatility) {
		this.volatility = volatility;
	}

	public Map<String, Double> getIncomeRate() {
		return incomeRate;
	}

	public void setIncomeRate(Map<String, Double> incomeRate) {
		this.incomeRate = incomeRate;
	}

	public Double getBuiltValue() {
		return builtValue;
	}

	public void setBuiltValue(Double builtValue) {
		this.builtValue = builtValue;
	}

	public Double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
}
