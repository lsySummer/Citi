package edu.nju.service.ExceptionsAndError;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException() {
        super("User Already Exist While Registering");
    }
}
