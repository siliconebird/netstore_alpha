<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<body>
	第${page.currentPage }页/共${page.totalPageNum}页&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath }${page.url }&pageIndex=${page.prePage}&offset=${page.offset}">上一页</a>
			<a href="${pageContext.request.contextPath }${page.url }&pageIndex=${page.nextPage}&offset=${page.offset}">下一页</a>
</body>
</html>