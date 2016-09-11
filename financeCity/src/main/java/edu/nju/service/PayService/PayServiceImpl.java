package edu.nju.service.PayService;

import edu.nju.model.PayWay;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.Payment;
import edu.nju.service.POJO.SimplePayWay;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    UserService userService;

    @Override
    public boolean bindCards(String cardNumber) {
        return false;
    }

    @Override
    public boolean payForProducts(List<Payment> payments) {
        return false;
    }

    @Override
    public void bindPayWay(SimplePayWay simplePayWay, FinanceCityUser financeCityUser) throws NotLoginException {
        PayWay payWay = new PayWay();
        payWay.setPayWay(simplePayWay.getPayment_mode());
        payWay.setUserId(financeCityUser.getID());

        userService.getUserDao(financeCityUser).save(payWay);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PayWay> getPayWayList(FinanceCityUser financeCityUser) throws NotLoginException {
        List<PayWay> list = (List<PayWay>)userService.getUserDao(financeCityUser).find("FROM PayWay p WHERE p.userId=" + financeCityUser.getID());

        if (list == null || list.size() == 0) {
            return null;
        }

        return list;
    }
}
