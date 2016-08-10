package edu.nju.service.UserService;

import edu.nju.dao.BaseDao;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.Exceptions.NotLoginException;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.POJO.UserInfo;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public interface UserService extends BaseService {

    /**
     * register
     * @param regInfo .
     * @return user id
     */
    Long register(RegisterInfo regInfo);

    /**
     * user login
     * @param userName .
     * @param password .
     * @return user id
     */
    Long login(String userName, String password);

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
    Long getID() throws NotLoginException;

    /**
     * get user dao
     * @return dao .
     */
    BaseDao getUserDao() throws NotLoginException;
}
