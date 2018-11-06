<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<meta charset="utf-8">

<head>
<title>INDEX</title>

<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/1027.css">

</head>


<body>
	

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

</html>


