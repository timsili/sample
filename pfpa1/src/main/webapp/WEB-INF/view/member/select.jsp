<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Info</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>no</th>
			<td>${memberVO.no}</td>
		</tr>
		<tr>
			<th>id</th>
			<td>${memberVO.id}</td>
		</tr>
		<tr>
			<th>name</th>
			<td>${memberVO.name}</td>
		</tr>
		<tr>
			<th>email</th>
			<td>${memberVO.email}</td>
		</tr>
		<tr>
			<th>tel</th>
			<td>${memberVO.tel}</td>
		</tr>
		<tr>
			<th>ceph</th>
			<td>${memberVO.ceph}</td>
		</tr>
		<tr>
			<th>poco</th>
			<td>${memberVO.poco}</td>
		</tr>
		<tr>
			<th>addr</th>
			<td>${memberVO.addr}</td>
		</tr>
		<tr>
			<th>daddr</th>
			<td>${memberVO.daddr}</td>
		</tr>
		<tr>
			<th>poin</th>
			<td>${memberVO.poin}</td>
		</tr>
		<tr>
			<th>sum</th>
			<td>${memberVO.sum}</td>
		</tr>
		<tr>
			<th>rank</th>
			<td>${memberVO.rank}</td>
		</tr>
		<tr>
			<th>regd</th>
			<td>${memberVO.regd}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="<c:url value="/mup/${id}"/>">Edit</a>
				<a href="<c:url value="/mde/${id}"/>">Delete</a>
				<a href="<c:url value="/main"/>">Main</a>
			</td>
		</tr>
	</table>
</body>
</html>