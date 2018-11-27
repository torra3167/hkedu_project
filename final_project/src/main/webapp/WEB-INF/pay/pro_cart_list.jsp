<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.Cart, model.ProFoodCart"%>
    
    <%
	Integer proFoodSum = (Integer)session.getAttribute("proFoodSum");
	List proFoodCartList = (List) session.getAttribute("proFoodCartList");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 프로그램 식품 장바구니 </title>
<script type="text/javascript">


	

	function proUpQty(name, qty) {
		
		location.href = "pro_cart_qty_up.gom?foodName=" + name;
	}
	
	function proDownQty(name, qty) {

		location.href = "pro_cart_qty_down.gom?foodName=" + name;

	}

	function proCheckBoxNumbers(num) {

		var hiddenNumbers = document.frm2.proDeleteNumbers.value;

		if (num.checked) {
			hiddenNumbers = hiddenNumbers + num.value + "/";

		} else {

			hiddenNumbers = hiddenNumbers.replace(num.value + "/", "");

		}
		document.frm2.proDeleteNumbers.value = hiddenNumbers;

	}
	function proItemDelete() {

		location.href = "pro_cart_remove.gom?delete="
				+ document.frm2.proDeleteNumbers.value;
	}
</script>
</head>

<body>

<% if(proFoodCartList == null){ %>
<h1 align="center">상품이 존재하지 않습니다.</h1>

<table class="table">
		<tr>
			<td>판매자이메일</td>
			<td>상품이미지</td>
			<td>상품명</td>
			<td>가격</td>
			<td>수량</td>
			<td>카테고리A</td>
			<td>카테고리B</td>
			<td>카테고리C</td>
			
		</tr>
</table>


	<% } else if(proFoodCartList != null) { %>
<h1 align="center"> <font color ="black"><font size = 15> 운동식품 장바구니</font></font></h1>
<table class="table">
	<tr>
		<td>판매자이메일</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>
		<td>수량</td>
		<td>카테고리A</td>
		<td>카테고리B</td>
		<td>카테고리C</td>
		<td><button class="btn-secondary"  onClick="javascript:proItemDelete();" >삭제</button></td>	
	</tr>
<form name="frm2" id="frm2" action="food_order_list.gom" method="post">	
	<input type="hidden"  id="proDeleteNumbers" name="proDeleteNumbers">
	<% 
		for(int i=0; i < proFoodCartList.size();i++){
			ProFoodCart proCart = (ProFoodCart)proFoodCartList.get(i);
	%>
	<tr>
		<td><%=proCart.getSellerEmail() %></td>
		<td><a href="pro_food_detail.gom?proFoodNo=<%=proCart.getFoodNo()%>"><img src="resource/<%=proCart.getFoodImage() %>" width="70" height="70"/></a></td>
		<td><%=proCart.getFoodName() %></td>
		<td><%=proCart.getFoodPrice() %></td>
		<td>
		<a href="javascript:proUpQty('<%=proCart.getFoodName()%>','<%= proCart.getDemandQty() %>')">
		<img src="images/up.jpg" width="15" height="15" border="0"/>업
		</a>
		<br><%=proCart.getDemandQty() %><br>
		<a href="javascript:proDownQty('<%=proCart.getFoodName()%>','<%= proCart.getDemandQty() %>')">
		<img src="images/down.jpg" width="15" height="15" border="0"/>다운
		</a>
		<br>
		</td>
		<td><%=proCart.getFoodCatANo() %></td>
		<td><%=proCart.getFoodCatBNo() %></td>
		<td><%=proCart.getFoodCatCNo() %></td>
		<td align="center">
			<input type="checkbox" name="proFoodNo" value="<%=proCart.getProFoodNo() %>" onClick="javascript:proCheckBoxNumbers(this);" />
		</td>
	</tr>
<% } %>
	<tr align="center">
			<td align="right" colspan="10"><font color="gray" size="5">총
					결제금액 :</font><font color="black" size="8"> <%=proFoodSum %> 원</font></td>
				
		</tr>
		
		<tr align="center">
			<td align="right" colspan="10">
				<input type="submit" value="결제하기" color="gray" size="5" class="gray" />	
			</td>
		</tr>
		<tr align="center">	
			<td align="right" colspan="10"><a href="index">쇼핑계속하기</a></td>
		</tr>
	</form>
	
	<% } %>
</table>
</body>
</html>