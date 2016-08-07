package edu.nju.service.Exceptions;

/**
 * Created by dell on 2016/7/25.
 */
public class InvalidAPINameException extends Exception {
    public InvalidAPINameException(String message) {
        super("Invalid API name: " + message);
    }
}
