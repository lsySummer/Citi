package edu.nju.service.Exceptions;

/**
 * Created by dell on 2016/8/13.
 */
public class DuplicateFunctionNameException extends Exception {
    public DuplicateFunctionNameException(String name) {
        super("Duplicate Function Name :" + name);
    }
}
