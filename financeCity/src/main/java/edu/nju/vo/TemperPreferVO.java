package edu.nju.vo;

import java.util.ArrayList;

/**
 * @author lsy
 * 投资性格偏好
 */
public class TemperPreferVO {
	/**投资金额*/
	private double money;
	/**投资开始时间*/
	private String beginTime;
	/**投资停止时间*/
	private String endTime;
	/**可承受损失*/
	private String bearLoss;
	/**止盈线*/
	private double stopProfit;
	/**投资产品*/
	private ArrayList<ProjectVO> projectArr;
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getBearLoss() {
		return bearLoss;
	}
	public void setBearLoss(String bearLoss) {
		this.bearLoss = bearLoss;
	}
	public double getStopProfit() {
		return stopProfit;
	}
	public void setStopProfit(double stopProfit) {
		this.stopProfit = stopProfit;
	}
	public ArrayList<ProjectVO> getProjectArr() {
		return projectArr;
	}
	public void setProjectArr(ArrayList<ProjectVO> projectArr) {
		this.projectArr = projectArr;
	}
}
