<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>no</th>
			<th>id</th>
			<th>cate</th>
			<th>item</th>
			<th>pric</th>
			<th>opti</th>
			<th>proop</th>
			<th>stock</th>
		</tr>
		<c:set var="sum" value="${0}"/>
		<c:forEach var="c" items="${cartList}" varStatus="loop">
			<tr>
				<td>${c.no}</td>
				<td>${c.id}</td>
				<td>${c.cate}</td>
				<td>${c.item}</td>
				<td>${c.pric}</td>
				<td>${c.opti}</td>
				<td>${c.proop}<c:set var="sum" value="${sum+c.pric+c.stock*c.proop}"/></td>
				<td>${c.stock}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5">
				<a href="<c:url value="/pli"/>">Continue</a>
				<a href="<c:url value="/main"/>">Main</a>
			</td>
			<td colspan="3">
				합계 : <c:out value="${sum}"/>
			</td>
		</tr>
	</table>
</body>
</html>