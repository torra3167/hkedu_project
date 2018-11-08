<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-4">
		    <div class="panel panel-default center-block">
			  <div class="panel-heading"><h3 class="panel-title"><strong>판매자 로그인</strong></h3></div>
			  <br>
			  <div class="panel-body">
				<form:form commandName="sellerLoginCommand" method="post">
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email</label>
				    <form:input path="sellerEmail" class="form-control" placeholder="Enter email" />
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Password <a href="/sessions/forgot_password">(forgot password)</a></label>
				   <form:password path="sellerPw" class="form-control" placeholder="Password" />
				  </div>
				  <div class="row justify-content-center">
				  <button type="submit" class="btn btn-sm btn-success">로그인</button>&nbsp;&nbsp;&nbsp;&nbsp;
				  <button type="button" class="btn btn-sm btn-info" onclick="location.href='./seller_join.gom'">회원가입</button>
				  </div>
				</form:form>
			  </div>
			</div>
		</div>
	</div>
</div>
</body>
</html>