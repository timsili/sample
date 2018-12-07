<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Member List</title>
</head>
<body>
	<a href="<c:url value="/main"/>">Main</a><br>
	<table border="1">
		<tr>
			<th>no</th>
			<th>id</th>
			<th>name</th>
			<th>email</th>
			<th>ceph</th>
			<th>rank</th>
			<th>regd</th>
		</tr>
		<c:forEach var="m" items="${memberList}" varStatus="loop">
			<tr>
				<td>${m.no}</td>
				<td><a href="<c:url value="/mse/${m.id}"/>">${m.id}</a></td>
				<td>${m.name}</td>
				<td>${m.email}</td>
				<td>${m.ceph}</td>
				<td>${m.rank}</td>
				<td>${m.regd}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pagination.prev}">
		<a href="${path}/mli?page=${pagination.start-1}">prev</a>
	</c:if>
	<c:forEach begin="${pagination.start}" end="${pagination.end}" var="nm">
		<a href="${path}/mli?page=${nm}">${nm}</a>
	</c:forEach>
	<c:if test="${pagination.next}">
		<a href="${path}/mli?page=${pagination.end+1}">next</a>
	</c:if>
</body>
</html>