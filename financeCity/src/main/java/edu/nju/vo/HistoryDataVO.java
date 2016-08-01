package edu.nju.vo;

import java.util.Map;

/**
 * @author lsy
 * 历史数据
 */
public class HistoryDataVO {
	/**历史发行过多少期*/
	private int term;
	
	/**波动率*/
	private Map<String,Double> volatility;
	
	/**收益率*/
	private Map<String,Double> incomeRate;
	
	/**成立时价值*/
	private double builtValue;
	
	/**当前价值*/
	private double currentValue;
	
	public Map getVolatility() {
		return volatility;
	}

	public void setVolatility(Map<String,Double> volatility) {
		this.volatility = volatility;
	}

	public Map getIncomeRate() {
		return incomeRate;
	}

	public void setIncomeRate(Map<String,Double> incomeRate) {
		this.incomeRate = incomeRate;
	}

	public double getBuiltValue() {
		return builtValue;
	}

	public void setBuiltValue(double builtValue) {
		this.builtValue = builtValue;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}
	
	
}
