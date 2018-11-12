<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.*, category.*" %>
<%
	List list = (List)request.getAttribute("list");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">

<script type="text/javascript">


function bca() {
	 var num = document.getElementById("cca").value;
	 $.ajax({
		 type:"POST",
		 url:"bca.gom",
		 dataType:"html",
		 data:"foodCatCNo=" + num,
		 success: function(result) {
			 $('#bca').html(result);
			 $('#aca').html("");
		 }
		 
	 });
}
 
 
 
</script>	
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
        <form method="post" action="food_reg.gom">
        	<div class="form-group">
				<label>판매식품 이름</label> <input type="text" name="foodName" class="form-control">
			</div>
			<div class="form-group">
				<label>판매식품 이미지</label> <input type="file" name="foodImage" class="form-control">
			</div>
			<div>
				<select id="cca" name="foodCatCNo" onclick="javascript:bca();"> 
				<% for(Object temp : list) {
					FoodCatC foodCatC = (FoodCatC)temp; %>
				 	<option value="<%=foodCatC.getFoodCatCNo()%>"> <%=foodCatC.getFoodCatCName() %></option>
				<% } %>
				</select>
			</div>
			<div id="bca"></div>
			<div id="aca"></div>
			
			<div class="form-group">
				<label>판매할 식품 개수</label> <input type="text" name="foodQuant" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 유통기한</label> <input type="text" name="foodExpiryDate" class="form-control">
			</div>
			<div class="form-group">
				<label> 식품재료 원산지</label> <input type="text" name="foodOrigin" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 할인율</label> <input type="text" name="foodSale" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 맛</label> <input type="text" name="foodFlavor" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 판매가격</label> <input type="text" name="foodPrice" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 탄수화물 함량</label> <input type="text" name="foodCarbo" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 단백질 함량</label> <input type="text" name="foodProtein" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 지방 함량</label> <input type="text" name="foodFat" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 칼로리</label> <input type="text" name="foodCal" class="form-control">
			</div>
			<button type="submit" class="btn btn-primary">메뉴 등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
</body>
</html>