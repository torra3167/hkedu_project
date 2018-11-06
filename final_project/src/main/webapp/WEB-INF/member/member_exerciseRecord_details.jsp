<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>

<html>
<head>
<title>운동 상세보기</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<style type="text/css">
.container {
	width: 70%;
	align:center;
}
.content{
	border: 1px solid black;
	text-align:center;
}
.items{
	padding:3px 3px;
}
#header{
	border-bottom:1px solid black;
}
button{
	float:right;
}
</style>
<body>
	<div class="container mt-3">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="">운동 기록</a>
		</nav>
		<div class="content">
			<table class="items">
				<tr id="header">
					<th>운동명</th>
					<th>무게</th>
					<th>횟수</th>
				</tr>
				<tr>
					<th>1</th>
					<th>2</th>
					<th>3</th></tr>
				<tr>
					<th>1</th>
					<th>2</th>
					<th>3</th></tr>
			</table>
		</div>
		<button type="button" class="btn btn-primary">목록으로</button>
	</div>
	<script src="./js/jquery.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>