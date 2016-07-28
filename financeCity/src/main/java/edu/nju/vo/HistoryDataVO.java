package edu.nju.vo;

/**
 * @author lsy
 * 历史数据
 */
public class HistoryDataVO {
	/**历史发行过多少期*/
	private int term;
	
	/**波动率*/
	private double volatility;
	
	/**收益率*/
	private double incomeRate;
	
	/**成立时价值*/
	private double builtValue;
	
	/**当前价值*/
	private double currentValue;
	
	public double getVolatility() {
		return volatility;
	}

	public void setVolatility(double volatility) {
		this.volatility = volatility;
	}

	public double getIncomeRate() {
		return incomeRate;
	}

	public void setIncomeRate(double incomeRate) {
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
