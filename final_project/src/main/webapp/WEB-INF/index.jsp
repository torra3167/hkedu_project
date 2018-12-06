<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.Program"%>
    
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
<style type="text/css">
	.includebody {
		min-height: 700px;
		
	}
</style>
</head>
<body>
<div>
	<jsp:include page="nav.jsp"></jsp:include>
</div>

<div class="includebody">	
	<jsp:include page="<%=iPage %>"></jsp:include>
</div>

<div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>


</body>
</html>