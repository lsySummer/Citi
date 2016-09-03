package edu.nju.action;

import edu.nju.service.Utils.JsonUtil;
import edu.nju.vo.BaseVO;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
public class AndroidAction extends BaseAction {
    private Map requestMap;
    private BaseVO result;
    private String textResult;

    @Override
    public void setServletRequest(HttpServletRequest request) {
        super.setServletRequest(request);
        try {
            requestMap = new JsonUtil(request.getInputStream()).getMap();
        }
        catch (IOException io) {
            io.printStackTrace();
            requestMap = new HashMap();
        }
    }

    protected Map getRequestMap() {
        return requestMap;
    }

    public BaseVO getResult() {
        return result;
    }

    public void setResult(BaseVO result) {
        this.result = result;
    }

    public String getTextResult() {
        return textResult;
    }

    public void setTextResult(String textResult) {
        this.textResult = textResult;
    }
}
