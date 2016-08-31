package edu.nju.vo;

/**
 * @author lsy
 * 用户
 */
public class UserVO extends BaseVO {
	/**ID*/
	private int id;
	/**电话*/
	private String mobile;
	/**生日*/
	private String birthday;
	/**收入*/
	private int income;
	/**是否是城市*/
	private boolean isUrben;
	/**月支出*/
	private int expense;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public boolean isUrben() {
		return isUrben;
	}

	public void setUrben(boolean urben) {
		isUrben = urben;
	}

	public int getExpense() {
		return expense;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}
}
