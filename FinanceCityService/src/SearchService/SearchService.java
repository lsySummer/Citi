package SearchService;

import BaseService.BaseService;
import Exceptions.InvalidProductNameException;
import POJO.Filter;
import POJO.Product;
import POJO.ProductBaseInfo;
import POJO.SearchConfig;

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


}
