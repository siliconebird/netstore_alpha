package com.turnrut.permission.dao;

import com.turnrut.permission.domain.User;

public interface userDao {

	User findUser(String userName, String passWord);

}
