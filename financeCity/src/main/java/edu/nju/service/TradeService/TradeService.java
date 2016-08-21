package edu.nju.service.TradeService;

import edu.nju.service.BaseService.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface TradeService extends BaseService {
    /**
     * buy product
     * @param tradeItemList .
     * @return if success
     */
    List<String> buyProduct(List<TradeItem> tradeItemList);

    /**
     * cancel unpaid product
     * @param checkCode .
     */
    boolean cancelUnpaid(String checkCode);

    /**
     * cancel all unpaid product
     */
    boolean cancelAllUnpaid();

    /**
     * redeem/sell product
     * @param ProductID .
     * @return if success
     */
    boolean redeemProduct(Integer ProductID);

    /**
     * enforce investment plan
     * @return if success
     */
    boolean enforceInvestmentPlan();
}
