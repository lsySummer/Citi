package edu.nju.action;

import edu.nju.service.ExceptionsAndError.*;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.BaseVO;
import edu.nju.vo.SessionIdVO;
import edu.nju.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * Created by Sun YuHao on 2016/9/3.
 */
@SuppressWarnings("unchecked")
public class AndroidUserAction extends AndroidAction {
    @Autowired
    UserService userService;

    private String register() {
        Map map = getRequestMap();
        SessionIdVO sessionIdVO = new SessionIdVO();

        try {
            FinanceCityUser financeCityUser = userService.register((String) map.get("mobile"), (String) map.get("password"), (String)map.get("username"));

            if (financeCityUser != null) {
                sessionIdVO.setSessionId(financeCityUser.getLoginSession());
                sessionIdVO.setId(financeCityUser.getID());
                ErrorManager.setError(sessionIdVO, ErrorManager.errorNormal);
                setResult(sessionIdVO);

                return SUCCESS;
            }
            else {
                ErrorManager.setError(sessionIdVO, ErrorManager.errorRegisterFailed);
                setResult(sessionIdVO);
                return SUCCESS;
            }
        }
        catch (UserAlreadyExistException e) {
            e.printStackTrace();
            ErrorManager.setError(sessionIdVO, ErrorManager.errorUserAlreadyExist);
        }
        catch (InvalidPasswordException i) {
            i.printStackTrace();
            ErrorManager.setError(sessionIdVO, ErrorManager.errorInvalidPassword);
        }
        catch (InvalidMobileException i2) {
            i2.printStackTrace();
            ErrorManager.setError(sessionIdVO, ErrorManager.errorInvalidMobile);
        }
        catch (Exception e2) {
            e2.printStackTrace();
            ErrorManager.setError(sessionIdVO, ErrorManager.errorInvalidParameter);
        }

        setResult(sessionIdVO);

        return SUCCESS;
    }

    private String getUserVO() {
        Map map = getRequestMap();
        String url = request.getRequestURL().toString();

        try {
            FinanceCityUser financeCityUser = new FinanceCityUser();
            financeCityUser.setID((Integer)map.get("id"));
            financeCityUser.setLoginSession((String)map.get("session"));

            setResult(userService.getUserVO(financeCityUser));
        }
        catch (Exception e) {
            e.printStackTrace();
            UserVO userVO = new UserVO();
            ErrorManager.setError(userVO, ErrorManager.errorNotLogin);

            setResult(userVO);
        }

        return SUCCESS;
    }

    private String setUserInfo() {
        Map map = getRequestMap();

        BaseVO baseVO = new BaseVO();
        try {
            FinanceCityUser financeCityUser = new FinanceCityUser();
            financeCityUser.setID((Integer)map.get("id"));
            financeCityUser.setLoginSession((String)map.get("session"));

            userService.modifyUserInfo((String)map.get("birthday"), (Integer)map.get("income"),
                    (Integer)map.get("isUrben") == 1, (Integer)map.get("expense"),
                    financeCityUser);

            ErrorManager.setError(baseVO, ErrorManager.errorNormal);
            setResult(baseVO);
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            ErrorManager.setError(baseVO, ErrorManager.errorNotLogin);
            setResult(baseVO);
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(baseVO, ErrorManager.errorInvalidParameter);
            setResult(baseVO);
        }

        return SUCCESS;
    }

    public String api_User() {
        String method = request.getMethod();
        if (method.equals("POST")) {
            return register();
        }
        else if (method.equals("GET")) {
            return getUserVO();
        }
        else if (method.equals("PUT")) {
            return setUserInfo();
        }
        else {
            BaseVO baseVO = new BaseVO();
            ErrorManager.setError(baseVO, ErrorManager.errorUnhandledMethod);
            setResult(baseVO);
        }

        return SUCCESS;
    }

    @SuppressWarnings("unchecked")
    public String login() {
        SessionIdVO ret = new SessionIdVO();
        try {

            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            if (username == null || password == null) {
                ErrorManager.setError(ret, ErrorManager.errorInvalidParameter);

                setResult(ret);
                return SUCCESS;
            }

            FinanceCityUser financeCityUser = userService.login(username, password);
            if (financeCityUser == null) {
                ErrorManager.setError(ret, ErrorManager.errorInvalidPassword);

                setResult(ret);
            } else {
                ErrorManager.setError(ret, ErrorManager.errorNormal);
                ret.setSessionId(financeCityUser.getLoginSession());
                ret.setId(financeCityUser.getID());
                setResult(ret);
            }
        }
        catch (Exception e) {
            ErrorManager.setError(ret, ErrorManager.errorInvalidParameter);
            setResult(ret);
        }

        return SUCCESS;
    }
}
