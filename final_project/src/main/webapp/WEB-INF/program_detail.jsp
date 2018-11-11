<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 보기</title>
</head>
<body>
	<h1 align="center">
		1
		의 정보
	</h1>
	<table align="center" width="600">
		
	
		<tr>
			<td rowspan="7"><img
				src="./resource/<% %>" /></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<td>종류 : </td>
		</tr>
		<tr>
			<td>이름 : </td>
		</tr>
		<tr>
			<td>가격: </td>
		</tr>
		
		<tr>
			<td>사이즈: </td>
		</tr>
		<tr>
			<td>색: </td>
		</tr>
		<tr>
			<td>내용: </td>
		</tr>
		<tr>
			<form action="goodsBuyAdd.sh" method="post" name="frm">
				
					<td>수량 :</td>
					<input type="hidden" name="num" value="">
					<td><input type="text" name="qty"></td>
					<td><input type="submit" value="결제하기" name="submit"></td>
			</form>
		</tr>
			
		<tr>
			<td colspan="2" align="center"><a href="exercise_list.gom">목록보기</a></td>
		</tr>

	</table>
</body>
</html>