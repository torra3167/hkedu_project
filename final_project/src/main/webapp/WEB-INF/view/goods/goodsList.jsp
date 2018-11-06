<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>상품 리스트</title>
</head>
<style type="text/css">
* {
	box-sizing: border-box;
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
	text-align: center;
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 70%;
}

.wrap {
	
}
</style>
<body>
	<div class="wrap">
		<h1 align="center">상품 목록 &nbsp;&nbsp;&nbsp;&nbsp;</h1>


		<div class="container">
			<div class="col">
				<a href="goodsView.sh?goods_num="><img src="./goodsUpload/"
					width="225" height="225" border="0"></a><br>

				<div class="content">
					<p>
						상품명 : <br> 가격 : 원 <br> 내용 : %> <br>
					</p>
				</div>
			</div>
		</div>
	</div>


</body>
</html>