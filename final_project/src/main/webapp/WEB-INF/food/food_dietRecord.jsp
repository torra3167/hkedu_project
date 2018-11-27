<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Food, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready();
var childWindow;
var sf;
var targetDiv;
function openSelectFoodWindow(num) {
	   var settings ='toolbar=no,directories=no,status=no,menubar=no,scrollbars=auto,resizable=yes,height=600,width=800,left=0,top=0';
	   childWindow = window.open("food_dietRecordWindow.gom","childWindow",settings);
	   childWindow.num = num;
// 	   childWindow.document.getElementById("childText").value = document.getElementById("parentText").value;
}
	
    
function addFoodRow(selectedFood, num){
	if(num==1){
		targetDiv = document.getElementById("targetBreakfast");
	}else if(num==2){
		targetDiv = document.getElementById("targetLunch");
	}else if(num==3){
		targetDiv = document.getElementById("targetDinner");
	}else if(num==4){
		targetDiv = document.getElementById("targetSnack");
	}
	
	sf = selectedFood.foodName;
	console.log("selectedFood.foodName : " + sf);
// 	var fndt = $.param(fName);
	var str = "";
	str += "<div id='addedRow'>"+selectedFood.foodName+"  "+selectedFood.carbo+"g  "+selectedFood.protein+"g  "+selectedFood.fat+"g  "+selectedFood.cal+"kcal  "+selectedFood.foodQuantity+"개  <input type='button' value='삭제' onclick='delRow(this,"+num+")' /></div><br>";
	var addedDiv = document.createElement("div"); // 폼 생성
	addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
	targetDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
}
          
function delRow(obj, num){
	//recordDate
	var recordDate = $("#recordDate").text();
		     
	var row = obj.parentNode.parentNode;
    row.parentNode.removeChild(row);
	
    //targetNumber
    console.log("targetNumber : "+  num);
    
    //foodName
    console.log("foodName : " + sf);
    
    $.ajax({
        type:"POST",
        url : "food_recordDelete.gom",
        data : "recordDate="+recordDate+"&mealtime="+num+"&foodName="+sf,
        success : function()
              {                 
        			console.log("ajax delete전송 성공");
              }
     });
}

// function searchDuplData(selectedFood, num){
// 	var bfChildrens = $("#targetBreakfast").children();
// 	console.log("targetBreakfast's Childrens : " + bfChildrens);
	
// 	var lcChildrens = $("#targetLunch").children();
// 	console.log("targetLunch's Childrens : " + lcChildrens);
	
// 	var dnChildrens = $("#targetDinner").children();
// 	console.log("targetDinner's Childrens : " + dnChildrens);
	
// 	var snChildrens = $("#targetSnack").children();
// 	console.log("targetSnack's Childrens : " + snChildrens);
	
// 	return "천천히";
// }
			
		
</script>

</head>
<body>
<div id="baseForm" name="baseForm">
	<div name="recordDate" id="recordDate">2018년 11월 27일</div>
   <input type="hidden" id="count" name="count" value="0">
   <h6>식품명 탄수화물 단백질 지방 칼로리</h6>
      <h6>아침식사</h6>
   <div id="targetBreakfast">
   </div>
   <input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(1)" />
   <br>
      <h6>점심식사</h6>
   <div id="targetLunch">
   </div>
   <input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(2)" />
   <br>
      <h6>저녁식사</h6>
   <div id="targetDinner">
   </div>
   <input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(3)" />
   <br>
      <h6>간식</h6>
   <div id="targetSnack">
   </div>
   <input type="button" value="간식 입력하기" onclick="openSelectFoodWindow(4)" /><br>
   <br>
<!--    <input type="button" value="추가" onclick="addRow()"> -->
<!--    <input type="button" value="삭제" onclick="delRow()"> -->
<!--    <input type="submit" value="완료"> -->
   
<!--    <input type="button" value="식사 입력하기" onclick="openFoodSearchWindow()" /> -->
<!--    자식창에 전달할 값 : <input type="text" id="parentText" name="parentText" value=""/> -->
   <br>
<!--     <input type="button" value="전달" onclick="setChildText()"> -->

   <br>
<!--    자식창에서 전달받은 값 : <input type="text" id="receiveFromChild" value=""/> -->
</div>

</body>
</html>