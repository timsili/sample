<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Delete</title>
</head>
<body>
	<form:form commandName="productVO" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="no">No</form:label></th>
				<td><form:input path="no" readonly="true"/></td>
			</tr>
			<tr>
				<th><form:label path="item">Item</form:label></th>
				<td><form:input path="item" readonly="true"/></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Delete">
					<a href="<c:url value="/aps/${no}"/>">Cancel</a>
					<a href="<c:url value="/main"/>">Main</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>