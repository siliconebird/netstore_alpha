<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/client/generalHeader.jsp" %>
<html>
<body>
	<a href="${pageContext.request.contextPath}/Servlet/ClientServlet?op=listbooks" ><font color="red" face="arial">所有分类</font></a>
	<c_rt:forEach items="${requestScope.categorys }" var="c" varStatus="vs">
		<a href="${pageContext.request.contextPath}/Servlet/ClientServlet?op=listbooksbycategory&categoryID=${c.id}">${c.name}</a>
	</c_rt:forEach>
	<br>
	
	<table border="0" width=666 align = center>
		<tr>
			<c_rt:forEach items="${requestScope.page.record }" var="v" varStatus="vs">
				<td>
					<img  src="${pageContext.request.contextPath}/image${v.photoPath}/${v.photoName}"><br>
					书名：${v.name }<br>
					作者：${v.author }<br>
					原价：1̶4̶4̶9<br>
					价格：${v.price }<br>
					<a href="${pageContext.request.contextPath}/Servlet/ClientServlet?op=listonebook&id=${v.id}">去看看</a>
				</td>
			</c_rt:forEach>
		</tr>
	</table>
	<%@ include file="/Manager/generalPage.jsp" %>
</body>
</html>