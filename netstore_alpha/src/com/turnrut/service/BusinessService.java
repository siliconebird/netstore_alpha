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
	//通过类别来找分页信息
	BookPage findPageBooks(String pageIndex, String offset, String categoryId);
	
	void cusRigist(Customer c);
	void cusActive(String keyCode);
	Customer cusLogin(String cusName,String cusPw);
	
	//保存订单
	void genOrder(Order order);
	//更改订单
	void updateOrder(Order order);
	//通过id查订单
	Order findOrderById(String orderId);
	//通过用户id查订单
	List<Order> findOrderByCusId(String CusId);
	//通过订单号查订单
	Order findOrderByNum(String Num);
	//通过订单号删除
	void delOrder(String delOrderId);
	
	//管理员登陆
	User userLogin(String userName,String passWord);
	//找出管理员角色
	List<Roler> findRoles(User user);
	//找出角色的功能
	List<Function> functions(Roler roler);
}
