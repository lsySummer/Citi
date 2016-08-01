package edu.nju.vo;

/**
 * @author lsy
 * 产品
 */
public class ProjectVO {
	
	/**产品名称*/
	private String name;
	/**产品id*/
	private String id;
	/**当前状态*/
	private String state;
	/**发行机构*/
	private IssueAgencyVO issuer;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public IssueAgencyVO getIssuer() {
		return issuer;
	}
	public void setIssuer(IssueAgencyVO issuer) {
		this.issuer = issuer;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getVariety() {
		return Variety;
	}
	public void setVariety(String variety) {
		Variety = variety;
	}
	public int getStartBid() {
		return startBid;
	}
	public void setStartBid(int startBid) {
		this.startBid = startBid;
	}
	public int getShareUnit() {
		return shareUnit;
	}
	public void setShareUnit(int shareUnit) {
		this.shareUnit = shareUnit;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getValidTime() {
		return validTime;
	}
	public void setValidTime(String validTime) {
		this.validTime = validTime;
	}
	public String getTermHorizon() {
		return termHorizon;
	}
	public void setTermHorizon(String termHorizon) {
		this.termHorizon = termHorizon;
	}
	public HistoryDataVO getHistoryData() {
		return historyData;
	}
	public void setHistoryData(HistoryDataVO historyData) {
		this.historyData = historyData;
	}
	/**投资类别*/
	private String category;
	/**具体品种*/
	private String Variety;
	/**起投价*/
	private int startBid;
	/**份额变动单位*/
	private int shareUnit;
	/**申请赎回到账时间*/
	private String returnTime;
	/**购买到生效时间*/
	private String validTime;
	/**投资期限*/
	private String termHorizon;
	/**历史数据*/
	private HistoryDataVO historyData;
	
}
