<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.Food"%>
    
<% 
    	Food food = (Food)request.getAttribute("sellerFood");
%> 
<html>
<head>
<meta charset="UTF-8">
<title>판매자 식품 상세보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="http://localhost:8080/final_project/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script type="text/javascript">

 
</script>	
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
        	<div class="form-group">
				<label>식품 번호</label> <input type="text" name="foodNo" class="form-control" value="<%=food.getFoodNo() %>" readonly="true">
			</div>
        	<div class="form-group">
				<label>판매식품 이름</label> <input type="text" name="foodName" class="form-control" value="<%=food.getFoodName() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>식품 판매가격(원)</label> <input type="text" name="foodPrice" class="form-control" value="<%=food.getFoodPrice() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>식품 할인율(%)</label> <input type="text" name="foodSale" class="form-control" value="<%=food.getFoodSale() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>판매식품 이미지</label> <br>
				<img alt="" src="resource/<%=food.getFoodStored() %>">
			</div>
			<div>
			카테고리
			<input type="text" name="foodCatANo" class="form-control" value="<%=food.getFoodCatANo() %>" readonly="true">
			<input type="text" name="foodCatBNo" class="form-control" value="<%=food.getFoodCatBNo() %>" readonly="true">
			<input type="text" name="foodCatCNo" class="form-control" value="<%=food.getFoodCatCNo() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>판매할 식품 개수</label> <input type="text" name="foodQuant" class="form-control" value="<%=food.getFoodQuant() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>식품 유통기한</label> <input type="text" name="foodExpiryDate" class="form-control" value="<%=food.getFoodExpiryDate() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>식품재료 원산지</label> <input type="text" name="foodOrigin" class="form-control" value="<%=food.getFoodOrigin() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>식품 탄수화물 함량(g)</label> <input type="text" name="foodCarbo" class="form-control" value="<%=food.getFoodCarbo() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>식품 단백질 함량(g)</label> <input type="text" name="foodProtein" class="form-control" value="<%=food.getFoodProtein() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>식품 지방 함량(g)</label> <input type="text" name="foodFat" class="form-control" value="<%=food.getFoodFat() %>" readonly="true">
			</div>
			<div class="form-group">
				<label>식품 칼로리(kcal)</label> <input type="text" name="foodCal" class="form-control" value="<%=food.getFoodCal() %>" readonly="true">
			</div>
			<button type="button" class="btn btn-primary" onclick="location.href='food_update.gom?foodNo=<%=food.getFoodNo() %>'">수정</button>
			<button type="button" class="btn btn-primary">삭제</button>
			<button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
    </div>
</body>
</html>