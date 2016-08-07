package SearchService;

import Exceptions.InvalidAPINameException;
import Exceptions.InvalidProductNameException;
import POJO.Filter;
import POJO.Product;
import POJO.ProductBaseInfo;
import POJO.SearchConfig;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class SearchServiceImpl implements SearchService {
    @Override
    public Object invokeAPI(String api, Map<String, Object> param) throws InvalidAPINameException {
        return null;
    }

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
    public List<String> getAPIList() {
        return null;
    }
}
