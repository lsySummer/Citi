package edu.nju.service.CategoryAndProduct;

/**
 * Created by Sun YuHao on 2016/8/26.
 */
public class ProductFactory {
    static public Product createProduct(Object product, String category) {
        return new Product(ProductCategoryManager.generateProductID(product, category),
                ProductCategoryManager.getCategoryByName(category), product);
    }
}
