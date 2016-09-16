package edu.nju.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.service.AssetManagementService.AssetManagementService;
import edu.nju.service.ExceptionsAndError.EmptyProductListException;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.ExceptionsAndError.NothingToPayException;
import edu.nju.service.ExceptionsAndError.PaymentFailedException;
import edu.nju.service.POJO.SimpleTradeInfo;
import edu.nju.service.POJO.TradeInfoWithCheckCode;
import edu.nju.service.PayService.PayService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.TradeService.TradeService;
import edu.nju.vo.OrderResultVO;
import edu.nju.vo.ProductVO;

/**
 * Created by Hermit on 16/9/5.
 */
@Controller
public class OrderAction extends BaseAction {
    @Autowired
    private TradeService tradeService;
    @Autowired
    private PayService payService;
    @Autowired
	AssetManagementService assetManagementService;

    @SuppressWarnings("unchecked")
    public String confirm() {
        try {
            FinanceCityUser financeCityUser = (FinanceCityUser)session.get("user");
            if (financeCityUser == null) {
                throw new NotLoginException();
            }
            String checkCode=request.getParameter("hidValue");
            if (checkCode == null) {
                throw new InvalidParametersException("checkCode");
            }
            List<TradeInfoWithCheckCode> list = (List<TradeInfoWithCheckCode>)session.get("investResult");
            if (list == null || list.size() == 0) {
                throw new EmptyProductListException();
            }

            List<SimpleTradeInfo> tradeInfoList = null;
            for (TradeInfoWithCheckCode tradeInfoWithCheckCode : list) {
                if (tradeInfoWithCheckCode.getCheckCode().equals(checkCode)) {
                    tradeInfoList = tradeInfoWithCheckCode.getTradeInfos();
                    request.setAttribute("tradeInfoList",tradeInfoList );
                }
            }
            if (tradeInfoList != null) {
                OrderResultVO orderResultVO = tradeService.buyProduct(tradeInfoList, financeCityUser);
                ErrorManager.setError(request, ErrorManager.errorNormal);
                session.put("orderResult", orderResultVO);
            }
            else {
                throw new InvalidParametersException("checkCode");
            }

            return SUCCESS;
        }
        catch (EmptyProductListException e) {
            e.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorNoSuchInvestmentPortfolio);
        }
        catch (NotLoginException n) {
            ErrorManager.setError(request, ErrorManager.errorNotLogin);
            return LOGIN;
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorInvalidParameter);
        }

        return ERROR;
    }

    @SuppressWarnings("unchecked")
    public String pay() {
        try {
            FinanceCityUser financeCityUser = (FinanceCityUser)session.get("user");
            if (financeCityUser == null) {
                throw new NotLoginException();
            }
            OrderResultVO orderResultVO = (OrderResultVO)session.get("orderResult");
            if (orderResultVO == null) {
                throw new NothingToPayException();
            }

            boolean success = payService.payForPortfolio(orderResultVO.getCheckCode(), financeCityUser);
            if (!success) {
                throw new PaymentFailedException();
            }

            return SUCCESS;
        }
        catch (NotLoginException e) {
            ErrorManager.setError(request, ErrorManager.errorNotLogin);
            return LOGIN;
        }
        catch (NothingToPayException n) {
            n.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorNoSuchOrder);
        }
        catch (PaymentFailedException p) {
            p.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorPaymentFailed);
        }

        return ERROR;
    }
    
    public String buyCombine(){
    	return confirm();
    }
}
