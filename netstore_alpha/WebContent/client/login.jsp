<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/client/generalHeader.jsp" %>
<html>
<body>
<h2>请登陆：</h2><br>
<form action="${pageContext.request.contextPath }/Servlet/ClientServlet?op=cusLogin" method="post">
	<table border="1" align="center" width="300">
		<tr>
			<th>账号：</th>
			<td><input type="text" name="cusName"></td>
		</tr>
		<tr>
			<th>密码：</th>
			<td><input type="text" name="cusPw"></td>
		</tr>
		<tr>
			<th colspan="2"><input type="submit" value="提交" > <input type="reset" value="重置"> </th>
		</tr>
	</table>
</form>
</body>
</html>