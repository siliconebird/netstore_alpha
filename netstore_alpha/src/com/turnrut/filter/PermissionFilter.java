package com.turnrut.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.turnrut.permission.domain.Function;
import com.turnrut.permission.domain.Roler;
import com.turnrut.permission.domain.User;
import com.turnrut.service.BusinessService;
import com.turnrut.service.Impl.BusinessServiceImpl;

/**
 * Servlet Filter implementation class PermissionFilter
 */
@WebFilter("/Manager/*")
public class PermissionFilter implements Filter {
	BusinessService bs = new BusinessServiceImpl();
    public PermissionFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// �����Ƿ��й���Ա��½û�еĻ���ת���½����
		HttpServletRequest req;
		HttpServletResponse res;
		try {
			req = (HttpServletRequest) request;
			res = (HttpServletResponse) response;
		} catch (Exception e) {
			throw new RuntimeException("������������");
		}
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null){
			req.getRequestDispatcher("/permission/login.jsp").forward(req, res);
		}
		// ͨ������Ա��ѯ��rolers
		Set<Function> allowedFunctions = new HashSet<Function>();
		List<Roler> rolers = bs.findRoles(user);
		//ͨ��rolers���functions ������ʵ��׼����list��
		for(Roler r:rolers){
			List<Function> list = bs.functions(r);
			allowedFunctions.addAll(list);
		}
		//�жϵ�ǰuri�Ƿ���functions  �оͷ��У�û�о�����
		String uri = req.getRequestURI(); // netsore/manage/index.jsp/op=???
		uri=uri.replace(req.getContextPath(), ""); //manage/index.jsp/op=???
		String queryParam = req.getQueryString();
		if(queryParam!=null){
			uri=uri+"?"+queryParam;
		}
		System.out.println(uri);
		boolean permiss =false;
		for(Function function:allowedFunctions){
			if(function.getUri().equals(uri)){
					permiss = true;
					break;
			}
		}
		if(permiss){
			chain.doFilter(request, response);
		}else{
			res.getWriter().write("sorry,you cant do it!");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
