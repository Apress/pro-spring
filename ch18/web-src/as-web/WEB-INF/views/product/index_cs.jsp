<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

Tato stránka zobrazuje všechny dostupné produkty:<br>
<c:forEach items="${products}" var="product">
	<c:out value="${product.name}"/>
	<a href="view.html?productId=<c:out value="${product.productId}"/>">[Zobrazit]</a>&nbsp;
	<a href="edit.html?productId=<c:out value="${product.productId}"/>">[Upravit]</a>&nbsp;<br>
	<hr>
</c:forEach><br>
<a href="edit.html">[Nový]</a>
