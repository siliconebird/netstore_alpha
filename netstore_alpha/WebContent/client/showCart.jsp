<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/client/generalHeader.jsp" %>
<html>
<body>
<c_rt:if test="${empty sessionScope.cart.cart }">
	<h1>你没有购买任何东西</h1>
</c_rt:if>
<c_rt:if test="${!empty sessionScope.cart.cart }">
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
							<td><input type="text" name="itemQuantity" value="${v.value.itemQuantity}" size="2" onchange="changeNum(this,'${ v.key}','${ v.value.itemQuantity}')"> </td>
							<td>${v.value.itemTotalPrice}</td>
							<td>
								<a  href="javascript:delItem('${v.key }')">删除</a> 
							</td>
					</tr>
				</c_rt:forEach>
				<tr>
					<td colspan="6">共${sessionScope.cart.totalQuantity}件商品     总额:${ sessionScope.cart.amount}         <a href="${pageContext.request.contextPath}/Servlet/ClientServlet?op=generOrder">去结算</a>
					</td>
				</tr>
			</table>
</c_rt:if>
		
			
			
			<script type="text/javascript">
				function changeNum(inputObj,itemId,oldValue) {
					
					if(!/^[1-9][0-9]*$/.test(inputObj.value)){
						alert("请输入数字！");
				  	}else{
				  		var sure = window.confirm("确定修改？");
						if(sure){
							//alert(inputObj.value);
							window.location.href="${pageContext.request.contextPath}/Servlet/ClientServlet?op=changeNum&bookId="+itemId+"&newNum="+inputObj.value;
						}else{
							inputObj.value = oldValue;
						}
				  	}
				}
			</script>
			<script type="text/javascript">
			function delItem(itemId) {
				var sure = window.confirm("确定删除？");
				if(sure){
					window.location.href="${pageContext.request.contextPath}/Servlet/ClientServlet?op=delOneItem&bookId="+itemId;
				}
			}
			</script>
</body>
</html>