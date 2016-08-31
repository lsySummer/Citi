package edu.nju.service.ExceptionsAndError;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class InvalidPasswordException extends Exception{
    public InvalidPasswordException() {
        super("Invalid Password Exception");
    }
}
