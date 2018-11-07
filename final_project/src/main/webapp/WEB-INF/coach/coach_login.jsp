<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<h2 class="text-center">코치 로그인</h2>
	<div class="container">
		<div class="signInBox">
			<form class="form-signin" method="post">
				<label for="inputEmail" class="sr-only">이메일</label> <input
					type="text" id="inputEmail" class="form-control" placeholder="이메일"
					> 
				<label for="inputPassword"
					class="sr-only">비밀번호</label> <input type="password"
					id="inputPassword" class="form-control" placeholder="비밀번호"
					>
				<div class="checkbox">
					<label> <input type="checkbox" value="remember-me">
						자동 로그인
					</label>
				</div>
				<div class="btn">
					<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
					<a href="">아이디/비밀번호 찾기</a>
				</div>
			</form>
		</div>
	</div>

	<script src="../js/jquery.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>