<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="css/1027.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<body>
<!-- As a link navbar -->

<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<a class="navbar-brand" href="index"><img alt="logo"
			src="images\logo.png"
			 width="40" height="40"></a>s

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#mainNavBar">
			<span class="navbar-toggler-icon"></span>

		</button>
		<div class="collapse navbar-collapse" id="mainNavBar">

			<ul class="nav navbar-nav">

				<li class="nav-item"><a class="nav-link" href="#">식품관</a></li>

				<li class="nav-item"><a class="nav-link" href="#">운동관</a></li>
				<li class="nav-item"><a class="nav-link" href="member_write_survey1.gom">내게 맞는
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
					href="admin/admin_menu.jsp">관리자로그인</a></li>
				<li class="nav-item"><a class="nav-link" href="seller_login.gom">판매자로그인</a></li>

				<!-- <li class="nav-item">
					<div class="dropdown">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown"> 코치메뉴 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="main/noticeBoard.jsp">회원관리</a> <a
								class="dropdown-item" href="exercise/exercise_list.jsp">운동관리</a>
						</div>
					</div>
				</li> -->
				<li class="nav-item"><a class="nav-link" href="coach_login.gom">코치로그인</a></li>
				
				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="member_join.gom" >회원가입</a> 
				<a
					class="nav-item nav-link" href="member_login.gom" >로그인</a> &nbsp;




	<!-- 검색  -->
				<form class="form-inline my-2 my-lg-0 text-left" action="index.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="내용을 입력하세요" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				
				
			</div>


		</div>
	</nav>
	
	
	
	
<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>