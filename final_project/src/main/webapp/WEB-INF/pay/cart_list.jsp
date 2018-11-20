<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.Cart"%>
    
    <%
	List cartList = (List) session.getAttribute("cartList");
	Integer foodTotalAmount = (Integer)session.getAttribute("foodTotalAmount");

    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 장바구니 </title>
<script type="text/javascript">
	function upQty(name,qty){  
		
			location.href="cart_qty_up.gom?foodName="+name;
	}
	
	function downQty(name,qty){  
	
			location.href="cart_qty_down.gom?foodName="+name;
		
		
	}
</script>
</head>

<body>

<% if(cartList == null && foodTotalAmount == null){ %>
<h1 align="center">상품이 존재하지 않습니다.</h1>

<table class="table">
		<tr>
			<td>상품이미지</td>
			<td>상품명</td>
			<td>가격</td>
			<td>수량</td>
			<td><input type="submit" value="삭제" /></td>
		</tr>
</table>
<% } else { %>
<h1 align="center"> <font color ="black"><font size = 15> 장바구니</font></font></h1>


<form action="cart_remove.gom" method="post">
<table class="table">
	<tr>
	<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td align="center">
		<input type="submit" value="삭제" />
		</td>
	</tr>
	
	<% 
		for(int i=0; i < cartList.size();i++){
			Cart cart = (Cart)cartList.get(i);
	%>
	
	<tr>
		
		<td><a href="food_detail.gom?foodNo=<%=cart.getFoodNo()%>"><img src="./resource/<%=cart.getFoodImage() %>" width="70" height="70"/></a></td>
		<td><%=cart.getFoodName() %></td>
		<td><%=cart.getFoodPrice() %></td>
		<td>
		<a href="javascript:upQty('<%=cart.getFoodName()%>','<%= cart.getDemandQty() %>')">
		<img src="images/up.jpg" width="15" height="15" border="0"/>업
		</a>
		<br>
		<%=cart.getDemandQty() %>
		<br>
		<a href="javascript:downQty('<%=cart.getFoodName()%>','<%= cart.getDemandQty() %>')">
		<img src="images/down.jpg" width="15" height="15" border="0"/>다운
		</a>
		<br>
		</td>
	<td align="center">
	<input type="checkbox" name="delete" value="<%=cart.getFoodNo() %>" />
	</td>
	</tr>
	<%} %>


</table>
</form>
<% } %>
<hr>
<% if(foodTotalAmount != null){ %> 
<table class="table">
		<tr align="center">
			<td align="right" colspan="6"><font color="gray" size="5">총
					결제금액 :</font><font color="black" size="8"> <%=foodTotalAmount %> 원</font></td>

		</tr>
		<tr>
			<td align="right"><a href="index">쇼핑계속하기</a></td>

		</tr>
	</table>
<% } %>
</body>
</html>