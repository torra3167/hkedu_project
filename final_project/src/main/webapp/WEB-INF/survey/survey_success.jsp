<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String email=(String)request.getAttribute("email"); 
	System.out.println(email);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 완료</title>
</head>
<body>
	<% if(email==null){ %>
		<script type="text/javascript">
			location.href="survey_success.gom";
		</script>
	<%} else{ %> 
		<script type="text/javascript" >
			location.href="member_write_survey2.gom";
		</script>
	<% } %>
</body>
</html>