<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

This page lists all available products:<br>
<c:forEach items="${products}" var="product">
	<c:out value="${product.name}"/>
	<a href="view.html?productId=<c:out value="${product.productId}"/>">[View]</a>&nbsp;
	<a href="edit.html?productId=<c:out value="${product.productId}"/>">[Edit]</a>&nbsp;<br>
	<hr>
</c:forEach><br>
<a href="edit.html">[Add]</a>
