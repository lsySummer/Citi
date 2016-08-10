package edu.nju.service.PayService;

import edu.nju.service.BaseService.BaseService;
import edu.nju.service.POJO.Payment;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public interface PayService extends BaseService {
    /**
     * TODO:add parameters
     * @return if success
     */
    boolean bindCards();

    /**
     * @param payments .
     * @return if success
     */
    boolean payForProducts(List<Payment> payments);
}
