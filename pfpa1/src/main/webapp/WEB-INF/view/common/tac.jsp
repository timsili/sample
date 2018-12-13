<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Terms and Conditions</title>
</head>
<body>
	<form action="tac" method="POST">
		<table border="1">
			<tr>
				<td colspan="2">이용약관 동의</td>
			</tr>
			<tr>
				<td colspan="2">이용약관 내용</td>
			</tr>
			<tr>
				<td>이용약관에 동의하십니까?</td>
				<td><input type="checkbox" name="terms" value="true">동의함</td>
			</tr>
			<tr>
				<td colspan="2">개인정보 수집 및 이용 동의</td>
			</tr>
			<tr>
				<td colspan="2">개인정보 수집 및 이용 내용</td>
			</tr>
			<tr>
				<td>개인정보 수집 및 이용에 동의하십니까?</td>
				<td><input type="checkbox" name="policy" value="true">동의함</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Next">
					<a href="<c:url value="/main"/>">Main</a><br>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>