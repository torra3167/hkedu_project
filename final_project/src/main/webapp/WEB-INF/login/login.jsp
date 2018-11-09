<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>	
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-4">
		    <div class="panel panel-default center-block">
			  <div class="panel-heading"><h3 class="panel-title text-center"><strong>로그인</strong></h3></div>
			  <br>
			  <div class="panel-body">
				<form:form commandName="loginCommand">
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email</label>
				    <form:input path="email" class="form-control" placeholder="Enter email" />
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Password <a href="/sessions/forgot_password">(forgot password)</a></label>
				   <form:password path="pw" class="form-control" placeholder="Password" />
				  </div>
				  
				   <label>
	            <form:checkbox path="rememberEmail"/>자동 로그인
	            <a href="findID.gom" >아이디/비밀번호 찾기</a>
	        	  </label>
				  <div class="row justify-content-center">
	
				  <button type="submit" class="btn btn-sm btn-success">로그인</button>&nbsp;&nbsp;&nbsp;&nbsp;
				  <button type="button" class="btn btn-sm btn-info" onclick="location.href='member_join.gom'">회원가입</button>
			
				  </div>
				</form:form>
			  </div>
			</div>
		</div>
	</div>
</div>
</body>
</html>