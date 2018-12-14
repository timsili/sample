<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="path" value="${pageContext.request.contextPath}"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Order Confirm</title>
</head>
<body>
	<a href="<c:url value="/pli"/>">Continue</a>
	<a href="<c:url value="/main"/>">Main</a>
	<table border="1">
		<tr>
			<th>id</th>
			<th>rank</th>
			<th>poin</th>
		</tr>
		<tr>
			<td>${memberVO.id}</td>
			<td>${memberVO.rank}</td>
			<td>${memberVO.poin}</td>
		</tr>
	</table>
	<table border="1">
		<tr>
			<th>item</th>
			<th>pric</th>
			<th>opti</th>
			<th>proop</th>
			<th>stock</th>
		</tr>
		<c:forEach var="c" items="${cartList}" varStatus="loop">
			<tr>
				<td>${c.item}</td>
				<td>${c.pric}</td>
				<td>${c.opti}</td>
				<td>${c.proop}</td>
				<td>${c.stock}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				합계 : ${sum}<br>적립예상 : ${point}
			</td>
		</tr>
	</table>
	배송 정보
	<form action="${path}/cfo" method="post">
	<input type="hidden" name="sum" value="${sum}">
	<table border="1" id="same" style="display: block;">
		<tr>
			<th>delivery</th>
			<td>
				<input type="radio" id="srb1" name="s" value="sa" onclick="chgs()" checked="checked">same
				<input type="radio" id="srb2" name="s" value="de" onclick="chgd()">def
			</td>
		</tr>
		<tr>
			<th>name</th>
			<td>${memberVO.name}</td>
		</tr>
		<tr>
			<th>address</th>
			<td>
				${memberVO.poco}<br>
				${memberVO.addr}<br>
				${memberVO.daddr}
			</td>
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
			<th>demand</th>
			<td><input type="text" name="sdema"></td>
		</tr>
	</table>
	<table border="1" id="sapm" style="display: block;">
		<tr>
			<td>
				<input type="radio" name="pm" value="ca" onclick="chgsc()" checked="checked">card
				<input type="radio" name="pm" value="ba" onclick="chgsb()">bank
			</td>
			<td rowspan="2"><input type="submit" value="Pay"></td>
		</tr>
		<tr>
			<td id="scar" style="display: block;">
				card<input type="hidden" name="card" value="card">
			</td>
			<td id="sban" style="display: none;">
				<table border="1">
					<tr>
						<th>name</th>
						<td><input type="text" name="bank"></td>
					</tr>
					<tr>
						<th>account</th>
						<td>
							<select name="acco">
								<option value="">선택바람</option>
								<option value="kb">국민 123456-12-123456</option>
								<option value="nh">농협 123-1234-1234-12</option>
								<option value="sh">신한 123-123-123456</option>
								<option value="wr">우리 1234-123-123456</option>
								<option value="hn">하나 123-123456-12345</option>
							</select>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	</form>
	<form:form commandName="ordersVO" method="POST">
		<table border="1" id="deff" style="display: none;">
			<tr>
				<th>delivery</th>
				<td>
					<input type="radio" id="drb1" name="s" value="sa" onclick="chgs()">same
					<input type="radio" id="drb2" name="s" value="de" onclick="chgd()" checked="checked">def
				</td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>address</th>
				<td>
					<input type="text" name="poco"/><br>
					<input type="text" name="addr"/><br>
					<input type="text" name="daddr"/>
				</td>
			</tr>
			<tr>
				<th>tel</th>
				<td><input type="text" name="tel"/></td>
			</tr>
			<tr>
				<th>ceph
				<td><input type="text" name="ceph"/></td>
			</tr>
			<tr>
				<th>demand</th>
				<td><input type="text" name="ddema"></td>
			</tr>
		</table>
		<table border="1" id="depm" style="display: none;">
			<tr>
			<td>
				<input type="radio" name="pm" value="ca" onclick="chgdc()" checked="checked">card
				<input type="radio" name="pm" value="ba" onclick="chgdb()">bank
			</td>
			<td rowspan="2"><input type="submit" value="Pay"></td>
		</tr>
		<tr>
			<td id="dcar" style="display: block;">
				card<input type="hidden" name="card" value="card">
			</td>
			<td id="dban" style="display: none;">
				<table border="1">
					<tr>
						<th>name</th>
						<td><input type="text" name="bank"></td>
					</tr>
					<tr>
						<th>account</th>
						<td>
							<select name="acco">
								<option value="">선택바람</option>
								<option value="kb">국민 123456-12-123456</option>
								<option value="nh">농협 123-1234-1234-12</option>
								<option value="sh">신한 123-123-123456</option>
								<option value="wr">우리 1234-123-123456</option>
								<option value="hn">하나 123-123456-12345</option>
							</select>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		</table>
	</form:form>
	<script type="text/javascript">
		function chgs(){
			$('#srb1').prop("checked", true);
			$('#srb2').prop("checked", false);
			$('#drb1').prop("checked", true);
			$('#drb2').prop("checked", false);
			same.style.display='';
			deff.style.display='none';
			sapm.style.display='';
			depm.style.display='none';
		}
		function chgd(){
			$('#srb1').prop("checked", false);
			$('#srb2').prop("checked", true);
			$('#drb1').prop("checked", false);
			$('#drb2').prop("checked", true);
			same.style.display='none';
			deff.style.display='';
			sapm.style.display='none';
			depm.style.display='';
		}
		function chgsc(){
			scar.style.display='';
			sban.style.display='none';
		}
		function chgsb(){
			scar.style.display='none';
			sban.style.display='';
		}
		function chgdc(){
			dcar.style.display='';
			dban.style.display='none';
		}
		function chgdb(){
			dcar.style.display='none';
			dban.style.display='';
		}
	</script>
</body>
</html>