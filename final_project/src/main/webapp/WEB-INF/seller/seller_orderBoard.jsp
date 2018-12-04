<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.FoodOrder, java.util.*"%>
<%
	List<FoodOrder> orderedFoodList = (List<FoodOrder>)request.getAttribute("orderedFoodList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 주문내역 조회</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<body>

	<div class="container">
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>주문번호</th>
					<th>식품명</th>
					<th>구매자</th>
				</tr>
			</thead>
			<tbody>
			<%
				for(Object temp : orderedFoodList){
					FoodOrder forp = (FoodOrder)temp;
			%>
				<tr class="active">
					<th><a href="#"><%=forp.getFoodOrderReceiverNo() %></a></th>
					<th><a href="#"><%=forp.getFoodOrderName() %></a></th>
					<th><a href="#"><%=forp.getMemberEmail() %></a></th>
				</tr>
			<% } %>
			</tbody>
		</table>
	
	</div>
</body>
</html>