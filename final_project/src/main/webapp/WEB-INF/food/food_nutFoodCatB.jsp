<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*, java.util.*"%>
<%
   List<FoodNutrient> selectedfoodNutList = (List<FoodNutrient>)request.getAttribute("selectedfoodNutList");   //결제한 식품들정보
   System.out.println("catB selectedfoodNutList.size() : "+selectedfoodNutList.size());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="nutBar">
<div class="row">
<select class="form-control col-4" id="catBNutFood" name="catBNutFood" style="width:100px">
	<%
	   for(Object temp2 : selectedfoodNutList){
		   FoodNutrient fn = (FoodNutrient)temp2;
	%>
	  <option value="<%=fn.getFoodNutrientName()%>,<%=fn.getFoodNutrientCarb()%>,<%=fn.getFoodNutrientProt()%>,<%=fn.getFoodNutrientFat()%>,<%=fn.getFoodNutrientKcal()%>"><%=fn.getFoodNutrientName()%></option>
	<%} %>
	</select>
	<input type="number" class="form-control col-1" id="nutQuantity" name="nutQuantity" value="1"/>
	<input type="button" class="btn btn-primary col-1" id="completeBtn" value="추가" onclick="addDiet(2)" />
	<input type="button" class="btn btn-danger col-1" id="completeBtn" value="취소" onclick="cancelNutAddDiet()"/>
</div>
</div>
</body>
</html>