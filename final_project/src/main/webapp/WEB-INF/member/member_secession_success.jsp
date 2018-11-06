<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴하기</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- function : 자동 로그인, 이메일/비밀번호 공란 체크 -->
<style type="text/css">
.container {
	width: 70%;
	max-width: 560px;
	float: middle;
}
.message{
	padding:40px;
	margin:10px;
	border:1px solid black;
	text-align:center;
}
.btn {
	float: right;
}

button[class] {
	font-size: 13px;
	margin: 3px;
}
</style>
<body>

	
	<div class="container">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="">탈퇴하기</a>
	</nav>
		<div class="message">탈퇴가 완료되었습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary">메인으로</button>
		</div>
	</div>


	<div class="container">
		<div class="message">일치하는 회원정보가 없습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary">다시 입력</button>
			<button type="button" class="btn btn-primary">메인으로</button>
		</div>
	</div>
</body>