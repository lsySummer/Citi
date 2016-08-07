package edu.nju.service.Exceptions;

/**
 * Created by dell on 2016/7/25.
 */
public class NotLoginException extends Exception {
    public NotLoginException() {
        super("Please login first");
    }
}
