package edu.nju.service.AssetManagementService;

import java.util.List;
import edu.nju.service.POJO.*;
import edu.nju.service.BaseService.BaseService;
import edu.nju.vo.InvestProductVO;

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
     * get InvestProductVOList
     * @return investProduct
     */
    List<InvestProductVO> getInvestProductVOList();

    /**
     * get events in chronological order
     * @return events
     */
    List<Event> getEvents();
}
