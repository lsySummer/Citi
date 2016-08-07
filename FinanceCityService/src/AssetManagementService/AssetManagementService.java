package AssetManagementService;

import BaseService.BaseService;
import POJO.Event;
import POJO.InvestmentPortFolio;
import POJO.Product;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public interface AssetManagementService extends BaseService{
    /**
     * get invested products
     * @return products
     */
    List<Product> getInvestedProducts();

    /**
     * get investment portfolio
     * @return investment portfolio
     */
    InvestmentPortFolio getInvestmentPortfolio();

    /**
     * get events in chronological order
     * @return events
     */
    List<Event> getEvents();
}
