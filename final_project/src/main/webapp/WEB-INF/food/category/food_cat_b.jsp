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

<select id="bca" name="foodCatBNo" onclick="javascript:aca();"> 
	<% for(Object temp : list) {
		FoodCatB foodCatB = (FoodCatB)temp; %>
	 	<option value="<%=foodCatB.getFoodCatBNo()%>"> <%=foodCatB.getFoodCatBName() %></option>
	<% } %>
	
	</select>
</body>
</html>