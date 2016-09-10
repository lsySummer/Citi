package nju.financecity_android.dao;

import nju.financecity_android.util.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by coral on 16-9-3.
 */
public abstract class CommonDao {

    public static final String host = "http://127.0.0.1:8080";

    /**
     * 指定接口。
     * 不一定要实现这个方法。
     *
     * @return api地址
     */
    public abstract String getAction();

    /**
     * 在这里定义完整的接口url。
     *
     * @return 完整的接口url。如果是get请求应该包含所有的参数
     */
    public abstract String getFullUrl();

    /**
     * 在这里发送自定义http请求并返回响应内容。
     *
     * @return 服务器响应内容。
     */
    public abstract String sendRequest();

    public Map readData() {
        Map data = null;
        String jsonString = sendRequest();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            data = objectMapper.readValue(jsonString, Map.class);
        } catch (IOException e) {
            System.err.println("读取到了数据，但是在解析为json的时候出现了错误。");
        }
        return data;
    }
}
