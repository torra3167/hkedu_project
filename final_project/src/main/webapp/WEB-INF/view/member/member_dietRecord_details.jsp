<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>

<html>
<head>
<title>식단 상세보기</title>
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
.value{
	height:10%;
}
</style>
<body>
	<div class="container mt-3">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="">식단 기록</a>
		</nav>
		<div class="content">
		<div class="total">
			<label>총 칼로리</label>
			<div class="value"></div>
		</div>
			<table class="items">
				<tr id="header">
					<th>음식명</th>
					<th>시간</th>
					<th>칼로리</th>
					<th>탄수화물</th>
					<th>단백질</th>
					<th>지방</th>
				</tr>
				<tr>
					<th>1</th>
					<th>2</th>
					<th>3</th>
					<th>4</th>
					<th>5</th>
					<th>6</th></tr>
				<tr>
					<th>1</th>
					<th>2</th>
					<th>3</th>
					<th>4</th>
					<th>5</th>
					<th>6</th></tr>
			</table>
		</div>
		<button type="button" class="btn btn-primary">목록으로</button>
	</div>
	<script src="./js/jquery.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
</body>
</html>