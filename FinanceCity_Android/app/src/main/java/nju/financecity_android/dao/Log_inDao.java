package nju.financecity_android.dao;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by sam on 16/9/6.
 */
public class Log_inDao {
    private static String mainurl = "http://172.26.99.26:8080/api／";

//    private static String url = "http://192.168.1.102:8080/api/login";

    public String sendPost(JSONObject param,String Api) {

         String ResultRes = null;
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    //client
//                    final HttpClient httpClient = new DefaultHttpClient();
//                    final HttpPost request = new HttpPost(url);
//                    // 绑定到请求的Entry
//                    StringEntity StringEn = new StringEntity(param.toString());
//
//                    Log.i("test","sendPost: StringEntity="+param.toString());
//
//                    StringEn.setContentType("application/json");
//                    request.setEntity(StringEn);
//                    // 发送请求
//                    Log.i("test","try one111");
//                    final HttpResponse httpResponse = httpClient.execute(request);
//                    Log.i("test","try one");
//                    String ress = null;
////                    if(httpResponse.getStatusLine().getStatusCode() == 200){
//                        // 得到应答的字符串，这也是一个 JSON 格式保存的数据
//                        Log.i("test","try two");
//                        HttpEntity entity = httpResponse.getEntity();
//                        ress = EntityUtils.toString(entity);
////                    }else {
////                        Log.d("test","wrong");
////                    }
////            httpResponse = new DefaultHttpClient().execute(request);
////            // 得到应答的字符串，这也是一个 JSON 格式保存的数据
////            String retSrc = EntityUtils.toString(httpResponse.getEntity());
//                    Log.i("test","sendPost: retSrc="+ ress);
//
//                } catch (Exception e)
//                {
//                    Log.e("test", "sendPost: Exception"+e);
//                    e.printStackTrace();
//                }
//            }
//        }).start();

        HttpURLConnection connection = null;
        try {
            URL url = new URL(mainurl+Api);
            connection = (HttpURLConnection) url.openConnection();
//            Log.i("testss", "try01");
//            String data = "\"username\":\"administer\",\"passwd\":\"123456\"";
            String data = param.toString();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setConnectTimeout(20000);
            connection.setReadTimeout(8000);
            // 设置请求的头
            connection.setRequestProperty("Connection", "keep-alive");
            // 设置请求的头
            connection.setRequestProperty("Content-Type",
                    "application/json");
            // 设置请求的头
//                    connection.setRequestProperty("Content-Length",
//                            String.valueOf(data.getBytes().length));
            // 设置请求的头
//                    connection
//                            .setRequestProperty("User-Agent",
//                                    "Mozilla/5.0 (Windows NT 6.3; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0");
            connection.connect();
            Log.i("testss", "try0");
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeBytes(data);
            Log.i("testss", "try1");
            if (connection.getResponseCode() == 200) {
                InputStream in = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                Log.i("test", "result = " + response.toString());
                ResultRes = response.toString();
            } else {
                Log.i("test", "Wrong");
            }
//                    HttpClient httpClient = new DefaultHttpClient();
//                    Log.i("test","try0");
//                    HttpGet httpGet = new HttpGet("http://www.baidu.com");
//                    Log.i("test","try1");
//                    HttpResponse httpResponse = httpClient.execute(httpGet);
//                    Log.i("test","try2");
//                    if(httpResponse.getStatusLine().getStatusCode() == 200){
//                        HttpEntity entity = httpResponse.getEntity();
//                        String response = EntityUtils.toString(entity,"utf-8");
//                        Log.i("test","response = "+response);
//                    }else {
//                        Log.i("test","Wrong");
//                    }
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("testss", "result=" + e);
        }

//        String aaa = "{     \"error\": 6,     \"message\": \"reason of error\"  , \"session\":\"asda\"}";
        return ResultRes;
    }
}
