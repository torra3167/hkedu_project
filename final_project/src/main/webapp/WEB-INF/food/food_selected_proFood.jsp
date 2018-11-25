<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.Food, category.*" %>
<%
	List<Food> selectedFoodList = (List<Food>)session.getAttribute("selectedFoodList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>food_selected_for_proFood</title>
</head>
<body>

<label>프로그램 식품 선택</label>
<select id="selectedFoodInput" name="selectedFoodInput" class="form-control" onchange="javascript:valueAdd(this);" >
<% for(Object o : selectedFoodList) { 
	Food food = (Food)o;
%>
	<option value="<%=food.getFoodNo() %>"> <%= food.getFoodName() %></option>
	
<% } %>
</select>
</body>
</html>