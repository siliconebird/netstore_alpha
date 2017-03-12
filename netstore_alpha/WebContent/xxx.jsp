<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/client/generalHeader.jsp" %>
<html>
<body>
	<h2>购买商品如下</h2>	
			<table border="1" width = "666" align="center">
				<tr>
					 <th>选择</th>
					 <th>书名</th>
					 <th>单价</th>
					 <th>数量</th>
					 <th>小计</th>
					 <th>操作</th>
				</tr>
				<c_rt:forEach items="${sessionScope.cart.cart }" var="v" varStatus="vs">
				<tr class="${vs.index%2==0?'odd':'even' }">
						<td><input type="checkbox" name="itemId" value="${v.key }"></td>
						<td>${v.value.itemName}</td>
						<td>${v.value.itemPrice}</td>
						<td>${v.value.itemQuantity}</td>
						<td>${v.value.itemTotalPrice}</td>
						<td>
							<a href="">删除</a> 
						</td>
				</tr>
				</c_rt:forEach>
				<tr>
					共${sessionScope.cart.totalQuantity}件商品     总额:${ sessionScope.cart.amount}         <a href="">去结算</a>
				</tr>
			</table>
</body>
</html>