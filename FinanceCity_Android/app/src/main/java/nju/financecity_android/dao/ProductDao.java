package nju.financecity_android.dao;

/**
 * Created by coral on 16-9-3.
 */
public class ProductDao extends CommonDao {

    public ProductDao(String productId) {
        setProductId(productId);
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String getAction() {
        return "/product/info/" + productId;
    }

    @Override
    public String getFullUrl() {
        return CommonDao.host + getAction();
    }

    private String productId;
}
