<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Integer dietRecordNo = (Integer)request.getAttribute("dietRecordNo");
%>
<%	//식단기록리스트
// 	Integer insertedDietNo = (Integer)session.getAttribute("insertedDietRecordNo");
	System.out.println("맨 위 dietRecordNo : " + dietRecordNo);
	
	List<DietRecordFood> dietRecordFoodList = (List<DietRecordFood>)request.getAttribute("dietRecordFoodList");
	List<DietRecordFood> breakfastList = new ArrayList<DietRecordFood>();
	List<DietRecordFood> lunchList = new ArrayList<DietRecordFood>();
	List<DietRecordFood> dinnerList = new ArrayList<DietRecordFood>();
	List<DietRecordFood> snackList = new ArrayList<DietRecordFood>();
	if(dietRecordFoodList != null){
		for(Object temp : dietRecordFoodList){
			DietRecordFood drs = (DietRecordFood)temp;
			if(drs.getDietRecordTime().equals("아침")){
				breakfastList.add(drs);
			}else if(drs.getDietRecordTime().equals("점심")){
				lunchList.add(drs);
			}else if(drs.getDietRecordTime().equals("저녁")){
				dinnerList.add(drs);
			}else {
				snackList.add(drs);
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식단기록 페이지</title>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready();
// var childWindow;
// var sf;
// var dietRecordNum;
var targetDiv;
var mealtime;
var selectedOption;
var quantity;
var recordDate;
<%-- var dietRecordNo;	//위에서 request로 받아온 넘버 <%=%>으로 넣기 테스트해서 ajax insert success에서 중복여부에 의한 결과 처리하기 --%>
$(document).ready(function() {
	    $('#bfInsertBtn').click(function() {
		mealtime = 1;
//	 		var url = $('#frmLogin').attr("action");
			
			//식단입력정보를 cntlr로 보내서 중복여부 확인하고, insert결과 반환해서 중복불가/입력완료 알려주고 페이지로 돌아와서 리스트로 뿌리기 
	        $.ajax({
                  type: "POST",
                  url: "food_openRecord.gom",
				  dataType:"html",
//                   data:
                  success: function(result) {
// 	    					sessionStorage.setItem("user_id", form_data.user_id);
	                      	$('#bfInsertPoint').html(result);
                  },
                  error: function() {
                    	$('#bfInsertPoint').html("<h2>Error</h2>");
                  }
	        });
      });
});

function addDiet(){
	selectedOption = document.getElementById("selectOrderedFood").value;
	quantity = document.getElementById("foodQuantity").value;
	recordDate = document.getElementById("recordDate").value;
	$.ajax({
		type:"POST",
		url:"food_recordInsert.gom",
		async :false,
		dataType:"html",
		data:"selectedOption="+selectedOption+"&quantity="+quantity+"&mealtime="+mealtime+"&recordDate="+recordDate,
		success:function(){
			addFoodRow(mealtime);
			$('#bfInsertPoint').html("");
		}
	});	
	
}
    
    
// function addFoodRow(selectedFood, num){
function addFoodRow(mealtime){
	if(mealtime==1){
		targetDiv = document.getElementById("targetBreakfast");
	}else if(mealtime==2){
		targetDiv = document.getElementById("targetLunch");
	}else if(mealtime==3){
		targetDiv = document.getElementById("targetDinner");
	}else if(mealtime==4){
		targetDiv = document.getElementById("targetSnack");
	}
	
// 	var foodQuantity = childWindow.document.getElementById("foodQuantity").value;
	var selectedOptions = selectedOption.split(",");
	for(var i=0; i < selectedOptions.length; i++){
		var element = selectedOptions[i];
        if(i == 0){ 
           var foodName = element;
        }else if(i == 1){
           var carbo = element;  
        }else if(i == 2){
           var protein = element;
        }else if(i == 3){
           var fat = element;  
        }else if(i == 4){
           var cal = element; 
        }else if(i == 5){
       	var foodNo = element;
        }
	}
	
	var str = "";
	str += "<div id='addedRow<%=dietRecordNo%>'>"+foodName+"  "+carbo+"g  "+protein+"g  "+fat+"g  "+cal+"kcal  "+quantity+"개  <input type='button' value='삭제' onclick='delRow(this,<%=dietRecordNo%>)' /><br></div>";
		var addedDiv = document.createElement("div"); // 폼 생성
		addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
		targetDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
}
          
function delRow(obj, dietRecordNo){
	console.log("부모창 dietRecordNo : "+ dietRecordNo);

	//recordDate
	var recordDate = $("#recordDate").text();
	
	$("#addedRow"+dietRecordNo+"").remove();
    
    $.ajax({
        type:"POST",
        url : "food_recordDelete.gom",
        data : "dietRecordNo="+dietRecordNo,
//         data : "recordDate="+recordDate+"&mealtime="+num+"&foodName="+sf,
        success : function()
              {                 
        			console.log("ajax delete전송 성공");
              }
     });
}

			
		
</script>
</head>
<body>
<div id="baseForm">
	<div id="recordDate">2018년 11월 27일</div>
   <input type="hidden" id="count" name="count" value="0">
   
   <h6>식품명 탄수화물 단백질 지방 칼로리</h6>
      <h6>아침식사</h6>
   <div id="targetBreakfast">
   <% for(Object temp2 : breakfastList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
   %>
   		<div id="addedRow<%=dietRecord.getDietRecordNo() %>"><%=dietRecord.getFoodNutrientName() %>  <%=dietRecord.getFoodCarbo() %>g  <%=dietRecord.getFoodProtein() %>g  <%=dietRecord.getFoodFat() %>g  <%=dietRecord.getFoodCal() %>kcal  <%=dietRecord.getFoodQuantity() %>개  <input type='button' value='삭제' onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /><br></div>
   <%	} %>
   </div>
   
   <input type="button" id="bfInsertBtn" value="식사 입력하기" /><!-- onclick="openSelectFoodWindow(1)" -->
   <br>
   
   <div id="bfInsertPoint"><!-- food_dietRecord2들어올자리 --></div>
   
   
   <br>
      <h6>점심식사</h6>
   <div id="targetLunch">
   <% for(Object temp2 : lunchList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
   %>
   		<div id="addedRow<%=dietRecord.getDietRecordNo() %>"><%=dietRecord.getFoodNutrientName() %>  <%=dietRecord.getFoodCarbo() %>g  <%=dietRecord.getFoodProtein() %>g  <%=dietRecord.getFoodFat() %>g  <%=dietRecord.getFoodCal() %>kcal  <%=dietRecord.getFoodQuantity() %>개  <input type='button' value='삭제' onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /><br></div>
   <%	} %>
   </div>
   <input type="button" value="식사 입력하기"/><!-- onclick="openSelectFoodWindow(2)" -->
   <br>
      <h6>저녁식사</h6>
   <div id="targetDinner">
   <% for(Object temp2 : dinnerList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
   %>
   		<div id="addedRow<%=dietRecord.getDietRecordNo() %>"><%=dietRecord.getFoodNutrientName() %>  <%=dietRecord.getFoodCarbo() %>g  <%=dietRecord.getFoodProtein() %>g  <%=dietRecord.getFoodFat() %>g  <%=dietRecord.getFoodCal() %>kcal  <%=dietRecord.getFoodQuantity() %>개  <input type='button' value='삭제' onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /><br></div>
   <%	} %>
   </div>
   <input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(3)" />
   <br>
      <h6>간식</h6>
   <div id="targetSnack">
   <% for(Object temp2 : snackList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
   %>
   		<div id="addedRow<%=dietRecord.getDietRecordNo() %>"><%=dietRecord.getFoodNutrientName() %>  <%=dietRecord.getFoodCarbo() %>g  <%=dietRecord.getFoodProtein() %>g  <%=dietRecord.getFoodFat() %>g  <%=dietRecord.getFoodCal() %>kcal  <%=dietRecord.getFoodQuantity() %>개  <input type='button' value='삭제' onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /><br></div>
   <%	} %>
   </div>
   <input type="button" value="간식 입력하기" onclick="openSelectFoodWindow(4)" /><br>
   <br>
</div>

<!-- ----------------------------------------------------------------------------------------- -->




</body>
</html>