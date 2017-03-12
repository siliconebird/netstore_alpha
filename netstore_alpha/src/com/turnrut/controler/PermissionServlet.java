package com.turnrut.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turnrut.permission.domain.User;
import com.turnrut.service.BusinessService;
import com.turnrut.service.Impl.BusinessServiceImpl;

/**
 * Servlet implementation class PermissionServlet
 */
@WebServlet("/permission/controler")
public class PermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BusinessService bs = new BusinessServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("op");
		if("login".equals(operation)){
			userLogin(request,response);
		}
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		User user = bs.userLogin(userName, passWord);
		HttpSession session = request.getSession();
		if(user==null){
			session.setAttribute("msg", "’À∫≈√‹¬Î¥ÌŒÛ£¨«Î≤È÷§");
		}	
		session.setAttribute("user", user);
		response.sendRedirect(request.getContextPath()+"/Manager/index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
