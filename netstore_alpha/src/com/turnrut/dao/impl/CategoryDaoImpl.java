package com.turnrut.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.turnrut.dao.CategoryDao;
import com.turnrut.dao.exception.DaoException;
import com.turnrut.domain.Category;
import com.turnrut.utils.DbUtils;

public class CategoryDaoImpl implements CategoryDao {
	DataSource ds = DbUtils.getDataSource();
	private QueryRunner qr = new QueryRunner(ds);
	@Override
	public void save(Category category) {
		try {
			qr.update("insert into categorys(id,name,description)values(?,?,?);", category.getId(),category.getName(),category.getDescription());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public Category getCategoryById(String id) {
		try {
			return qr.query("select * from categorys where id=?", new BeanHandler<Category>(Category.class), id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
	}

	@Override
	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		try {
			return  qr.query("select * from categorys", new BeanListHandler<Category>(Category.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
	}

	@Override
	public void removeCategoryById(String id) {
		try {
			qr.update("delete from categorys where id = ?",id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DaoException(e);
		}
	}

}
