<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Progress Detail</title>
</head>
<body>
	<a href="<c:url value="/main"/>">Main</a>
	<a href="<c:url value="/pro"/>">Progress</a>
	<table border="1">
		<tr>
			<th>cate</th>
			<th>item</th>
			<th>pric</th>
			<th>opti</th>
			<th>proop</th>
			<th>stock</th>
		</tr>
		<c:forEach var="ol" items="${orderList}">
			<tr>
				<td>${ol.cate}</td>
				<td><a href="<c:out value="${path}/pse/${ol.no}"/>">${ol.item}</a></td>
				<td>${ol.pric}</td>
				<td>${ol.opti}</td>
				<td>${ol.proop}</td>
				<td>${ol.stock}</td>
			</tr>
		</c:forEach>
	</table>
	<table border="1">
		<tr>
			<th>orno</th>
			<td>${order.orno}</td>
		<tr>
		<tr>
			<th>name</th>
			<td>${order.name}</td>
		<tr>
		<tr>
			<th>address</th>
			<td>
				${order.poco}<br>
				${order.addr}<br>
				${order.daddr}
			</td>
		<tr>
		<tr>
			<th>tel</th>
			<td>${order.tel}</td>
		<tr>
		<tr>
			<th>ceph</th>
			<td>${order.ceph}</td>
		<tr>
		<tr>
			<th>dema</th>
			<td>${order.dema}</td>
		<tr>
		<tr>
			<th>prog</th>
			<td>${order.prog}</td>
		<tr>
		<tr>
			<th>regd</th>
			<td>${order.regd}</td>
		<tr>
		<tr>
			<th>sum</th>
			<td>${order.sum}</td>
		<tr>
	</table>
</body>
</html>