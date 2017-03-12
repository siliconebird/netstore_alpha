<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Manager/uppage.jsp" %>
<html>
<body>
<br>
<h1>分类列表</h1>
<table border="1" width="440" align="center">
	<tr>
		<th>选中</th>
		<th>类名</th>
		<th>描述</th>
		<th>操作</th>
	</tr>
	<c_rt:forEach items="${requestScope.list }" var="v"  varStatus="vs">
		<tr class="${vs.index%2==0?'odd':'even' }">
			<td><input type="checkbox" name="selecteID" value=${v.id }></td>
			<td>${v.name }</td>
			<td>${v.description }</td>
			<td>
			<a href=${pageContext.request.contextPath }/Manager/ControlerServlet?op=del&id=${v.id }>删除</a>
			<a href="script:alert(''未完工)">修改</a>
			</td>
		</tr>
	</c_rt:forEach>

</table>
</body>
</html>