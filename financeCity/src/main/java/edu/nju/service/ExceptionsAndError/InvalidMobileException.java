package edu.nju.service.ExceptionsAndError;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class InvalidMobileException extends Exception{
    public InvalidMobileException() {
        super("Invalid Mobile");
    }
}
