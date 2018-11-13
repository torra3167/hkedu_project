<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- function : 자동 로그인, 이메일/비밀번호 공란 체크 -->

<body>

	<div class="container">
		<div class="message">회원님의 회원정보에 있는 이메일로 비밀번호를 전송했습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary" onclick="index">메인으로</button>
			<button type="button" class="btn btn-primary" onclick="login.gom">로그인</button>
		</div>
	</div>


	<div class="container">
		<div class="message">일치하는 회원정보가 없습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
			<button type="button" class="btn btn-primary" onclick="member_join.gom">회원가입</button>
		</div>
	</div>
</body>