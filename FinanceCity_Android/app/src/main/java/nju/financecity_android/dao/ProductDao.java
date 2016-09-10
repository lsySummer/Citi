package nju.financecity_android.dao;

import nju.financecity_android.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by coral on 16-9-3.
 */
public class ProductDao extends CommonDao {

    public ProductDao(String productId) {
        setProductId(productId);
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String getAction() {
        return "/api/product/info";
    }

    @Override
    public String getFullUrl() {
        return CommonDao.host + getAction();
    }

    @Override
    public String sendRequest() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("id", productId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return HttpUtil.postJson(getFullUrl(), jo);
    }

    private String productId;
}
