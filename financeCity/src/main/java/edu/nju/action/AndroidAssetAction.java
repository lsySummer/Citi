package edu.nju.action;

import edu.nju.service.AssetManagementService.AssetManagementService;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.AssetValue;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.AssetValueHistoryVO;
import edu.nju.vo.CurrentInvestmentVO;
import edu.nju.vo.TradeHistoryListVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
public class AndroidAssetAction extends AndroidAction {
    @Autowired
    AssetManagementService assetManagementService;

    public String getHistoryVO() {
        Map map = getRequestMap();

        if (!request.getMethod().equals("POST")) {
            TradeHistoryListVO tradeHistoryListVO = new TradeHistoryListVO();
            ErrorManager.setError(tradeHistoryListVO, ErrorManager.errorUnhandledMethod);
            return SUCCESS;

        }

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

    public String getAssetHistoryVO() {
        AssetValueHistoryVO assetValueHistoryVO = new AssetValueHistoryVO();

        try {
            int days = Integer.valueOf(request.getParameter("days"));
            int id = Integer.valueOf(request.getParameter("id"));
            String session = request.getParameter("sessionId");

            FinanceCityUser financeCityUser = new FinanceCityUser();
            financeCityUser.setID(id);
            financeCityUser.setLoginSession(session);

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
}
