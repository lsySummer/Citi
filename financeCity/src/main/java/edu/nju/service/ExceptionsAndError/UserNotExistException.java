package edu.nju.service.ExceptionsAndError;

/**
 * Created by Sun YuHao on 2016/9/2.
 */
public class UserNotExistException extends Exception {
    public UserNotExistException(String user) {
        super("User '" + user + "' does no exist");
    }
}
