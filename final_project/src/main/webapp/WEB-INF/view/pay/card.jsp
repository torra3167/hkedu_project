<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카드결제</title>
<script type="text/javascript">
function goPage() {
	location.href="NewFile.jsp";
}
</script>
<style type="text/css">
table{border:3px solid black;}
#tborder{margin-top:20px; margin-bottom:20px}
#border{border-top:1px dotted black; padding:20px;}
#border2{padding:10px;} 
</style>
</head>
<body>
<table align="center" border="0" width =50% height=300 id="tborder">
<tr align="center">
				<td colspan=2 id="border2"><font size=5>카드결제</font></td>
			</tr> 
			<tr>
				<td id="border" align="center">구매자번호 : </td>
				<td id="border" align="left"><input type="text" name="buyNum" /></td>
			</tr>
			<tr>
				<td id="border" align="center">총 금액 : </td>
				<td id="border" align="left"><input type="number" name="buyTotalprice" size=20 /><br/>
				</td>
			</tr>
			<tr>
				<td id="border" align="center">카드번호 :</td>
				<td id="border" align="left"><input type="text" name="" maxlength=4 size="5" /> - <input
					type="text" name="" maxlength=4 size="5" /> - <input type="text" name="" maxlength=4 size="5" /> - <input
					type="text" name="" maxlength=4 size="5" /></td>
			</tr>
			<tr>
				<td id="border" align="center">CVC 번호 :</td>
				<td id="border" align="left"><input type="text" name="" maxlength=4 size="8" 
				placeholder="숫자3자리입력" /></td>
			</tr>
			<tr>
				<td id="border" align="center">결제승인일 :</td>
				<td id="border" align="left"><input type="text" name="payApprovalDay" /></td>
			</tr>
			<tr>
				<td id="border" align="center">결제승인번호 :</td>
				<td id="border" align="left"><input type="text" name="payApprovalNumber" /></td>
			</tr>
			<tr>
				<td colspan=2 align="center" id="border2">
				 <input type="button" value="취소" onclick=""/>&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="button" value="완료" onclick="javascript:goPage();"/>
				</td>
			</tr>
</table>
</body>
</html>