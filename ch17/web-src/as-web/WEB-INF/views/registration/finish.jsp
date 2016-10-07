<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <c:set var="css"><spring:theme code="css"/></c:set>
   	<c:if test="${not empty css}"><link rel="stylesheet" href="<c:url value="${css}"/>" type="text/css" /></c:if>
</head>
<body>
<form action="wizard.html?_finish" method="post">
<input type="hidden" name="_page" value="2">
<table>
	<tr>
		<td>Register now?</td>
		<td><c:out value="${command}"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Next"></td>
	</tr>
</table>
</form>
</body>
</html>