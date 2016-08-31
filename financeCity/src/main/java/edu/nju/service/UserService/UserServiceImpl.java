package edu.nju.service.UserService;

import edu.nju.dao.BaseDao;
import edu.nju.dao.UserDao;
import edu.nju.dao.impl.CommonDao;
import edu.nju.model.User;
import edu.nju.model.UserLogin;
import edu.nju.service.BaseService.BaseServiceAdaptor;
import edu.nju.service.ExceptionsAndError.*;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public class UserServiceImpl extends BaseServiceAdaptor implements UserService {
    @Autowired
    private BaseDao DAO;

    @Override
    public FinanceCityUser register(RegisterInfo regInfo) {
        return null;
    }

    @Override
    public FinanceCityUser login(String userName, String password) {
        /** match username and password */
        List list = DAO.login("SELECT id FROM User user WHERE user.username=? AND user.password=?", userName, password);

        /** if login failed */
        if (list == null || list.size() == 0) {
            return null;
        }
        /** if succeed */
        else {
            FinanceCityUser financeCityUser = new FinanceCityUser();
            financeCityUser.setID((Integer)list.get(0));
            /** online */
            UserLogin userLogin = new UserLogin();
            userLogin.setUserId(financeCityUser.getID());
            userLogin.setDate(new Timestamp(System.currentTimeMillis()));

            String session = MD5_32(userName + userLogin.getDate().toString());
            financeCityUser.setLoginSession(session);
            userLogin.setSession(session);
            DAO.saveOrUpdate(userLogin);

            return financeCityUser;
        }
    }

    @Override
    public boolean logout(FinanceCityUser financeCityUser) {
        /** not online */
        try {
            UserLogin userLogin = (UserLogin)DAO.find("FROM UserLogin userLogin WHERE userLogin.id=" + financeCityUser.getID() +
            " AND userLogin.session=" + financeCityUser.getLoginSession()).get(0);
            if (userLogin != null) {
                getUserDao(financeCityUser).delete(userLogin);
                financeCityUser.setID(null);
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
    public boolean isLogin(FinanceCityUser financeCityUser) {
        try {
            List list = DAO.find("SELECT loginID FROM UserLogin userLogin WHERE userLogin.id=" + financeCityUser.getID());
            /** weather login id is the same as the one in database*/
            return (financeCityUser.getLoginSession().equals(list.get(0)));
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserVO getUserVO(FinanceCityUser financeCityUser){
        UserVO userVO = new UserVO();

        try {
            List list = getUserDao(financeCityUser).find("FROM User u WHERE u.id=" + financeCityUser.getID());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            User user = (User) list.get(0);

            userVO.setUrben(user.getIfCity() == 1);
            userVO.setId(user.getId());
            userVO.setMobile(user.getPhone());
            userVO.setIncome(user.getIncome());
            userVO.setBirthday(dateFormat.format(user.getBirthday()));
            userVO.setExpense(user.getMonthlyExpense());
            ErrorManager.setError(userVO, ErrorManager.errorNormal);
        }
        catch (NotLoginException e) {
            ErrorManager.setError(userVO, ErrorManager.errorNotLogin);
            e.printStackTrace();
        }

        return userVO;
    }

    @Override
    public boolean modifyUserInfo(UserVO userVO, FinanceCityUser financeCityUser) {
        try {
            List list = getUserDao(financeCityUser).find("FROM User u WHERE u.id=" + financeCityUser.getID());
            User user = (User) list.get(0);

            user.setUpdateAt(new Timestamp(System.currentTimeMillis()));
            user.setBirthday(Timestamp.valueOf(userVO.getBirthday()));
            user.setIfCity(userVO.isUrben() ? (byte) 1 : 0);
            user.setMonthlyExpense(userVO.getExpense());
            user.setIncome(userVO.getIncome());
            user.setPhone(userVO.getMobile());

            getUserDao(financeCityUser).save(user);

            return true;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return false;
        }
    }

    @Override
    public UserDao getUserDao(FinanceCityUser financeCityUser) throws NotLoginException {
        if (!isLogin(financeCityUser)) {
            throw new NotLoginException();
        }
        else {
            return (UserDao)DAO;
        }
    }

    private String MD5_32(String message) {
        return DigestUtils.md5DigestAsHex(message.getBytes());
    }

    private boolean ifUserExist(String mobile) {
        List list = getCommonDao().find("FROM User u WHERE u.phone=" + mobile);
        return  (list.size() > 0);
    }

    private Integer getIDByMobile(String mobile) {
        List list = getCommonDao().find("SELECT id FROM User u WHERE u.phone=" + mobile);
        if (list == null || list.size() == 0) {
            return null;
        }
        else {
            return (Integer)list.get(0);
        }
    }


    @Override
    public CommonDao getCommonDao() {
        return (CommonDao)DAO;
    }

    @Override
    public FinanceCityUser register(String mobile, String password, String session) throws InvalidPasswordException, InvalidMobileException, UserAlreadyExistException {
        if (!validMobile(mobile)){
            throw new InvalidMobileException();
        }
        else if (!validPassword(password)) {
            throw new InvalidPasswordException();
        }
        else if (ifUserExist(mobile)) {
            throw new UserAlreadyExistException();
        }
        else {
            User user = new User();
            user.setPhone(mobile);
            user.setPassword(password);
            DAO.save(user);

            return login(mobile, password);
        }
    }

    @Override
    public boolean modifyUserInfo(String birthday, int income, boolean isUrben, int expense, FinanceCityUser financeCityUser) {
        try {
            List list = getUserDao(financeCityUser).find("From User u WHERE u.id=" + financeCityUser.getID());
            if (list == null || list.size() == 0) {
                return false;
            }

            User user = (User)list.get(0);
            user.setBirthday(Timestamp.valueOf(birthday));
            user.setIncome(income);
            user.setIfCity(isUrben ? (byte)1 : 0);
            user.setMonthlyExpense(expense);

            getUserDao(financeCityUser).update(user);

            return true;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            return false;
        }
    }

    private boolean validPassword(String password) {
        return password.length() >= 8 && password.length() <= 30;
    }

    private boolean validMobile(String mobile) {
        return  (mobile.length() == 13 && isNumeric(mobile));
    }

    private boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); ++i) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
