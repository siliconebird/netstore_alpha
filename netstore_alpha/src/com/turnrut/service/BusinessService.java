package com.turnrut.service;

import java.util.List;

import com.turnrut.common.BookPage;
import com.turnrut.domain.Book;
import com.turnrut.domain.Category;
import com.turnrut.domain.Customer;
import com.turnrut.domain.Order;
import com.turnrut.permission.domain.Function;
import com.turnrut.permission.domain.Roler;
import com.turnrut.permission.domain.User;

public interface BusinessService {
	void addCategory(Category category);
	List<Category> findAllCategorys();
	Category findCategoryById(String id);
	void deleteCategoryById(String id);
	
	void addBook(Book book);
	BookPage findPageBooks(String pageIndex,String offset);
	Book findBookById(String id);
	void deleteBookById(String id);
	//ͨ��������ҷ�ҳ��Ϣ
	BookPage findPageBooks(String pageIndex, String offset, String categoryId);
	
	void cusRigist(Customer c);
	void cusActive(String keyCode);
	Customer cusLogin(String cusName,String cusPw);
	
	//���涩��
	void genOrder(Order order);
	//���Ķ���
	void updateOrder(Order order);
	//ͨ��id�鶩��
	Order findOrderById(String orderId);
	//ͨ���û�id�鶩��
	List<Order> findOrderByCusId(String CusId);
	//ͨ�������Ų鶩��
	Order findOrderByNum(String Num);
	//ͨ��������ɾ��
	void delOrder(String delOrderId);
	
	//����Ա��½
	User userLogin(String userName,String passWord);
	//�ҳ�����Ա��ɫ
	List<Roler> findRoles(User user);
	//�ҳ���ɫ�Ĺ���
	List<Function> functions(Roler roler);
}
