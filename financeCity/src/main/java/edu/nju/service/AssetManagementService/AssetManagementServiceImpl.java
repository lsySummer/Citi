package edu.nju.service.AssetManagementService;

import edu.nju.model.*;
import edu.nju.service.CategoryAndProduct.Category;
import edu.nju.service.CategoryAndProduct.Product;
import edu.nju.service.CategoryAndProduct.ProductCategoryManager;
import edu.nju.service.ExceptionsAndError.DataNotFoundException;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.Investment_portfolio;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.service.Utils.TimeTransformation;
import edu.nju.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class AssetManagementServiceImpl implements AssetManagementService {
    @Autowired
    private SearchService searchService;
    @Autowired
    private UserService userService;

    @SuppressWarnings("unchecked")
    @Override
    public CurrentInvestmentVO getInvestProductVOList(FinanceCityUser financeCityUser) {
        CurrentInvestmentVO currentInvestmentVO = new CurrentInvestmentVO();

        try {
            List<InvestStatus> list = userService.getUserDao(financeCityUser).
                    find("FROM InvestStatus investStatus WHERE investStatus.userId=" + financeCityUser.getID());
            if (list == null || list.size() == 0) {
                ErrorManager.setError(currentInvestmentVO, ErrorManager.errorDataNotFound);
                return null;
            }
            else {
                List<Investment_portfolio> investment_portfolioList = new ArrayList<>();
                for (InvestStatus investStatus : list) {
                    InvestmentPortfolio investmentPortfolio = (InvestmentPortfolio)userService.getUserDao(financeCityUser).
                            find("FROM InvestmentPortfolio i WHERE i.id=" + investStatus.getPortfolioId()).get(0);

                    List<TradeHistory> tradeHistoryList = userService.getUserDao(financeCityUser).
                            find("FROM TradHistory t WHERE t.portfolioId=" + investmentPortfolio.getId());

                    List<ProductVO> productList = new ArrayList<>();
                    for (TradeHistory tradeHistory : tradeHistoryList) {
                        try {
                            Product product = searchService.getProductByID(tradeHistory.getId());
                            ProductVO productVO = new ProductVO();
                            productVO.setId(product.getID());
                            productVO.setType(product.getCategory().getChineseName());
                            productVO.setBuyingDate(tradeHistory.getDate().toString());
                            productVO.setCurrentValue(getCurrentValue(tradeHistory.getTradingVolume().doubleValue(), product, tradeHistory));
                            productVO.setBuyingValue(tradeHistory.getTradingVolume().doubleValue());
                            productVO.setName(product.getName());
                            productVO.setEndDate(getEndDate(tradeHistory, product));
                            //TODO:set redeem date
                            productVO.setCanRedeemDate("");

                            productList.add(productVO);
                        }
                        catch (NoSuchProductException n) {
                            n.printStackTrace();
                        }
                    }
                    Investment_portfolio investment_portfolio = new Investment_portfolio();
                    investment_portfolio.setProductVOs(productList);
                    investment_portfolioList.add(investment_portfolio);
                }

                currentInvestmentVO.setInvestmentPortfolioList(investment_portfolioList);
                ErrorManager.setError(currentInvestmentVO, ErrorManager.errorNormal);
            }
        }
        catch (NotLoginException e) {
            e.printStackTrace();
            ErrorManager.setError(currentInvestmentVO, ErrorManager.errorNotLogin);
        }

        return currentInvestmentVO;
    }

    private double getCurrentValue(double trading_volume, Product product, TradeHistory tradeHistory) {
        double current_value;
        if (product.getCategory().belongTo(ProductCategoryManager.categoryBond) ||
                product.getCategory().belongTo(ProductCategoryManager.categoryBank) ||
                product.getCategory().belongTo(ProductCategoryManager.categoryInsurance)) {
            double ret_rate = TimeTransformation.getTimeFromNow(tradeHistory.getDate(), 'd') / 365;
            current_value = (ret_rate + 1) * trading_volume;
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryFund)) {
            ProductFund productFund = (ProductFund)product.getProduct();
            current_value = (productFund.getNav().doubleValue() / tradeHistory.getNav().doubleValue()) * trading_volume;
        }
        else {
            //exception
            return trading_volume;
        }

        return current_value;
    }

    private double getProductValueOnDate(double tradingVolume, Category category, TradeHistory tradeHistory, Date date, double NAVOnDate) {
        double value;
        if (category.belongTo(ProductCategoryManager.categoryBond) ||
                category.belongTo(ProductCategoryManager.categoryBank) ||
                category.belongTo(ProductCategoryManager.categoryInsurance)) {
            double ret_rate = TimeTransformation.getTimeFromDate(new Date(tradeHistory.getDate().getTime()), date, TimeTransformation.year);
            value = (ret_rate + 1) * tradingVolume;
        }
        else if (category.belongTo(ProductCategoryManager.categoryFund)) {
            value = (NAVOnDate / tradeHistory.getNav().doubleValue()) * tradingVolume;
        }
        else {
            //exception
            return tradingVolume;
        }

        return value;
    }

    private String getEndDate(TradeHistory tradeHistory, Product product) {
        double endtime = 0;

        if (product.getCategory().belongTo(ProductCategoryManager.categoryInsurance)) {
            ProductInsurance productInsurance = (ProductInsurance)product.getProduct();
            endtime = TimeTransformation.getTimeAfter(tradeHistory.getDate(), productInsurance.getWarrantyPeriod().doubleValue(),
                    TimeTransformation.year, TimeTransformation.microSecond);
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryFund)) {
            ProductFund productFund = (ProductFund)product.getProduct();
            endtime = TimeTransformation.getTimeAfter(tradeHistory.getDate(), productFund.getLength().doubleValue(),
                    TimeTransformation.year, TimeTransformation.microSecond);
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryBank)) {
            ProductBank productBank = (ProductBank) product.getProduct();
            endtime = TimeTransformation.getTimeAfter(tradeHistory.getDate(), productBank.getLength().doubleValue(),
                    TimeTransformation.year, TimeTransformation.microSecond);
        }
        else if (product.getCategory().belongTo(ProductCategoryManager.categoryBond)) {
            ProductBond productBond = (ProductBond) product.getProduct();
            endtime = TimeTransformation.getTimeAfter(tradeHistory.getDate(), productBond.getLength().doubleValue(),
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
            List<TradeHistory> tradeHistoryList = userService.getUserDao(financeCityUser).find("FROM TradHistory t WHERE t.userId=" + financeCityUser.getID());

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
