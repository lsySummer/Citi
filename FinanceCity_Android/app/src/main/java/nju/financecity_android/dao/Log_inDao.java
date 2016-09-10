package nju.financecity_android.dao;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 * Created by sam on 16/9/8.
 */
public class Log_inDao {
    private static String mainurl = "";

    private static String url="http://localhost:8888/Citi/api/institution";

    public String sendPost(JSONObject param)
    {
        try {
            HttpPost request = new HttpPost(url);
            // 绑定到请求的Entry
            StringEntity StringEn = new StringEntity(param.toString());

            Log.i("test","sendRequest: StringEntity="+param.toString());

            StringEn.setContentType("application/json");
            request.setEntity(StringEn);
            // 发送请求
            HttpResponse httpResponse = null;
            httpResponse = new DefaultHttpClient().execute(request);
            // 得到应答的字符串，这也是一个 JSON 格式保存的数据
            String retSrc = EntityUtils.toString(httpResponse.getEntity());
            Log.d("test","sendRequest: retSrc="+retSrc);
            return retSrc;
        } catch (Exception e)
        {
            Log.e("test", "sendRequest: Exception");
            e.printStackTrace();
        }
        return null;
    }
}
