<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.FoodOrder, model.ProFoodOrder"%>
    
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
     <%
    String email = (String)session.getAttribute("email");
	List cartList = (List)session.getAttribute("FoodOrderList");
	List proFoodOrderList = (List)session.getAttribute("proFoodOrderList");
    int sum = 0;
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"> <font color ="black"><font size = 15> 주문서</font></font></h1>



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

 	<form:form commandName="foodOrderReceiver" action="food_order_list_insert.gom"> 
 	<form:hidden path="memberEmail" value="<%=email %>"/>

 <% 	if(proFoodOrderList == null) { %>
	
<% 	} %>
	
<% 	if(proFoodOrderList != null) {
	 
		for(Object temp : proFoodOrderList) {
			ProFoodOrder proFoodOrder = (ProFoodOrder)temp;

	%>
	
	<tr>
		<td><%=proFoodOrder.getSellerEmail() %></td>
		<td><%=proFoodOrder.getFoodNo()%><img src="resource/<%=proFoodOrder.getProFoodOrderStored() %>" width="70" height="70"/></td>
		<td><%=proFoodOrder.getProFoodOrderName() %></td>
		<td><%=proFoodOrder.getProFoodOrderPrice() %></td>
		<td><%=proFoodOrder.getProFoodOrderQuant() %></td>
		<td><%=proFoodOrder.getFoodCatANo() %></td>
		<td><%=proFoodOrder.getFoodCatBNo() %></td>
		<td><%=proFoodOrder.getFoodCatCNo() %></td>
	</tr>
		
	
	<%
		sum += 	proFoodOrder.getProFoodOrderPrice() * proFoodOrder.getProFoodOrderQuant();
	} 
 } %>	
 

<% 	if(cartList == null) { %>
	
<% 	} 

	if(cartList != null) { 
		
		for(Object temp2 : cartList) {
			FoodOrder foodOrder = (FoodOrder)temp2;

	%>
	
	<tr>
		<td><%=foodOrder.getSellerEmail() %></td>
		<td><%=foodOrder.getFoodNo()%><img src="resource/<%=foodOrder.getFoodOrderStored() %>" width="70" height="70"/></td>
		<td><%=foodOrder.getFoodOrderName() %></td>
		<td><%=foodOrder.getFoodOrderPrice() %></td>
		<td><%=foodOrder.getFoodOrderQuant() %></td>
		<td><%=foodOrder.getFoodCatANo() %></td>
		<td><%=foodOrder.getFoodCatBNo() %></td>
		<td><%=foodOrder.getFoodCatCNo() %></td>
	</tr>
	
	<%
		sum += 	foodOrder.getFoodOrderPrice() * foodOrder.getFoodOrderQuant();
	} %>
	
<% } %>
	</table>
	
		
		
		<div class="form-group">
          <label>이름</label>
          <form:input path="foodOrderReceiverName" class="form-control" />
        </div>
        <div class="form-group">
          <label>연락처 번호</label>
          <form:input path="foodOrderReceiverPhone" class="form-control" />
        </div>
        <div class="form-group">
          <label>기본주소</label>
          <form:input path="foodOrderReceiverAddr1" class="form-control" />
        </div>
        
        <div class="form-group">
          <label>상세주소</label>
          <form:input path="foodOrderReceiverAddr2" class="form-control" />
        </div>
        
        <div class="form-group">
          <label>우편번호</label>
          <form:input path="foodOrderReceiverAddrno" class="form-control" />
        </div>
        
        <div class="form-group">
          <label>결제총금액</label>
          <form:input path="foodOrderReceiverTotal" class="form-control" value="<%=sum %>" readonly="true"/>
        </div>
       
        <div class="form-group">
					<label>결제방법</label> <select name="foodPayDivide" class="form-control">
						<option value="card" selected>카드결제</option>
						<option value="cash">현금결제</option>
					</select>
				</div>
        <button type="submit" class="btn btn-primary" >결제하기</button>
        <button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
		
	 </form:form>



</body>
</html>