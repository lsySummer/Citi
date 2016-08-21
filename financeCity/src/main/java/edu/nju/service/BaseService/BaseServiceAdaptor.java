package edu.nju.service.BaseService;

import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.Exceptions.InvalidParametersException;
import org.springframework.stereotype.Service;
import sun.plugin.dom.exception.InvalidAccessException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/8/13.
 */
@Service
public class BaseServiceAdaptor implements BaseService {
    protected List<String> apiList;

    @Override
    public Object invokeAPI(String apiName, List<Object> param) throws InvalidAPINameException,InvalidParametersException {
        List<Class> paramType = new ArrayList<>();
        for (Object arg : param) {
            paramType.add(arg.getClass());
        }

        try {
            Class[] args = new Class[param.size()];
            paramType.toArray(args);
            Method method = getClass().getMethod(apiName, args);
            return method.invoke(this, param.toArray());
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new InvalidAPINameException(apiName);
        }
        catch (IllegalAccessException | InvocationTargetException i) {
            i.printStackTrace();
            throw new InvalidParametersException(apiName);
        }
    }

    @Override
    public List<String> getAPIList() {
        if (apiList == null) {
            apiList = new ArrayList<>();
        }
        for (Method method : getClass().getMethods()) {
            apiList.add(method.getName());
        }

        return apiList;
    }
}
