package edu.nju.service.AssetManagementService;

import edu.nju.model.InvestStatus;
import edu.nju.model.TradeHistory;
import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.Event;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.*;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class AssetManagementServiceImpl extends BaseFunctionServiceAdaptor implements AssetManagementService {
    private SearchService searchService;

    @SuppressWarnings("unchecked")
    @Override
    public CurrentInvestmentVO getInvestProductVOList(FinanceCityUser financeCityUser) {
        CurrentInvestmentVO currentInvestmentVO = new CurrentInvestmentVO();

        try {
            List<InvestStatus> list = getUserService().getUserDao(financeCityUser).
                    find("FROM InvestStatus investStatus WHERE investHistory.id=" + financeCityUser.getID());
            if (list == null || list.size() == 0) {
                return null;
            }
            else {
                List<ProductVO> investList = new ArrayList<>();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                for (InvestStatus investStatus : list) {
                    try {
                        Product product = searchService.getProductByID(investStatus.getProductId());
                        ProductVO productVO = new ProductVO();
                        productVO.setBuyingDate(dateFormat.format(investStatus.getDate()));
                        productVO.setBuyingValue(investStatus.getTotalValue().doubleValue());
                        productVO.setName(product.getName());
                        productVO.setCurrentValue(getCurrentValue(investStatus.getAmount(), product));
                        productVO.setType(ProductCategoryManager.getChineseName(product.getCategory().getCategoryName()));
                        productVO.setError(0);
                        productVO.setMessage("");
                        //TODO:set redeem date
                        productVO.setCanRedeemDate("");
                        //TODO:set end date
                        productVO.setEndDate("");

                        investList.add(productVO);
                    }
                    catch (NoSuchProductException n) {
                        n.printStackTrace();
                    }
                }

                currentInvestmentVO.setProductVOList(investList);
                ErrorManager.setError(currentInvestmentVO, ErrorManager.errorNormal);
            }

        }
        catch (NotLoginException e) {
            e.printStackTrace();
            ErrorManager.setError(currentInvestmentVO, ErrorManager.errorNotLogin);
        }

        return currentInvestmentVO;
    }

    @Override
    public void bindSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    //TODO:get current value
    private double getCurrentValue(int amount, Product product) {
        return 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public TradeHistoryListVO getTradeHistory(FinanceCityUser financeCityUser){
        TradeHistoryListVO tradeHistoryListVO = new TradeHistoryListVO();

        try {
            List<TradeHistoryVO> tradeHistoryVOList = new ArrayList<>();
            List list = getUserService().getUserDao(financeCityUser).find("FROM TradHistory t WHERE t.userId=" + financeCityUser.getID());

            if (list == null || list.size() == 0) {
                ErrorManager.setError(tradeHistoryListVO, ErrorManager.errorDateNotFound);
            }

            List<TradeHistory> tradeHistoryList = (List<TradeHistory>) list;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (TradeHistory tradeHistory : tradeHistoryList) {
                try {
                    TradeHistoryVO tradeHistoryVO = new TradeHistoryVO();
                    Product product = searchService.getProductByID(tradeHistory.getProductId());

                    tradeHistoryVO.setAmount(tradeHistory.getAmount());
                    tradeHistoryVO.setDate(dateFormat.format(tradeHistory.getTradeAt()));
                    tradeHistoryVO.setProductId(product.getID());
                    tradeHistoryVO.setProductName(product.getName());
                    tradeHistoryVO.setTradingType(tradeHistory.getTradeType());
                    tradeHistoryVO.setUnit(product.getCategory().getUnit());
                    tradeHistoryVO.setTradingVolume(tradeHistory.getTradingVolume().doubleValue());

                    tradeHistoryVOList.add(tradeHistoryVO);
                } catch (NoSuchProductException n) {
                    n.printStackTrace();
                }
            }

            tradeHistoryListVO.setTradeHistoryVOList(tradeHistoryVOList);
            ErrorManager.setError(tradeHistoryListVO, ErrorManager.errorNormal);
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            ErrorManager.setError(tradeHistoryListVO, ErrorManager.errorNotLogin);
        }

        return tradeHistoryListVO;
    }
}
