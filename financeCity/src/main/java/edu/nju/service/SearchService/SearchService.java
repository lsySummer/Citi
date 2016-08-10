package edu.nju.service.SearchService;

import edu.nju.service.BaseService.BaseService;
import edu.nju.service.Exceptions.InvalidProductNameException;
import edu.nju.service.POJO.Filter;
import edu.nju.service.POJO.Product;
import edu.nju.service.POJO.ProductBaseInfo;
import edu.nju.service.POJO.SearchConfig;
import edu.nju.vo.*;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public interface SearchService extends BaseService{
    /**
     * get product info
     * @param productName .
     * @return product info
     */
    Product getProductByName(String productName) throws InvalidProductNameException;

    /**
     * search product by filter
     * @param filter .
     * @return products that are chosen
     */
    List<Product> searchProductByFilter(Filter filter);

    /**
     * search products by keyword
     * @param keyWord .
     * @return products
     */
    List<ProductBaseInfo> searchProductsByKey(String keyWord);

    /**
     * get all products
     * @return all products
     */
    List<ProductBaseInfo> getAllProducts();

    /**
     * get products by search config
     * @param searchConfig .
     * @return products needed
     */
    List<ProductBaseInfo> searchProductsByConfig(SearchConfig searchConfig);

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
     * get Timeline
     * @return timeline
     */
    TimeLineVO getTimeLineVO();
}
