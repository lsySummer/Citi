package edu.nju.vo;

/**
 * @author lsy
 * 投资产品
 */
public class InvestProductVO {
	/**投资时间*/
	private String investTime;
	public String getInvestTime() {
		return investTime;
	}
	public void setInvestTime(String investTime) {
		this.investTime = investTime;
	}
	public double getInitMoney() {
		return initMoney;
	}
	public void setInitMoney(double initMoney) {
		this.initMoney = initMoney;
	}
	public double getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}
	public double getProfitRate() {
		return profitRate;
	}
	public void setProfitRate(double profitRate) {
		this.profitRate = profitRate;
	}
	public String getDueTime() {
		return dueTime;
	}
	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}
	public String getGetTime() {
		return getTime;
	}
	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}
	/**初始金额*/
	private double initMoney;
	/**当前价值*/
	private double currentValue;
	/**盈利率*/
	private double profitRate;
	/**到期时间*/
	private String dueTime;
	/**可取时间*/
	private String getTime;
}
