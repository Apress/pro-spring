<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<html>
<head>
    <c:set var="css"><spring:theme code="css"/></c:set>
   	<c:if test="${not empty css}"><link rel="stylesheet" href="<c:url value="${css}"/>" type="text/css" /></c:if>
		
	<tiles:insert attribute="meta"/>
	<title><tiles:getAsString name="title"/></title>
</head>

<table cellspacing="1" cellpadding="1" border="1" width="700px" align="center" bgcolor="#ffffff">
	<tr>
		<td colspan="2"><tiles:insert attribute="header"/></td>
	</tr>
	<tr>
		<td colspan="2"><tiles:insert attribute="toolbar"/></td>
	</tr>
	<tr height="400px">
		<td width="150px" valign="top"><tiles:insert attribute="menu"/></td>
		<td width="550px" valign="top"><tiles:insert attribute="body"/></td>
	</tr>
	<tr>
		<td colspan="2"><tiles:insert attribute="footer"/></td>
	</tr>
</table>

</body>
</html>
