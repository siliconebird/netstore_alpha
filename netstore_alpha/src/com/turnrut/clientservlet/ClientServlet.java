package com.turnrut.clientservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turnrut.common.BookPage;
import com.turnrut.common.Cart;
import com.turnrut.common.CartItems;
import com.turnrut.common.SendMail;
import com.turnrut.domain.Book;
import com.turnrut.domain.Category;
import com.turnrut.domain.Customer;
import com.turnrut.domain.OderItem;
import com.turnrut.domain.Order;
import com.turnrut.service.BusinessService;
import com.turnrut.service.Impl.BusinessServiceImpl;
import com.turnrut.utils.FillBeanUtil;
import com.turnrut.utils.idGernerUtil;

@WebServlet("/Servlet/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String operation;  
    BusinessService bs = new BusinessServiceImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		operation = request.getParameter("op");
		if("listbooks".equals(operation)){
			listBooks(request,response);
		}if("listbooksbycategory".equals(operation)){
			listBooksByCategory(request,response);
		}if("listonebook".equals(operation)){
			listOneBook(request,response);
		}if("addCart".equals(operation)){
			addBookToCart(request,response);
		}if("changeNum".equals(operation)){
			changeNum(request,response);
		}if("delOneItem".equals(operation)){
			delOneItem(request,response);
		}if("cusRigist".equals(operation)){
			cusRigist(request,response);
		}if ("cusActive".equals(operation)) {
			cusActive(request,response);
		}if ("cusLogin".equals(operation)) {
			cusLogin(request,response);
		}if ("delCus".equals(operation)) {
			delCus(request,response);
		}if ("generOrder".equals(operation)) {
			generOrder(request,response);
		}if ("myOrder".equals(operation)) {
			showMyOrder(request,response);
		}if ("delOder".equals(operation)) {
			delOder(request,response);
		}
		
	}
	
	private void delOder(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String delOrderId = request.getParameter("orderId");
		bs.delOrder(delOrderId);
		showMyOrder(request,response);
	}

	private void showMyOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//检查用户是否登陆 未登录转向登陆界面
		Customer cus = (Customer) session.getAttribute("customer");
		if(cus==null){
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
		}
		List<Order> list = bs.findOrderByCusId(cus.getId());
		request.setAttribute("myOrders", list);
		request.getRequestDispatcher("/client/listMyOrders.jsp").forward(request, response);
	}

	private void generOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//检查用户是否登陆 未登录转向登陆界面
		Customer cus = (Customer) session.getAttribute("customer");
		if(cus==null){
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
		}
		//将cart中的东西转到order中
		Cart cart = (Cart) session.getAttribute("cart");
		Order order = new Order();
		String orderNum = idGernerUtil.generId();
		order.setOrderNum(orderNum);
		order.setAmount(cart.getAmount());
		order.setQuantity(cart.getTotalQuantity());
		order.setCustomer(cus);
		//将cartitem中的东西转到orderitem中
		Map<String, CartItems> items =  cart.getCart();
		//练级存储  如果订单中有订单项 记得也要存储起来
		if(items.size()>0){
			for(Map.Entry<String, CartItems> item:items.entrySet()){
				OderItem o = new OderItem();
				o.setOrderItemId(UUID.randomUUID().toString());
				o.setPrice(item.getValue().getItemTotalPrice());
				o.setBook(item.getValue().getBook());
				o.setQuantity(item.getValue().getItemQuantity());
				order.getoItems().add(o);
			}
			bs.genOrder(order);
			session.removeAttribute("cart");
			request.getRequestDispatcher("/client/pay.jsp?orderNum="+orderNum+"&amount="+order.getAmount()).forward(request, response);
		}
	}

	private void delCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		//String cusId = request.getParameter("cusId");
		HttpSession session = request.getSession();
		session.removeAttribute("customer");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void cusLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String cusName = request.getParameter("cusName");
		String cusPw = request.getParameter("cusPw");
		Customer c = bs.cusLogin(cusName, cusPw);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(c==null){
			request.setAttribute("msg", "用户名或者密码错误！");
			request.getRequestDispatcher("/client/msg.jsp").forward(request, response); 
		}else if(!c.isActivied()){
			request.setAttribute("msg", "账号未激活，请查看邮件激活！");
			request.getRequestDispatcher("/client/msg.jsp").forward(request, response); 
		}
		HttpSession session = request.getSession();
		session.setAttribute("customer", c);
		response.getWriter().write("登陆成功！2s后返回主页");
		response.setHeader("Refresh", "2;url="+request.getContextPath()+"");
	}

	private void cusActive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		response.setContentType("text/html;charset=UTF-8");
		if(code!=null&&!code.trim().equals("")){
			bs.cusActive(code);
			response.getWriter().write("激活成功啦！2s后返回主页");
		}else{
			response.getWriter().write("激活码错误！2s后返回主页");
		}
		response.setHeader("Refresh", "2;url="+request.getContextPath());
	}
	private void cusRigist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer c = FillBeanUtil.fillBean(request, Customer.class);
		String keyCode = UUID.randomUUID().toString();
		c.setKeyCode(keyCode);
		//启动一个新的线程来发送邮件
		SendMail sm = new SendMail(c);
		sm.start();
		bs.cusRigist(c);
		request.setAttribute("msg", "恭喜您注册成功，我们已经向您的注册邮箱中发送一封激活邮件，请您确认! <a href='"+request.getContextPath()+"'>返回首页</a>");
		request.getRequestDispatcher("/client/msg.jsp").forward(request, response);
	}

	private void delOneItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String bookId = request.getParameter("bookId"); 
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.getCart().remove(bookId);
		response.sendRedirect(request.getContextPath()+"/client/showCart.jsp");
	}

	private void changeNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String bookId = request.getParameter("bookId");
		String newNum = request.getParameter("newNum");
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		cart.getCart().get(bookId).setItemQuantity(Integer.parseInt(newNum));
		response.sendRedirect(request.getContextPath()+"/client/showCart.jsp");
	}

	private void addBookToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		Book book = bs.findBookById(bookId);
		CartItems item = new CartItems(book);
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
			cart.addItem(book);
		request.setAttribute("msg", "添加购物车成功<a href ='"+request.getContextPath()+"'>继续购物<a>");
		request.getRequestDispatcher("/client/msg.jsp").forward(request, response);
	}

	private void listOneBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookId = request.getParameter("id");
		Book book = bs.findBookById(bookId);
		request.setAttribute("book", book);
		request.getRequestDispatcher("/client/listOneBook.jsp").forward(request, response);
	}

	private void listBooksByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 通过category来显示书籍
		String categoryId = request.getParameter("categoryID");
		List<Category> categorys = bs.findAllCategorys();
		BookPage page = bs.findPageBooks("", "",categoryId);
		System.out.println(page.getTotalBookNum()+"  "+page.getTotalPageNum());
		page.setUrl("/Servlet/ClientServlet?op=listbooksbycategory&categoryID="+categoryId);
		request.setAttribute("categorys", categorys);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/listBook.jsp").forward(request, response);	
	}

	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categorys = bs.findAllCategorys();
		BookPage page = bs.findPageBooks(request.getParameter("pageIndex"), request.getParameter("offset"));
		page.setUrl("/Servlet/ClientServlet?op=listbooks");
		request.setAttribute("categorys", categorys);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/client/listBook.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
