<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,command.*" %>
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
<select id="cca" name="cnum" >
<% for(Object o : list) { 
	Cca ccar = (Cca)o;
%>
	<option value="<%= ccar.getCnum()%>">
	<%= ccar.getCname() %></option>
<% } %>
</select>
</body>
</html>