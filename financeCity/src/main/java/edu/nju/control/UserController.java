package edu.nju.control;

import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sun YuHao on 2016/8/31.
 */
@Controller
@RequestMapping(value = "api/")
public class UserController {
    @RequestMapping(value = "user", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    UserVO getUserVO(HttpServletRequest request) {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();

        return userService.getUserVO((FinanceCityUser) request.getSession().getAttribute("user"));
    }
}
