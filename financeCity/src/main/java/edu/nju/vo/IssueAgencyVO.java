package edu.nju.vo;

/**
 * @author lsy 发行机构
 */
public class IssueAgencyVO {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegisterName() {
		return registerName;
	}
	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}
	public String getRegisterAdd() {
		return registerAdd;
	}
	public void setRegisterAdd(String registerAdd) {
		this.registerAdd = registerAdd;
	}
	public String getOfficeAdd() {
		return officeAdd;
	}
	public void setOfficeAdd(String officeAdd) {
		this.officeAdd = officeAdd;
	}
	public String getAgencyWebsite() {
		return agencyWebsite;
	}
	public void setAgencyWebsite(String agencyWebsite) {
		this.agencyWebsite = agencyWebsite;
	}
	/** 机构名称 */
	private String name;
	/** 注册名*/
	private String registerName;
	/** 注册地址*/
	private String registerAdd;
	/** 办公地址 */
	private String officeAdd;
	/**机构网址 */
	private String agencyWebsite;
}
