<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{
		text-align: center;
	}
</style>
<title>管理员登陆</title>
</head>
<body>
	<h1>请登陆</h1><br>
	<form action="${pageContext.request.contextPath}/permission/controler?op=login" method="post">
		<table align="center" width="333">
			<tr>
				<th>用户名：</th>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<th>密码：</th>
				<td><input type="text" name="passWord"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="登陆"> <input type="reset" value="重置"></td>
				
			</tr>
		</table>
	
	</form>
</body>
</html>