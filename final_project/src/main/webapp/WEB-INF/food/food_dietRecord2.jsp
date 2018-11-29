<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Food, java.util.*"%>
<%
//결제식단 select list
   List<Food> orderedFoodList = (List<Food>)request.getAttribute("orderedFoodList");   //결제한 식품들정보
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<label>주문한 상품 중 선택</label>
	<select class="form-control" id="selectOrderedFood" name="selectOrderedFood">
	<%
	   int fn = 0;
	   for(Object temp : orderedFoodList){
	      Food food = (Food)temp;
	%>
	  <option value="<%=food.getFoodName()%>,<%=food.getFoodCarbo()%>,<%=food.getFoodProtein()%>,<%=food.getFoodFat()%>,<%=food.getFoodCal()%>,<%=food.getFoodNo()%>"><%=food.getFoodName() %></option>
	  
	<%} %>
	</select><input type="button" id="completeBtn" value="추가" onclick="addDiet()"/>
	<input type="number" id="foodQuantity" name="foodQuantity" value="1"/>
	
<%-- 	<input type="hidden" id="mealtime" name="mealtime" value="<script>num</script>"/> --%>
</body>
</html>