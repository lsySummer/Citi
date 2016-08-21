package edu.nju.service.PayService;

import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.POJO.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class PayServiceImpl extends BaseFunctionServiceAdaptor implements PayService {

    @Override
    public boolean bindCards(String cardNumber) {
        return false;
    }

    @Override
    public boolean payForProducts(List<Payment> payments) {
        return false;
    }
}
