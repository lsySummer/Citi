package edu.nju.service.POJO;

/**
 * Created by dell on 2016/7/25.
 */
public class Product {
    public Product(Object product, String category) {
        this.product = product;
        this.category = category;
    }

    private Object product;
    private String category;

    public Object getProduct() {
        return product;
    }

    public void setProduct(Object product) {
        this.product = product;
    }
}
