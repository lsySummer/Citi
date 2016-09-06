package edu.nju.service.CategoryAndProduct;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
public class ProductFactory {
    static public Product createProduct(Object product) {
        return new Product(ProductCategoryManager.generateProductID(product),
                ProductCategoryManager.getProductCategory(product), product);
    }
}
