package nju.financecity_android.vo;

import java.util.Date;

/**
 * Created by coral on 16-8-27.
 */
public class ProductInfo {

    public ProductInfo() { }
    public ProductInfo(String id, String productName, Date buy, Date expiration, Date available, double buyPrice, double currPrice) {
        this.productId = id;
        this.productName = productName;
        this.buy = buy;
        this.expiration = expiration;
        this.available = available;
        this.buyPrice = buyPrice;
        this.currPrice = currPrice;
    }

    public String productId;
    public String productName;
    public Date buy, expiration, available;
    public double buyPrice, currPrice;
}
