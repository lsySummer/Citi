package edu.nju.action;

import edu.nju.model.UserTemperPrefer;
import edu.nju.service.AssetManagementService.AssetManagementService;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.InvalidUserPreferenceException;
import edu.nju.service.ExceptionsAndError.NotAllConfigurationSetException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.InvestAdvisorService.InvestAdvisorService;
import edu.nju.service.POJO.AssetValue;
import edu.nju.service.POJO.SimplePortfolio;
import edu.nju.service.POJO.SimpleTradeInfo;
import edu.nju.service.POJO.TradeInfoWithCheckCode;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.AssetValueHistoryVO;
import edu.nju.vo.CurrentInvestmentVO;
import edu.nju.vo.RecommendedPortfolioVO;
import edu.nju.vo.TradeHistoryListVO;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
public class AndroidAssetAction extends AndroidAction {
    @Autowired
    AssetManagementService assetManagementService;
    @Autowired
    InvestAdvisorService investAdvisorService;
    @Autowired
    UserService userService;

    public String getHistoryVO() {
        if (!request.getMethod().equals("POST")) {
            TradeHistoryListVO tradeHistoryListVO = new TradeHistoryListVO();
            ErrorManager.setError(tradeHistoryListVO, ErrorManager.errorUnhandledMethod);
            setResult(tradeHistoryListVO);
            return SUCCESS;
        }

        try {
            FinanceCityUser financeCityUser = getUser();
            if (financeCityUser == null) {
                throw new  NotLoginException();
            }

            setResult(assetManagementService.getTradeHistory(financeCityUser));
        }
        catch (Exception e) {
            TradeHistoryListVO tradeHistoryListVO = new TradeHistoryListVO();
            ErrorManager.setError(tradeHistoryListVO, ErrorManager.errorNotLogin);

            setResult(tradeHistoryListVO);
        }

        return SUCCESS;
    }

    public String getCurrentInvestmentVO() {
        if (!request.getMethod().equals("POST")) {
            CurrentInvestmentVO currentInvestmentVO = new CurrentInvestmentVO();
            ErrorManager.setError(currentInvestmentVO, ErrorManager.errorUnhandledMethod);
            setResult(currentInvestmentVO);

            return SUCCESS;
        }

        try {
            FinanceCityUser financeCityUser = getUser();
            if (financeCityUser == null) {
                throw new NotLoginException();
            }

            setResult(assetManagementService.getInvestProductVOList(financeCityUser));
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            CurrentInvestmentVO currentInvestmentVO = new CurrentInvestmentVO();
            ErrorManager.setError(currentInvestmentVO, ErrorManager.errorNotLogin);

            setResult(currentInvestmentVO);
        }
        catch (Exception e) {
            e.printStackTrace();
            CurrentInvestmentVO currentInvestmentVO = new CurrentInvestmentVO();
            ErrorManager.setError(currentInvestmentVO, ErrorManager.errorInnerDataError);

            setResult(currentInvestmentVO);
        }

        return SUCCESS;
    }

    public String getAssetHistoryVO() {
        Map map = getRequestMap();
        AssetValueHistoryVO assetValueHistoryVO = new AssetValueHistoryVO();

        try {
            FinanceCityUser financeCityUser = getUser();
            if (financeCityUser == null) {
                throw new NotLoginException();
            }

            Integer days = (Integer)map.get("days");
            if (days == null) {
                days = Integer.MAX_VALUE;
            }

            List<AssetValue> assetValueList = assetManagementService.getAssetValueHistory(financeCityUser, days);
            assetValueHistoryVO.setAssetValues(assetValueList);

            ErrorManager.setError(assetValueHistoryVO, ErrorManager.errorNormal);
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            ErrorManager.setError(assetValueHistoryVO, ErrorManager.errorNotLogin);
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(assetValueHistoryVO, ErrorManager.errorInvalidParameter);
        }

        setResult(assetValueHistoryVO);
        return SUCCESS;
    }

    public String getRecommendPortfolio() {
                RecommendedPortfolioVO recommendedPortfolioVO = new RecommendedPortfolioVO();

                try {
                    FinanceCityUser financeCityUser = getUser();
                    if (financeCityUser == null) {
                        throw new NotLoginException();
                    }

                    UserTemperPrefer userTemperPrefer = userService.getUserTemper(financeCityUser);
            List<TradeInfoWithCheckCode> list = investAdvisorService.createInvestmentPortFolio(userTemperPrefer);

            List<SimplePortfolio> portfolios = new ArrayList<>();
            for (TradeInfoWithCheckCode tradeInfoWithCheckCode : list) {
                SimplePortfolio simplePortfolio = new SimplePortfolio();
                simplePortfolio.setPortfolio(tradeInfoWithCheckCode.getTradeInfos());
                portfolios.add(simplePortfolio);
            }

            recommendedPortfolioVO.setData(portfolios);
            ErrorManager.setError(recommendedPortfolioVO, ErrorManager.errorNormal);
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            ErrorManager.setError(recommendedPortfolioVO, ErrorManager.errorNotLogin);
        }
        catch (NotAllConfigurationSetException n) {
            n.printStackTrace();
            ErrorManager.setError(recommendedPortfolioVO, ErrorManager.errorUserInfoNotSet);
        }
        catch (InvalidUserPreferenceException i) {
            i.printStackTrace();
            ErrorManager.setError(recommendedPortfolioVO, ErrorManager.errorInvalidUserPreference);
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(recommendedPortfolioVO, ErrorManager.errorInnerDataError);
        }

        setResult(recommendedPortfolioVO);

        return SUCCESS;
    }
}
