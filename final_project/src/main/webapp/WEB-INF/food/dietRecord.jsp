<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Food, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready();
	var childWindow;
	
	function openSelectFoodWindow(num) {
		 // 자식창에 대한 세팅(옵션)
	   var settings ='toolbar=no,directories=no,status=no,menubar=no,scrollbars=auto,resizable=yes,height=600,width=800,left=0,top=0';
	   childWindow = window.open("FoodSearchWindow.gom","childWindow",settings);
	   childWindow.num = num;
// 	   childWindow.document.getElementById("childText").value = document.getElementById("parentText").value;
	}
	
	/* function setChildText(){
		childWindow.document.getElementById("childText").value = document.getElementById("parentText").value;
    } */
    
function addFoodRow(selectedFood, num){
	if(num==1){
		var targetDiv = document.getElementById("targetBreakfast");
	}else if(num==2){
		var targetDiv = document.getElementById("targetLunch");
	}else if(num==3){
		var targetDiv = document.getElementById("targetDinner");
	}else if(num==4){
		var targetDiv = document.getElementById("targetSnack");
	}

	var str = "";
	str += "<div>"+selectedFood.foodName+" "+selectedFood.carbo+" "+selectedFood.protein+" "+selectedFood.fat+" "+selectedFood.cal+"<input type='button' value='삭제' onclick='delRow(this)' /></div><br>";
	var addedDiv = document.createElement("div"); // 폼 생성
	addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
	targetDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
}
          
function delRow(obj){
	var row = obj.parentNode.parentNode;
	row.parentNode.removeChild(row);
}

			
		
</script>
</head>
<body>
<div id="baseForm" name="baseForm">
	<input type="hidden" id="count" name="count" value="0">
	<h6>식품명 탄수화물 단백질 지방 칼로리</h6>
		<h6>아침식사</h6><input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(1)" /><br>
	<div id="targetBreakfast">
	</div>
	<br>
		<h6>점심식사</h6><input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(2)" /><br>
	<div id="targetLunch">
	</div>
	<br>
		<h6>저녁식사</h6><input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(3)" /><br>
	<div id="targetDinner">
	</div>
	<br>
		<h6>간식</h6><input type="button" value="간식 입력하기" onclick="openSelectFoodWindow(4)" /><br>
	<div id="targetSnack">
	</div>
	<br>
<!-- 	<input type="button" value="추가" onclick="addRow()"> -->
<!-- 	<input type="button" value="삭제" onclick="delRow()"> -->
<!-- 	<input type="submit" value="완료"> -->
	
<!-- 	<input type="button" value="식사 입력하기" onclick="openFoodSearchWindow()" /> -->
<!-- 	자식창에 전달할 값 : <input type="text" id="parentText" name="parentText" value=""/> -->
	<br>
<!-- 	 <input type="button" value="전달" onclick="setChildText()"> -->

	<br>
<!-- 	자식창에서 전달받은 값 : <input type="text" id="receiveFromChild" value=""/> -->
</div>

</body>
</html>