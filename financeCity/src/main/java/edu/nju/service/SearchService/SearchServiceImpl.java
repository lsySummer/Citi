package edu.nju.service.SearchService;

import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
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
public class SearchServiceImpl extends BaseFunctionServiceAdaptor implements SearchService {

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
    public HistoryDataVO getHistoryDataVO(Long productId) {
        return null;
    }

    @Override
    public ProductDetailVO getProductDetailVO(Long productID) {
        return null;
    }

    @Override
    public ProjectVO getProjectVO(Long projectID) {
        return null;
    }

    @Override
    public TimeLineVO getTimeLineVO() {
        return null;
    }
}
