<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- function : 자동 로그인, 이메일/비밀번호 공란 체크 -->

<body>


<div class="container">

		<div class="signInBox">
	      <form class="form-signin">
	        <label>연락처</label>
	        <input type="text" id="inputPhone" class="form-control" placeholder="연락처" required="" autofocus=""><br>
	        <label>이름</label>
	        <input type="text" id="inputName" class="form-control" placeholder="이름" required=""><hr>
	        <div class="btn">
	        <button class="btn btn-lg btn-primary" type="submit">찾기</button>
	        <button class="btn btn-lg btn-primary" type="button">뒤로가기</button>
	        </div>
	      </form>
		</div>
    </div>
</body>
</html>