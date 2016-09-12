package edu.nju.action;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;

@Controller
public class Assets extends BaseAction{

	public String execute() throws ServletException, IOException {
		return SUCCESS;
	}
	
	public String getRecommend(){
		return SUCCESS;
	}
	
	public String getProduct(){
		return SUCCESS;
	}
}
