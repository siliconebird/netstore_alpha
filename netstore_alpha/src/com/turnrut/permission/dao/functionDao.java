package com.turnrut.permission.dao;

import java.util.List;

import com.turnrut.permission.domain.Function;
import com.turnrut.permission.domain.Roler;

public interface functionDao {

	List<Function> getFunctions(Roler roler);

}
