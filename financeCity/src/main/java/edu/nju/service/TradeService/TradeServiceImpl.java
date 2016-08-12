package edu.nju.service.TradeService;

import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.Exceptions.InvalidAPINameException;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class TradeServiceImpl extends BaseFunctionService implements TradeService {

    @Override
    public boolean buyProduct(Long productID) {
        return false;
    }

    @Override
    public boolean redeemProduct(Long ProductID) {
        return false;
    }

    @Override
    public boolean enforceInvestmentPlan() {
        return false;
    }
}
