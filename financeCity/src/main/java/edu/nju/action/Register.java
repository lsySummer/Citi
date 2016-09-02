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
public class Register extends BaseAction{
	@Autowired
	private UserService userService;
	
	public String execute() throws ServletException,IOException, InvalidPasswordException, InvalidMobileException, UserAlreadyExistException{
		String mobile=request.getParameter("mobile");
		String verify=request.getParameter("verify");
		String nickname=request.getParameter("nickname");
		String password=request.getParameter("password");
		RegisterInfo regInfo = new RegisterInfo();
		regInfo.setUserName(mobile);
		regInfo.setPassword(password);
		userService.register(mobile,password,nickname);
		request.setAttribute("info", "success");
		return "success";
	}
}
