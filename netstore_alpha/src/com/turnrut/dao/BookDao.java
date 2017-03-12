package com.turnrut.dao;

import java.util.List;

import com.turnrut.domain.Book;

public interface BookDao {

	void save(Book book);

	int getBookNum();

	List<Book> getPageBooks(int startIndex, int offset);
	//ͨ���������
	List<Book> getPageBooks(int startIndex, int oSet, String categoryId);
	
	Book getBookById(String id);

	void removeBookById(String id);
	//ͨ������������¼����
	int getBookNum(String categoryId);

	

}
