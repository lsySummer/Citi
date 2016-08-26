package edu.nju.service.CategoryAndProduct;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
public class Product {
    private Integer ID;
    private Category category;
    private Object product;

    public Product(Integer ID, Category category, Object product) {
        this.ID = ID;
        this.category = category;
        this.product = product;
    }

    public Integer getID() {
        return ID;
    }

    public Category getCategory() {
        return category;
    }

    public Object getProduct() {
        return product;
    }

    public String getUnit() {
        return category.getUnit();
    }
}
