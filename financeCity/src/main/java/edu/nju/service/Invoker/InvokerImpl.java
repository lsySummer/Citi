package edu.nju.service.Invoker;

import edu.nju.service.BaseService.BaseService;
import edu.nju.service.ExceptionsAndError.InvalidAPINameException;
import edu.nju.service.ExceptionsAndError.InvalidParametersException;

import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/13.
 */
public class InvokerImpl implements Invoker {
    private String apiName;
    private BaseService service;

    public InvokerImpl(String apiName, BaseService service) {
        this.apiName = apiName;
        this.service = service;
    }

    @Override
    public Object invokeAPI(List<Object> param) throws InvalidAPINameException, InvalidParametersException {
        return service.invokeAPI(apiName, param);
    }

    @Override
    public void setAPIName(String name) {
        this.apiName = name;
    }

    @Override
    public void setService(BaseService service) {
        this.service = service;
    }
}
