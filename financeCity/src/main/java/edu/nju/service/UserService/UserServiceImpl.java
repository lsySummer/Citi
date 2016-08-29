package edu.nju.service.UserService;

import edu.nju.dao.BaseDao;
import edu.nju.dao.UserDao;
import edu.nju.dao.impl.CommonDao;
import edu.nju.model.User;
import edu.nju.model.UserLogin;
import edu.nju.service.BaseService.BaseServiceAdaptor;
import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class UserServiceImpl extends BaseServiceAdaptor implements UserService {
    private Integer ID;
    private String loginID;
    private boolean loginState;

    @Autowired
    private BaseDao DAO;

    @Override
    public Integer register(RegisterInfo regInfo) {
        return null;
    }

    @Override
    public Integer login(String userName, String password) {
        /** match username and password */
        List list = DAO.login("SELECT id FROM User user WHERE user.username=? AND user.password=?", userName, password);

        /** if login failed */
        if (list == null || list.size() == 0) {
            return null;
        }
        /** if succeed */
        else {
            ID = (Integer)list.get(0);
            /** online */
            UserLogin userLogin = new UserLogin();
            userLogin.setUserId(ID);
            userLogin.setDate(new Timestamp(System.currentTimeMillis()));
            loginID = MD5_32(new Timestamp(System.currentTimeMillis()).toString() + ID);
            userLogin.setLoginId(loginID);
            DAO.save(userLogin);
            loginState = true;

            return ID;
        }
    }

    @Override
    public boolean logout() {
        /** not online */
        try {
            UserLogin userLogin = (UserLogin)DAO.find("FROM UserLogin userLogin WHERE userLogin.id=" + ID +
            " AND userLogin.loginID=" + loginID).get(0);
            if (userLogin != null) {
                getUserDao().delete(userLogin);
                ID = null;
                loginState = false;
            }
            else {
                return false;
            }
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
            List list = DAO.find("SELECT loginID FROM UserLogin userLogin WHERE userLogin.id=" + getID());
            /** weather login id is the same as the one in database*/
            return (loginID.equals((String) list.get(0)));
        }
        catch (NotLoginException n) {
            return false;
        }
    }

    @Override
    public UserVO getUserVO() throws NotLoginException{
        UserVO userVO = new UserVO();

        try {
            List list = DAO.find("FROM User u WHERE u.id=" + getID());
            User user = (User) list.get(0);

            userVO.setIfCity(user.getIfCity() == 1);
            userVO.setName(user.getName());
            userVO.setBirthday(user.getBirthday().toString());
            userVO.setCityName(user.getCity());
            userVO.setMonthlyExpense(user.getMonthlyExpense());
            userVO.setError(ErrorManager.errorNormal);
            userVO.setMessage(ErrorManager.getDescreption(ErrorManager.errorNormal));

            return userVO;
        }
        catch (NotLoginException e) {
            userVO.setError(ErrorManager.errorNotLogin);
            userVO.setMessage(ErrorManager.getDescreption(ErrorManager.errorNotLogin));
            e.printStackTrace();
            throw e;
        }
    }

    //TODO:...
    @Override
    public boolean modifyUserInfo(UserVO userVO) {
        return false;
    }

    @Override
    public Integer getID() throws NotLoginException {
        if (ID == null) {
            throw new NotLoginException();
        }

        return ID;
    }

    @Override
    public UserDao getUserDao() throws NotLoginException {
        if (!isLogin()) {
            throw new NotLoginException();
        }
        else {
            return (UserDao)DAO;
        }
    }

    private String MD5_32(String message) {
        return DigestUtils.md5DigestAsHex(message.getBytes());
    }
    private boolean validPassword(String password) {
        //TODO:add judge
        return false;
    }

    @Override
    public CommonDao getCommonDao() {
        return (CommonDao)DAO;
    }
}
