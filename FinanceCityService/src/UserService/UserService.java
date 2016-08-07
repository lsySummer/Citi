package UserService;

import BaseService.BaseService;
import POJO.RegisterInfo;
import POJO.UserInfo;

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
     * @param id .
     * @return if it's successful
     */
    boolean logout(String id);

    /**
     * modify user info
     * @param id .
     * @param userInfo .
     * @return if it's successful
     */
    boolean modifyUserInfo(String id, UserInfo userInfo);
}
