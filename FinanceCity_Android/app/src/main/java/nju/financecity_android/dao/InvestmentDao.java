package nju.financecity_android.dao;

import nju.financecity_android.model.UserSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by coral on 16-9-12.
 */
public class InvestmentDao extends CommonDao {
    @Override
    public String getAction() {
        return "/api/investment";
    }

    @Override
    public String getFullUrl() {
        return CommonDao.host + getAction();
    }

    @Override
    public String sendRequest() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("id", Integer.parseInt(UserSession.getCurrUser().getUserId()));
            jo.put("sessionId", UserSession.getCurrUser().getSessionId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
