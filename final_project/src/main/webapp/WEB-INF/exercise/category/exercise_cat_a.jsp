<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,category.*" %>
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
<select id="aCategory" name="exerciseCatANumber" class="form-control" >
<Script>
<%-- 	alert("<%=list.size()%>");
 --%></Script>
<% for(Object o : list) { 
	ExerciseCatA exerciseCatA = (ExerciseCatA)o;
%>
	<option value="<%= exerciseCatA.getExerciseCatANumber()%>">
	<%= exerciseCatA.getExerciseCatAName() %></option>	
<% } %>
</select>

</body>
</html>