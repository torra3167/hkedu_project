<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-md-4">
		    <div class="panel panel-default center-block">
			  <div class="panel-heading"><h3 class="panel-title"><strong>판매자 로그인</strong></h3></div>
			  <div class="panel-body">
			  	<form role="form">
				  <div class="form-group">
				    <label for="exampleInputEmail1">Email</label>
				    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
				  </div>
				  <div class="form-group">
				    <label for="exampleInputPassword1">Password <a href="/sessions/forgot_password">(forgot password)</a></label>
				    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
				  </div>
				  <div class="row justify-content-center">
				  <button type="submit" class="btn btn-sm btn-success">로그인</button>&nbsp;&nbsp;&nbsp;&nbsp;
				  <button type="button" class="btn btn-sm btn-info">회원가입</button>
				  </div>
				</form>
			  </div>
			</div>
		</div>
	</div>
</div>
</body>
</html>