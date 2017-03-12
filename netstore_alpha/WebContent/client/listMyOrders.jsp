<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/client/generalHeader.jsp" %>
<html>
<body>
<c_rt:if test="${empty requestScope.myOrders }">
	<h1>您没有任何订单</h1>
</c_rt:if>
<c_rt:if test="${!empty requestScope.myOrders }">
	<h2>您的订单如下</h2>
	<table border="1" width = "666" align="center">
				<tr>
					 <th>选择</th>
					 <th>订单号</th>
					 <th>订单数量</th>
					 <th>订单价格</th>
					 <th>订单状态</th>
					 <th>操作</th>
				</tr>
				<c_rt:forEach items="${requestScope.myOrders }" var="v" varStatus="vs">
					<tr class="${vs.index%2==0?'odd':'even' }">
							<td><input type="checkbox" name="orderId" value="${v.orderId }"></td>
							<td>${v.orderNum}</td>
							<td>${v.quantity}</td>
							<td>${v.amount}</td>
							<td>
							<c_rt:choose>
								<c_rt:when test="${v.status==0}">
									未付款
								</c_rt:when>
								<c_rt:when test="${v.status==1}">
									等待发货
								</c_rt:when>
								<c_rt:when test="${v.status==2}">
									已发货
								</c_rt:when>
							
							</c_rt:choose>
							</td>
							<td>	
										<a  href="javascript:delItem('${v.orderId }')">删除订单</a> 
										<c_rt:if test="${v. status==0}">
											<a  href="${pageContext.request.contextPath }/client/pay.jsp?orderNum=${v.orderNum}&amount=${v.amount}">现在去支付</a>
										</c_rt:if> 
							</td>
					</tr>
				</c_rt:forEach>
			</table>
</c_rt:if>
		
			
			<script type="text/javascript">
			function delItem(itemId) {
				var sure = window.confirm("确定删除？");
				if(sure){
					window.location.href="${pageContext.request.contextPath}/Servlet/ClientServlet?op=delOder&orderId="+itemId;
				}
			}
			</script>
</body>
</html>