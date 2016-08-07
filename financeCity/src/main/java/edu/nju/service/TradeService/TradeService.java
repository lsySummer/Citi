package edu.nju.service.TradeService;

import edu.nju.service.BaseService.BaseService;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public interface TradeService extends BaseService {
    /**
     * buy product
     * @param productID .
     * @return if success
     */
    boolean buyProduct(String productID);

    /**
     * redeem/sell product
     * @param ProductID .
     * @return if success
     */
    boolean redeemProduct(String ProductID);

    /**
     * enforce investment plan
     * @return if success
     */
    boolean enforceInvestmentPlan();
}
