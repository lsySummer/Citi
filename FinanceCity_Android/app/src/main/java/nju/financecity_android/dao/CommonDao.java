package nju.financecity_android.dao;

import nju.financecity_android.util.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * Created by coral on 16-9-3.
 */
public abstract class CommonDao {

    public static final String host = "http://127.0.0.1:8080/";

    public abstract String getAction();

    public abstract String getFullUrl();

    public Map readData() {
        Map data = null;
        String url = getFullUrl();
        String jsonString = HttpUtil.sendGet(url);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            data = objectMapper.readValue(jsonString, Map.class);
        } catch (IOException e) {
            System.err.println("读取到了数据，但是在解析为json的时候出现了错误。");
        }
        return data;
    }

}
