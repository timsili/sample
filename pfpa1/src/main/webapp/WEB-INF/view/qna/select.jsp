<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA Detail</title>
</head>
<body>
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
			<th>rcnt</th>
			<td>${qnaVO.rcnt}</td>
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
				<a href="<c:url value="/qli"/>">List</a>
				<a href="<c:url value="/main"/>">Main</a>
			</td>
		</tr>
	</table>
</body>
</html>