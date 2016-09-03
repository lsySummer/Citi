package edu.nju.control;

import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.NotLoginException;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.BaseVO;
import edu.nju.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
@Controller
@RequestMapping(value = "/")
public class UserController {
    @RequestMapping(value = "api/user", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    UserVO getUserVO_android(HttpServletRequest request) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();

        return userService.getUserVO((FinanceCityUser) request.getSession(false).getAttribute("user"));
    }

    @RequestMapping(value = "user", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    UserVO getUserVO(HttpServletRequest request) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();

        try {
            FinanceCityUser financeCityUser = (FinanceCityUser)request.getSession(false).getAttribute("user");
            if (financeCityUser == null) {
                throw new NotLoginException();
            }
            return userService.getUserVO(financeCityUser);
        }
        catch (Exception e) {
            e.printStackTrace();
            UserVO userVO = new UserVO();
            ErrorManager.setError(userVO, ErrorManager.errorNotLogin);

            return userVO;
        }
    }

    @RequestMapping(value = "user", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    BaseVO updateUserVO(HttpServletRequest request, @RequestBody Map map) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();
        BaseVO baseVO = new BaseVO();
        try {
            userService.modifyUserInfo((String)map.get("birthday"), (Integer)map.get("income"),
                    (Integer)map.get("isUrben") == 1, (Integer)map.get("expense"),
                    (FinanceCityUser)request.getSession(false).getAttribute("user"));

            ErrorManager.setError(baseVO, ErrorManager.errorNormal);
            return baseVO;
        }
        catch (NotLoginException n) {
            n.printStackTrace();
            ErrorManager.setError(baseVO, ErrorManager.errorNotLogin);
            return baseVO;
        }
        catch (Exception e) {
            e.printStackTrace();
            ErrorManager.setError(baseVO, ErrorManager.errorInvalidParameter);
            return baseVO;
        }
    }

    @RequestMapping(value = "user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    BaseVO registerUser(HttpServletRequest request, @RequestBody Map map) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();
        BaseVO baseVO = new BaseVO();

        try {
            FinanceCityUser financeCityUser = userService.register((String) map.get("mobile"), (String) map.get("password"), (String)map.get("username"));

            if (financeCityUser != null) {
                request.getSession(true).setAttribute("user", financeCityUser);

                ErrorManager.setError(baseVO, ErrorManager.errorNormal);
                return baseVO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        ErrorManager.setError(baseVO, ErrorManager.errorRegisterFailed);
        return baseVO;
    }
}
