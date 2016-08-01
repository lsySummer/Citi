package edu.nju.vo;

/**
 * @author lsy
 * 家庭开销
 */ 
public class FamilySpendingVO {
	/**是否做好投资期间意外大额支出准备*/
	private boolean ifPrepare; 
	public boolean isIfPrepare() {
		return ifPrepare;
	}
	public void setIfPrepare(boolean ifPrepare) {
		this.ifPrepare = ifPrepare;
	}
	public boolean isIfNeed() {
		return ifNeed;
	}
	public void setIfNeed(boolean ifNeed) {
		this.ifNeed = ifNeed;
	}
	/**是否需要专门配置大额支出准备*/
	private boolean ifNeed;
}
