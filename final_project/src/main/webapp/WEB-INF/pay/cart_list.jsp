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
$(document).ready();
	function upQty(name,qty){  
		
			location.href="cart_qty_up.gom?foodName="+name;
	}
	
	function downQty(name,qty){  
	
			location.href="cart_qty_down.gom?foodName="+name;
		
		
	}

	function checkBoxNumbers(num) {
 	
 		

/*  		var deleteNumberValue = num.value;
 */ 
 		
		var hiddenNumbers = document.frm.deleteNumbers.value;
		
		
		
		if(num.checked){
			hiddenNumbers = hiddenNumbers + num.value + "/";
/* 			document.frm.deleteNumbers.value += deleteNumberValue + "/";
 */			
		}else{
			
/* 			document.frm.deleteNumbers.value = hiddenNumbers.replace(deleteNumberValue+"/", "");
 */			hiddenNumbers = hiddenNumbers.replace(num.value + "/", "");
 			
 
 		}
		  document.frm.deleteNumbers.value = hiddenNumbers;
		
/* 		alert(hiddenNumbers);
 */		
	}
	function itemDelete() {
		
		
 		
 		location.href="cart_remove.gom?delete=" + document.frm.deleteNumbers.value; 
	}
	
</script>
</head>

<body>

<% if(cartList == null && foodTotalAmount == null){ %>
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
<% } else { %>
<h1 align="center"> <font color ="black"><font size = 15> 장바구니</font></font></h1>



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
		<td><button class="btn-secondary"  onClick="javascript:itemDelete();" >삭제</button></td>
		
	</tr>

<form name="frm" id="frm" action="food_order_list.gom" method="post">	
	
	<input type="hidden"  id="deleteNumbers" name="deleteNumbers">
	<% 
		for(int i=0; i < cartList.size();i++){
			Cart cart = (Cart)cartList.get(i);
	%>
	
	<tr>
		<td><%=cart.getSellerEmail() %></td>
		<td><a href="food_detail.gom?foodNo=<%=cart.getFoodNo()%>"><img src="resource/<%=cart.getFoodImage() %>" width="70" height="70"/></a></td>
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
		<td><%=cart.getFoodCatANo() %></td>
		<td><%=cart.getFoodCatBNo() %></td>
		<td><%=cart.getFoodCatCNo() %></td>
		
		
	<td align="center">
	<input type="checkbox" name="foodNo" value="<%=cart.getFoodNo() %>" onClick="javascript:checkBoxNumbers(this);" />
	</td>
	</tr>
		<%-- <input type="hidden" name="foodQuant" value="<%=cart.getDemandQty() %>">
		<input type="hidden" name="foodCatANo" value="<%=cart.getFoodCatANo() %>">
		<input type="hidden" name="foodCatBNo" value="<%=cart.getFoodCatBNo() %>">
		<input type="hidden" name="foodCatCNo" value="<%=cart.getFoodCatCNo() %>"> --%>
		
	<%} %>

	<tr align="center">
			<td align="right" colspan="10"><font color="gray" size="5">총
					결제금액 :</font><font color="black" size="8"> <%=foodTotalAmount %> 원</font></td>
				
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
	
</table>

<% } %>
</body>
</html>