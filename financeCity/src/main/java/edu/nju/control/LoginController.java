package edu.nju.control;

import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ServiceManager;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.BaseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    BaseVO login(HttpServletRequest request, @RequestParam(value = "username")String username, @RequestParam(value = "passwd")String password) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();

        FinanceCityUser financeCityUser = userService.login(username, password);
        BaseVO ret = new BaseVO();
        if (financeCityUser == null) {
            ErrorManager.setError(ret, ErrorManager.errorInvalidUserOrPassword);

            return ret;
        }
        else {
            request.getSession(true).setAttribute("user", financeCityUser);
            ErrorManager.setError(ret, ErrorManager.errorNormal);

            return ret;
        }
    }
}
