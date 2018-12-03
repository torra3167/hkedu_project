<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.*, category.*" %>
<%
	List list = (List)request.getAttribute("foodCat");

/* 	System.out.println("food_reg.jsp :" + list.size());
 */
 
 %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
			,error:function(request,status,error){
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}

	
		});		
	}
 
// var regDate;
$(function() {
	$("#foodExpiryDate").datepicker({
		changeMonth: true, 
		changeYear: true,
		nextText: '다음 달',
		prevText: '이전 달' ,
		dateFormat: "yy년 mm월 dd일",
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	
// 		onSelect: function(dateText, inst) {
// 		    alert('선택하신 날짜는'+dateText);
// 		    regDate = dateText;
// 		   location.href="food_recordMain.gom?dateText="+regDate;
	});
});

 
function checkVal(){
	if(!$("#foodName").val()){
		alert("식품 이름을 입력해주세요.");
		return false;
	}else if(!$("#foodPrice").val()){
		alert("식품 가격을 입력해주세요.");
		return false;
	}else if(isNaN($("#foodPrice").val())){
		alert("가격은 숫자만 입력해주세요.");
		return false;
	}else if(!$("#foodCal").val()){
		alert("식품 칼로리를 입력해주세요.");
		return false;
	}else if(isNaN($("#foodCal").val())){
		alert("칼로리는 숫자만 입력해주세요.");
		return false;
	}else if(!$("#foodFat").val()){
		alert("식품 지방함량을 입력해주세요.");
		return false;
	}else if(isNaN($("#foodFat").val())){
		alert("지방함량은 숫자만 입력해주세요.");
		return false;
	}else if(!$("#foodProtein").val()){
		alert("식품 단백질함량을 입력해주세요.");
		return false;
	}else if(isNaN($("#foodProtein").val())){
		alert("단백질함량은 숫자만 입력해주세요.");
		return false;
	}else if(!$("#foodCarbo").val()){
		alert("식품 탄수화물함량을 입력해주세요.");
		return false;
	}else if(isNaN($("#foodCarbo").val())){
		alert("탄수화물함량은 숫자만 입력해주세요.");
		return false;
	}else if(!$("#foodExpiryDate").val()){
		alert("식품 유통기한을 입력해주세요.");
		return false;
	}else if(!$("#foodQuant").val()){
		alert("판매등록하실 식품의 개수를 입력해주세요.");
		return false;
	}else if(isNaN($("#foodQuant").val())){
		alert("등록상품 개수는 숫자만 입력해주세요.");
		return false;
	}else if(!$("#foodImage").val()){
		alert("식품 이미지를 입력해주세요.");
		return false;
	}else if(!$("#foodSale").val()){
		alert("식품 가격의 할인율을 입력해주세요.");
		return false;
	}else if(isNaN($("#foodSale").val())){
		alert("할인율은 숫자만 입력해주세요.");
		return false;
	}else if(!$("#FCC").val()){
		alert("식품 카테고리를 선택해주세요.");
		return false;
	}else if(!$("#FCB").val()){
		alert("식품 카테고리를 선택해주세요.");
		return false;
	}else if(!$("#FCA").val()){
		alert("식품 카테고리를 선택해주세요.");
		return false;
	}
	document.getElementById('frm').submit();
}
 
 
</script>	
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
        <form method="post" action="food_reg.gom" enctype="multipart/form-data" id="frm">
        	<div class="form-group">
				<label>판매식품 이름</label> <input type="text" id="foodName" name="foodName" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 판매가격(원)</label> <input type="text" id="foodPrice" name="foodPrice" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 할인율(%)</label> <input type="text" id="foodSale" name="foodSale" class="form-control">
			</div>
			<div class="form-group">
				<label>판매식품 이미지</label> <input type="file" id="foodImage"  name="foodImage" class="form-control">
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
				<label>판매할 식품 개수</label> <input type="text" id="foodQuant"  name="foodQuant" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 유통기한</label> <input type="text" id="foodExpiryDate" name="foodExpiryDate" class="form-control" value="">
			</div>
			<div class="form-group">
				<label>식품 탄수화물 함량(g)</label> <input type="text" id="foodCarbo"  name="foodCarbo" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 단백질 함량(g)</label> <input type="text" id="foodProtein" name="foodProtein" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 지방 함량(g)</label> <input type="text" id="foodFat" name="foodFat" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 칼로리(kcal)</label> <input type="text" id="foodCal" name="foodCal" class="form-control">
			</div>
			<button type="button" class="btn btn-primary" onclick="checkVal()">메뉴 등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
    
  
</body>
</html>