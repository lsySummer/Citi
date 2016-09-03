package edu.nju.control;

import edu.nju.model.PayWay;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.PayService.PayService;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.BaseVO;
import edu.nju.vo.PayWayVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/1.
 */
@Controller
@RequestMapping(value = "/")
public class PayController {
    @RequestMapping(value = "payment/mode", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    BaseVO bind(@RequestParam(value = "payment_mode") String payment_mode) {
        BaseVO baseVO = new BaseVO();
        ErrorManager.setError(baseVO, ErrorManager.errorNormal);

        return baseVO;
    }

    @RequestMapping(value = "payment/mode", method = RequestMethod.GET, produces = "application/json;cahrset=UTF-8")
    public @ResponseBody
    PayWayVO getPayWayList(HttpServletRequest request) {
        PayWayVO payWayVO = new PayWayVO();

        try {
            PayService payService = ServiceManagerImpl.getInstance().getPayService();
            List<PayWay> payWayList = payService.getPayWayList((FinanceCityUser) request.getSession().getAttribute("user"));

            if (payWayList == null) {
                ErrorManager.setError(payWayVO, ErrorManager.errorDateNotFound);
                return payWayVO;
            }

            PayWayVO.PayWayResult[] payWayResults = new PayWayVO.PayWayResult[payWayList.size()];
            for (int i = 0; i < payWayList.size(); ++i) {
                payWayResults[i].setPid(payWayList.get(i).getId());
                payWayResults[i].setDescription(payWayList.get(i).getPayWay());
            }

            payWayVO.setDate(payWayResults);
            ErrorManager.setError(payWayVO, ErrorManager.errorNormal);

            return payWayVO;
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(payWayVO, ErrorManager.errorNotLogin);
            return payWayVO;
        }
    }
}
