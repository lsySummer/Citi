package edu.nju.service.UserService;

import edu.nju.dao.UserDao;
import edu.nju.dao.impl.CommonDao;
import edu.nju.service.BaseService.BaseService;
import edu.nju.service.ExceptionsAndError.InvalidMobileException;
import edu.nju.service.ExceptionsAndError.InvalidPasswordException;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.ExceptionsAndError.UserAlreadyExistException;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
@Service
public interface UserService extends BaseService {

    /**
     * register
     * @param regInfo .
     * @return user info
     */
    FinanceCityUser register(RegisterInfo regInfo);

    /**
     * register
     * @param mobile .
     * @param password .
     * @return user info
     */
    FinanceCityUser register(String mobile, String password, String session) throws InvalidPasswordException, InvalidMobileException, UserAlreadyExistException;

    /**
     * user login
     * @param userName .
     * @param password .
     * @return user id
     */
    FinanceCityUser login(String userName, String password);

    /**
     * user logout
     * @return if it's successful
     */
    boolean logout(FinanceCityUser financeCityUser);

    /**
     * if user login
     * @return if user login
     */
    boolean isLogin(FinanceCityUser financeCityUser);

    /**
     * modify user info
     * @param userVO .
     * @return if it's successful
     */
    boolean modifyUserInfo(UserVO userVO, FinanceCityUser financeCityUser);

    boolean modifyUserInfo(String birthday, int income, boolean isUrben, int expense, FinanceCityUser financeCityUser);

    /**
     * get user dao
     * @return user dao .
     */
    UserDao getUserDao(FinanceCityUser financeCityUser) throws NotLoginException;

    /**
     * get common dao
     * @return common dao
     */
    CommonDao getCommonDao();

    UserVO getUserVO(FinanceCityUser financeCityUser);
}
