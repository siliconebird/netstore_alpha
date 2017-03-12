package com.turnrut.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.turnrut.dao.BookDao;
import com.turnrut.dao.exception.DaoException;
import com.turnrut.domain.Book;
import com.turnrut.utils.DbUtils;

public class BookDaoImpl implements BookDao {
	QueryRunner qr = new QueryRunner(DbUtils.getDataSource());
	public void save(Book book) {
		try {
			qr.update("insert into books(id,name,author,price,description,categoryID,photoPath,photoName) values(?,?,?,?,?,?,?,?)", 
					book.getId(),
					book.getName(),
					book.getAuthor(),
					book.getPrice(),
					book.getDescription(),
					book.getCategoryID(),
					book.getPhotoPath(),
					book.getPhotoName());
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public int getBookNum() {
		Object obj;
		try {
			obj = qr.query("select count(*) from books", new ScalarHandler(1));
		} catch (Exception e) {
			throw new DaoException(e);
		}
		//注意此处转型方法
		Long num = (Long)obj;
		return num.intValue();
	}
	//通过类别来计算记录条数
	@Override
	public int getBookNum(String categoryId) {
		Object obj;
		try {
			obj = qr.query("select count(*) from books where categoryID = ?",new ScalarHandler(1) , categoryId);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		Long num = (Long) obj;
		return num.intValue();
	}

	public List<Book> getPageBooks(int startIndex, int offset) {
		List<Book> list;
		try {
			list = qr.query("select * from books limit ?,?", new BeanListHandler<Book>(Book.class),startIndex,offset);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return list;
	}
	//通过类别来找记录
	@Override
	public List<Book> getPageBooks(int startIndex, int offset, String categoryId) {
		List<Book> list;
		try {
			list = qr.query("select * from books where categoryID = ? limit ?,?", new BeanListHandler<Book>(Book.class),categoryId,startIndex,offset);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		return list;
	}
	
	public Book getBookById(String id) {
		try {
			return qr.query("select * from books where id = ?", new BeanHandler<Book>(Book.class), id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	public void removeBookById(String id) {
		try {
			 qr.update("delete from books where id = ?",id);
		} catch (Exception e) {
			throw new DaoException(e);
		}
		
	}



	

}
