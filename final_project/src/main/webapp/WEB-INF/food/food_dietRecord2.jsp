<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*, java.util.*"%>
<%
//결제식단 select list
   List<Food> orderedFoodList = (List<Food>)request.getAttribute("orderedFoodList");   //결제한 식품들정보
   List<FoodNutrient> frs = (List<FoodNutrient>)request.getAttribute("foodNutrients");   //결제한 식품들정보
   System.out.println("frs size :********** "+frs.size());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<div id="orderedBar">
	<h6>주문한 식품 중 선택</h6>
<div class="row">
	<select class="form-control col-2" id="selectOrderedFood" name="selectOrderedFood" style="width:100px">
	<%
	   for(Object temp : orderedFoodList){
	      Food food = (Food)temp;
	%>
	  <option value="<%=food.getFoodName()%>,<%=food.getFoodCarbo()%>,<%=food.getFoodProtein()%>,<%=food.getFoodFat()%>,<%=food.getFoodCal()%>,<%=food.getFoodNo()%>"><%=food.getFoodName() %></option>
	  
	<%} %>
	</select>
	<input type="number" class="form-control col-1" id="foodQuantity" name="foodQuantity" value="1"/>
	<input type="button" class="btn btn-primary col-1" id="completeBtn" value="추가" onclick="addDiet(1)" />
	<input type="button" class="btn btn-danger col-1" id="completeBtn" value="취소" onclick="cancelAddDiet()"/>
</div>
<br>
<br>
</div>
<div id="nutCatBar">
	<h6>일반 식품 중 선택</h6>
<div class="row">
	<select class="form-control col-2" id="selectNutrientFood" name="selectNutrientFood" style="width:100px" onclick="javascript:funcBcat();">
	<%
	   for(Object temp3 : frs){
		   FoodNutrient frnt = (FoodNutrient)temp3;
		   System.out.println("dr2 frnt getFoodNutrientName : "+frnt.getFoodNutrientCatName());
	%>
	  <option value="<%=frnt.getFoodNutrientCatName()%>"><%=frnt.getFoodNutrientCatName()%></option>
	  
	<%} %>
	</select>
</div>
</div>
</body>
</html>