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
<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="http://localhost:8080/final_project/css/bootstrap.min.css">
</head>

<body>

	<div class="container">
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>식품명</th>
					<th>가격</th>
					<th>개수</th>
					<th>개수</th>
					<th>개수</th>
					<th>개수</th>
				</tr>
			</thead>
			
			<tbody>
			 <% for(Object temp : list) {
				 Food food = (Food)temp; %>
				<tr>
					<td><a href="exercise_detail.gom?foodNo=<%=food.getFoodNo() %>"><%=food.getFoodNo() %></a></td>
					<td><%=food.getFoodCatANo() %></td>
					<td><%=food.getFoodCatBNo() %></td>
					<td><%=food.getFoodCatCNo() %></td>
					<td><%=food.getFoodPrice() %></td>
					<td><%=food.getFoodQuant() %></td>
<%-- 					<td><img src="http://localhost:8080/final_project/resource/<%=upload.getUploadStored() %>" width="80" height="80"></td> --%>
					<td><%=food.getFoodExpiryDate() %></td> 
					
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