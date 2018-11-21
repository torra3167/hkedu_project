<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자전용페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="http://localhost:8080/final_project/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
  <!-- Nav tabs -->
	<ul class="nav nav-tabs nav-justified">
	  <li class="nav-item">
	    <a class="nav-link active" data-toggle="tab" href="#home">주문내역</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu1">판매량 통계</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu2">판매식품 등록</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu3">등록식품 수정</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu4">관리자 문의</a>
	  </li>
	</ul>
	
	<br>
	<br>
	<!-- Tab panes -->
	<div class="tab-content">
		<div class="tab-pane container active" id="home">
			<jsp:include page="seller_orderBoard.jsp"></jsp:include>
		</div>
	  	 <div class="tab-pane container fade" id="menu1">
	  		<jsp:include page="../food/food_orderStatistics.jsp"></jsp:include>
	  	</div>
	   	<div class="tab-pane container fade" id="menu2">
	  		<jsp:include page="../food/food_reg.jsp"></jsp:include>
		</div>
	  	<div class="tab-pane container fade" id="menu3">
	  		<jsp:include page="seller_foodList.jsp"></jsp:include>
	  	</div>
	  	<div class="tab-pane container fade" id="menu4">
	  		<jsp:include page="seller_contactAdmin.jsp"></jsp:include>
		</div>  
	</div>
</div>


</body>
</html>