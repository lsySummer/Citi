package edu.nju.service.ExceptionsAndError;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class InvalidServiceNameException extends Exception {
    public InvalidServiceNameException(String message) {
        super("Invalid service name: " + message);
    }
}
