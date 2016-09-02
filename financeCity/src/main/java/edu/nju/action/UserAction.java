package edu.nju.action;

import edu.nju.service.ExceptionsAndError.*;
import edu.nju.service.ServiceManagerImpl;
import edu.nju.service.Sessions.FinanceCityUser;
import edu.nju.service.UserService.UserService;
import edu.nju.vo.UserVO;
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
        String username = request.getParameter("nickname");

        if (mobile == null || password == null || username == null) {
            return ERROR;
        }
        UserService userService = ServiceManagerImpl.getInstance().getUserService();
        try {
            FinanceCityUser financeCityUser = userService.register(mobile, password, username);
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

        UserService userService = ServiceManagerImpl.getInstance().getUserService();
        FinanceCityUser financeCityUser = userService.login(username, password);
        if (financeCityUser == null) {
            ErrorManager.setError(request, ErrorManager.errorLoginFailed);
            return ERROR;
        }

        session.put("user", financeCityUser);
        ErrorManager.setError(request, ErrorManager.errorNormal);
        return SUCCESS;
    }

    public String getUserVO() {
        UserService userService = ServiceManagerImpl.getInstance().getUserService();

        FinanceCityUser financeCityUser = (FinanceCityUser) session.get("user");
        if (financeCityUser == null) {
            ErrorManager.setError(request, ErrorManager.errorNotLogin);
            return ERROR;
        }

        UserVO userVO = userService.getUserVO(financeCityUser);
        request.setAttribute("userVO", userVO);

        return SUCCESS;
    }
}
