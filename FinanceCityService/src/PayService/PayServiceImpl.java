package PayService;

import Exceptions.InvalidAPINameException;
import POJO.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class PayServiceImpl implements PayService {
    @Override
    public Object invokeAPI(String api, Map<String, Object> param) throws InvalidAPINameException {
        return null;
    }

    @Override
    public boolean bindCards() {
        return false;
    }

    @Override
    public boolean payForProducts(List<Product> products) {
        return false;
    }

    @Override
    public List<String> getAPIList() {
        return null;
    }
}
