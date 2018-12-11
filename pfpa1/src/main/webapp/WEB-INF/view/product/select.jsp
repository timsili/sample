<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<title>Product Info</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>no</th>
			<td>${productVO.no}</td>
		</tr>
		<tr>
			<th>item</th>
			<td>${productVO.item}</td>
		</tr>
		<tr>
			<th>category</th>
			<td>${productVO.cate}</td>
		</tr>
		<tr>
			<th>thumb nail</th>
			<td><img src="${path}/images/${productVO.item}/${productVO.cntn}"></td>
		</tr>
		<tr>
			<th>price</th>
			<td>${productVO.pric}</td>
		</tr>
		<tr>
			<th>options</th>
			<td>${productVO.opti}</td>
		</tr>
		<tr>
			<th>price of option</th>
			<td>${productVO.proop}</td>
		</tr>
		<tr>
			<td colspan="2">
				<form:form commandName="cartVO" method="POST" action="${path}/cas">
					<input type="hidden" name="no" value="${productVO.no}">
					<input type="hidden" name="cate" value="${productVO.cate}">
					<input type="hidden" name="item" value="${productVO.item}">
					<input type="hidden" name="pric" value="${productVO.pric}">
					<input type="text" name="opti">
					<input type="text" name="proop">
					<input type="text" name="stock">
					<input type="submit" value="Cart">
				</form:form>
				<%-- <form action="${path}/cas" method="GET">
					<input type="hidden" name="no" value="${productVO.no}">
					<input type="hidden" name="cate" value="${productVO.cate}">
					<input type="hidden" name="item" value="${productVO.item}">
					<input type="hidden" name="pric" value="${productVO.pric}">
					<input type="text" name="opti">
					<input type="text" name="proop">
					<input type="submit" value="Cart">
				</form> --%>
			</td>
		</tr>
		<tr>
			<th>description</th>
			<td>
				<c:forEach var="d" items="${descrList}">
					<img src="${path}/images/${productVO.item}/${d}"
						style="width: auto; height: auto; max-width: 200px;"><br>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<th>stock</th>
			<td>${productVO.stock}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="<c:url value="/pli"/>">List</a>
				<a href="<c:url value="/main"/>">Main</a>
			</td>
		</tr>
	</table>
</body>
</html>