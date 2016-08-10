package edu.nju.service.UserService;

import edu.nju.dao.BaseDao;
import edu.nju.dao.impl.BaseDaoImpl;
import edu.nju.service.Exceptions.InvalidAPINameException;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.POJO.Online;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.POJO.UserInfo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class UserServiceImpl implements UserService {
    private Long ID;
    private String loginID;
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
    public Long register(RegisterInfo regInfo) {
        return null;
    }

    @Override
    public Long login(String userName, String password) {
        /** match username and password */
        List list = DAO.login("SELECT id FROM User user WHERE user.username=? AND user.password=?", userName, password);

        /** if login failed */
        if (list == null || list.size() == 0) {
            return null;
        }
        /** if succeed */
        else {
            ID = (Long)list.get(0);
            /** online */
            DAO.save(new Online(ID));
            loginState = true;

            return ID;
        }
    }

    @Override
    public boolean logout() {
        ID = null;
        loginState = false;

        /** not online */
        try {
            getUserDao().delete(new Online(ID));
        }
        catch (NotLoginException n) {
            n.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean isLogin() {
        if (!loginState) {
            return false;
        }

        try {
            List list = DAO.find("SELECT loginID FROM Online online WHERE online.id=" + getID());
            /** weather login id is the same as the one in database*/
            return (loginID.equals((String) list.get(0)));
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public boolean modifyUserInfo(UserInfo userInfo) {
        return false;
    }

    @Override
    public Long getID() throws NotLoginException {
        if (ID == null) {
            throw new NotLoginException();
        }

        return ID;
    }

    @Override
    public BaseDao getUserDao() throws NotLoginException {
        if (!isLogin()) {
            throw new NotLoginException();
        }
        else {
            return DAO;
        }
    }
}
