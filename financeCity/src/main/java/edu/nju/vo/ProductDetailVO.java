package edu.nju.vo;

/**
 * @author lsy
 * 产品详情
 */
public class ProductDetailVO {
	/**产品简要描述*/
	private String briefDes;
	
	public String getBriefDes() {
		return briefDes;
	}

	public void setBriefDes(String briefDes) {
		this.briefDes = briefDes;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**详细介绍*/
	private String introduction;
	
	/**图片地址*/
	private String imgUrl;
	
	/**官方地址链接*/
	private String url;
}
