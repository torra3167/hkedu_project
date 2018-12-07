<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Program, model.Food"%>


<% 
	List programList = (List) request.getAttribute("Program");
	List selectedFoodList = (List) request.getAttribute("selectedFoodList");
	int foodIndex = 0;
	int index = 0;
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
					<a href="food_list.gom">식품관</a>
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
		<% if(selectedFoodList == null) {
			for(int i = 0; i < 4; i++) {
		%>
		
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_register.gom">
				<img class="d-block w-100" style="height: 200px;" src="images/404.png" alt="Third slide">
				</a>
				<div id="info" style="height: 100px;">
					식품을 등록해주세요 <br> <img src="images/d-day/dot.png"
						width="20" height="20">식품을 등록해주세요
				</div>
			</div>
			
		</div>		
			
		 <% } %>
			</div>
			</div>
	<% } else if(selectedFoodList.size() < 4) { %>
	<%
		
		 if(selectedFoodList.size() < 4) {
			foodIndex = selectedFoodList.size();
		}
		for(int i = 0; i < foodIndex; i++) {
			
			Food food = (Food)selectedFoodList.get(i);

		%>
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="food_detail.gom?foodNo=<%=food.getFoodNo() %>">
				<img class="d-block w-100" src="resource\\<%=food.getFoodStored() %>" alt="Third slide" width="300" height="200">
				</a>
				<div id="info" style="height: 100px;">
					<%=food.getFoodName() %> <br> <img src="images/d-day/dot.png"
						width="20" height="20"><%=food.getFoodPrice() %>원
				</div>
			</div>
		</div>
		<%
		}
		foodIndex = 4 - (selectedFoodList.size() % 4);
/* 		System.out.println((selectedFoodList.size() % 4) + "selectedFoodList.size()");
 */		if(foodIndex > 0) { 
			for(int i = 0; i < foodIndex; i++) {

		%>
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="seller_menu.gom">
				<img class="d-block w-100" src="images/404.png" alt="Third slide" width="300" height="200">
				</a>
				<div id="info" style="height: 100px;">
					식품을 등록해주세요 <br> <img src="images/d-day/dot.png"
						width="20" height="20">식품을 등록해주세요
				</div>
			</div>
			
		</div>
			
		<% }
			
		}
		
		} else if(selectedFoodList.size() > 4) { 
		for(int i = 0; i < 4; i++) {
			
			Food food = (Food)selectedFoodList.get(i); %>
			
			<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="food_detail.gom?foodNo=<%=food.getFoodNo() %>">
				<img class="d-block w-100" src="resource\\<%=food.getFoodStored() %>" alt="Third slide" width="300" height="200">
				</a>
				<div id="info" style="height: 100px;">
					<%=food.getFoodName() %> <br> <img src="images/d-day/dot.png"
						width="20" height="20"><%=food.getFoodPrice() %>원
				</div>
			</div>
		</div>
		<% }
		}%>
		
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
	<div class="container">
		<div class="row">
		<% if(programList == null) {
			for(int i = 0; i < 4; i++) {
		%>
		
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_register.gom">
				<img class="d-block w-100" src="images/404.png" alt="Third slide" style="height: 200px;" >
				</a>
				<div id="info" style="height: 100px;">
					프로그램을 등록해주세요 <br> <img src="images/d-day/dot.png"
						width="20" height="20">프로그램을 등록해주세요
				</div>
			</div>
			
		</div>		
			
		 <% } %>
			
	<% } else if(programList.size() < 4) { 
	
		
		 if(programList.size() < 4) {
			index = programList.size();
		}
		for(int i = 0; i < index; i++) {
			
			Program program = (Program)programList.get(i);

		%>
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_detail.gom?proNo=<%=program.getProNo()%>
					&proContent=<%=program.getProContent()%>
					&proPrice=<%=program.getProPrice()%>
					&proStatus=<%=program.getProStatus()%>
					&proStored=<%=program.getProStored()%>
					">
				<img class="d-block w-100" src="resource\\<%=program.getProStored() %>" alt="Third slide" width="300" height="200">
				</a>
				<div id="info" style="height: 100px;">
					<%=program.getProName() %> <br> <img src="images/d-day/dot.png"
						width="20" height="20"><%=program.getProPrice()  %>원
				</div>
			</div>
			
		</div>
		<%
		}
		index  = 4 - (programList.size() % 4);
/* 		System.out.println((programList.size() % 4) + "programList.size()");
 */		if(index > 0) { 
			for(int i = 0; i < index; i++) {
				
				
		%>
		<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_register.gom">
				<img class="d-block w-100" src="images/404.png" alt="Third slide" style="height: 200px;" >
				</a>
				<div id="info" style="height: 100px;">
					프로그램을 등록해주세요 <br> <img src="images/d-day/dot.png"
						width="20" height="20">프로그램을 등록해주세요
				</div>
			</div>
			
		</div>		
			
		<% }
			
		}
		
		} else if(programList.size() > 4) { 
		for(int i = 0; i < 4; i++) {
			
			Program program = (Program)programList.get(i); %>
			
			<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
			<div id="box">
				<a href="program_detail.gom?proNo=<%=program.getProNo()%>
					&proContent=<%=program.getProContent()%>
					&proPrice=<%=program.getProPrice()%>
					&proStatus=<%=program.getProStatus()%>
					&proStored=<%=program.getProStored()%>
					">
				<img class="d-block w-100" src="resource\\<%=program.getProStored() %>" alt="Third slide" width="300" height="200">
				</a>
				<div id="info" style="height: 100px;">
					<%=program.getProName() %> <br> <img src="images/d-day/dot.png"
						width="20" height="20"><%=program.getProPrice()  %>원
				</div>
			</div>
		</div>
		<% }
		}%>
</div>
</div>
</body>

</html>


