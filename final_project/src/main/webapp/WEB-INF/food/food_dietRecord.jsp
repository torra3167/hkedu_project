<%@page import="model.DietRecord"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// 	DietRecord dietRecord = new DietRecord();
// 	Food food = new Food();
	
// 	if((DietRecord)request.getAttribute("addedDietRecord") != null){
// 	dietRecord	= (DietRecord)request.getAttribute("addedDietRecord");
// 	food = (Food)request.getAttribute("addedFood");
	
// 	System.out.println("부모창 맨 위 getDietRecordNo  : " + dietRecord.getDietRecordNo());
// 	System.out.println("부모창 맨 위 getFoodNo : " + food.getFoodNo());
// 	}else{
// 		System.out.println("부모창 dietRecord 맨 위 null");
// 		System.out.println("부모창 food 맨위 null");
// 	}

	List<DietRecordFood> dietRecordFoodList = (List<DietRecordFood>)request.getAttribute("dietRecordFoodList");
	List<DietRecordFood> breakfastList = new ArrayList<DietRecordFood>();
	List<DietRecordFood> lunchList = new ArrayList<DietRecordFood>();
	List<DietRecordFood> dinnerList = new ArrayList<DietRecordFood>();
	List<DietRecordFood> snackList = new ArrayList<DietRecordFood>();
	
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
%>
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
	
    
// function addFoodRow(selectedFood, num){
function addFoodRow(selectedFood, num){
	
	console.log("부모창 addFoodRow selectedFood : " + selectedFood);	
	console.log("부모창 addFoodRow num : " + num);	
	
	if(num==1){
		targetDiv = document.getElementById("targetBreakfast");
	}else if(num==2){
		targetDiv = document.getElementById("targetLunch");
	}else if(num==3){
		targetDiv = document.getElementById("targetDinner");
	}else if(num==4){
		targetDiv = document.getElementById("targetSnack");
	}
	
// 	sf = selectedFood.foodName;
// 	console.log("selectedFood.foodName : " + sf);
// 	var fndt = $.param(fName);
	var str = "";
	console.log("부모창 str 밑에ㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔ");
// 	str += "<div id='addedRow'>"+selectedFood.foodName+"  "+selectedFood.carbo+"g  "+selectedFood.protein+"g  "+selectedFood.fat+"g  "+selectedFood.cal+"kcal  "+selectedFood.foodQuantity+"개  <input type='button' value='삭제' onclick='delRow(this,"+num+")' /></div><br>";
	
	<%-- <% 
	System.out.println("부모창 if문 위에 getDietRecordNo  : " + dietRecord.getDietRecordNo());
	System.out.println("부모창 if문 위에 getFoodNo : " + food.getFoodNo());
	if(dietRecord != null) { %>
	alert("dietRecord != nulldietRecord != nulldietRecord != nulldietRecord != null");
	<%
	System.out.println("부모창 if문 아래 getDietRecordNo  : " + dietRecord.getDietRecordNo());
	System.out.println("부모창 if문 아래 getFoodNo : " + food.getFoodNo());
		if(food.getFoodNo() > 0){ %>
		alert("food.getFoodNo() != 0food.getFoodNo() != 0food.getFoodNo() != 0food.getFoodNo() != 0"); --%>
<%-- 		str += "<div id='addedRow'>"<%=food.getFoodName() %>"  "<%=food.getFoodCarbo() %>"g  "<%=food.getFoodProtein() %>"g  "<%=food.getFoodFat() %>"g  "<%=food.getFoodCal() %>"kcal  "<%=dietRecord.getFoodQuantity() %>"개  <input type='button' value='삭제' onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /></div><br>"; --%>
		var addedDiv = document.createElement("div"); // 폼 생성
		addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
		targetDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
	<%-- <% }else{
		System.out.println("부모창 if문 else getFoodNo : " + food.getFoodNo());
	%>
		alert("이미 입력한 식품입니다.");
		return false;
	<% }
	  }else{
		  System.out.println("부모창 dietRecord가 널이라고? : " + dietRecord);
	  }
			%> --%>
}
          
// function delRow(obj, num){
function delRow(obj, dietRecordNo){
	console.log("부모창 dietRecordNo : "+ dietRecordNo);

	//recordDate
	var recordDate = $("#recordDate").text();
	
	$("#addedRow"+dietRecordNo+"").remove();
// 	var row = obj.parentNode.parentNode.;
//     row.parentNode.removeChild(row);
	
    
    //foodName
//     console.log("foodName : " + sf);
    
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
<!-- for(DietRecord temp : dietRecordList){ -->
<!-- 		if(temp.getDietRecordTime().equals("아침")){ -->
<!-- 			breakfastRecordList = temp; -->
<!-- 		}else if(temp.getDietRecordTime().equals("점심")){ -->
<!-- 			lunchRecordList = temp; -->
<!-- 		}else if(temp.getDietRecordTime().equals("저녁")){ -->
<!-- 			dinnerRecordList = temp; -->
<!-- 		}else { -->
<!-- 			snackRecordList = temp; -->
<!-- 		} -->
<!-- 	} -->
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
   <input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(1)" />
   <br>
      <h6>점심식사</h6>
   <div id="targetLunch">
   <% for(Object temp2 : lunchList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
   %>
   		<div id="addedRow<%=dietRecord.getDietRecordNo() %>"><%=dietRecord.getFoodNutrientName() %>  <%=dietRecord.getFoodCarbo() %>g  <%=dietRecord.getFoodProtein() %>g  <%=dietRecord.getFoodFat() %>g  <%=dietRecord.getFoodCal() %>kcal  <%=dietRecord.getFoodQuantity() %>개  <input type='button' value='삭제' onclick='delRow(this,"<%=dietRecord.getDietRecordNo() %>")' /><br></div>
   <%	} %>
   </div>
   <input type="button" value="식사 입력하기" onclick="openSelectFoodWindow(2)" />
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

</body>
</html>