<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Order Detail</title>
</head>
<body>
	<a href="<c:url value="/main"/>">Main</a>
	<a href="<c:url value="/oal"/>">Order List</a>
	<table border="1">
		<tr>
			<th>cate</th>
			<th>item</th>
			<th>pric</th>
			<th>opti</th>
			<th>proop</th>
			<th>stock</th>
		</tr>
		<c:forEach var="ol" items="${odd}">
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
			<td>${od.orno}</td>
		<tr>
		<tr>
			<th>name</th>
			<td>${od.name}</td>
		<tr>
		<tr>
			<th>address</th>
			<td>
				${od.poco}<br>
				${od.addr}<br>
				${od.daddr}
			</td>
		<tr>
		<tr>
			<th>tel</th>
			<td>${od.tel}</td>
		<tr>
		<tr>
			<th>ceph</th>
			<td>${od.ceph}</td>
		<tr>
		<tr>
			<th>dema</th>
			<td>${od.dema}</td>
		<tr>
		<tr>
			<th>prog</th>
			<td>${od.prog}</td>
		<tr>
		<tr>
			<th>regd</th>
			<td>${od.regd}</td>
		<tr>
		<tr>
			<th>sum</th>
			<td>${od.sum}</td>
		<tr>
		<tr>
			<th>pame</th>
			<td>${od.pame}</td>
		</tr>
		<tr>
			<th>pade</th>
			<td>${od.pade}</td>
		</tr>
		<tr>
			<th>change</th>
			<td>
				<form action="${path}/oad/${od.orno}" method="post">
					<select name="progress">
						<option value="wp">결제대기중</option>
						<option value="pd">배송준비중</option>
						<option value="od">배송중</option>
						<option value="cd">배송완료</option>
					</select>
					<input type="submit" value="change">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>