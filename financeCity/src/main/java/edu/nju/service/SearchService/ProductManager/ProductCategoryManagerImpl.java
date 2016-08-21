package edu.nju.service.SearchService.ProductManager;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/14.
 */
@Service
public class ProductCategoryManagerImpl implements ProductCategoryManager {
    static private ProductCategoryManager productCategoryManager;
    private List<ProductCategory> productList;
    private final int serialNumberSize = 10000000;

    private  ProductCategoryManagerImpl() {
        productList = new ArrayList<>();
        productList.add(new ProductCategory(1, "Bond"));
        productList.add(new ProductCategory(2, "Fund"));
    }

    static public ProductCategoryManager getInstance() {
        if (productCategoryManager == null) {
            productCategoryManager = new ProductCategoryManagerImpl();
        }

        return productCategoryManager;
    }

    @Override
    public String getType(Integer ID) {
        int index = ID / serialNumberSize;
        for (ProductCategory productCategory : productList) {
            if (productCategory.getId() == ID) {
                return productCategory.getType();
            }
        }

        return null;
    }

    @Override
    public Integer getProductItemIndex(Integer ID) {
        return ID % serialNumberSize;
    }

    private class ProductCategory {
        private int id;
        private String type;

        private ProductCategory(int id, String type) {
            this.id = id;
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    @Override
    public Integer generateProductID(int itemId, String category) {
        for (ProductCategory productCategory : productList) {
            if (productCategory.getType().equals(category)) {
                return productCategory.getId() * serialNumberSize + itemId;
            }
        }

        return null;
    }
}
