package edu.nju.service.BaseService;

import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.UserService.UserService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/7.
 */
public class BaseFunctionService implements BaseService {
    protected UserService userService;

    @Override
    public Object invokeAPI(String apiName, List<Object> param) throws InvalidAPINameException {
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
        catch (Exception e) {
            e.printStackTrace();
            throw new InvalidAPINameException(apiName);
        }
    }

    @Override
    public List<String> getAPIList() {
        List<String> apiList = new ArrayList<>();
        for (Method method : getClass().getMethods()) {
            apiList.add(method.getName());
        }

        return apiList;
    }

    public void bindUserService(UserService userService) {
        this.userService = userService;
    }

    protected UserService getUserService() {
        return userService;
    }
}
