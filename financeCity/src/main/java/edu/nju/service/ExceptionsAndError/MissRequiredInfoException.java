package edu.nju.service.ExceptionsAndError;

/**
 * Created by Sun YuHao on 2016/8/18.
 */
public class MissRequiredInfoException extends Exception {
    public MissRequiredInfoException(String category) {
        super("Miss required info while invest category :" + category );
    }
}
