package edu.nju.action;

import edu.nju.service.ExceptionsAndError.*;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import org.springframework.stereotype.Controller;

/**
 * Created by Sun YuHao on 2016/9/2.
 */
@Controller
public class UserAction extends BaseAction {

    @SuppressWarnings("unchecked")
    public String register() {
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");

        if (mobile == null || password == null) {
            return ERROR;
        }
        UserService userService = ServiceManagerImpl.getInstance().getUserService();
        try {
            FinanceCityUser financeCityUser = userService.register(mobile, password);
            session.put("user", financeCityUser);
            ErrorManager.setError(request, ErrorManager.errorNormal);
            return SUCCESS;
        }
        catch(UserAlreadyExistException e) {
            e.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorUserAlreadyExist);
            return ERROR;
        }
        catch (InvalidMobileException i) {
            i.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorInvalidMobile);
            return ERROR;
        }
        catch (InvalidPasswordException i2) {
            i2.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorInvalidPassword);
            return ERROR;
        }
    }

    @SuppressWarnings("unchecked")
    public String login() {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null) {
            return ERROR;
        }

        try {
            UserService userService = ServiceManagerImpl.getInstance().getUserService();
            FinanceCityUser financeCityUser = userService.login(username, password);
            session.put("user", financeCityUser);
            return SUCCESS;
        }
        catch (UserNotExistException e) {
            e.printStackTrace();
            ErrorManager.setError(request, ErrorManager.errorUserNotExist);
            return ERROR;
        }
    }

    public String getUserVO() {
        return null;
    }
}
