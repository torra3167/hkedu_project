<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>구매내역</title>
</head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/custom.css">
<style type="text/css">
.wrap{
	width:70%;
	text-align:center;
	display:block;
	margin-left:auto;
	margin-right:auto;
}
div p {
	margin-top: 20px;
	text-align: center;
	margin-bottom: 80px;
}

.col {
	float: left;
	margin-right: 40px;
	text-decoration: none;
	color: black;
}

.container {
	text-align: left;
	display: block;
	margin-left: auto;
	margin-right: auto;
	font-size: 13px;
}

.item {
	border: 0;
}
button[class]{
	float:right;
}
</style>
<body>
	<div class="wrap text-center">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="">내 구매내역</a>
		</nav>
		<div class="container">
			<div class="col">
				<a href=""><img class="item" src=""></a><br>

				<div class="content">
					<p>
						상품명 : <br> 가격 : 원 <br> 주문일 : <br>
					</p>
				</div>
			</div>
			<button type="button" class="btn btn-secondary">뒤로가기</button>
			<button type="button" class="btn btn-primary">쇼핑하기</button>
		</div>
	</div>

	<script src="./js/jquery.min.js"></script>
    <script src="./js/popper.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
</body>
</html>