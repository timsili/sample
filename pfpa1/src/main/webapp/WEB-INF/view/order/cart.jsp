<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Cart</title>
</head>
<body>
	<a href="<c:url value="/pli"/>">Continue</a>
	<a href="<c:url value="/main"/>">Main</a>
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
		<c:if test="${empty cartList}">
			<tr>
				<td colspan="8">장바구니가 비어있습니다.</td>
			</tr>
		</c:if>
		<c:if test="${!empty cartList}">
			<c:forEach var="c" items="${cartList}" varStatus="loop">
				<tr>
					<td>${c.no}</td>
					<td>${c.id}</td>
					<td>${c.cate}</td>
					<td>${c.item}</td>
					<td>${c.pric}</td>
					<td>${c.opti}</td>
					<td>${c.proop}<c:set var="sum" value="${sum+(c.pric+c.proop)*c.stock}"/></td>
					<td>${c.stock}</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<td colspan="8">
				합계 : <c:out value="${sum}"/><br>
			</td>
		</tr>
	</table>
	<form action="${path}/cfm" method="get">
		<input type="submit" value="Check Order">
	</form>
</body>
</html>
