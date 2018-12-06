<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
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
				    <label for="exampleInputPassword1">Password</label>
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