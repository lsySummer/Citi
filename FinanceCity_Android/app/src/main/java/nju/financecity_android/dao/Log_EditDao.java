package nju.financecity_android.dao;

/**
 * Created by sam on 16/9/14.
 */
public class Log_EditDao extends CommonDao {
    @Override
    public String getAction() {
        return host+"/api/user";
    }

    @Override
    public String getFullUrl() {
        return getAction();
    }

    @Override
    public String sendRequest() {
        return null;
    }
}
