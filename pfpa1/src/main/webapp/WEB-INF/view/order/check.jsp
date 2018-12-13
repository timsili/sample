<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Check Order</title>
</head>
<body>
	<a href="<c:url value="/main"/>">Main</a>
	<form action="${path}/cho" method="post">
		<table>
			<tr>
				<th>orno</th>
				<td>${ordersVO.orno}</td>
			</tr>
			<tr>
				<th>name</th>
				<td>${ordersVO.name}</td>
			</tr>
			<tr>
				<th>poco</th>
				<td>${ordersVO.poco}</td>
			</tr>
			<tr>
				<th>addr</th>
				<td>${ordersVO.addr}</td>
			</tr>
			<tr>
				<th>daddr</th>
				<td>${ordersVO.daddr}</td>
			</tr>
			<tr>
				<th>tel</th>
				<td>${ordersVO.tel}</td>
			</tr>
			<tr>
				<th>ceph</th>
				<td>${ordersVO.ceph}</td>
			</tr>
			<tr>
				<th>dema</th>
				<td>${ordersVO.dema}</td>
			</tr>
			<tr>
				<th>pame</th>
				<td>${ordersVO.pame}</td>
			</tr>
			<tr>
				<th>pade</th>
				<td>${ordersVO.pade}</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="yes"></td>
			</tr>
		</table>
	</form>
</body>
</html>