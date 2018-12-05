<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main</title>
<c:set var="path" value="${pageContext.request.contextPath}"/>
</head>
<body>
this is main page<br>
<c:if test="${empty loginVO }">
	<a href="<c:url value="/tac"/>">회원가입</a><br>
	<a href="<c:url value="/lin"/>">로그인</a><br>
</c:if>
<c:if test="${!empty loginVO }">
	${loginVO.id}<br>
	<a href="<c:url value="/lou"/>">로그아웃</a><br>
	<a href="<c:url value="/mli"/>">회원목록</a><br>
</c:if>
</body>
</html>