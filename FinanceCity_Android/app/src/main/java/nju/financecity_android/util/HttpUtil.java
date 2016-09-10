package nju.financecity_android.util;

import nju.financecity_android.dao.CommonDao;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * Created by coral on 16-9-3.
 */
public class HttpUtil {

    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     *
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url;
            URL realUrl = new URL(urlNameString);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.connect();
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    public static String sendRequest(String url, String requestBody, String method) {
        String result = "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(method);
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.connect();

            PrintWriter pw = new PrintWriter(connection.getOutputStream());
            pw.print(requestBody);
            pw.flush();
            pw.close();

            Scanner scanner = new Scanner(connection.getInputStream());
            while (scanner.hasNextLine()) {
                result += new String(scanner.nextLine().getBytes("UTF-8"), "UTF-8") + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String sendJson(String url, JSONObject jsonData, String method) {
        return sendRequest(url, jsonData.toString(), method);
    }

    public static void main(String[] args) {
        System.out.println(sendRequest(CommonDao.host + "/api/user", "{'id': 18187459874, 'session': '489c50b7a1171376ec41c4730e24c27b'}", "GET"));
    }
}
