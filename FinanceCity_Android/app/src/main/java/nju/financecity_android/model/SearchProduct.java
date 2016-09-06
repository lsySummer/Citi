package nju.financecity_android.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.financecity_android.dao.SearchDao;
import nju.financecity_android.vo.ProductVO;

/**
 * Created by Administrator on 2016/9/6.
 */
public class SearchProduct {
    private List<Map<String,Object>> analyse()//TODO 针对不同筛选条件
    {
        String mRawData= new SearchDao().sendPost();
        return onPostExecute(mRawData);
    }

    private List<Map<String,Object>> onPostExecute(String result)
    {
        List<Map<String,Object>> resultList=new ArrayList<Map<String,Object>>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            int resultCode = jsonObject.getInt("error");
            if (resultCode == 0) {
                JSONArray resultJsonArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < resultJsonArray.length(); i++) {
                    JSONObject resultJsonObject = resultJsonArray.getJSONObject(i);
                    String type = resultJsonObject.getString("productType");
                    HashMap<String, Object> map = new HashMap<>();
                    switch (type) {
                        case "bank":
                            map.put("productId", resultJsonObject.getInt("productId"));
                            map.put("productType", type);
                            map.put("pid", resultJsonObject.getInt("pid"));
                            map.put("name", resultJsonObject.getString("name"));
                            map.put("yearly_income_rate", resultJsonObject.getDouble("yearly_income_rate"));
                            map.put("product_type", resultJsonObject.getString("product_type"));
                            map.put("income_type", resultJsonObject.getString("income_type"));
                            map.put("initial_money", resultJsonObject.getInt("initial_money"));
                            map.put("open_date", resultJsonObject.getString("open_date"));
                            map.put("distributor_bank", resultJsonObject.getString("distributor_bank"));
                            map.put("distributor_institution", resultJsonObject.getString("distributor_institution"));
                            break;
                        case "fund":
                            map.put("productId", resultJsonObject.getInt("productId"));
                            map.put("productType", type);
                            map.put("pid", resultJsonObject.getInt("pid"));
                            map.put("name", resultJsonObject.getString("name"));
                            map.put("expected_income_rate", resultJsonObject.getDouble("expected_income_rate"));
                            map.put("state", resultJsonObject.getString("state"));
                            map.put("net_value", resultJsonObject.getString("net_value"));
                            map.put("sid", resultJsonObject.getInt("sid"));
                            map.put("type", resultJsonObject.getString("type"));
                            map.put("mng_charge_rate", resultJsonObject.getString("mng_charge_rate"));
                            map.put("est_date", resultJsonObject.getString("est_date"));
                            break;
                        case "insurance":
                            map.put("productId", resultJsonObject.getInt("productId"));
                            map.put("productType", type);
                            map.put("pid", resultJsonObject.getInt("pid"));
                            map.put("name", resultJsonObject.getString("name"));
                            map.put("insurance_life", resultJsonObject.getDouble("insurance_life"));
                            map.put("amount_in_force", resultJsonObject.getString("amount_in_force"));
                            map.put("way_of_charge", resultJsonObject.getString("way_of_charge"));
                            map.put("distributor", resultJsonObject.getInt("distributor"));
                            break;
                        case "bond":
                            map.put("productId", resultJsonObject.getInt("productId"));
                            map.put("productType", type);
                            map.put("pid", resultJsonObject.getInt("pid"));
                            map.put("name", resultJsonObject.getString("name"));
                            map.put("year_interest_rate", resultJsonObject.getDouble("year_interest_rate"));
                            map.put("nominal_interest_rate", resultJsonObject.getString("nominal_interest_rate"));
                            map.put("life", resultJsonObject.getString("life"));
                            map.put("type", resultJsonObject.getInt("type"));
                            map.put("code", resultJsonObject.getInt("code"));
                            break;
                    }
                    resultList.add(map);
                }
            }
        }catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultList;
    }
}
