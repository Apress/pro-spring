<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <c:set var="css"><spring:theme code="css"/></c:set>
   	<c:if test="${not empty css}"><link rel="stylesheet" href="<c:url value="${css}"/>" type="text/css" /></c:if>
</head>
<body>
Thank you!
</body>
</html>