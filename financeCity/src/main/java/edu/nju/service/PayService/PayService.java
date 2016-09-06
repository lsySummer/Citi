package edu.nju.service.PayService;

import edu.nju.model.PayWay;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.Payment;
import edu.nju.service.POJO.SimplePayWay;
import edu.nju.service.Sessions.FinanceCityUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface PayService extends BaseService {
    /**
     * @return if success
     */
    boolean bindCards(String cardNumber);

    /**
     * @param payments .
     * @return if success
     */
    boolean payForProducts(List<Payment> payments);

    void bindPayWay(SimplePayWay payWay, FinanceCityUser financeCityUser) throws NotLoginException;

    List<PayWay> getPayWayList(FinanceCityUser financeCityUser) throws NotLoginException;
}
