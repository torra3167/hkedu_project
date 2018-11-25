<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.*, category.*" %>
<%
	List list = (List)request.getAttribute("foodCat");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<select id="FCA" name="foodCatANo" class="form-control" onchange="javascript:selectedFood(this);" >
<% for(Object o : list) { 
	FoodCatA ccar = (FoodCatA)o;
%>
	<option value="<%=ccar.getFoodCatANo() %>"> <%= ccar.getFoodCatAName() %></option>
<% } %>
</select>
</body>
</html>