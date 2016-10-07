<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<form action="edit.html" method="post">
<input type="hidden" name="productId" value="<c:out value="${command.productId}"/>">
<table>
	<tr>
		<td>Name</td>
		<td><spring:bind path="command.name">
				<input name="name" value="<c:out value="${status.value}"/>">
				<span class="error"><c:out value="${status.errorMessage}"/></span>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td>Expiration Date</td>
		<td><spring:bind path="command.expirationDate">
				<input name="expirationDate" value="<c:out value="${status.value}"/>">
				<span class="error"><c:out value="${status.errorMessage}"/></span>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit"></td>
	</tr>
</table>
</form>
