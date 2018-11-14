<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.*, category.*" %>
<%
	List list = (List)request.getAttribute("foodCat");
/* 	System.out.println("food_reg.jsp :" + list.size());
 */%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="http://localhost:8080/final_project/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script type="text/javascript">



function funcBca() {
	 var num = document.getElementById("FCC").value;
	 $.ajax({
		 type:"POST",
		 url:"bca.gom",
		 dataType:"html",
		 data:"foodCatCNo=" + num,
		 success: function(result) {
			 $('#divBca').html(result);
			 $('#divAca').html("");
		 }
		 
	 });
}

function funcAca() {
		var num1 = document.getElementById("FCC").value; 
		var num2 = document.getElementById("FCB").value;
		/* alert(num1+"  "+ num2); */
		$.ajax({
			type:"POST",
			url:"cca.gom",
			dataType:"html",
			data:"foodCatBNo="+num2 + "&foodCatCNo=" + num1,
			success:function(result){
				$('#divAca').html(result);	
			}
		});		
	}
 
 
 
</script>	
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
        <form method="post" action="food_reg.gom" enctype="multipart/form-data">
        	<div class="form-group">
				<label>식품 번호</label> <input type="text" name="foodNo" class="form-control">
			</div>
        	<div class="form-group">
				<label>판매식품 이름</label> <input type="text" name="foodName" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 판매가격(원)</label> <input type="text" name="foodPrice" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 할인율(%)</label> <input type="text" name="foodSale" class="form-control">
			</div>
			<div class="form-group">
				<label>판매식품 이미지</label> <input type="file" name="foodImage" class="form-control">
			</div>
			<div>
			<select id="FCC" name="foodCatCNo" onclick="javascript:funcBca();"> 
				<% for(Object temp : list) {
					FoodCatC acar = (FoodCatC)temp; %>
				 	<option value="<%=acar.getFoodCatCNo() %>"> <%=acar.getFoodCatCName() %></option>
				<% } %>
			</select>
			</div>
			<div id="divBca"></div>
			<div id="divAca"></div>
			<div class="form-group">
				<label>식품 맛</label> <input type="text" name="foodFlavor" class="form-control">
			</div>
			<div class="form-group">
				<label>판매할 식품 개수</label> <input type="text" name="foodQuant" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 유통기한</label> <input type="text" name="foodExpiryDate" class="form-control">
			</div>
			<div class="form-group">
				<label>식품재료 원산지</label> <input type="text" name="foodOrigin" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 탄수화물 함량(g)</label> <input type="text" name="foodCarbo" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 단백질 함량(g)</label> <input type="text" name="foodProtein" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 지방 함량(g)</label> <input type="text" name="foodFat" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 칼로리(kcal)</label> <input type="text" name="foodCal" class="form-control">
			</div>
			<button type="submit" class="btn btn-primary">메뉴 등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
    
  
</body>
</html>