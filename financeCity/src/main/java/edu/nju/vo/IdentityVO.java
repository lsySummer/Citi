package edu.nju.vo;

/**
 * @author lsy
 * 身份特征
 */
public class IdentityVO {
	/**年收入*/
	private double income;
	/**婚姻状态*/
	private String marriage;
	/**风险偏好*/
	private String riskPrefer;
	/**投资目的*/
	private String target;
	/**投资经验*/
	private String experience;
	/**就业情况*/
	private String job;
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getRiskPrefer() {
		return riskPrefer;
	}
	public void setRiskPrefer(String riskPrefer) {
		this.riskPrefer = riskPrefer;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
