<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<h1>Struts action</h1>
<c:forEach items="${products}" var="product">
	<c:out value="${product.name}"/><br>
</c:forEach>
<br>
<c:out value="${fromStruts}"/>