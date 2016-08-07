package AssetManagementService;

import Exceptions.InvalidAPINameException;
import POJO.Event;
import POJO.InvestmentPortFolio;
import POJO.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class AssetManagementServiceImpl implements AssetManagementService {
    @Override
    public Object invokeAPI(String api, Map<String, Object> param) throws InvalidAPINameException {
        return null;
    }

    @Override
    public List<Product> getInvestedProducts() {
        return null;
    }

    @Override
    public List<String> getAPIList() {
        return null;
    }

    @Override
    public InvestmentPortFolio getInvestmentPortfolio() {
        return null;
    }

    @Override
    public List<Event> getEvents() {
        return null;
    }
}
