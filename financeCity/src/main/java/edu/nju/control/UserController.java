package edu.nju.control;

import edu.nju.service.ExceptionsAndError.ErrorManager;
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
    @RequestMapping(value = "api/user", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    UserVO getUserVO_android(HttpServletRequest request) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();

        return userService.getUserVO((FinanceCityUser) request.getSession().getAttribute("user"));
    }

    @RequestMapping(value = "user", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    UserVO getUserVO(HttpServletRequest request) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();

        return userService.getUserVO((FinanceCityUser) request.getSession().getAttribute("user"));
    }

    @RequestMapping(value = "user", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public BaseVO updateUserVO(HttpServletRequest request, @RequestBody Map map) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();
        BaseVO baseVO = new BaseVO();
        try {
            boolean ifSuccess = userService.modifyUserInfo((String)map.get("birthday"), (Integer)map.get("income"),
                    (Integer)map.get("isUrben") == 1 ? true : false, (Integer)map.get("expense"),
                    (FinanceCityUser)request.getSession().getAttribute("user"));

            if (ifSuccess) {
                ErrorManager.setError(baseVO, ErrorManager.errorNormal);
                return baseVO;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ErrorManager.setError(baseVO, ErrorManager.errorNotLogin);
        return baseVO;
    }

    @RequestMapping(value = "user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    BaseVO registerUser(HttpServletRequest request, @RequestBody Map map) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();
        BaseVO baseVO = new BaseVO();

        try {
            FinanceCityUser financeCityUser = userService.register((String) map.get("mobile"), (String) map.get("password"), request.getSession().getId());

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
