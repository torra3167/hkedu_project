<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.*, model.*, category.*" %>
<%
 	List list = (List)request.getAttribute("foodCat");
//  	System.out.println("food_update.jsp :" + list.size());
%>
<html>
<head>
<meta charset="UTF-8">
<title>등록식품 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
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
 
$(function() {
	$("#foodExpiryDate").datepicker({
		changeMonth: true, 
		changeYear: true,
		nextText: '다음 달',
		prevText: '이전 달' ,
		dateFormat: "yy년 mm월 dd일",
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
		});
});
 
</script>	
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
        <form:form commandName="foodUpdateCommand" method="post" action="food_update.gom" enctype="multipart/form-data">
        	<div class="form-group">
				<!-- <label>판매식품 번호</label> --> <form:hidden path="foodNo" class="form-control"/>
			</div>
        	<div class="form-group">
				<label>판매식품 이름</label> <form:input path="foodName" class="form-control"/>
			</div>
			<div class="form-group">
				<label>식품 판매가격(원)</label> <form:input path="foodPrice" class="form-control"/>
			</div>
			<div class="form-group">
				<label>식품 할인율(%)</label> <form:input path="foodSale" class="form-control"/>
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
				<label>판매할 식품 개수</label> <form:input path="foodQuant" class="form-control"/>
			</div>
			<div class="form-group">
				<label>식품 유통기한</label> <form:input path="foodExpiryDate" class="form-control"/>
			</div>
			<div class="form-group">
				<label>식품 탄수화물 함량(g)</label> <form:input path="foodCarbo" class="form-control"/>
			</div>
			<div class="form-group">
				<label>식품 단백질 함량(g)</label> <form:input path="foodProtein" class="form-control"/>
			</div>
			<div class="form-group">
				<label>식품 지방 함량(g)</label> <form:input path="foodFat" class="form-control"/>
			</div>
			<div class="form-group">
				<label>식품 칼로리(kcal)</label> <form:input path="foodCal" class="form-control"/>
			</div>
			<button type="submit" class="btn btn-primary">수정 완료</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
			<button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
        </form:form>
    </div>
    
  
</body>
</html>

