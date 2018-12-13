<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="bank" method="POST">
		<table border="1">
			<tr>
				<th>name</th>
				<td><input type="text" name="ordn"></td>
			</tr>
			<tr>
				<th>bank</th>
				<td>
					<select name="ordb">
						<option value="">선택바람</option>
						<option value="">국민 123456-12-123456</option>
						<option value="">농협 123-1234-1234-12</option>
						<option value="">신한 123-123-123456</option>
						<option value="">우리 1234-123-123456</option>
						<option value="">하나 123-123456-12345</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					aight?
				</td>
			</tr>
			<tr>
				<td colspan="2">
					button
				</td>
			</tr>
		</table>
	</form>
</body>
</html>