package edu.nju.control;

import edu.nju.service.ExceptionsAndError.ErrorManager;
import edu.nju.service.ExceptionsAndError.UserNotExistException;
import edu.nju.service.ServiceManager;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.BaseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {
    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    BaseVO login(HttpServletRequest request, @RequestBody Map map) {
        BaseVO ret = new BaseVO();
        UserService userService = ServiceManagerImpl.getInstance().getUserService();

        String username = (String)map.get("username");
        String password = (String)map.get("password");
        if (username == null || password == null) {
            ErrorManager.setError(ret, ErrorManager.errorInvalidParameter);

            return ret;
        }

        FinanceCityUser financeCityUser = userService.login(username, password);
        if (financeCityUser == null) {
            ErrorManager.setError(ret, ErrorManager.errorInvalidPassword);

            return ret;
        }
        else {
            request.getSession(true).setAttribute("user", financeCityUser);
            ErrorManager.setError(ret, ErrorManager.errorNormal);

            return ret;
        }
    }
}
