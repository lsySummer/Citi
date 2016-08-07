package Exceptions;

/**
 * Created by dell on 2016/7/25.
 */
public class InvalidServiceNameException extends Exception {
    public InvalidServiceNameException(String message) {
        super("Invalid service name: " + message);
    }
}
