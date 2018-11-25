<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, 
    model.FoodProFood"%>

<%
	List<FoodProFood> list = (List<FoodProFood>)request.getAttribute("FoodProFoodList");

%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!--1: N  -->
	<div class="container mt-3">
		<h1>식품+프로그램식품</h1>
		
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">

					<th>전체 식품 번호</th>
					<th>판매자 이메일</th>
					<th>식품카테고리A 번호</th>
					<th>식품카테고리B 번호</th>
					<th>식품카테고리C 번호</th>
					<th>프로그램 번호</th>
					<th>코치 이메일</th>
					<th>전체 식품 이름</th>
					<th>전체 식품 개수</th>
					<th>전체 식품 유통기한 날짜</th>
					<th>전체 식품 원산지 설명</th>
					<th>전체 식품 탄수화물</th>
					<th>전체 식품 단백질</th>
					<th>전체 식품 지방</th>
					<th>전체 식품 칼로리</th>
					<th>전체 식품 사진 저장된 이름</th>
					

				</tr>
			</thead>
			<tbody>
				
					<% for(Object temp : list) {
				FoodProFood foodProFoodList = (FoodProFood)temp; %>
				<tr>
					<td><%=foodProFoodList.getFoodNo() %></td>
					<td><%=foodProFoodList.getSellerEmail() %></td>
					<td><%=foodProFoodList.getFoodCatANo() %></td>
					<td><%=foodProFoodList.getFoodCatBNo() %></td>
					<td><%=foodProFoodList.getFoodCatCNo() %></td>
					<td><%=foodProFoodList.getProNo() %></td>
					<td><%=foodProFoodList.getCoachEmail() %></td>
					<td><%=foodProFoodList.getFoodName() %></td>
					<td><%=foodProFoodList.getFoodQuant() %></td>
					<td><%=foodProFoodList.getFoodExpiryDate() %></td>
					<td><%=foodProFoodList.getFoodOrigin() %></td>
					<td><%=foodProFoodList.getFoodCarbo() %></td>
					<td><%=foodProFoodList.getFoodProtein() %></td>
					<td><%=foodProFoodList.getFoodFat() %></td>
					<td><%=foodProFoodList.getFoodCal() %></td>
					<td><%=foodProFoodList.getFoodStored() %></td>
			
				</tr>


				
				

			</tbody>
		</table>
		
		<div>
	    			<form action="cart_addList.gom" method="post">
						<div class="form-row">
			                <div class="form-group col-sm-2">
			                	<label>수량</label>
			                	<input type="text" name="demandQty" class="form-control" maxlength="20">
			              	</div>
		              	</div>
		              	<div>가격: <%=foodProFoodList.getFoodPrice() %></div>
						<input type="text" name="proFoodNo" value="<%=foodProFoodList.getProFoodNo() %>">
						
						<button type="submit" class="btn btn-primary">장바구니 담기</button>
					</form>
    			</div>
		<%
					}
				%>

		<hr>