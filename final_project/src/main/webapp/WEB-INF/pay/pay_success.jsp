<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	String memberEmail = (String)session.getAttribute("email");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function goMain() {
	location.href="index";
}
</script>
</head>
<body>

<div class="container">
	<div class="row text-center">
        <div class="col-12">
        <br><br> <h2 style="color:#0fad00">Success</h2>
        <h3><%=memberEmail %> 님</h3>
        <p style="font-size:20px;color:#5C5C5C;">결제가 완료되었습니다.</p>
        <button class="btn btn-success" onclick="javascript:goMain();">     메인으로      </button>
    <br><br>
        </div>
        
	</div>
</div>

<br/>
</body>
</html>