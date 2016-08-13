package edu.nju.service.Invoker;

/**
 * Created by Sun YuHao on 2016/8/13.
 */
public interface APIFilter {
    boolean isAvailable(String apiName);
}
