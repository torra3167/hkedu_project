<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.Cart, model.ProFoodCart"%>
    
    <%
	List programCartList = (List) session.getAttribute("programCartList");
	Integer programSum = (Integer)session.getAttribute("programSum");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 장바구니 </title>
<script type="text/javascript">

	function checkBoxNumbers(num) {

		var hiddenNumbers = document.frm.deleteNumbers.value;

		if (num.checked) {
			hiddenNumbers = hiddenNumbers + num.value + "/";

		} else {

			hiddenNumbers = hiddenNumbers.replace(num.value + "/", "");

		}
		document.frm.deleteNumbers.value = hiddenNumbers;

	}
	function itemDelete() {

		location.href = "program_cart_remove.gom?delete="
				+ document.frm.deleteNumbers.value;
	}


</script>
</head>

<body>

<% if(programCartList == null){ %>
<h1 align="center">상품이 존재하지 않습니다.</h1>

<table class="table">
		<tr>
			<td>프로그램 판매자이메일</td>
			<td>프로그램 상품이미지</td>
			<td>프로그램 상품명</td>
			<td>프로그램 가격</td>
			<td>프로그램 내용</td>
		
		</tr>
</table>

<% } else if(programCartList != null) { %>
<h1 align="center"> <font color ="black"><font size = 15> 프로그램장바구니</font></font></h1>
<table class="table">
	<tr>
		<td>프로그램 판매자이메일</td>
		<td>프로그램 상품이미지</td>
		<td>프로그램 상품명</td>
		<td>프로그램 가격</td>
		<td>프로그램 내용</td>
		<td><button class="btn-secondary"  onClick="javascript:itemDelete();" >삭제</button></td>	
	</tr>
<form name="frm" id="frm" action="program_food_order_list.gom" method="post">	
	<input type="hidden"  id="deleteNumbers" name="deleteNumbers">
	<% 
		for(int i=0; i < programCartList.size();i++){
			Cart cart = (Cart)programCartList.get(i);
	%>
	<tr>
		<td><%=cart.getCoachEmail() %></td>
		<td><a href="food_detail.gom?foodNo=<%=cart.getProNo()%>"><img src="resource/<%=cart.getProStored() %>" width="70" height="70"/></a></td>
		<td><%=cart.getProName() %></td>
		<td><%=cart.getProPrice() %></td>
		<td><%=cart.getProContent() %></td>
		<td align="center">
			<input type="checkbox" name="proNo" value="<%=cart.getProNo() %>" onClick="javascript:checkBoxNumbers(this);" />
		</td>
	</tr>
	<% }  %>	
	<tr align="center">
			<td align="right" colspan="10"><font color="gray" size="5">총
					결제금액 :</font><font color="black" size="8"> <%=programSum %> 원</font></td>
				
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