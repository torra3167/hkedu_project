<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.*, category.*" %>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>food_selected_for_proFood
<body>
<input id="selectedFoodInput" name="selectedFoodInput" class="form-control" onclick="javascript:valueAdd(this);" >
<% for(Object o : list) { 
	FoodCatA ccar = (FoodCatA)o;
%>

</select>
</body>
</html>