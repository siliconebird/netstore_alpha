<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/client/generalHeader.jsp" %>
<html>
<body>
		<h2>商品详情</h2>
		<img  src="${pageContext.request.contextPath }/image${requstScope.book.photoPath}/${requstScope.book.photoName}"><br>
		<h3>${requestScope.book.name }</h3><br>
		${requestScope.book.price }<br>
		简介：${requestScope.book.description }<br>
		<a href="javascript:history.back()">继续购物</a>
		<a href="${pageContext.request.contextPath }/Servlet/ClientServlet?op=addCart&bookId=${requestScope.book.id}">放入购物车</a>
</body>
</html>