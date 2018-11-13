<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품주문 통계</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="http://localhost:8080/final_project/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<!-- <script src="http://localhost:8080/final_project/js/jquery.min.js"></script>
<script src="http://localhost:8080/final_project/js/popper.min.js"></script>
<script src="http://localhost:8080/final_project/js/bootstrap.min.js"></script> -->
<style type="text/css">
    	 a:link { color: black; text-decoration: none;}
		 a:visited { color: black; text-decoration: none;}
		 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
<div class="container-fluid">
	<div class="col col-md-9">
		<div class="row">
			<div class="col col-md-5 col-md-offset-1">
				<h3>당일 매출</h3><br>
				<h4>판매량</h4>
				전체<span class="pull-right strong">판매량:400개 / 재고:1000개</span><br>
				 <div class="progress">
					<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="40"aria-valuemin="0" aria-valuemax="100" style="width:40%">40%</div>
				</div>
				<a href="#">닭가슴살샐러드</a><span class="pull-right strong">판매량:100개 / 재고:500개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
				<a href="#">영양밥도시락</a><span class="pull-right strong">판매량:100개 / 재고:300개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="30"aria-valuemin="0" aria-valuemax="100" style="width:30%">30%</div>
				</div>
				<a href="#">소풍도시락</a><span class="pull-right strong">판매량:100개 / 재고:200개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				기타<span class="pull-right strong">판매량:100개 / 재고:200개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				<br>
				<div class="row">
					<h4 class="col-sm-6 text-left">매출액</h4>
					<h4 class="col-sm-6 text-right">1,300,000원</h4>
				</div>
				<a href="#">닭가슴살샐러드</a><span class="pull-right strong">매출액: 600,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				<a href="#">영양밥도시락</a><span class="pull-right strong">매출액: 300,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="30"aria-valuemin="0" aria-valuemax="100" style="width:30%">30%</div>
				</div>
				<a href="#">소풍도시락</a><span class="pull-right strong">매출액: 200,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
				기타<span class="pull-right strong">매출액: 200,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
			</div>
			<div class="col col-md-5">
				<h3>당월 매출</h3><br>
				<h4>판매량</h4>
				전체<span class="pull-right strong">판매량:400개 / 재고:1000개</span><br>
				<div class="progress">
					<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="40"aria-valuemin="0" aria-valuemax="100" style="width:40%">40%</div>
				</div>
				<a href="#">닭가슴살샐러드</a><span class="pull-right strong">판매량:100개 / 재고:500개</span>
				<div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
				<a href="#">영양밥도시락</a><span class="pull-right strong">판매량:100개 / 재고:300개</span>
				<div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="30"aria-valuemin="0" aria-valuemax="100" style="width:30%">30%</div>
				</div>
				<a href="#">소풍도시락</a><span class="pull-right strong">판매량:100개 / 재고:200개</span>
				<div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				기타<span class="pull-right strong">판매량:100개 / 재고:200개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				<br>
				<div class="row">
					<h4 class="col-sm-6 text-left">매출액</h4>
					<h4 class="col-sm-6 text-right">1,300,000원</h4>
				</div>
				<a href="#">닭가슴살샐러드</a><span class="pull-right strong">매출액: 500,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				<a href="#">영양밥도시락</a><span class="pull-right strong">매출액: 300,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="30"aria-valuemin="0" aria-valuemax="100" style="width:30%">30%</div>
				</div>
				<a href="#">소풍도시락</a><span class="pull-right strong">매출액: 200,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
				기타<span class="pull-right strong">매출액: 200,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>