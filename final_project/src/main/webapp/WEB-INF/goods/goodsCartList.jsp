<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 장바구니 </title>
</head>
 <link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
<body>

<script type="text/javascript">
	function checkQty(name,qty){  
		if(qty<=1){
			return false;
		} else {
			location.href="goodsCartQtyDown.sh?name="+name;
		}
		
	}
</script>
<h1 align="center">상품이 존재하지 않습니다.</h1>
<h1 align="center"> <font color ="black"><font size = 15> 장바구니</font></font></h1>
<table width="600" align="center">
<tr>
<td align="right"><a href="../index.jsp">쇼핑계속하기</a></td>
</tr>
</table>

<form action="goodsCartRemove.sh" method="post" name="myForm">
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
		<td>1</td>
		<td><img src="./goodsUpload/" width="70" height="70"/></td>
		<td>111</td>
		<td>111</td>
		<td>
		<a href="./goodsCartQtyUp.sh?name=">
		<img src="images/up.jpg" width="15" height="15" border="0"/>
		</a>
		<br>
			개수
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
	


</table>
</form>

<table align="center" width="70%" border="2">
	<tr align="center" >
		<td align="right" colspan="6"><font color ="gray" size="5">총 결제금액 :</font><font color ="black" size="8">원</font></td>
	</tr>
</table>

</body>
</html>