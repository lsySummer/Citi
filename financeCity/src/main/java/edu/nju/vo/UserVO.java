package edu.nju.vo;

/**
 * @author lsy
 * 用户
 */
public class UserVO extends BaseVO {
	/**ID*/
	private Integer id;
	/**电话*/
	private String mobile;
	/**生日*/
	private String birthday;
	/**收入*/
	private Integer income;
	/**是否是城市*/
	private Boolean isUrben;
	/**月支出*/
	private Integer expense;
	/**用户名*/
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Boolean getUrben() {
		return isUrben;
	}

	public void setUrben(Boolean urben) {
		isUrben = urben;
	}

	public Integer getExpense() {
		return expense;
	}

	public void setExpense(Integer expense) {
		this.expense = expense;
	}
}
