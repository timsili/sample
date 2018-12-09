<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA Detail</title>
</head>
<body>
	<a href="<c:url value="/qli"/>">List</a>
	<a href="<c:url value="/main"/>">Main</a>
	<table border="1">
		<tr>
			<th>no</th>
			<td>${qnaVO.no}</td>
		</tr>
		<tr>
			<th>writ</th>
			<td>${qnaVO.writ}</td>
		</tr>
		<tr>
			<th>title</th>
			<td>${qnaVO.title}</td>
		</tr>
		<tr>
			<th>regd</th>
			<td>${qnaVO.regd}</td>
		</tr>
		<tr>
			<th>cont</th>
			<td>${qnaVO.cont}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="<c:url value="/qde/${qnaVO.no}"/>">Delete</a>
			</td>
		</tr>
	</table>
	<table border="1">
		<c:forEach var="r" items="${reqnaList}" varStatus="loop">
			<tr>
				<td>${r.writ}</td>
				<td>${r.regd}</td>
			</tr>
			<tr>
				<td colspan="2">${r.cont}</td>
			</tr>
		</c:forEach>
	</table>
	<form:form commandName="reqnaVO" method="POST">
		<form:hidden path="writ"/>
		<table border="1">
			<tr>
				<td>${reqnaVO.writ}</td>
			</tr>
			<tr>
				<td><form:textarea path="cont" rows="3" cols="50" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Regist"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>