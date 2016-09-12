package nju.financecity_android.dao;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class SearchDao {
//    private String url="http://172.19.105.116:8888/Citi/api/product/s";//TODO 使用服务器URL
    private static String url="http://192.168.1.111:8888/Citi/api/product/s";

    public String sendPost(JSONObject param)
    {
        try {
            HttpPost request = new HttpPost(url);
            // 绑定到请求 Entry
            StringEntity se = new StringEntity(param.toString());

            Log.i("test","sendRequest: StringEntity="+param.toString());

            se.setContentType("application/json");
            request.setEntity(se);
            // 发送请求
            HttpResponse httpResponse = null;
            httpResponse = new DefaultHttpClient().execute(request);
            // 得到应答的字符串，这也是一个 JSON 格式保存的数据
            String retSrc = EntityUtils.toString(httpResponse.getEntity());
            Log.i("test","sendRequest: retSrc="+retSrc);
            return retSrc;
        } catch (Exception e)
        {
            Log.e("test", "sendRequest: Exception");
            e.printStackTrace();
        }
        return null;
    }
}
