<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery Tracking</title>
</head>
<body>
	<a href="<c:url value="/main"/>">Main</a><br>
	<table border="1">
		<tr>
			<th>orno</th>
			<th>regd</th>
			<th>item</th>
			<th>sum</th>
			<th>prog</th>
			<th>cancel</th>
		</tr>
		<c:forEach var="o" items="${ordersList}" varStatus="status">
			<tr>
				<td><a href="<c:url value="/pro/${o.orno}"/>">${o.orno}</a></td>
				<td>${o.regd}</td>
				<td>${o.item}</td>
				<td>${o.sum}</td>
				<td>${o.prog}</td>
				<td><a href="<c:url value="/ode/${o.orno}"/>">cancel</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>