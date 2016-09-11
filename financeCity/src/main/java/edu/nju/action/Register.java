package edu.nju.action;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.nju.service.ExceptionsAndError.InvalidMobileException;
import edu.nju.service.ExceptionsAndError.InvalidPasswordException;
import edu.nju.service.ExceptionsAndError.UserAlreadyExistException;
import edu.nju.service.POJO.RegisterInfo;
import edu.nju.service.UserService.UserService;

@Controller
public class Register extends BaseAction {
	@Autowired
	UserService userService;

	public String execute() throws ServletException, IOException {

		String mobile = request.getParameter("mobile");
		String verify = request.getParameter("verify");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		RegisterInfo regInfo = new RegisterInfo();
		regInfo.setUserName(mobile);
		regInfo.setPassword(password);
		try {
				userService.register(mobile, password,nickname);
			} catch (InvalidMobileException e) {
				request.setAttribute("failReason", "手机号码不正确");
				return "fail";
			} catch (UserAlreadyExistException e) {
				request.setAttribute("failReason", "该手机号已被注册");
				return "fail";
			} catch (InvalidPasswordException e) {
				request.setAttribute("failReason", "密码至少为8位");
				return "fail";
			}
		return "success";
	}
}
