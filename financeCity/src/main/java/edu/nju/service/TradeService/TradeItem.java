package edu.nju.service.TradeService;

import edu.nju.service.POJO.Product;
import edu.nju.service.SearchService.ProductManager.ProductCategoryManagerImpl;
import org.springframework.util.DigestUtils;

/**
 * Created by Sun YuHao on 2016/8/17.
 */
public class TradeItem {
    private int amount;
    private double tradingVolume;
    private String type;
    private Product product;
    private String metaInfo;

    //TODO:maybe unnecessary?
    private int product_id;
    private double price;
    private String unit;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTradingVolume() {
        return tradingVolume;
    }

    public void setTradingVolume(double tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(String metaInfo) {
        this.metaInfo = metaInfo;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public TradeItem(int product_id, double price, String unit, int amount) {
        this.product_id = product_id;
        this.price = price;
        this.unit = unit;
        this.amount = amount;
    }

    public TradeItem(String product_type, int index, double price, String unit, int amount) {

        this.product_id = ProductCategoryManagerImpl.getInstance().generateProductID(index, product_type);
        this.price = price;
        this.unit = unit;
        this.amount = amount;
    }

    public TradeItem(double tradingVolume, String type, Product product, String metaInfo) {
        this.tradingVolume = tradingVolume;
        this.type = type;
        this.product = product;
        this.metaInfo = metaInfo;
    }

    public String generateMD5(int id, String timestamp) {
        return DigestUtils.md5DigestAsHex((timestamp + id +
                getProduct_id() + getAmount()).getBytes());
    }
}
