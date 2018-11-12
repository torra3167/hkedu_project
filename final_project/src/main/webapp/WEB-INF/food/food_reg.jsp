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
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<script type="text/javascript">


function bcaf(){
	var num = document.getElementById("ccca").value;
	$.ajax({
		type : "post",
		url : "foodCatB.gom",
		dataType : "html",
		data : "foodCatCNo="+num,
		success : function(result){
			$('#bbbca').html(result);
			$('#aaaca').html("");
		}
	});
}

function acaf(){
	var num1 = document.getElementById("ccca").value;
	var num2 = document.getElementById("bca1").value;
	alert('ccaf()왔다');
	$.ajax({
		type : "post",
		url : "foodCatA.gom",
		dataType : "html",
		data : "foodCatBNo="+num2 + "&foodCatCNo="+num1,
		success : function(result){
			$('#aaaca').html(result);
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
				<select id="ccca" name="foodCatCNo" onclick="javascript:bcaf();">
					<!-- list에 있는 것 option으로 주기 -->
					<% for(Object obj : list){
						FoodCatC foodCatC = (FoodCatC)obj;	%>
						<option value="<%=foodCatC.getFoodCatCNo()%>"><%=foodCatC.getFoodCatCName() %></option>
					<% } %>
				</select>
			</div>
			<div id="bbbca"></div>
			<div id="aaaca"></div>
			
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