package nju.financecity_android.vo;

/**
 * Created by coral on 16-9-8.
 */
public class GoodsInfo {
    public String goodsName;
    public String goodsId;
    public double price;
    public int amount;
    public String type, subType; // "基金" "保险" "债券" ""

    public GoodsInfo(String goodsId, String goodsName, double price, int amount) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.price = price;
        this.amount = amount;
    }
}
