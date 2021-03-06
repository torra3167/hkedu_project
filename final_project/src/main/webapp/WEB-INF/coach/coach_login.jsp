<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/1027.css">


<body>

	<h2 class="text-center">로그인</h2>
	<div class="container">
		<div class="signInBox">
		
	<form:form commandName="loginCommand">
				<label for="inputEmail" class="sr-only">이메일</label> 
				<form:input path="email" class="form-control" placeholder="이메일"/>
				
				<label for="inputPassword"
					class="sr-only">비밀번호</label> 
					<form:password path="pw" placeholder="비밀번호" class="form-control"/>
					
				<div class="checkbox">
					<label> 
						<form:checkbox path="rememberEmail"/>
						자동 로그인
					</label>
				</div>
				<div class="btn">
					<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
					<a href="">아이디/비밀번호 찾기</a>
				</div>
			</form:form>
			
		</div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	
</body>
</html>