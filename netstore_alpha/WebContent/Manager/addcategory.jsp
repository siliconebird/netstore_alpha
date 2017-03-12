<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Manager/uppage.jsp"%> 
<html>
<head>
<title>添加分类信息</title>
</head>
<body>
	<br><br>

	<form  method="post" action="${pageContext.request.contextPath }/Manager/ControlerServlet?op=add">
		<table align="center" border="1" width="440" >
			<tr>
				<td>类别</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>类别描述</td>
				<td> <textarea rows="3" cols="38" name="description"></textarea> </td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交" >
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>