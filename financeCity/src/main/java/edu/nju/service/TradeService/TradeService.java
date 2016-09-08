package edu.nju.service.TradeService;

import edu.nju.service.Sessions.FinanceCityUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface TradeService {
    /**
     * buy product
     * @param tradeItemList .
     * @return if success
     */
    List<String> buyProduct(List<TradeItem> tradeItemList, FinanceCityUser financeCityUser);

    /**
     * cancel unpaid product
     * @param checkCode .
     */
    boolean cancelUnpaid(String checkCode, FinanceCityUser financeCityUser);

    /**
     * cancel all unpaid product
     */
    boolean cancelAllUnpaid(FinanceCityUser financeCityUser);

    /**
     * redeem/sell product
     * @param ProductID .
     * @return if success
     */
    boolean redeemProduct(Integer ProductID, FinanceCityUser financeCityUser);

    /**
     * enforce investment plan
     * @return if success
     */
    boolean enforceInvestmentPlan();
}
