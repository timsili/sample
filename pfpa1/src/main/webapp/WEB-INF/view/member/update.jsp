<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Info Edit</title>
</head>
<body>
	<form:form commandName="memberVO" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="id">id</form:label></th>
				<td>${memberVO.id}</td>
			</tr>
			<tr>
				<th><form:label path="name">name</form:label></th>
				<td>${memberVO.name}</td>
			</tr>
			<tr>
				<th><form:label path="email">email</form:label></th>
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<th><form:label path="tel">tel</form:label></th>
				<td><form:input path="tel"/></td>
			</tr>
			<tr>
				<th><form:label path="ceph">ceph</form:label></th>
				<td><form:input path="ceph"/></td>
			</tr>
			<tr>
				<th><form:label path="poco">poco</form:label></th>
				<td><form:input path="poco"/></td>
			</tr>
			<tr>
				<th><form:label path="addr">addr</form:label></th>
				<td><form:input path="addr"/></td>
			</tr>
			<tr>
				<th><form:label path="daddr">daddr</form:label></th>
				<td><form:input path="daddr"/></td>
			</tr>
			<tr>
				<th><form:label path="pwd">pwd</form:label></th>
				<td><input type="password" id="pwd" name="pwd"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Edit">
					<a href="<c:url value="/main"/>">Main</a><br>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>