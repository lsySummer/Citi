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
    boolean buyProduct(Long productID);

    /**
     * redeem/sell product
     * @param ProductID .
     * @return if success
     */
    boolean redeemProduct(Long ProductID);

    /**
     * enforce investment plan
     * @return if success
     */
    boolean enforceInvestmentPlan();
}
