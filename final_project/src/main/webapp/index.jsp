<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<meta charset="utf-8">

<head>
<title>1027</title>

<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/1027.css">


</head>


<body>
	<!-- As a link navbar -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<a class="navbar-brand" href="#"><img alt="logo"
			src="images/logo.png" width="40" height="40"></a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#mainNavBar">
			<span class="navbar-toggler-icon"></span>

		</button>
		<div class="collapse navbar-collapse" id="mainNavBar">

			<ul class="nav navbar-nav">

				<li class="nav-item"><a class="nav-link" href="#">식품관</a></li>

				<li class="nav-item"><a class="nav-link" href="#">운동관</a></li>
				<li class="nav-item"><a class="nav-link" href="#">내게 맞는
						상품진단</a></li>
				<li class="nav-item"><a class="nav-link"
					href="Goods/goodsCartList.jsp">Cart</a></li>
				<li class="nav-item">
					<div class="dropdown">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="main/noticeBoard.jsp">공지사항</a> <a
								class="dropdown-item" href="main/contact.jsp" target="_blank">1:1문의</a>
						</div>
					</div>
				</li>

				<li class="nav-item"><a class="nav-link"
					href="admin/admin_menu.jsp">관리자메뉴</a></li>
				<li class="nav-item"><a class="nav-link" href="seller/seller_menu.jsp">판매자메뉴</a></li>

				<li class="nav-item">
					<div class="dropdown">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown"> 코치메뉴 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="main/noticeBoard.jsp">회원관리</a> <a
								class="dropdown-item" href="exercise/exercise_list.jsp">운동관리</a>
						</div>
					</div>
				</li>
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="#" target="_blank">회원가입</a> <a
					class="nav-item nav-link" href="#" target="_blank">로그인</a> &nbsp;




	<!-- 검색  -->
				<form class="form-inline my-2 my-lg-0 text-left" action="index.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="내용을 입력하세요" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				
				
			</div>


		</div>
	</nav>

	<!--carousel-->
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item item1 active">

				<div class="helper"></div>
				<div class="intro" id="navi">
					<h5>광고제목1</h5>
					<p>광고한줄내용1</p>
					<a href="#">링크이동1</a>
				</div>
			</div>
			<div class="carousel-item item2">
				<div class="helper"></div>
				<div class="intro" id="navi">
					<h5>광고제목2</h5>
					<p>광고한줄내용2</p>
					<a href="#">링크이동2</a>
				</div>
			</div>

			<div class="carousel-item item3">
				<div class="helper"></div>
				<div class="intro" id="navi">
					<h5>광고제목3</h5>
					<p>광고한줄내용3</p>
					<a href="#">링크이동3</a>
				</div>
			</div>
		</div>

		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>





	<!-- alert -->
	<div class="container">
		<div class="row">
			<div class="col-12">

				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					<a href="#"><strong>식품관!</strong></a> 건강한 식생활을 시작해보세요!
					<button type="button" class="close" data-dismiss="success"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</div>
		</div>
	</div>


<!--grid-->
<div class="container">
	<div class="row">
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="images/bibimbap.jpg"
					alt="Third slide">
				<div id="info">
					제목1 <br> <a href="#"><img src="images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>

			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="images/burger.jpg" alt="Third slide">
				<div id="info">
					제목2 <br> <a href="#"><img src="images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="images/chicken.jpg"
					alt="Third slide">
				<div id="info">
					제목3 <br> <a href="#"><img src="images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="images/sushi.jpg" alt="Third slide">
				<div id="info">
					제목4 <br> <a href="#"><img src="images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<!-- alert -->
		<div class="container">
			<div class="row">
				<div class="col-12">

					<div class="alert alert-info alert-dismissible fade show"
						role="alert">
						<a href="#"><strong>운동관!</strong></a> 전문코치와 함께 목표를 달성해보세요!
						<button type="button" class="close" data-dismiss="info"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- container -->
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="images/1.jpg" alt="Third slide">
				<div id="info">
					제목5 <br> <a href="#"><img src="images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="images/2.jpg" alt="Third slide">
				<div id="info">
					제목6 <br> <a href="#"><img src="images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="images/3.jpg" alt="Third slide">
				<div id="info">
					제목7 <br> <a href="#"><img src="images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="images/4.jpg" alt="Third slide">
				<div id="info">
					제목8 <br> <a href="#"><img src="images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>


</body>

<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">

	Copyright ⓒ 2018 환곰탈태 All Rights Reserved. </footer>


</html>


