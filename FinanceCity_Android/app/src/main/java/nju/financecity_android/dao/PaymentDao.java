package nju.financecity_android.dao;

/**
 * Created by sam on 16/9/14.
 */
public class PaymentDao extends CommonDao {
    @Override
    public String getAction() {
        return host+"/payment/mode";
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
