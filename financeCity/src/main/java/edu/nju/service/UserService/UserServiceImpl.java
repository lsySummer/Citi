package edu.nju.service.UserService;

import edu.nju.dao.BaseDao;
import edu.nju.dao.impl.BaseDaoImpl;
import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.POJO.UserInfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/7/25.
 */
public class UserServiceImpl implements UserService {
    private String ID;
    private boolean loginState;
    private BaseDao DAO;

    public UserServiceImpl() {
        DAO = new BaseDaoImpl();
    }

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

    @Override
    public String register(RegisterInfo regInfo) {
        return null;
    }

    @Override
    public String login(String userName, String password) {
        return null;
    }

    @Override
    public boolean logout() {
        ID = null;
        loginState = false;
        return true;
    }

    @Override
    public boolean isLogin() {
        return loginState;
    }

    @Override
    public boolean modifyUserInfo(UserInfo userInfo) {
        return false;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public BaseDao getUserDao() {
        if (!isLogin()) {
            return null;
        }
        else {
            return DAO;
        }
    }
}
