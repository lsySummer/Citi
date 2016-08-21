package edu.nju.service.SearchService.ProductManager;

import edu.nju.service.UserService.UserService;

/**
 * Created by Sun YuHao on 2016/8/14.
 */
public interface ProductCategoryManager {
    /**
     * get product type by id
     * @param ID .
     * @return type
     */
    String getType(Integer ID);

    /**
     * get item index by product id
     * @param ID .
     * @return .
     */
    Integer getProductItemIndex(Integer ID);

    /**
     * generate product id
     * @param itemId .
     * @param category .
     * @return product id.
     */
    Integer generateProductID(int itemId, String category);
}
