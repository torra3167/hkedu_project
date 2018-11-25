<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Food"%>
	
<% 
    	List list = (List)request.getAttribute("sellerFoodList");
 %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 등록식품 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<body>

	<div class="container">
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>식품번호</th>
					<th>식품명</th>
					<th>가격</th>
					<th>개수</th>
					<th>유통기한</th>
				</tr>
			</thead>
			
			<tbody>
			 <% for(Object temp : list) {
				 Food food = (Food)temp; %>
				<tr>
					<td><%=food.getFoodNo() %></td>
					<td><a href="seller_foodDetail.gom?foodNo=<%=food.getFoodNo() %>"><%=food.getFoodName() %></a></td>
					<td><%=food.getFoodPrice() %></td>
					<td><%=food.getFoodQuant() %></td>
					<td><%=food.getFoodExpiryDate() %></td>
					<td><img src="http://localhost:8080/final_project/resource/<%=food.getFoodStored() %>" width="80" height="80"></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		
		<hr>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center mt-3">
					<li class="page-item"><a class="page-link" href="#">이전</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">다음</a></li>
				</ul>
			</nav>
	</div>
</body>
</html>