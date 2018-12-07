<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- <link rel="stylesheet" href="../css/bootstrap.min.css"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" -->
<!-- 	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" -->
<!-- 	crossorigin="anonymous"> -->

</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
	<div><h3><strong>판매자 정보수정</strong></h3></div>
	<br>
	<form:form method="post" action="seller_update.gom" commandName="sellerUpdateCommand">
		<div class="form-group">
			<label>이메일</label> <form:input path="sellerEmail" class="form-control" value="${ai.email}" readonly="true" />
		</div>
		<div class="form-group">
			<label>비밀번호</label> <form:password path="sellerPw" class="form-control" />
		</div>
		<div class="form-group">
			<label>비밀번호 확인</label> <input type="password" name="sellerConfirmPw" class="form-control"><!-- 속성추가 필요 -->
		</div>
		<div class="form-group">
			<label>휴대폰번호</label> <form:input path="sellerPhone" class="form-control" />
 		</div>
		<button type="submit" class="btn btn-primary">확인</button>
		<button type="reset" class="btn btn-primary">다시 작성</button>
		<button type="button" class="btn btn-primary" onclick="location.href='seller_withdrawal.gom'">회원탈퇴</button>
	</form:form>
</div>

</body>
</html>