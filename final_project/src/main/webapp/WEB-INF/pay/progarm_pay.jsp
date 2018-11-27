<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "model.ProOrder" %>
    
    <%
		String memberEmail = (String)session.getAttribute("email");
    	ProOrder proOrder = (ProOrder)session.getAttribute("proOrder");
		
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
<form action="program_pay_success.gom" method="post" >
<table align="center" border="0" width =50% height=300 id="tborder">
<tr align="center">


				<td colspan=2 id="border2"><font size=5>카드결제</font></td>
			</tr>
		
			<input type="hidden" name="proOrderNo" value="<%=proOrder.getProOrderNo() %>">	
		
		

			
			<tr>
				<td id="border" align="center">구매자이메일 : </td>
				<td id="border" align="left"><input type="text" name="memberEmail" value=<%=memberEmail %> readonly="readonly"/></td>
			</tr>
			
			<tr>
				<td id="border" align="center">카드번호 :</td>
				<td id="border" align="left"><input type="text" name="proPayCardNo" maxlength=30 size="5" />
			</tr>
			
			<tr>
				<td id="border" align="center">년도 :</td>
				<td id="border" align="left"><input type="text" name="proPayCardY" /></td>
			</tr>
			
			<tr>
				<td id="border" align="center">월 :</td>
				<td id="border" align="left"><input type="text" name="proPayCardM" /></td>
			</tr>
			
			
			<tr>
				<td id="border" align="center">CVC 번호 :</td>
				<td id="border" align="left"><input type="text" name="proPayCardCvc" maxlength=4 size="8" 
				placeholder="숫자3자리입력" /></td>
			</tr>
			
			<tr>
				<td id="border" align="center">총 금액 : </td>
				<td id="border" align="left"><input type="number" name="proPayPrice" value="<%=proOrder.getProOrderTotal() %>" readonly="readonly"  /><br/>
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