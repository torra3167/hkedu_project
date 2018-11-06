<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- function : 자동 로그인, 이메일/비밀번호 공란 체크 -->
<style type="text/css">
	.container{
		width:70%;
		max-width:560px;
		float:middle;
	}
	#inputPhone{
		width:60%;
		float:right;
	}
	#inputName{
		width:60%;
		float:right;
	}
	.btn{
		float:right;
	}
	button[class]{
		font-size:13px;
		width:60%;
		margin:5px;
	}
	a {
		font-size:13px;
		color:black;
		text-decoration:none;
	}
	a:hover{
		color:black;
		text-decoration:none;
	}
	</style>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="">비밀번호 찾기</a>
    </nav>
<div class="container">
	      <form class="form-signin">
	        <label>아이디</label>
	        <input type="text" id="inputPhone" class="form-control" placeholder="연락처" required="" autofocus=""><br>
	        <label>연락처</label>
	        <input type="text" id="inputName" class="form-control" placeholder="이름" required=""><hr>
	        <div class="btn">
	        <button class="btn btn-lg btn-primary btn-block" type="submit">찾기</button>
	        <button class="btn btn-lg btn-primary btn-block" type="button">뒤로가기</button>
	        </div>
	      </form>
    </div>
</body>
</html>