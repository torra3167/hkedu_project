<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Program, model.FoodAndApplication"%>


<% 
	List programList = (List) request.getAttribute("Program");
	List foodAppliList = (List) request.getAttribute("foodAppliList");
%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<head>
<title>INDEX</title>

<link rel="stylesheet" href="css/main.css">

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
					<h5>흔들리면 모두 지방이에요</h5>
					<p>새로운 인생을 시작하세요</p>
					<a href="program_list.gom">운동관</a>
				</div>
			</div>
			<div class="carousel-item item2">
				<div class="helper"></div>
				<div class="intro" id="navi">
					<h5>칼로리와 맛 그 무엇도 놓칠 수 없어</h5>
					<p>균형있고 맛있는 식단을 위한 선택</p>
					<a href="#">식품관</a>
				</div>
			</div>

			<div class="carousel-item item3">
				<div class="helper"></div>
				<div class="intro" id="navi">
					<h5>살은 빼고 싶지만 맛있게 먹고싶어..</h5>
					<p>쉐프의 레시피 레시피 판다</p>
					<a href="food_list.gom">식품관</a>
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
					<a href="food_list.gom"><strong>#식품관!</strong></a> 건강한 식생활을 시작해보세요!
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
		<% if(foodAppliList == null) {
			for(int i = 0; i < 4; i++) {
		%>
		
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_register.gom">
				<img class="d-block w-100" src="images/404.png" alt="Third slide">
				</a>
				<div id="info">
					식품을 등록해주세요 <br> <img src="images/d-day/dot.png"
						width="20" height="20">식품을 등록해주세요
				</div>
			</div>
			
		</div>		
			
		 <% } %>
			</div>
			</div>
	<% } else { %>

	<%
		
		
		int foodIndex = 1;
		
		
		for(int i = 0; i < foodAppliList.size(); i++) {
			
			FoodAndApplication foodAppli = (FoodAndApplication)foodAppliList.get(i);

		%>
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_detail.gom?proNo=<%=foodAppli.getFoodNo()%>">
				<img class="d-block w-100" src="resource\\<%=foodAppli.getFoodStored() %>" alt="Third slide" >
				</a>
				<div id="info">
					<%=foodAppli.getFoodName() %> <br> <img src="images/d-day/dot.png"
						width="20" height="20"><%=foodAppli.getFoodPrice() %>
				</div>
			</div>
		</div>
		<%
		}
		foodIndex = 4 - (programList.size() % 4);
	
		if(foodIndex > 0) { 
			for(int i = 0; i < foodIndex; i++) {

		%>
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_register.gom">
				<img class="d-block w-100" src="images/404.png" alt="Third slide">
				</a>
				<div id="info">
					식품을 등록해주세요 <br> <img src="images/d-day/dot.png"
						width="20" height="20">식품을 등록해주세요
				</div>
			</div>
			
		</div>
			
		<% }
			
		} 
		} %>

		<!-- alert -->
		<div class="container">
			<div class="row">
				<div class="col-12">

					<div class="alert alert-info alert-dismissible fade show"
						role="alert">
						<a href="program_list.gom"><strong>#운동관!</strong></a> 전문코치와 함께 목표를 달성해보세요!
						<button type="button" class="close" data-dismiss="info"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
				</div>
			</div>
		</div>
		
		<!-- container -->
		<%
		if(programList == null) { %>
			<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_register.gom">
				<img class="d-block w-100" src="images/404.png" alt="Third slide">
				</a>
				<div id="info">
					프로그램을 등록해주세요 <br> <img src="images/d-day/dot.png"
						width="20" height="20">프로그램을 등록해주세요
				</div>
			</div>
			
		</div>
	 <% } else {
		int index = 1;
		for(int i = 0; i < programList.size(); i++) {
			
			Program program = (Program)programList.get(i);
			
			
		
		%>
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_detail.gom?proNo=<%=program.getProNo()%>">
				<img class="d-block w-100" src="resource\\<%=program.getProStored() %>" alt="Third slide" >
				</a>
				<div id="info">
					<%=program.getProName() %> <br> <img src="images/d-day/dot.png"
						width="20" height="20"><%=program.getProContent() %>
				</div>
			</div>
		</div>
		<%
		}
		index = 4 - (programList.size() % 4);
	
		if(index > 0) { 
			for(int i = 0; i < index; i++) {

		%>
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_register.gom">
				<img class="d-block w-100" src="images/404.png" alt="Third slide">
				</a>
				<div id="info">
					프로그램을 등록해주세요 <br> <img src="images/d-day/dot.png"
						width="20" height="20">프로그램을 등록해주세요
				</div>
			</div>
			
		</div>
			
		<% }
			}  
			}%>


</body>

</html>


