<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>
<head>
<title>Pro Spring</title>
</head>
<body>
<h1>Struts action</h1>
<c:forEach items="${products}" var="product">
	<c:out value="${product.name}"/><br>
</c:forEach>
</body>
</html>