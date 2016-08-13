package edu.nju.service.TradeService;

import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class TradeServiceImpl extends BaseFunctionServiceAdaptor implements TradeService {

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
