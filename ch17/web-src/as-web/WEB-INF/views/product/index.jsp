<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <c:set var="css"><spring:theme code="css"/></c:set>
   	<c:if test="${not empty css}"><link rel="stylesheet" href="<c:url value="${css}"/>" type="text/css" /></c:if>
</head>
<body>
This page lists all available products:<br>
<c:forEach items="${products}" var="product">
	<c:out value="${product.name}"/>
	<a href="view.html?productId=<c:out value="${product.productId}"/>">[View]</a>&nbsp;
	<a href="edit.html?productId=<c:out value="${product.productId}"/>">[Edit]</a>&nbsp;<br>
	<hr>
</c:forEach><br>
<a href="edit.html">[Add]</a>
</body>
</html>