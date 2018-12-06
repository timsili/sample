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
	<c:if test="${loginVO.id ne 'admin'}">
		<a href="<c:url value="/mde/${loginVO.id}"/>">회원탈퇴</a><br>
	</c:if>
	<c:if test="${loginVO.id eq 'admin'}">
		<a href="<c:url value="/mli"/>">회원목록</a><br>
	</c:if>
</c:if>
<a href="<c:url value="/pli"/>">물품목록</a><br>
<a href="<c:url value="/pin"/>">물품등록</a><br>
</body>
</html>
