<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Registration</title>
</head>
<body>
	<form:form commandName="memberVO" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="id">ID</form:label></th>
				<td><form:input path="id"/></td>
			</tr>
			<tr>
				<th><form:label path="pwd">Password</form:label></th>
				<td><form:input path="pwd"/></td>
			</tr>
			<tr>
				<th><form:label path="cpwd">Confirm Password</form:label></th>
				<td><form:input path="cpwd"/></td>
			</tr>
			<tr>
				<th><form:label path="name">Name</form:label></th>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<th><form:label path="email">E-mail</form:label></th>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<th><form:label path="tel">Telephone</form:label></th>
				<td><form:input path="tel"/></td>
			</tr>
			<tr>
				<th><form:label path="ceph">Mobile</form:label></th>
				<td><form:input path="ceph"/></td>
			</tr>
			<tr>
				<th><form:label path="poco">Post Code</form:label></th>
				<td><form:input path="poco"/></td>
			</tr>
			<tr>
				<th><form:label path="addr">Address</form:label></th>
				<td><form:input path="addr"/></td>
			</tr>
			<tr>
				<th><form:label path="daddr">Detail Address</form:label></th>
				<td><form:input path="daddr"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Join">
					<a href="<c:url value="/main"/>">Main</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>