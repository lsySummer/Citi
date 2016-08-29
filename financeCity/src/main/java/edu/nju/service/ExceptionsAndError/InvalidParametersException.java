package edu.nju.service.ExceptionsAndError;

/**
 * Created by Sun YuHao on 2016/8/18.
 */
public class InvalidParametersException extends Exception {
    public InvalidParametersException(String message) {
        super("Invalid parameter while invoking function: " + message);
    }
}
