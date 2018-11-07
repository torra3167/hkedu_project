<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- function : 자동 로그인, 이메일/비밀번호 공란 체크 -->

<body>
<div class="container">
		<div class="signInBox">
	      <form class="form-signin">
	        <label for="inputEmail" class="sr-only">이메일</label>
	        <input type="email" id="inputEmail" class="form-control" placeholder="이메일" required="" autofocus="">
	        <label for="inputPassword" class="sr-only">비밀번호</label>
	        <input type="password" id="inputPassword" class="form-control" placeholder="비밀번호" required="">
	        <div class="checkbox">
	          <label>
	            <input type="checkbox" value="remember-me"> 자동 로그인
	          </label>
	        </div>
	        <div class="btn">
	        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
	        <button class="btn btn-lg btn-primary btn-block" type="button">회원가입</button>
	        <a href="" >아이디/비밀번호 찾기</a>
	        </div>
	      </form>
		</div>
    </div>
       <script src="../js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>