package edu.nju.service.impl;

import edu.nju.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

import edu.nju.dao.TestDao;
import edu.nju.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	ServiceManager serviceManager;
	
	@Override
	public String test(String text) {
		System.out.println(text);
		return text;
	}

	public TestDao getTestDao() {
		return null;
	}

	public void setTestDao(TestDao testDao) {
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/applicationContext.xml");
		TestService testService = (TestService) applicationContext.getBean("testServiceImpl");
	}
}
