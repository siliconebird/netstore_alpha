<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>欢迎光临</title>
</head>
<body>
	<jsp:forward page="/Servlet/ClientServlet">
			<jsp:param value="listbooks" name="op"/>
			<jsp:param value="1" name="pageIndex"/>
			<jsp:param value="3" name="offset"/>
	</jsp:forward>
</body>
</html>