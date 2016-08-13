package edu.nju.service.Invoker;

import edu.nju.service.BaseService.BaseService;
import edu.nju.service.Exceptions.InvalidAPINameException;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/13.
 */
public interface Invoker {
    Object invokeAPI(List<Object> param) throws InvalidAPINameException;
    void setAPIName(String name);
    void setService(BaseService service);
}
