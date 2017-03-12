package com.turnrut.permission.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.turnrut.dao.exception.DaoException;
import com.turnrut.permission.dao.functionDao;
import com.turnrut.permission.domain.Function;
import com.turnrut.permission.domain.Roler;
import com.turnrut.utils.DbUtils;

public class functionDaoImpl implements functionDao {
	QueryRunner qr = new QueryRunner(DbUtils.getDataSource());
	@Override
	public List<Function> getFunctions(Roler roler) {
		try {
			return qr.query("select f.* from functions f,rolers_functions rf where f.id = rf.f_id and rf.r_id = ?", new BeanListHandler<Function>(Function.class),roler.getId());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}

}
