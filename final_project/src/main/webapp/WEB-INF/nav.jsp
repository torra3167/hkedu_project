<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.text.SimpleDateFormat, java.util.Calendar"%>
    
    <%
    	String divide = (String)session.getAttribute("divide");
    %>
<%
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
    String recordDate = simpleDateFormat.format(Calendar.getInstance().getTime());
    System.out.println("nav recordDate : "+recordDate);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>


</head>
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

				<li class="nav-item"><a class="nav-link" href="program_list.gom">운동관</a></li>
				<li class="nav-item"><a class="nav-link" href="member_write_survey1.gom">내게 맞는
						상품진단</a></li>
				<li class="nav-item"><a class="nav-link" href="pro_review_all_list.gom">프로그램모든리뷰</a></li>		
				<li class="nav-item"><a class="nav-link"
					onclick="window.open('chatting.gom', '',
						'width=400, height=580'); return false;">채팅</a></li>	
					
				<li class="nav-item">
					<div class="dropdown">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="personalQna.gom" >1:1문의</a>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="seller_join.gom" >판매자가입</a> 
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

				<li class="nav-item"><a class="nav-link" href="food_list.gom">식품관</a></li>

				<li class="nav-item"><a class="nav-link" href="program_list.gom">운동관</a></li>
				<li class="nav-item"><a class="nav-link" href="member_write_survey1.gom">내게 맞는
						상품진단</a></li>
				<li class="nav-item"><a class="nav-link" href="food_recordMain.gom?dateText=<%=recordDate %>">식단 기록</a></li>
				<li class="nav-item"><a class="nav-link"
					href="exercise_record.gom">운동 기록</a></li>
				<li class="nav-item"><a class="nav-link"
					href="program_list.gom">프로그램리스트</a></li>

				<li class="nav-item"><a class="nav-link"
					href="cart_list.gom">Cart</a></li>
				
				<li class="nav-item"><a class="nav-link"
					href="pro_cart_list.gom">운동식품Cart</a></li>	
				
				<li class="nav-item"><a class="nav-link"
					href="program_cart_list.gom">프로그램Cart</a></li>	
				<li class="nav-item"><a class="nav-link"
					onclick="window.open('chatting.gom', '',
						'width=400, height=580'); return false;">채팅</a></li>	
				<li class="nav-item">
				
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="personalQna.gom" >1:1문의</a>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="logout.gom" >로그아웃</a>
				<a class="nav-item nav-link" href="member_withdrawal.gom" >탈퇴하기</a>
			 



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

				<li class="nav-item"><a class="nav-link" href="food_list.gom">식품관</a></li>
				<li class="nav-item"><a class="nav-link" href="exercise_list.gom">운동리스트</a></li>
				<li class="nav-item"><a class="nav-link" href="program_list.gom">프로그램리스트</a></li>
				<li class="nav-item"><a class="nav-link" href="pro_review_all_list.gom">프로그램모든리뷰</a></li>
				<li class="nav-item"><a class="nav-link"
					href="cart_list.gom">일반Cart</a></li>
					
				<li class="nav-item"><a class="nav-link"
					href="pro_cart_list.gom">운동식품Cart</a></li>
				
				<li class="nav-item"><a class="nav-link"
					href="program_cart_list.gom">프로그램Cart</a></li>
					
				<li class="nav-item">
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="personalQna.gom" >1:1문의</a>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="pro_food_list.gom" >프로그램식품보기</a> 
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

<% } else if(divide.equals("ns")||divide.equals("w")||divide.equals("s")) { %>
	
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

				<li class="nav-item"><a class="nav-link" href="food_list.gom">식품관</a></li>

				<li class="nav-item"><a class="nav-link" href="program_list.gom">운동관</a></li>
				<li class="nav-item"><a class="nav-link" href="member_write_survey1.gom">내게 맞는
						상품진단</a></li>
				<li class="nav-item"><a class="nav-link"
					href="cart_list.gom">일반Cart</a></li>
				
				<li class="nav-item"><a class="nav-link"
					href="pro_cart_list.gom">운동식품Cart</a></li>	
					
				<li class="nav-item"><a class="nav-link"
					href="program_cart_list.gom">프로그램Cart</a></li>
						
				<li class="nav-item">
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="personalQna.gom" >1:1문의</a>
			<%
				if(divide.equals("ns")){
			%>
							<a class="dropdown-item" href="seller_application.gom" >입점신청하기</a>
			<%	} else if(!divide.equals("ns")){ %>
							<a class="dropdown-item" href="seller_lookUpApplication.gom" >입점신청서 조회</a>
			<%	} %>
						</div>
					</div>
				</li>				
			</ul>


			<div class="navbar-nav ml-md-auto">
				<a class="nav-item nav-link" href="seller_update.gom" >마이페이지</a> 
			 &nbsp;
			 <%
				if(divide.equals("s")){
			 %>
				<a class="nav-item nav-link" href="seller_menu.gom" >판매자 전용메뉴</a> 
			 &nbsp;
			 <%	} %>
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

				<li class="nav-item"><a class="nav-link" href="food_list.gom">식품관</a></li>
				<li class="nav-item"><a class="nav-link" href="program_list.gom">운동관</a></li>
				<li class="nav-item"><a class="nav-link" href="member_write_survey1.gom">내게 맞는
						상품진단</a></li>
				<li class="nav-item"><a class="nav-link"
					href="cart_list.gom">Cart</a></li>
				
				<li class="nav-item"><a class="nav-link"
					href="pro_cart_list.gom">운동식품Cart</a></li>	
				
				<li class="nav-item"><a class="nav-link"
					href="program_cart_list.gom">프로그램Cart</a></li>		
				<li class="nav-item">
					<div class="dropdown show">
						<a class="nav-link dropdown-toggle" id="dropdown"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							고객센터 </a>
						<div class="dropdown-menu" aria-labelledby="dropdown">
							<a class="dropdown-item" href="personalQna.gom" >1:1문의</a>
							<a class="dropdown-item" href="food_reviewReportList.gom" >리뷰신고 관리</a>
							<a class="dropdown-item" href="review_report_board.gom" >프로그램리뷰 신고 관리</a>
							<a class="dropdown-item" href="seller_applicationList.gom" >입점신청서 관리</a>
							<a class="dropdown-item" href="admin_program_list.gom" >프로그램신청 관리</a>
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

<!--jquery풀버전. 슬림버전사용시 ajax사용불가  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>