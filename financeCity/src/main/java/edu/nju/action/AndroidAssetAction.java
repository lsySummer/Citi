package edu.nju.action;

import edu.nju.service.AssetManagementService.AssetManagementService;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.CurrentInvestmentVO;
import edu.nju.vo.TradeHistoryListVO;
import edu.nju.vo.TradeHistoryVO;

import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
public class AndroidAssetAction extends AndroidAction {
    public String getHistoryVO() {
        Map map = getRequestMap();

        if (!request.getMethod().equals("POST")) {
            TradeHistoryListVO tradeHistoryListVO = new TradeHistoryListVO();
            ErrorManager.setError(tradeHistoryListVO, ErrorManager.errorUnhandledMethod);
            return SUCCESS;

        }

        AssetManagementService assetManagementService = ServiceManagerImpl.getInstance().getAssetManagementService();

        try {
            FinanceCityUser financeCityUser = new FinanceCityUser();
            financeCityUser.setID((Integer)map.get("id"));
            financeCityUser.setLoginSession((String)map.get("session"));
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
        Map map = getRequestMap();

        if (!request.getMethod().equals("POST")) {
            CurrentInvestmentVO currentInvestmentVO = new CurrentInvestmentVO();
            ErrorManager.setError(currentInvestmentVO, ErrorManager.errorUnhandledMethod);
            return SUCCESS;

        }

        AssetManagementService assetManagementService = ServiceManagerImpl.getInstance().getAssetManagementService();

        try {
            FinanceCityUser financeCityUser = new FinanceCityUser();
            financeCityUser.setID((Integer)map.get("id"));
            financeCityUser.setLoginSession((String)map.get("session"));
            setResult(assetManagementService.getInvestProductVOList(financeCityUser));
        }
        catch (Exception e) {
            CurrentInvestmentVO currentInvestmentVO = new CurrentInvestmentVO();
            ErrorManager.setError(currentInvestmentVO, ErrorManager.errorNotLogin);

            setResult(currentInvestmentVO);
        }

        return SUCCESS;
    }
}
