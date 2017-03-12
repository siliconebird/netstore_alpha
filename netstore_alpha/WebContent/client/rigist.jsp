<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/client/generalHeader.jsp" %>
<html>
<body>
<h2>注册信息</h2><br>
<form action="${pageContext.request.contextPath }/Servlet/ClientServlet?op=cusRigist" method="post">
	<table border="1" align="center" width="500">
		<tr>
			<th>账号：</th>
			<td><input type="text" name="cusName" onblur="isEmpty(this)" ></td>
		</tr>
		<tr>
			<th>密码：</th>
			<td><input type="text" name="cusPw" onblur="isEmpty(this)"></td>
		</tr>
		<tr>
			<th>电话：</th>
			<td><input type="text" name="phone"></td>
		</tr>
		<tr>
			<th>收货地址：</th>
			<td><input type="text" name="address"></td>
		</tr>
		<tr>
			<th>Email：</th>
			<td><input type="text" name="email" onblur="isEmpty(this)"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="提交"></td>
		</tr>
	</table>
</form>
</body>
	<script type="text/javascript">
		function isEmpty(inputObj) {
			if(inputObj.value==null);
				alert("此项不能为空！")
		     }
	</script>
</html>