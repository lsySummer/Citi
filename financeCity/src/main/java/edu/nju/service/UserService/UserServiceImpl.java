package edu.nju.service.UserService;

import edu.nju.dao.BaseDao;
import edu.nju.dao.UserDao;
import edu.nju.dao.impl.BaseDaoImpl;
import edu.nju.dao.impl.CommonDao;
import edu.nju.model.User;
import edu.nju.model.UserLogin;
import edu.nju.service.BaseService.BaseServiceAdaptor;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.POJO.UserInfo;
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
    public boolean modifyUserInfo(UserVO userVO) {
        try {
            List list = getUserDao().find("FROM User user WHERE user.id=" + ID);
            if (list == null || list.size() == 0) {
                return false;
            }

            User user = (User)list.get(0);

            if (validPassword(userVO.getPassword())) {
                user.setPassword(userVO.getPassword());
            }
            user.setEmail(userVO.getEmail());
            user.setSecureAnswer(userVO.getAnswer());
            user.setPhone(userVO.getPhone());
            user.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            //TODO:set account
            user.setAccount("");
            //TODO:set chosen question
            user.setChoosedQuestions(0);

            return true;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return false;
        }
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
