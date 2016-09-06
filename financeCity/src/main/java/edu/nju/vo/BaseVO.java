package edu.nju.vo;

/**
 * Created by Sun YuHao on 2016/8/28.
 */
public class BaseVO {
    int Error;
    String Message;

    public int getError() {
        return Error;
    }

    public void setError(int error) {
        Error = error;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
