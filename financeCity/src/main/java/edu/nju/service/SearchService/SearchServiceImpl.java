package edu.nju.service.SearchService;

import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.Exceptions.InvalidProductNameException;
import edu.nju.service.POJO.Filter;
import edu.nju.service.POJO.Product;
import edu.nju.service.POJO.ProductBaseInfo;
import edu.nju.service.POJO.SearchConfig;
import edu.nju.vo.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class SearchServiceImpl extends BaseFunctionService implements SearchService {

    @Override
    public Product getProductByName(String productName) throws InvalidProductNameException {
        return null;
    }

    @Override
    public List<Product> searchProductByFilter(Filter filter) {
        return null;
    }

    @Override
    public List<ProductBaseInfo> searchProductsByKey(String keyWord) {
        return null;
    }

    @Override
    public List<ProductBaseInfo> getAllProducts() {
        return null;
    }

    @Override
    public List<ProductBaseInfo> searchProductsByConfig(SearchConfig searchConfig) {
        return null;
    }

    @Override
    public HistoryDataVO getHistoryDataVO(String productId) {
        return null;
    }

    @Override
    public ProductDetailVO getProductDetailVO(String productID) {
        return null;
    }

    @Override
    public ProjectVO getProjectVO(String projectID) {
        return null;
    }

    @Override
    public TimeLineVO getTimeLineVO(String ID) {
        return null;
    }
}
