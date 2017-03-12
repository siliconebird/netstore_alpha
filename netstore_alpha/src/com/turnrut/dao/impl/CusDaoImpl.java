package com.turnrut.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.turnrut.dao.CusDao;
import com.turnrut.dao.exception.DaoException;
import com.turnrut.domain.Customer;
import com.turnrut.utils.DbUtils;

public class CusDaoImpl implements CusDao {
	QueryRunner qr = new QueryRunner(DbUtils.getDataSource());
	
	@Override
	public void save(Customer c) {
		try {
			qr.update("insert into customers(id,cusName,cusPw,phone,address,email,activied,keyCode) values(?,?,?,?,?,?,?,?)",
					c.getId(),
					c.getCusName(),
					c.getCusPw(),
					c.getPhone(),
					c.getAddress(),
					c.getEmail(),
					c.isActivied(),
					c.getKeyCode()
					);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Customer findCusByKey(String keyCode) {
		try {
			return qr.query("select * from customers where keyCode = ?", new BeanHandler<Customer>(Customer.class), keyCode);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void updateCus(Customer c) {
		try {
			 qr.update("update customers set cusName=?,cusPw=?,phone=?,address=?,email=?,activied=?,keyCode=? where id=?", 
						c.getCusName(),
						c.getCusPw(),
						c.getPhone(),
						c.getAddress(),
						c.getEmail(),
						c.isActivied(),
						c.getKeyCode(),	 
						c.getId()
					 );
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Customer findCusByNamePw(String cusName, String cusPw) {
		try {
			return qr.query("select * from customers where cusName = ? and cusPw = ?", new BeanHandler<Customer>(Customer.class), cusName,cusPw);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Customer findCusById(String cusId) {
		try {
			return qr.query("select * from customers where keyCode = ?", new BeanHandler<Customer>(Customer.class), cusId);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

}
