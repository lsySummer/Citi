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
    private static List<Map<String,Object>> analyse()//TODO 针对不同筛选条件
    {
//        String mRawData= new SearchDao().sendPost();
        String mRawData="{" +
                "'error':0," +
                "'message':'reason of error'," +
                "'data':[" +
                "{" +
                "'pid':100001," +
                "'name':'name'," +
                "'yearly_income_rate':0.0295," +
                "'product_type':'开放式净值型'," +
                "'income_type':'保本浮动收益型'," +
                "'initial_money':50000," +
                "'open_date':'yyyy-MM-dd'," +
                "'distributor_bank':'浦发银行'," +
                "'distributor_institution':'浦发银行'," +
                "},F4" +
                "{"+
                "'pid':100001," +
                "'name':'name'," +
                "'expected_income_rate':0.05," +
                "'state':'产品状态'," +
                "'net_value':10000," +
                "'sid':'基金编号'," +
                "'type':'简单基金'," +
                "'mng_charge_rate':4.5," +
                "'est_date':'yyyy-MM-dd'" +
                "}," +
                "{" +
                "'pid':100001," +
                "'name':'name'," +
                "'insurance_life':'终身'," +
                "'insurance_age':30," +
                "'amount_in_force':[100000, 200000]," +
                "'way_of_charge':'缴费方式'," +
                "'distributor':'叉叉基金'" +
                "}," +
                "{" +
                "'pid':100001," +
                "'name':'name'," +
                "'yearly_interest_rate':0.07," +
                "'nominal_interest_rate':0.025," +
                "'life':2," +
                "'type':'债券类型'," +
                "'code':'债券代码'" +
                "}" +
                "]" +
                "}";
        return onPostExecute(mRawData);
    }

    private static List<Map<String,Object>> onPostExecute(String result)
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
    public static void main(String[] args)
    {
        System.out.println(SearchProduct.analyse());
    }
}
