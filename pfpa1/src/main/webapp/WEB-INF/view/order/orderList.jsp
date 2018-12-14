<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Order List</title>
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
			<th>change</th>
		</tr>
		<c:forEach var="o" items="${odList}">
			<tr>
				<td><a href="<c:url value="/oad/${o.orno}"/>">${o.orno}</a></td>
				<td>${o.regd}</td>
				<td>${o.item}</td>
				<td>${o.sum}</td>
				<td>${o.prog}</td>
				<td>
					<select>
						<option value="wp">결제대기중</option>
						<option value="pd">배송준비중</option>
						<option value="od">배송중</option>
						<option value="cd">배송완료</option>
					</select>
					<input type="submit" value="change">
				</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pagination.prev}">
		<a href="${path}/oal?page=${pagination.start-1}">prev</a>
	</c:if>
	<c:forEach begin="${pagination.start}" end="${pagination.end}" var="nm">
		<a href="${path}/oal?page=${nm}">${nm}</a>
	</c:forEach>
	<c:if test="${pagination.next}">
		<a href="${path}/oal?page=${pagination.end+1}">next</a>
	</c:if>
</body>
</html>