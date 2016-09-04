package edu.nju.action;

import edu.nju.model.PayWay;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.PayService.PayService;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.BaseVO;
import edu.nju.vo.PayWayVO;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
public class AndroidPayAction extends AndroidAction {
    private String bindPayWay() {
        BaseVO baseVO = new BaseVO();
        ErrorManager.setError(baseVO, ErrorManager.errorNormal);

        setResult(baseVO);

        return SUCCESS;
    }

    private String getPayWayList() {
        PayWayVO payWayVO = new PayWayVO();

        try {
            PayService payService = ServiceManagerImpl.getInstance().getPayService();
            List<PayWay> payWayList = payService.getPayWayList((FinanceCityUser) session.get("user"));

            if (payWayList == null) {
                ErrorManager.setError(payWayVO, ErrorManager.errorDataNotFound);
                setResult(payWayVO);

                return SUCCESS;
            }

            int size = payWayList == null ? 0 :payWayList.size();
            PayWayVO.PayWayResult[] payWayResults = new PayWayVO.PayWayResult[size];
            for (int i = 0; i < size; ++i) {
                payWayResults[i].setPid(payWayList.get(i).getId());
                payWayResults[i].setDescription(payWayList.get(i).getPayWay());
            }

            payWayVO.setDate(payWayResults);
            ErrorManager.setError(payWayVO, ErrorManager.errorNormal);

            setResult(payWayVO);
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(payWayVO, ErrorManager.errorNotLogin);
            setResult(payWayVO);
        }

        return SUCCESS;
    }

    public String payMode() {
        String method = request.getMethod();

        if (method.equals("GET")) {
            return getPayWayList();
        }
        else if (method.equals("POST")) {
            return bindPayWay();
        }
        else {
            BaseVO baseVO = new BaseVO();
            ErrorManager.setError(baseVO, ErrorManager.errorUnhandledMethod);
        }

        return SUCCESS;
    }
}
