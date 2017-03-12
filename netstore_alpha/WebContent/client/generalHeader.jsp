<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.turnrut.com/functions"  prefix="myfn"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
<title>XX商城</title>
</head>
<body>
	<h1>欢迎光临</h1><br>
	<a href="${pageContext.request.contextPath }/index.jsp">首页</a>
		<c_rt:if test="${empty sessionScope.customer }">
			<a href="${pageContext.request.contextPath }/client/login.jsp">登陆</a>
			<a href="${pageContext.request.contextPath }/client/rigist.jsp">注册</a>
		</c_rt:if>
		<c_rt:if test="${!empty sessionScope.customer }">
			 欢迎您${sessionScope.customer.cusName } &nbsp;&nbsp;<a href="${pageContext.request.contextPath }/Servlet/ClientServlet?op=delCus&cusId=${sessionScope.customer.id}">注销</a>
		</c_rt:if>
	<a href="${pageContext.request.contextPath }/Servlet/ClientServlet?op=myOrder">我的订单</a>
	<a href="${pageContext.request.contextPath }/client/showCart.jsp">我的购物车</a><br><br>
</body>
</html>