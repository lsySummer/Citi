package edu.nju.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;

import edu.nju.dao.TestDao;
import edu.nju.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;

import edu.nju.service.TestService;

@Controller
public class TestAction extends BaseAction {

	@Autowired
	private TestService testService;

	public String execute() throws ServletException, IOException {
		System.out.println("hello");
		String text = request.getParameter("txt");
		return testService.test(text);
	}

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/applicationContext.xml");
		TestAction testAction = (TestAction) applicationContext.getBean("testServiceImpl");
	}
}
