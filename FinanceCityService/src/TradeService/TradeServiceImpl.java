package TradeService;

import Exceptions.InvalidAPINameException;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class TradeServiceImpl implements TradeService {
    @Override
    public Object invokeAPI(String api, Map<String, Object> param) throws InvalidAPINameException {
        return null;
    }

    @Override
    public boolean buyProduct(String productID) {
        return false;
    }

    @Override
    public boolean redeemProduct(String ProductID) {
        return false;
    }

    @Override
    public boolean enforceInvestmentPlan() {
        return false;
    }

    @Override
    public List<String> getAPIList() {
        return null;
    }
}
