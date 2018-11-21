<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String email=(String)request.getAttribute("email"); 
	System.out.println(email);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(email==null){ %>
	<div class="container mt-3">
		설문 작성이 완료되었습니다.<br>
		<button type="button" class="btn btn-primary" onclick="location.href='index'">메인으로</button>
	</div>
	<%} else{ %> 
		<script type="text/javascript" >
			location.href="member_write_survey2.gom";
		</script>
	<% } %>
</body>
</html>