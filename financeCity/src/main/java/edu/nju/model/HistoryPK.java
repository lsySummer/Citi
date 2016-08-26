package edu.nju.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
public class HistoryPK implements Serializable {
    private int commodityId;
    private int productId;

    @Column(name = "commodity_id")
    @Id
    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    @Column(name = "product_id")
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistoryPK historyPK = (HistoryPK) o;

        if (commodityId != historyPK.commodityId) return false;
        if (productId != historyPK.productId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commodityId;
        result = 31 * result + productId;
        return result;
    }
}
