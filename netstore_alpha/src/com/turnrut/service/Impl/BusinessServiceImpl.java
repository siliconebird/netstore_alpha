package com.turnrut.service.Impl;

import java.util.List;
import java.util.UUID;

import com.turnrut.common.BookPage;
import com.turnrut.dao.BookDao;
import com.turnrut.dao.CategoryDao;
import com.turnrut.dao.CusDao;
import com.turnrut.dao.OrderDao;
import com.turnrut.dao.impl.BookDaoImpl;
import com.turnrut.dao.impl.CategoryDaoImpl;
import com.turnrut.dao.impl.CusDaoImpl;
import com.turnrut.dao.impl.OrderDaoImpl;
import com.turnrut.domain.Book;
import com.turnrut.domain.Category;
import com.turnrut.domain.Customer;
import com.turnrut.domain.Order;
import com.turnrut.permission.dao.functionDao;
import com.turnrut.permission.dao.rolerDao;
import com.turnrut.permission.dao.userDao;
import com.turnrut.permission.dao.impl.functionDaoImpl;
import com.turnrut.permission.dao.impl.rulerDaoImpl;
import com.turnrut.permission.dao.impl.userDaoImpl;
import com.turnrut.permission.domain.Function;
import com.turnrut.permission.domain.Roler;
import com.turnrut.permission.domain.User;
import com.turnrut.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	CategoryDao categoryDao = new CategoryDaoImpl();
	BookDao bookDao = new BookDaoImpl();
	CusDao cusDao = new CusDaoImpl();
	OrderDao orderDao = new OrderDaoImpl();
	userDao userDao = new userDaoImpl();
	rolerDao rolerDao = new rulerDaoImpl();
	functionDao functionDao = new functionDaoImpl();
	public void addCategory(Category category) {
		category.setId(UUID.randomUUID().toString());
		categoryDao.save(category);
	}


	public Category findCategoryById(String id) {
		return categoryDao.getCategoryById(id);
	}


	public List<Category> findAllCategorys() {
		return categoryDao.getAllCategorys();
	}


	
	public void deleteCategoryById(String id) {
		categoryDao.removeCategoryById(id);
		
	}


	
	public void addBook(Book book) {
		book.setId(UUID.randomUUID().toString());
		bookDao.save(book);
		
	}


	@Override
	public BookPage findPageBooks(String currentPage,String offset) {
		int cPage =1;
		int oSet = 3;
		if(currentPage!=null&&!currentPage.trim().equals("")){
			cPage = Integer.parseInt(currentPage);
		}
		if(offset!=null&&!offset.trim().equals("")){
			oSet = Integer.parseInt(offset);
		}
		int bookNum = bookDao.getBookNum();
		BookPage page = new BookPage(cPage, oSet, bookNum);
		int startIndex = page.getStartIndex();
		List<Book> record = bookDao.getPageBooks(startIndex,oSet);
		page.setRecord(record);
		return page;
	}
	//通过categoryid来找出page信息
	@Override
	public BookPage findPageBooks(String pageIndex, String offset, String categoryId) {
		int cPage =1;
		int oSet = 3;
		if(pageIndex!=null&&!pageIndex.trim().equals("")){
			cPage = Integer.parseInt(pageIndex);
		}
		if(offset!=null&&!offset.trim().equals("")){
			oSet = Integer.parseInt(offset);
		}
		int bookNum = bookDao.getBookNum(categoryId);
		BookPage page = new BookPage(cPage, oSet, bookNum);
		int startIndex = page.getStartIndex();
		List<Book> record = bookDao.getPageBooks(startIndex,oSet,categoryId);
		page.setRecord(record);
		return page;
	}


	@Override
	public Book findBookById(String id) {
		
		return bookDao.getBookById(id);
	}


	@Override
	public void deleteBookById(String id) {
		bookDao.removeBookById(id);
	}

	//用户注册
	@Override
	public void cusRigist(Customer c) {
		c.setId(UUID.randomUUID().toString());
		cusDao.save(c);
	}

	//用户账号激活
	@Override
	public void cusActive(String keyCode) {
		Customer c = cusDao.findCusByKey(keyCode);
		c.setActivied(true);
		cusDao.updateCus(c);
	}

	//用户登陆
	@Override
	public Customer cusLogin(String cusName, String cusPw) {
		Customer c = cusDao.findCusByNamePw(cusName,cusPw);
		if(c == null){
			return null;
		}
		return c;
	}

	//保存订单信息
	@Override
	public void genOrder(Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		orderDao.save(order);
	}


	@Override
	public void updateOrder(Order order) {
		orderDao.update(order);
	}


	@Override
	public Order findOrderById(String orderId) {
		return orderDao.getById(orderId);
	}


	@Override
	public List<Order> findOrderByCusId(String CusId) {
		return orderDao.getByCusId(CusId);
	}


	@Override
	public Order findOrderByNum(String Num) {
		return orderDao.getByNum(Num);
	}


	@Override
	public void delOrder(String delOrderId) {
		orderDao.removeOder(delOrderId);
	}


	@Override
	public User userLogin(String userName, String passWord) {
		return userDao.findUser(userName,passWord);
	}


	@Override
	public List<Roler> findRoles(User user) {
		return rolerDao.getRolers(user);
	}


	@Override
	public List<Function> functions(Roler roler) {
		return functionDao.getFunctions(roler);
	}




}
