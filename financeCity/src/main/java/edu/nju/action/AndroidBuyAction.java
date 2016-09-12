package edu.nju.action;

import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;
import edu.nju.service.ExceptionsAndError.NoSuchProductException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.SimpleTradeInfo;
import edu.nju.service.SearchService.SearchService;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.TradeService.TradeService;
import edu.nju.vo.OrderResultVO;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
public class AndroidBuyAction extends AndroidAction {
    @Autowired
    SearchService searchService;
    @Autowired
    TradeService tradeService;

    @SuppressWarnings("unchecked")
    public String order() {
        Map map = getRequestMap();
        OrderResultVO orderResultVO = new OrderResultVO();

        try {
            List<Map> productList = (List<Map>)map.get("product_list");
            if (productList == null || productList.size() == 0) {
                throw new InvalidParametersException("product_list");
            }

            int id = (Integer)map.get("id");
            String session = (String)map.get("sessionId");

            List<SimpleTradeInfo> simpleTradeInfoList = new ArrayList<>();
            for (Map tradeMap : productList) {
                int pid = (Integer)tradeMap.get("pid");
                double amount = (Double)tradeMap.get("amount");

                SimpleTradeInfo simpleTradeInfo = new SimpleTradeInfo();
                simpleTradeInfo.setAmount(amount);
                simpleTradeInfo.setProductId(pid);
            }

            FinanceCityUser financeCityUser = new FinanceCityUser();
            financeCityUser.setID(id);
            financeCityUser.setLoginSession(session);

            orderResultVO = tradeService.buyProduct(simpleTradeInfoList, financeCityUser);
            ErrorManager.setError(orderResultVO, ErrorManager.errorNormal);
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            ErrorManager.setError(orderResultVO, ErrorManager.errorNotLogin);
        }
        catch (NoSuchProductException n) {
            n.printStackTrace();
            ErrorManager.setError(orderResultVO, ErrorManager.errorNoSuchProduct);
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(orderResultVO, ErrorManager.errorInvalidParameter);
        }

        return SUCCESS;
    }
}
