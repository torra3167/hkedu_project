<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
		Integer foodOrderReceiverNumber = (Integer)request.getAttribute("FoodOrderReceiverNumber");
		Integer foodOrderReceiverTotal = (Integer)request.getAttribute("FoodOrderReceiverTotal");
		String memberEmail = (String)session.getAttribute("email");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제</title>
<script type="text/javascript">

</script>
<style type="text/css">
table{border:3px solid black;}
#tborder{margin-top:20px; margin-bottom:20px}
#border{border-top:1px dotted black; padding:20px;}
#border2{padding:10px;} 
</style>
</head>
<body>
<form >
<table align="center" border="0" width =50% height=300 id="tborder">
<tr align="center">


				<td colspan=2 id="border2"><font size=5>카드결제</font></td>
			</tr> 
			<input type="hidden" name="foodPayPrice" value="<%=foodOrderReceiverTotal%>">
			<input type="hidden" name="foodOrderReceiverNo" value="<%=foodOrderReceiverNumber%>">
				
			<tr>
				<td id="border" align="center">구매자이메일 : </td>
				<td id="border" align="left"><input type="text" name="memberEmail" /></td>
			</tr>
			
			<tr>
				<td id="border" align="center">카드번호 :</td>
				<td id="border" align="left"><input type="text" name="foodPayCardNo" maxlength=30 size="5" />
			</tr>
			
			<tr>
				<td id="border" align="center">년도 :</td>
				<td id="border" align="left"><input type="text" name="foodPayCardY" /></td>
			</tr>
			
			<tr>
				<td id="border" align="center">월 :</td>
				<td id="border" align="left"><input type="text" name="foodPayCardM" /></td>
			</tr>
			
			
			<tr>
				<td id="border" align="center">CVC 번호 :</td>
				<td id="border" align="left"><input type="text" name="foodPayCardCvc" maxlength=4 size="8" 
				placeholder="숫자3자리입력" /></td>
			</tr>
			
			<tr>
				<td id="border" align="center">총 금액 : </td>
				<td id="border" align="left"><input type="number" name="foodPayPrice" size=20 /><br/>
				</td>
			</tr>
			<tr>
				<td colspan=2 align="center" id="border2">
				 <input type="button" value="취소" onclick=""/>&nbsp;&nbsp;&nbsp;&nbsp; 
				<input type="submit" value="결제완료" />
				</td>
			</tr>
	</form>
</table>
</body>
</html>