<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>QnA List</title>
</head>
<body>
	<a href="<c:url value="/main"/>">Main</a><br>
	<form action="${path}/qli" method="GET">
		<input type="text" name="id">
		<input type="submit" value="Search">
	</form>
	<table border="1">
		<tr>
			<th>no</th>
			<th>rep</th>
			<th>title</th>
			<th>writ</th>
			<th>regd</th>
		</tr>
		<c:forEach var="q" items="${qnaList}" varStatus="loop">
			<tr>
				<td>${q.no}</td>
				<td>${q.rep}</td>
				<td><a href="<c:url value="/qse/${q.no}"/>">${q.title}</a></td>
				<td>${q.writ}</td>
				<td>${q.regd}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pagination.prev}">
		<a href="${path}/qli?page=${pagination.start-1}">prev</a>
	</c:if>
	<c:forEach begin="${pagination.start}" end="${pagination.end}" var="nm">
		<a href="${path}/qli?page=${nm}">${nm}</a>
	</c:forEach>
	<c:if test="${pagination.next}">
		<a href="${path}/qli?page=${pagination.end+1}">next</a>
	</c:if>
	<br><a href="<c:url value="/qin"/>">문의등록</a>
</body>
</html>