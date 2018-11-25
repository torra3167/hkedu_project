<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.FoodProFood" %>
    
    <%
    	List<FoodProFood> list = (List<FoodProFood>)request.getAttribute("FoodProFoodList");
    	System.out.println(list.size());
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		
	<div class="container">
	<h1 class="">프로그램 리스트</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>프로그램 음식 사진</th>
					<th>프로그램 음식 이름 </th>
					<th>프로그램 음식  판매자</th>
					<th>프로그램 음식  가격</th>
					<th>프로그램 음식  리뷰</th>
					<th>프로그램 음식  리뷰보기</th>
				</tr>
			</thead>
			<tbody>
			<% for(Object temp : list) {
				FoodProFood foodProFoodList = (FoodProFood)temp; %>
				<tr>
					<td><img src="http://localhost:8080/final_project/resource/<%=foodProFoodList.getFoodStored() %>" width="80" height="80"></td>				
					<td><a href="pro_food_list_detail.gom?proFoodNo=<%=foodProFoodList.getProFoodNo() %>"><%=foodProFoodList.getFoodName() %></a></td>					
					<td><%=foodProFoodList.getSellerEmail() %></td>
					<td><%=foodProFoodList.getFoodPrice() %></td>
					<td><a href="pro_review_write.gom?proNo=<%=foodProFoodList.getFoodCarbo() %>&coachEmail=<%=foodProFoodList.getFoodFat() %>">리뷰작성</a></td>
					<td><a href="pro_review_list.gom?proNo=<%=foodProFoodList.getFoodCatCNo() %>">리뷰확인하러가기</a></td>
				</tr>
				
				<% } %>
				
			</tbody>
		</table>

		<hr>
</body>
</html>