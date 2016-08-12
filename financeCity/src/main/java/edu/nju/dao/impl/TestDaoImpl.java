package edu.nju.dao.impl;

import edu.nju.model.User;
import edu.nju.model.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.nju.dao.BaseDao;
import edu.nju.dao.TestDao;
import edu.nju.model.First;

import java.sql.Timestamp;

@Repository
public class TestDaoImpl implements TestDao{

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public String addName(String name) {
		First f = new First();
		f.setName(name);
		baseDao.save(f);
		return "success";
	}

	public static void main(String[] args) {
		BaseDao baseDao = new BaseDaoImpl();
		UserLogin userLogin = new UserLogin();

		userLogin.setDate(new Timestamp(0));
		userLogin.setLoginId("???");
		userLogin.setUserId(0);
		baseDao.save(userLogin);
	}
}
