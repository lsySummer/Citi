package edu.nju.service.SearchService;

import edu.nju.service.BaseService.BaseService;
import edu.nju.service.Exceptions.NoSuchProductException;
import edu.nju.service.POJO.Filter;
import edu.nju.service.POJO.Product;
import edu.nju.service.POJO.ProductBaseInfo;
import edu.nju.service.POJO.SearchConfig;
import edu.nju.service.SearchService.ProductManager.ProductFilter;
import edu.nju.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface SearchService extends BaseService{
    /**
     * get product info
     * @param productName .
     * @return product info
     */
    Product getProductByName(String productName) throws NoSuchProductException;

    /**
     * get product by id
     * @param ID .
     * @return product .
     * @throws NoSuchProductException .
     */
    Product getProductByID(Integer ID) throws NoSuchProductException;

    /**
     * search product by filter
     * @param filter .
     * @return products that are chosen
     */
    List<Product> searchProductByFilter(ProductFilter filter);

    /**
     * search products by keyword
     * @param keyWord .
     * @return products
     */
    List<Product> searchProductsByKey(String keyWord);

    /**
     * search product by condition
     * @param type .
     * @param cond .
     * Note:object name is 'p'
     * @return products list
     */
    List<Product> searchProductsByCondition(String type, String cond);

    /**
     * get product list by order
     * Note: object name is 'p'
     * @param type .
     * @param order .
     * @return product list order by param
     */
    List<Product> getProductListByOrder(String type, String order);

    /**
     * get history data
     * @param productId .
     * @return history data
     */
    HistoryDataVO getHistoryDataVO(Long productId);

    /**
     * get product detail
     * @param productID .
     * @return product detail
     */
    ProductDetailVO getProductDetailVO(Long productID);

    /**
     * get project
     * @param projectID .
     * @return project
     */
    ProjectVO getProjectVO(Long projectID);

    /**
     * generate product id
     * @param product_type .
     * @param itemId .
     * @return product id
     */
    int generateProductID(String product_type, int itemId);

    /**
     * search some object by min word
     * @param PO .
     * @param word .
     * @return .
     */
    Object searchMin(String PO, String word);
}
