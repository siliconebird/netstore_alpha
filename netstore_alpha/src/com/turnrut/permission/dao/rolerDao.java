package com.turnrut.permission.dao;

import java.util.List;

import com.turnrut.permission.domain.Roler;
import com.turnrut.permission.domain.User;

public interface rolerDao {

	List<Roler> getRolers(User user);

}
