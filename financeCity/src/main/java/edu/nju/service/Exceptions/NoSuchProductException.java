package edu.nju.service.Exceptions;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class NoSuchProductException extends Exception{
    public NoSuchProductException(String message) {
        super("Invalid product name: " + message);
    }
    public NoSuchProductException(Integer ID) {
        super("Invalid product ID: " + ID);
    }
}
