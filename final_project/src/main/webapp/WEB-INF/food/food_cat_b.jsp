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

<select id="FCB" name="foodCatBNo" onclick="javascript:funcAca();" class="form-control"> 
<option value="">--선택하세요--</option>
	<% for(Object temp : list) {
		FoodCatB bcar = (FoodCatB)temp; %>
	 	<option value="<%=bcar.getFoodCatBNo() %>"> <%=bcar.getFoodCatBName() %></option>
	<% } %>
</select>
</body>
</html>