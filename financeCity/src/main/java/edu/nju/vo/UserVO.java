package edu.nju.vo;

/**
 * @author lsy
 * 用户
 */
public class UserVO extends BaseVO {
	/**姓名*/
	private String Name;
	/**生日*/
	private String Birthday;
	/**城市名*/
	private String CityName;
	/**是否是城市*/
	private boolean IfCity;
	/**月支出*/
	private int MonthlyExpense;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBirthday() {
		return Birthday;
	}

	public void setBirthday(String birthday) {
		Birthday = birthday;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public boolean isIfCity() {
		return IfCity;
	}

	public void setIfCity(boolean ifCity) {
		IfCity = ifCity;
	}

	public int getMonthlyExpense() {
		return MonthlyExpense;
	}

	public void setMonthlyExpense(int monthlyExpense) {
		MonthlyExpense = monthlyExpense;
	}
}
