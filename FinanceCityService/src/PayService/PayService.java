package PayService;

import BaseService.BaseService;
import POJO.Product;

import java.util.List;

/**
 * Created by dell on 2016/7/25.
 */
public interface PayService extends BaseService {
    /**
     * TODO:add parameters
     * @return if success
     */
    boolean bindCards();

    /**
     * TODO:add parameters identify cards
     * @param products .
     * @return if success
     */
    boolean payForProducts(List<Product> products);
}
