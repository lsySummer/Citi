package edu.nju.service.AssetManagementService;

import edu.nju.model.*;
import edu.nju.service.BaseService.BaseFunctionServiceAdaptor;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.DataNotFoundException;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.Utils.TimeTransformation;
import edu.nju.vo.*;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
                        productVO.setId(product.getID());
                        productVO.setBuyingDate(dateFormat.format(investStatus.getDate()));
                        productVO.setBuyingValue(investStatus.getTradingVolume().doubleValue());
                        productVO.setName(product.getName());
                        productVO.setCurrentValue(getCurrentValue(investStatus.getTradingVolume().doubleValue(), product, investStatus));
                        productVO.setType(ProductCategoryManager.getChineseName(product.getCategory().getCategoryName()));
                        productVO.setError(0);
                        productVO.setMessage("");
                        productVO.setEndDate(getEndDate(investStatus, product));
                        //TODO:set redeem date
                        productVO.setCanRedeemDate("");


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

    private double getCurrentValue(double trading_volume, Product product, InvestStatus investStatus) {
        double current_value;
        if (product.getCategory().belongTo(ProductCategoryManager.categoryBond) ||
                product.getCategory().belongTo(ProductCategoryManager.categoryBank) ||
                product.getCategory().belongTo(ProductCategoryManager.categoryInsurance)) {
            double ret_rate = TimeTransformation.getTimeFromNow(investStatus.getDate(), 'd') / 365;
            current_value = (ret_rate + 1) * trading_volume;
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryFund)) {
            ProductFund productFund = (ProductFund)product.getProduct();
            current_value = (productFund.getNav().doubleValue() / investStatus.getNav().doubleValue()) * trading_volume;
        }
        else {
            //exception
            return trading_volume;
        }

        return current_value;
    }

    private String getEndDate(InvestStatus investStatus, Product product) {
        double endtime = 0;

        if (product.getCategory().belongTo(ProductCategoryManager.categoryInsurance)) {
            ProductInsurance productInsurance = (ProductInsurance)product.getProduct();
            endtime = TimeTransformation.getTimeAfter(investStatus.getDate(), productInsurance.getWarrantyPeriod().doubleValue(),
                    TimeTransformation.year, TimeTransformation.microSecond);
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryFund)) {
            ProductFund productFund = (ProductFund)product.getProduct();
            endtime = TimeTransformation.getTimeAfter(investStatus.getDate(), productFund.getLength().doubleValue(),
                    TimeTransformation.year, TimeTransformation.microSecond);
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryBank)) {
            ProductBank productBank = (ProductBank) product.getProduct();
            endtime = TimeTransformation.getTimeAfter(investStatus.getDate(), productBank.getLength().doubleValue(),
                    TimeTransformation.year, TimeTransformation.microSecond);
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryBond)) {
            ProductBond productBond = (ProductBond) product.getProduct();
            endtime = TimeTransformation.getTimeAfter(investStatus.getDate(), productBond.getLength().doubleValue(),
                    TimeTransformation.year, TimeTransformation.microSecond);
        }


        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(new Timestamp((long)endtime));
    }

    @SuppressWarnings("unchecked")
    @Override
    public TradeHistoryListVO getTradeHistory(FinanceCityUser financeCityUser){
        TradeHistoryListVO tradeHistoryListVO = new TradeHistoryListVO();

        try {
            List<TradeHistoryVO> tradeHistoryVOList = new ArrayList<>();
            List<TradeHistory> tradeHistoryList = getUserService().getUserDao(financeCityUser).find("FROM TradHistory t WHERE t.userId=" + financeCityUser.getID());

            if (tradeHistoryList == null || tradeHistoryList.size() == 0) {
                throw new DataNotFoundException("Trade History");
            }

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (TradeHistory tradeHistory : tradeHistoryList) {
                try {
                    TradeHistoryVO tradeHistoryVO = new TradeHistoryVO();
                    Product product = searchService.getProductByID(tradeHistory.getProductId());

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
        catch (DataNotFoundException d){
            d.printStackTrace();
            ErrorManager.setError(tradeHistoryListVO, ErrorManager.errorDataNotFound);
        }

        return tradeHistoryListVO;
    }
}
