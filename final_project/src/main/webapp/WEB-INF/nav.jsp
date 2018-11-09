<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String divide = (String)request.getAttribute("divide");
    %>
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<body>

<!--로그인 하기전  -->
<%if(divide == null || divide.equals(""))  { %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<a class="navbar-brand" href="index"><img alt="logo"
			src="images\logo.png"
			 width="40" height="40"></a>

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
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="main/noticeBoard.jsp">공지사항</a> 
							<a class="dropdown-item" href="main/contact.jsp" >1:1문의</a>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="member_join.gom" >회원가입</a> 
				<a class="nav-item nav-link" href="login.gom" >로그인</a> &nbsp;



	<!-- 검색  -->
				<form class="form-inline my-2 my-lg-0 text-left" action="index.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="내용을 입력하세요" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				
				
			</div>


		</div>
	</nav>
<% } else if(divide.equals("p")) { %>
<!--회원 로그인  -->	
<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<a class="navbar-brand" href="index"><img alt="logo"
			src="images\logo.png"
			 width="40" height="40"></a>

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
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="main/noticeBoard.jsp">공지사항</a> 
							<a class="dropdown-item" href="main/contact.jsp" >1:1문의</a>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="member_join.gom" >마이페이지</a> 
			 &nbsp;
				<a class="nav-item nav-link" href="logout.gom" >로그아웃</a>	
			 



	<!-- 검색  -->
				<form class="form-inline my-2 my-lg-0 text-left" action="index.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="내용을 입력하세요" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				
				
			</div>


		</div>
	</nav>	
<% } else if(divide.equals("c")) { %>
<!-- 코치 로그인  -->
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<a class="navbar-brand" href="index"><img alt="logo"
			src="images\logo.png"
			 width="40" height="40"></a>

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
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="main/noticeBoard.jsp">공지사항</a> 
							<a class="dropdown-item" href="main/contact.jsp" >1:1문의</a>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="member_join.gom" >코치페이지</a> 
				<a class="nav-item nav-link" href="program_register.gom" >프로그램등록</a> 
				<a class="nav-item nav-link" href="exercise_register.gom" >운동등록</a> 
				<a class="nav-item nav-link" href="logout.gom" >로그아웃</a>	



	<!-- 검색  -->
				<form class="form-inline my-2 my-lg-0 text-left" action="index.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="내용을 입력하세요" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				
				
			</div>


		</div>
	</nav>

<% } else if(divide.equals("s")) { %>
	
	<!-- 판매자 페이지  -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<a class="navbar-brand" href="index"><img alt="logo"
			src="images\logo.png"
			 width="40" height="40"></a>

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
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="main/noticeBoard.jsp">공지사항</a> 
							<a class="dropdown-item" href="main/contact.jsp" >1:1문의</a>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="member_join.gom" >판매자페이지</a> 
			 &nbsp;
				<a class="nav-item nav-link" href="logout.gom" >로그아웃</a>	


	<!-- 검색  -->
				<form class="form-inline my-2 my-lg-0 text-left" action="index.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="내용을 입력하세요" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
				
				
			</div>


		</div>
	</nav>
<% } else if(divide.equals("a")) { %>	
	<!-- 관리자 페이지  -->
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">


		<a class="navbar-brand" href="index"><img alt="logo"
			src="images\logo.png"
			 width="40" height="40"></a>

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
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="main/noticeBoard.jsp">공지사항</a> 
							<a class="dropdown-item" href="main/contact.jsp" >1:1문의</a>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="member_join.gom" >코치페이지</a> 
				 &nbsp;
				<a class="nav-item nav-link" href="member_join.gom" >판매자페이지</a> 
			 	&nbsp;
				<a class="nav-item nav-link" href="member_join.gom" >회원마이페이지</a> 
				 &nbsp;
		
				<a class="nav-item nav-link" href="logout.gom" >로그아웃</a>	
				 
		
			 
	<!-- 검색  -->
				<form class="form-inline my-2 my-lg-0 text-left" action="index.jsp">
					<input class="form-control mr-sm-2" type="search"
						placeholder="내용을 입력하세요" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
			</div>
	</nav>			
<% } %>
</body>
</html>