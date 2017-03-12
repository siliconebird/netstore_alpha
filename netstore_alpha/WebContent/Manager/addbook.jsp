<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Manager/uppage.jsp"%> 
<html>
<head>
<title>添加书籍信息</title>
</head>
<body>
	<br><br>

	<form  enctype="multipart/form-data"  method="post" action="${pageContext.request.contextPath }/Manager/ControlerServlet?op=addbook">
		<table align="center" border="1" width="440" >
			<tr>
				<td>书名</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author" size="20"></td>
			</tr>
			<tr>
				<td>单价</td>
				<td><input type="text" name="price" size="20"></td>
			</tr>
			<tr>
				<td>图片</td>
				<td><input type="file" name="photo" ></td>
			</tr>
			<tr>
				<td>描述</td>
				<td> <textarea rows="3" cols="38" name="description"></textarea> </td>
			</tr>
			<tr>
				<td>所属分类</td>
				<td>
					<select name="categoryID">
						<c_rt:forEach items="${requestScope.list }" var="v" varStatus="vs">
							<option value="${v.id }">${v.name }</option>
						</c_rt:forEach>
					</select>
				</td>
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