<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매</title>
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
			<td colspan=2 id="border2"><font size=5>구매</font></td>
		</tr>
		<tr>
			<td id="border" align="center">구매자이름 :</td>
			<td id="border" align="left"><input type="text" name="buyNum" /></td>
		</tr>
		<tr>
			<td id="border" align="center">핸드폰 :</td>
			<td id="border" align="left"><select name="buyPhone"
				id="buyPhone">
					<option value="buyPhone1">010</option>
					<option value="buyPhone1">011</option>
					<option value="buyPhone1">016</option>
					<option value="buyPhone1">019</option>
			</select> - <input type="text" name="buyPhone2" maxlength=4 size="5" /> - <input
				type="text" name="buyPhone3" maxlength=4 size="5" /></td>
		</tr>
		<tr>
			<td id="border" align="center">주소 :</td>
			<td id="border" align="left"><input type="text"
				id="sample6_postcode" name="buyZipcode" placeholder="우편번호">
				<input type="button" onclick="sample6_execDaumPostcode()"
				value="우편번호 찾기"><br> <input type="text"
				id="sample6_address" placeholder="주소" name="buyAddr1"> <input
				type="text" id="sample6_address2" placeholder="상세주소" name="buyAddr2"></td>
		</tr>
		<tr>
			<td id="border" align="center">이메일 :</td>
			<td id="border" align="left"><input type="text" name="buyEmail1"
				size=20 /> @ <input type="text" name="buyEmail2" size=20 /><br />
				이메일을 통해 주문처리과정을 보내드립니다.<br /> 이메일 주소란에는 반드시 수신가능한 이메일주소를 입력해 주세요.</td>
		</tr>
		<tr>
			<td id="border" align="center">구매자 총 금액 :</td>
			<td id="border" align="left"><input type="number"
				name="buyTotalprice" size=20 /><br /></td>
		</tr>
	</table>
</body>
</html>