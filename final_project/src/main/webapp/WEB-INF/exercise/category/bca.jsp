<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "command.*, java.util.*"%>
    
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

<select id="bca" name="bnum" onclick="javascript:cca();"> 
	<% for(Object temp : list) {
	 	Bca bca = (Bca)temp; %>
	 	<option value="<%=bca.getBnum()%>"> <%=bca.getBname() %></option>
	<% } %>
	
	</select>
</body>
</html>