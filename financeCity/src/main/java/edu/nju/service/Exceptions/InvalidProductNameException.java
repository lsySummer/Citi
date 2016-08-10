package edu.nju.service.Exceptions;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class InvalidProductNameException extends Exception{
    InvalidProductNameException(String message) {
        super("Invalid product name: " + message);
    }
}
