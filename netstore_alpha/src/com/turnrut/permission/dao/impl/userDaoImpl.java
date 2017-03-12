package com.turnrut.permission.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.turnrut.dao.exception.DaoException;
import com.turnrut.permission.dao.userDao;
import com.turnrut.permission.domain.User;
import com.turnrut.utils.DbUtils;

public class userDaoImpl implements userDao {
	QueryRunner qr = new QueryRunner(DbUtils.getDataSource());

	@Override
	public User findUser(String userName, String passWord) {
		try {
			return qr.query("select * from users where userName = ? and passWord = ?", new BeanHandler<User>(User.class), userName,passWord);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
}
