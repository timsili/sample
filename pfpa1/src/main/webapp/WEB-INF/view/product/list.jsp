<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Product List</title>
</head>
<body>
	<a href="<c:url value="/main"/>">Main</a><br>
	<table border="1">
		<tr>
			<th>no</th>
			<th>item</th>
			<th>cate</th>
			<th>cntn</th>
			<th>pric</th>
		</tr>
		<c:forEach var="p" items="${productList}">
			<tr>
				<td>${p.no}</td>
				<td><a href="<c:url value="/pse/${p.no}"/>">${p.item}</a></td>
				<td>${p.cate}</td>
				<td height="100px"><img src="${path}/images/${p.item}/${p.cntn}" 
					style="width: auto;height: auto; 
					max-width: 90px; max-height: 90px;"></td>
				<td>${p.pric}</td>
			</tr>
		</c:forEach>
	</table>
	<c:if test="${pagination.prev}">
		<a href="${path}/pli?page=${pagination.start-1}">prev</a>
	</c:if>
	<c:forEach begin="${pagination.start}" end="${pagination.end}" var="nm">
		<a href="${path}/pli?page=${nm}">${nm}</a>
	</c:forEach>
	<c:if test="${pagination.next}">
		<a href="${path}/pli?page=${pagination.end+1}">next</a>
	</c:if>
</body>
</html>