<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>

<html>
<head>
<title>설문지</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>

<body>
	<div class="container mt-3">
		<form method="post" action="">
			<div class="form-group">
				<label>신장</label> <input type="text" class="form-control"
					placeholder="cm">
			</div>
			<div class="form-group">
				<label>체중</label> <input type="text" class="form-control"
					placeholder="kg">
			</div>
			<div class="form-group">
				<label>BMI</label> <input type="text" class="form-control">
			</div>
			<div class="form-group">
				<label>연령</label> <input type="text" class="form-control">
			</div>
			<div class="form-group">
				<label>식습관</label> <select class="form-control">
					<option value="" selected>--선택--</option>
					<option value="1">1</option>
					<option value="2">2</option>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">완료</button>
			<button type="reset" class="btn btn-secondary">다시 작성</button>
			<button type="button" class="btn btn-secondary">뒤로가기</button>
		</form>
	</div>
	<script src="./js/jquery.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>