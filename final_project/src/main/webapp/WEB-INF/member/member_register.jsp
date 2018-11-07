<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html>
  <head>
    <title>회원가입</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
  </head>
  <body>
    <div class="container mt-3">
      <form method="post" action="">
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