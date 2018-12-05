<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%	
	String recDate = (String)request.getAttribute("dateText");

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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<!-- <script src="http://code.jquery.com/jquery-2.1.1.min.js"></script> -->
<script type="text/javascript">
$(document).ready();
var targetDiv;
var mealtime;
var selectedOption;
var quantity;
var recordDate;
var dietRecordNo;
var mealtimeText;
var btnGroup;
var selectedfoodNut;
var addDietParam;

function recordBtn(num){
	recordDate = document.getElementById('recordDate').innerHTML;
// 	alert("recordDate1 : "+recordDate);
		mealtime = num;
// 		alert("mealtime : "+mealtime);
		$(document).ready(function() {
	        $.ajax({
	            type: "POST",
	            url: "food_openRecord.gom",
				dataType:"html",
	            success: function(result) {
						$('#insertPoint').html(result);
						btnGroup = document.getElementById('btnGroup');
						btnGroup.disabled = true;
	            }
		    });
		});
}

function cancelAddDiet(){
	$('#insertPoint').html("");
	btnGroup.disabled = false;
	mealtime = null;
}

function cancelNutAddDiet(){
	$('#orderedBar').html("");
	$('#catB').html("");
	$('#nutCatBar').html("");
	btnGroup.disabled = false;
	mealtime = null;
}

function addDiet(addNo){
	addDietParam = addNo;
	if(addDietParam==1){
		selectedOption = document.getElementById("selectOrderedFood").value;
		quantity = document.getElementById("foodQuantity").value;
	}else{
		selectedOption = document.getElementById("catBNutFood").value;
		quantity = document.getElementById("nutQuantity").value;
	}
	$.ajax({
		type:"POST",
		url:"food_recordDuplication.gom",
		dataType:"html",
		data:"selectedOption="+selectedOption+"&mealtime="+mealtime+"&recordDate="+recordDate,
		success:function(response){
			if(response=="false"){
				$.ajax({
					type:"POST",
					url:"food_recordInsert.gom",
					dataType:"html",
					data:"selectedOption="+selectedOption+"&quantity="+quantity+"&mealtime="+mealtime+"&recordDate="+recordDate,
					success:function(result){
								dietRecordNo = result;
// 								alert("dietRecordNo1 : "+dietRecordNo);
								addFoodRow();
								if(addDietParam==1){
								$('#insertPoint').html("");
								}else{
									$('#catB').html("");
									$('#nutCatBar').html("");
								}
								btnGroup.disabled = false;
							}
				});
		 	}else{
				alert("중복되는 식단입니다. 다시 입력해주세요.");
			}
		}
	});	
	
}






function addFoodRow(){
// 	alert("mealtime : "+mealtime);
	if(mealtime==1){
		targetDiv = document.getElementById("targetBreakfast");
		mealtimeText = "아침식사";
	}else if(mealtime==2){
		targetDiv = document.getElementById("targetLunch");
		mealtimeText = "점심식사";
	}else if(mealtime==3){
		targetDiv = document.getElementById("targetDinner");
		mealtimeText = "저녁식사";
	}else if(mealtime==4){
		targetDiv = document.getElementById("targetSnack");
		mealtimeText = "간식";
	}
	
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
	str += "<td>"+mealtimeText+"</td><td>"+foodName+"</td><td>"+carbo+"g</td><td>"+protein+"g</td><td>"+fat+"g</td><td>"+cal+"kcal</td><td>"+quantity+"개</td><td><input type='button' value='삭제' class='btn btn-danger' onclick='delRow(this,"+dietRecordNo+")' /></td>";
		var addedDiv = document.createElement("tr"); // 폼 생성
		addedDiv.setAttribute("id", "addedRow"+dietRecordNo+"");
		addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
		targetDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
}
          
function delRow(obj, drNum){
// 	alert("dietRecordNo2 : "+drNum);
	$("#addedRow"+drNum).remove();
    
    $.ajax({
        type:"POST",
        url : "food_recordDelete.gom",
        data : "drNum="+drNum,
        success : function()
              {                 
        			console.log("ajax delete전송 성공");
              }
     });
}

function funcBcat() {
	$('#orderedBar').html("");
	 var foodNutrientCatName = document.getElementById("selectNutrientFood").value;
	 $.ajax({
		 type:"POST",
		 url:"food_nutFoodCatName.gom",
		 dataType:"html",
		 data:"foodNutrientCatName="+foodNutrientCatName,
		 success: function(result) {
			 $('#catB').html(result);
		 }
	 });
}
			
		
</script>
</head>
<body>
   <h2>식단 기록하기</h2>
   <div id="recordDate" style="color:black;font-size:20px;"><%=recDate %></div>
   <br>
<div class="btn-group">
  <div class="btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" id="btnGroup" style="width:165px;">
       식단 입력하기
    </button>
    <div class="dropdown-menu">
	   <a class="dropdown-item" id="bfBtnDiv" onclick="recordBtn(1)">아침식사</a>
	   <a class="dropdown-item" id="lcBtnDiv" onclick="recordBtn(2)">점심식사</a>
	   <a class="dropdown-item" id="dnBtnDiv" onclick="recordBtn(3)">저녁식사</a>
	   <a class="dropdown-item" id="snBtnDiv" onclick="recordBtn(4)">간식</a>
    </div>
  </div>
  <button type="button" class="btn btn-primary" onclick="location.href='food_recordMain.gom?dateText=<%=recDate %>'">목록으로</button>
</div>
   
   <div id="insertPoint"></div>
   <div id="catB"></div>
   
    <br> 
	<br>
      <table class="table table-hover">
	    <thead>
	      <tr>
	        <th><!-- 식사시간 --></th>
	        <th>식품명</th>
	        <th>탄수화물</th>
	        <th>단백질</th>
	        <th>지방</th>
	        <th>칼로리</th>
	        <th>개수</th>
	        <th><!-- 삭제버튼 --></th>
	      </tr>
	    </thead>
	    <tbody id="targetBreakfast">
	   <% for(Object temp2 : breakfastList){ 
		   DietRecordFood dietRecord = (DietRecordFood)temp2;
	   %>
	   	  <tr id="addedRow<%=dietRecord.getDietRecordNo() %>">
	   	  	<td>아침식사</td>
	   		<td><%=dietRecord.getFoodNutrientName() %></td>
	        <td><%=dietRecord.getFoodCarbo() %>g</td>
	        <td><%=dietRecord.getFoodProtein() %>g</td>
	        <td><%=dietRecord.getFoodFat() %>g</td>
	        <td><%=dietRecord.getFoodCal() %>kcal</td>
	        <td><%=dietRecord.getFoodQuantity() %>개</td>
	        <td><input type='button' value='삭제' class="btn btn-danger" onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /></td>
	      </tr>
	   <%	} %>
	   </tbody>
   
   
   <tbody id="targetLunch">
	   <% for(Object temp2 : lunchList){ 
		   DietRecordFood dietRecord = (DietRecordFood)temp2;
	   %>
	   	  <tr id="addedRow<%=dietRecord.getDietRecordNo() %>">
	   	  	<td>점심식사</td>
	   		<td><%=dietRecord.getFoodNutrientName() %></td>
	        <td><%=dietRecord.getFoodCarbo() %>g</td>
	        <td><%=dietRecord.getFoodProtein() %>g</td>
	        <td><%=dietRecord.getFoodFat() %>g</td>
	        <td><%=dietRecord.getFoodCal() %>kcal</td>
	        <td><%=dietRecord.getFoodQuantity() %>개</td>
	        <td><input type='button' value='삭제' class="btn btn-danger" onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /></td>
	      </tr>
	   <%	} %>
   </tbody>
  
   
   <tbody id="targetDinner">
	   <% for(Object temp2 : dinnerList){ 
		   DietRecordFood dietRecord = (DietRecordFood)temp2;
	   %>
	   	  <tr id="addedRow<%=dietRecord.getDietRecordNo() %>">
	   	  	<td>저녁식사</td>
	   		<td><%=dietRecord.getFoodNutrientName() %></td>
	        <td><%=dietRecord.getFoodCarbo() %>g</td>
	        <td><%=dietRecord.getFoodProtein() %>g</td>
	        <td><%=dietRecord.getFoodFat() %>g</td>
	        <td><%=dietRecord.getFoodCal() %>kcal</td>
	        <td><%=dietRecord.getFoodQuantity() %>개</td>
	        <td><input type='button' value='삭제' class="btn btn-danger" onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /></td>
	      </tr>
	   <%	} %>
   </tbody>
   
   
   <tbody id="targetSnack">
	   <% for(Object temp2 : snackList){ 
		   DietRecordFood dietRecord = (DietRecordFood)temp2;
	   %>
	   	  <tr id="addedRow<%=dietRecord.getDietRecordNo() %>">
	   	  	<td>간식</td>
	   		<td><%=dietRecord.getFoodNutrientName() %></td>
	        <td><%=dietRecord.getFoodCarbo() %>g</td>
	        <td><%=dietRecord.getFoodProtein() %>g</td>
	        <td><%=dietRecord.getFoodFat() %>g</td>
	        <td><%=dietRecord.getFoodCal() %>kcal</td>
	        <td><%=dietRecord.getFoodQuantity() %>개</td>
	        <td><input type='button' value='삭제' class="btn btn-danger" onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /></td>
	      </tr>
	   <%	} %>
   </tbody>
   
</table>
</body>
</html>