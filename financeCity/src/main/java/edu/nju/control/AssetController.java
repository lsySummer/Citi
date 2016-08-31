package edu.nju.control;

import edu.nju.service.AssetManagementService.AssetManagementService;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.CurrentInvestmentVO;
import edu.nju.vo.TradeHistoryListVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sun YuHao on 2016/8/30.
 */
@Controller
@RequestMapping("/api")
public class AssetController {
    @RequestMapping(value = "/asset/history", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    TradeHistoryListVO getHistoryVO(HttpServletRequest request) {
        AssetManagementService assetManagementService = ServiceManagerImpl.getInstance().getAssetManagementService();

        return assetManagementService.getTradeHistory((FinanceCityUser)request.getSession().getAttribute("user"));
    }

    @RequestMapping(value = "/investment", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    CurrentInvestmentVO getCurrentInvestmentVO(HttpServletRequest request) {
        AssetManagementService assetManagementService = ServiceManagerImpl.getInstance().getAssetManagementService();

        return assetManagementService.getInvestProductVOList((FinanceCityUser)request.getSession().getAttribute("user"));
    }
}
