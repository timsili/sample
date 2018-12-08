<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Delete</title>
</head>
<body>
	<form:form commandName="memberVO" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="id">id</form:label></th>
				<td><form:input path="id" readonly="true"/></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="pwd"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Delete">
					<a href="<c:url value="/mse/${id}"/>">Cancel</a>
					<a href="<c:url value="/main"/>">Main</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>