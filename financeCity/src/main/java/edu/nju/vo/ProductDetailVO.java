package edu.nju.vo;

/**
 * @author lsy
 * 产品详情
 */
public class ProductDetailVO extends BaseVO {
	private String type;
	private Object data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
