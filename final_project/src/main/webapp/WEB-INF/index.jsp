<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	String iPage = (String)request.getAttribute("iPage");
	if (request.getAttribute("iPage") == null) {
		iPage = "main.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<jsp:include page="nav.jsp"></jsp:include>
</div>
<div>
	<jsp:include page="<%= iPage %>"></jsp:include>
</div>
<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>


</body>
</html>