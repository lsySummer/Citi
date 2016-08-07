package edu.nju.service.UserService;

import edu.nju.dao.BaseDao;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.POJO.UserInfo;

/**
 * Created by dell on 2016/7/25.
 */
public interface UserService extends BaseService {

    /**
     * register
     * @param regInfo .
     * @return user id
     */
    String register(RegisterInfo regInfo);

    /**
     * user login
     * @param userName .
     * @param password .
     * @return user id
     */
    String login(String userName, String password);

    /**
     * user logout
     * @return if it's successful
     */
    boolean logout();

    /**
     * if user login
     * @return if user login
     */
    boolean isLogin();

    /**
     * modify user info
     * @param userInfo .
     * @return if it's successful
     */
    boolean modifyUserInfo(UserInfo userInfo);

    /**
     * get user id
     * @return user id .
     */
    String getID();

    /**
     * get user dao
     * @return dao .
     */
    BaseDao getUserDao();
}
