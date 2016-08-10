package edu.nju.service.Exceptions;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class NotAllConfigurationSetException extends Exception {
    public NotAllConfigurationSetException() {
        super("Not all configuration were set");
    }
}
