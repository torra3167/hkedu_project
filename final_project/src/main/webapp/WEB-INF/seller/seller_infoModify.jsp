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
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
	<form method="post" action="#">
		<div class="form-group">
			<label>이메일</label> <input type="text" name="sellerEmail" class="form-control" placeholder="abc@naver.com" disabled>
		</div>
		<div class="form-group">
			<label>비밀번호</label> <input type="password" name="sellerPw" class="form-control">
		</div>
		<div class="form-group">
			<label>비밀번호 확인</label> <input type="password" name="sellerPw2" class="form-control"><!-- 속성추가 필요 -->
		</div>
		<div class="form-group">
			<label>휴대폰번호</label> <input type="text" name="sellerPhone" class="form-control">
			<input type="button" class="btn btn-primary" name="sellerPhoneDuplicate" value="중복 확인" onclick="">
		</div>
		<button type="submit" class="btn btn-primary">확인</button>
		<button type="reset" class="btn btn-primary">다시 작성</button>
	</form>
</div>
</body>
</html>