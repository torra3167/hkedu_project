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
			src="../images/logo.png" width="40" height="40"></a>

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
					href="admin/admin_menu .jsp">관리자메뉴</a></li>
				<li class="nav-item"><a class="nav-link" href="seller/sellerMenu.jsp">판매자메뉴</a></li>

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
<!--grid-->

		<div class="container">
			<div class="row">
				
		
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="../images/1.jpg" alt="Third slide">
				<div id="info">
					제목5 <br> <a href="#"><img src="../images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="../images/2.jpg" alt="Third slide">
				<div id="info">
					제목6 <br> <a href="#"><img src="../images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="../images/3.jpg" alt="Third slide">
				<div id="info">
					제목7 <br> <a href="#"><img src="../images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="../images/4.jpg" alt="Third slide">
				<div id="info">
					제목8 <br> <a href="#"><img src="../images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>
		
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<img class="d-block w-100" src="../images/4.jpg" alt="Third slide">
				<div id="info">
					제목9
					 <br> <a href="#"><img src="../images/d-day/dot.png"
						width="20" height="20"> 이름</a>
				</div>
			</div>
		</div>

</div>
</div>



</body>

<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">

	Copyright ⓒ 2018 환곰탈태 All Rights Reserved. </footer>


</html>


