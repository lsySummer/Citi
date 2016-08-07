package Exceptions;

/**
 * Created by dell on 2016/7/25.
 */
public class InvalidProductNameException extends Exception{
    InvalidProductNameException(String message) {
        super("Invalid product name: " + message);
    }
}
