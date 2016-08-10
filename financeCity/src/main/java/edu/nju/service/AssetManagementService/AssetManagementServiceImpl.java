package edu.nju.service.AssetManagementService;

import edu.nju.service.BaseService.BaseFunctionService;
import edu.nju.service.POJO.Event;
import edu.nju.service.POJO.InvestmentPortFolio;
import edu.nju.service.POJO.Product;
import edu.nju.vo.InvestProductVO;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class AssetManagementServiceImpl extends BaseFunctionService implements AssetManagementService {

    @Override
    public List<Product> getInvestedProducts() {
        return null;
    }

    @Override
    public InvestmentPortFolio getInvestmentPortfolio() {
        return null;
    }

    @Override
    public List<InvestProductVO> getInvestProductVOList() {
        return null;
    }

    @Override
    public List<Event> getEvents() {
        return null;
    }
}
