package com.turnrut.permission.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.turnrut.dao.exception.DaoException;
import com.turnrut.permission.dao.rolerDao;
import com.turnrut.permission.domain.Roler;
import com.turnrut.permission.domain.User;
import com.turnrut.utils.DbUtils;

public class rulerDaoImpl implements rolerDao {
	QueryRunner qr = new QueryRunner(DbUtils.getDataSource());
	@Override
	public List<Roler> getRolers(User user) {
		try {
			return qr.query("select r.* from rolers r,users_rolers ur where r.id = ur.r_id and ur.u_id = ?", new BeanListHandler<Roler>(Roler.class),user.getId());
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
}
