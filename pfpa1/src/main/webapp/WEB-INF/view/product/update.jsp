<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Update</title>
</head>
<body>
	<form:form commandName="productVO" method="POST" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th><form:label path="item">Item</form:label></th>
				<td><form:input path="item" readonly="true"/></td>
			</tr>
			<tr>
				<th><form:label path="cate">Category</form:label></th>
				<td><form:input path="cate"/></td>
			</tr>
			<tr>
				<th><form:label path="pric">Price</form:label></th>
				<td><form:input path="pric"/></td>
			</tr>
			<tr>
				<th><form:label path="opti">Options</form:label></th>
				<td><form:input path="opti"/></td>
			</tr>
			<tr>
				<th><form:label path="proop">Price of Options</form:label></th>
				<td><form:input path="proop"/></td>
			</tr>
			<tr>
				<th><form:label path="descr">Description</form:label></th>
				<td>
					<input type="file" name="descr" multiple="multiple"><br>
					first photo gonna thumb nail
				</td>
			</tr>
			<tr>
				<th><form:label path="stock">Stock</form:label></th>
				<td><form:input path="stock"/></td>
			</tr>
			<tr>
				<th><form:label path="acti">Active</form:label></th>
				<td>
					Active: <form:radiobutton path="acti" value="1"/>&nbsp;
					Inactive: <form:radiobutton path="acti" value="0"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Regist">
					<a href="<c:url value="/aps/${no}"/>">Cancel</a>
					<a href="<c:url value="/main"/>">Main</a>
				</td>
			</tr>
		</table>
		<form:hidden path="ontn"/>
		<form:hidden path="cntn"/>
		<form:hidden path="ondes"/>
		<form:hidden path="cndes"/>
	</form:form>
</body>
</html>