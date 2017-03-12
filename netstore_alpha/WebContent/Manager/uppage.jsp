<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/main.css">
</head>
<body>
	<br><br>
	<h1>后台管理系统</h1>
	<br>
	<a href="${pageContext.request.contextPath }/Manager/addcategory.jsp">添加分类</a>
	<a href="${pageContext.request.contextPath }/Manager/ControlerServlet?op=querycategory">查询分类</a>
	<a href="${pageContext.request.contextPath }/Manager/ControlerServlet?op=addbooksign">添加图书</a>
	<a href="${pageContext.request.contextPath }/Manager/ControlerServlet?op=querybook">查询图书</a>
</body>
</html>