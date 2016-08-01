package edu.nju.vo;

/**
 * @author lsy
 * 用户
 */
public class UserVO {
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	/**用户名*/
	private String username;
	/** 密码*/
	private String password;
	private String email;
	private String phone;
	/**密保问题**/
	private String question;
	/** 密保答案*/
	private String answer;
	/**绑定的信用卡or银行卡*/
	private String cardNumber;
	/**生日*/
	private String birthday;
	/**城市*/
	private String city;
	/**城市还是农村*/
	private boolean ifCity;
	/**每月支出水平*/
	private String expense;
	/**每月收入水平*/
	private String income;
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isIfCity() {
		return ifCity;
	}
	public void setIfCity(boolean ifCity) {
		this.ifCity = ifCity;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	
}
