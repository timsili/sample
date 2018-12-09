<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA Registration</title>
</head>
<body>
	<form:form commandName="qnaVO" method="POST">
		<table border="1">
			<tr>
				<th><form:label path="writ">Writer</form:label></th>
				<td><form:input path="writ" readonly="true"/></td>
			</tr>
			<tr>
				<th><form:label path="title">Title</form:label></th>
				<td><form:input path="title"/></td>
			</tr>
			<tr>
				<th><form:label path="cont">Content</form:label></th>
				<td><form:textarea path="cont"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Regist">
					<a href="<c:url value="/main"/>">Main</a>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>