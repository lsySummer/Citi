package edu.nju.service.PayService;

import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.POJO.Payment;
import edu.nju.service.POJO.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class PayServiceImpl extends BaseFunctionService implements PayService {

    @Override
    public boolean bindCards() {
        return false;
    }

    @Override
    public boolean payForProducts(List<Payment> payments) {
        return false;
    }
}
