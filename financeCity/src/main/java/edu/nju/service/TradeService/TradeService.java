package edu.nju.service.TradeService;

import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.SimpleTradeInfo;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.OrderResultVO;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface TradeService {
    /**
     * buy product
     * @param tradeInfoList , user info.
     * @return checkCode
     */
    OrderResultVO buyProduct(List<SimpleTradeInfo> tradeInfoList, FinanceCityUser financeCityUser) throws NotLoginException, NoSuchProductException;

    /**
     * cancel unpaid product
     * @param checkCode .
     */
    boolean cancelUnpaid(String checkCode, FinanceCityUser financeCityUser);

    boolean cancelUnpaid(int product_id, FinanceCityUser financeCityUser);

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

    void ackPayment(String checkCode, FinanceCityUser financeCityUser) throws NotLoginException, NoSuchProductException;
}
