<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무통장입금</title>
<script type="text/javascript">
	function goPage() {
		location.href = "NewFile.jsp";
	}
</script>
<style type="text/css">
table {
	border: 3px solid black;
}

#tborder {
	margin-top: 20px;
	margin-bottom: 20px
}

#border {
	border-top: 1px dotted black;
	padding: 20px;
}

#border2 {
	padding: 10px;
}
</style>
</head>
<body>
	<table align="center" border="0" width=50% height=300 id="tborder">
		<tr align="center">
			<td colspan=2 id="border2"><font size=5>무통장입금</font></td>
		</tr>
		<tr>
			<td id="border" align="center">구매자번호 :</td>
			<td id="border" align="left"><input type="text" name="buyNum" /></td>
		</tr>
		<tr>
			<td id="border" align="center">총 금액 :</td>
			<td id="border" align="left"><input type="number"
				name="buyTotalprice" size=20 /><br /></td>
		</tr>
		<tr>
			<td id="border" align="center">입금자명 :</td>
			<td id="border" align="left"><input type="text" name="" /></td>
		</tr>
		<tr>
			<td id="border" align="center">입금은행 :</td>
			<td id="border" align="left"><select name="" id="">
					<option value="">선택해 주세요</option>
					<option value="">기업은행:525-039166-01-018(주)정필컴퍼니</option>
					<option value="">국민은행:594401-04-079458(주)정필컴퍼니</option>
					<option value="">우리은행:1005-002-717935(주)정필컴퍼니</option>
					<option value="">신한은행:140-010-923855(주)정필컴퍼니</option>
					<option value="">농협:355-0035-9762-13(주)정필컴퍼니</option>
			</select></td>
		</tr>
		<tr>
			<td id="border" align="center">결제승인일 :</td>
			<td id="border" align="left"><input type="text"
				name="payApprovalDay" /></td>
		</tr>
		<tr>
			<td id="border" align="center">결제승인번호 :</td>
			<td id="border" align="left"><input type="text"
				name="payApprovalNumber" /></td>
		</tr>
		<tr>
			<td colspan=2 align="center" id="border2"><input type="button"
				value="취소" onclick="" />&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="button" value="완료" onclick="javascript:goPage();" /></td>
		</tr>
	</table>
</body>
</html>