<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.*, category.*" %>
<%
	List list = (List)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<select id="aca" name="foodCatANo" >
<% for(Object o : list) { 
	FoodCatA foodCatA = (FoodCatA)o;
%>
	<option value="<%= foodCatA.getFoodCatANo() %>">
	<%= foodCatA.getFoodCatAName() %></option>
<% } %>
</select>
</body>
</html>