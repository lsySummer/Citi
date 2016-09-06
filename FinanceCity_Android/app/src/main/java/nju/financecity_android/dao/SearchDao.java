package nju.financecity_android.dao;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class SearchDao {
    private String url="127.0.0.1:8080/product/s";
    public String sendPost()
    {
        HttpPost request = new HttpPost(url);
        // 先封装一个 JSON 对象
        JSONObject param = new JSONObject();
        try {
            param.put("name", "rarnu");
            param.put("password", "123456");
        } catch (JSONException e)
        {
            Log.e("json", "sendPost: exception1");
        }
        Log.i("json", "sendPost: "+param.toString());
        // 绑定到请求 Entry
        StringEntity se=null;
        try {
             se= new StringEntity(param.toString());
        }catch (UnsupportedEncodingException e)
        {
            Log.e("java", "sendPost: exception2");
        }
        request.setEntity(se);
        // 发送请求
        HttpResponse httpResponse = null;
        try {
            httpResponse = new DefaultHttpClient().execute(request);
        } catch (IOException e)
        {
            Log.e("java", "sendPost: exception3");
        }
        // 得到应答的字符串，这也是一个 JSON 格式保存的数据
        String retSrc = null;
        try{
            retSrc=EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e)
        {
            Log.e("java", "sendPost: exception4");
        }
        // 生成 JSON 对象
        JSONObject result = null;
        try {
            result = new JSONObject(retSrc);
        } catch(JSONException e)
        {
            Log.e("json", "sendPost: exception5");
        }

        String token = null;
        try {
            token = result.getString("token");
        } catch (JSONException e)
        {
            Log.e("json", "sendPost: exception6");
        }
        return token;
    }
}
