<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Manager/uppage.jsp" %>
<%@ taglib uri="http://www.turnrut.com/functions" prefix="myfn" %>
<html>
<body>
<br>
<h1>图书列表</h1>
<table border="1" width="640" align="center">
	<tr>
		<th nowrap="nowrap">选中</th>
		<th nowrap="nowrap">类名</th>
		<th nowrap="nowrap">作者</th>
		<th nowrap="nowrap">价格</th>
		<th nowrap="nowrap">描述</th>
		<th nowrap="nowrap">类别信息</th>
		<th nowrap="nowrap">封面</th>
		<th nowrap="nowrap">操作</th>
	</tr>
	<c_rt:forEach items="${requestScope.page.record }" var="v"  varStatus="vs">
		<tr class="${vs.index%2==0?'odd':'even' }">
			<td nowrap="nowrap"><input type="checkbox" name="selecteID" value=${v.id }></td>
			<td nowrap="nowrap">${v.name }</td>
			<td nowrap="nowrap">${v.author}</td>
			<td nowrap="nowrap">${v.price}</td>
			<td nowrap="nowrap">${v.description}</td>
			<td nowrap="nowrap">${myfn:showNameById(v.categoryID)}</td>
			<td nowrap="nowrap"> 
				<img src="${pageContext.request.contextPath}/image${v.photoPath}/${v.photoName}">
			</td>
			<td nowrap="nowrap">
			<a href=${pageContext.request.contextPath }/Manager/ControlerServlet?op=delbook&id=${v.id }>删除</a>
			<a href="script:alert(''未完工)">修改</a>
			</td>
		</tr>
	</c_rt:forEach>
</table>
<hr>
			<%@ include file="/Manager/generalPage.jsp" %>
			<form method="post" action="${pageContext.request.contextPath }/Manager/ControlerServlet?op=querybook">
				跳至第<input type="text" name ="pageIndex"  onchange="onPageIndexInput(this)">页&nbsp;
				每页显示
				<select name="offset">
					<option value="3">3</option>
					<option value="5">5</option>
					<option value="10">10</option>
				</select>条
				<input type="submit" value="跳转" >
			</form>
			<script type="text/javascript">
					function onPageIndexInput( ) {
						
					}
			</script>
</body>
</html>