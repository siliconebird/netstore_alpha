package com.turnrut.dao;

import java.util.List;

import com.turnrut.domain.Book;

public interface BookDao {

	void save(Book book);

	int getBookNum();

	List<Book> getPageBooks(int startIndex, int offset);
	//通过类别来找
	List<Book> getPageBooks(int startIndex, int oSet, String categoryId);
	
	Book getBookById(String id);

	void removeBookById(String id);
	//通过类别来算出记录条数
	int getBookNum(String categoryId);

	

}
