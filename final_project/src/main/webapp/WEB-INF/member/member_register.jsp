<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html>
  <head>
    <title>회원가입</title>
<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/1027.css">

  </head>
  <body>
    <div class="container mt-3">
      <form method="post" action="member_register">
        <div class="form-group">
          <label>이메일</label>
          <input type="email" class="form-control">
          <button type="button" class="btn btn-primary">중복 체크</button>
        </div>
        <div class="form-group">
          <label>비밀번호</label>
          <input type="password" class="form-control">
        </div>
        <div class="form-group">
          <label>이름</label>
          <input type="text" class="form-control">
        </div>
        <div class="form-group">
          <label>연락처</label>
          <input type="text" class="form-control">
        </div>
        <div class="form-group">
          <label>우편번호</label>
          <input type="text" class="form-control">
          <button type="button" id="findPostNo" class="btn btn-primary">우편번호 찾기</button>
        </div>
        <div class="form-group">
          <label>기본주소</label>
          <input type="text" class="form-control">
        </div>
        <div class="form-group">
          <label>상세주소</label>
          <input type="text" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">회원가입</button>
        <button type="reset" class="btn btn-primary">다시 작성</button>
        <button type="button" class="btn btn-primary">뒤로가기</button>
      </form>
    </div>
    <script src="./js/jquery.min.js"></script>
    <script src="./js/popper.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
  </body>
</html>