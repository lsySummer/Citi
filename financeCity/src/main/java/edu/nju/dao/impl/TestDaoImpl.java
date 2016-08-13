package edu.nju.dao.impl;

import edu.nju.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.TestDao;

import java.sql.Timestamp;

@Repository
public class TestDaoImpl implements TestDao{

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public String addName(String name) {
		//First f = new First();
		//f.setName(name);
		//baseDao.save(f);
		return "success";
	}

	@Override
	public void save(Object bean) {
		baseDao.save(bean);
	}

	@Override
	public void delete(Object bean) {
		baseDao.delete(bean);
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/applicationContext.xml");
		TestDao testDao = (TestDao)applicationContext.getBean("testDaoImpl");
		UserLogin userLogin = new UserLogin();

		userLogin.setDate(new Timestamp(100000));
		userLogin.setLoginId("???");
		userLogin.setUserId(0);
		testDao.delete(userLogin);
	}
}
