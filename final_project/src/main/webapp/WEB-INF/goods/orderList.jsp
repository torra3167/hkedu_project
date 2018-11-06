<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 결제 </title>
</head>
<body>
<script type="text/javascript">
	function checkQty(name,qty){  
		if(qty<=1){
			return false;
		} else {
			location.href="goodsBuyQtyDown.sh?name="+name;
		}
		
	}
</script>

<h1 align="center"> <font color ="black"><font size = 15> 결제정보</font></font></h1>
<table width="600" align="center">
<tr>
<td align="right"><a href="goodsList.sh">결제취소</a></td>
</tr>
</table>

<form action="goodsBuyRemove.sh" method="post" name="myForm">
<table align="center" width="70%" border="2">
	<tr align="center" >
		<td>번호	</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td align="center">
		<input type="submit" name="delete" value="삭제" />
		
		</td>

	</tr>
	
	
	<tr align="center">
		<td>11</td>
		<td><img src="./goodsUpload/<" width="70" height="70"/></td>
		<td>11</td>
		<td>13213</td>
		<td>
		<a href="./goodsBuyQtyUp.sh?name=">
		<img src="images/up.jpg" width="15" height="15" border="0"/>
		</a>
		<br>
			갯수
		<br>
		<a href="javascript:checkQty('1','2')">
		<img src="images/down.jpg" width="15" height="15" border="0"/>
		</a>
		<br>
		</td>
	<td align="center">
	<input type="checkbox" name="delete" value="" />
	</td>
	</tr>
	
<tr align="center">
				<td colspan=6 id="border2"><font size=5>구매리스트</font></td>
			</tr> 
			<tr>
				<td id="border" align="center">구매자이름 : </td>
				<td colspan=5 id="border" align="left"><input type="text" name="buyNum" /></td>
			</tr>
			<tr>
				<td id="border" align="center">핸드폰 : </td>
				<td colspan=5 id="border" align="left"><select name="buyPhone" id="buyPhone">
						<option value="buyPhone1">010</option>
						<option value="buyPhone1">011</option>
						<option value="buyPhone1">016</option>
						<option value="buyPhone1">019</option>
				</select> - <input type="text" name="buyPhone2" maxlength=4 size="5" /> - <input
					type="text" name="buyPhone3" maxlength=4 size="5" /></td>
			</tr>
			<tr>
				<td id="border" align="center">주소 : </td>
				<td colspan=5 id="border" align="left"><input type="text" id="sample6_postcode" name="buyZipcode" placeholder="우편번호">
					<input type="button" onclick="sample6_execDaumPostcode()"
					value="우편번호 찾기"><br> <input type="text"
					id="sample6_address" placeholder="주소" name="buyAddr1"> <input type="text"
					id="sample6_address2" placeholder="상세주소" name="buyAddr2"></td>
			</tr>
			<tr>
				<td id="border" align="center">이메일 : </td>
				<td colspan=5 id="border" align="left"><input type="text" name="buyEmail1" size=20 /> @ <input
					type="text" name="buyEmail2" size=20 /><br/>
					이메일을 통해 주문처리과정을 보내드립니다.<br/>
					이메일 주소란에는 반드시 수신가능한 이메일주소를 입력해 주세요.</td>
			</tr>
			
			<tr>
				<td id="border" align="center" colspan=6>결제정보 </td>
			
				
			</tr>
			
			
			
			
			

</table>
</form>

<table align="center" width="70%" border="2">
	<tr align="center" >
		<td align="right" colspan="6">
		<font color ="gray" size="5">총 결제금액 :</font><font color ="black" size="8">원</font><br>
		<a href="goodsPayView.sh?totalMoney="><font color ="gray" size="5">결제하기</font></a>
		</td>
		
	</tr>
</table>

	
</body>
</html>