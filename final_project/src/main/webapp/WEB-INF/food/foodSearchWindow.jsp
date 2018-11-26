<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Food, java.util.*"%>
<!-- , javax.servlet.http.HttpSession -->
<%
	List<Food> orderedFoodList = (List<Food>)request.getAttribute("orderedFoodList");	//결제한 식품들정보
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foodSerchWindow</title>
<script type="text/javascript">
$(document).ready();
var num = 0;
var sentFoodNo = 0;
	function getParentText(){
	    document.getElementById("childText").value = opener.document.getElementById("parentText").value;
	}
	
// 	function sendData() {
// 		 var num = document.getElementById("selectOrderedFood").value;
// 		 $.ajax({
// 			 type:"POST",
// 			 url:"food_record.gom",
// 			 dataType:"html",
// 			 data:"FoodNo=" + num,
// 			 success: function(result) {
// 			 }
			 
// 		 });
// 	}
	
	function setParentText(){
//         opener.document.getElementById("parentText").value = document.getElementById("childText").value
        var selectedFoodValues = document.getElementById("selectOrderedFood").value.split(",");
        for (var i=0; i < selectedFoodValues.length; i++){
               var element = selectedFoodValues[i];
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
            	 sentFoodNo = element;
             }
        }
        
        var selectedFood = {
        	foodName: foodName,
        	carbo: carbo,
        	protein: protein,
        	fat: fat,
        	cal: cal
        }
        
        if(num==1){
        	opener.addFoodRow(selectedFood, num);
        }else if(num==2){
        	opener.addFoodRow(selectedFood, num);
        }else if(num==3){
        	opener.addFoodRow(selectedFood, num);
        }else if(num==4){
        	opener.addFoodRow(selectedFood, num);
        }
        
        frm.submit();
        window.onload = function(){
        	window.close();
        }
//         self.close();
        
   }
        
   


</script> 


</head>
<body>
<h3>식사 입력하기</h3>
<hr>
	<form name="frm" id="frm" action="food_record.gom" method="POST">
		<div class="form-row">
	        <div class="form-group col-sm-3">
	          <label>주문한 상품 중 선택</label>
	          <select class="form-control" id="selectOrderedFood" name="selectOrderedFood">
	          <%
	          	int fn = 0;
	          	for(Object temp : orderedFoodList){
	          		Food food = (Food)temp;
	          %>
	            <option value="<%=food.getFoodName()%>,<%=food.getFoodCarbo()%>,<%=food.getFoodProtein()%>,<%=food.getFoodFat()%>,<%=food.getFoodCal()%>,<%=food.getFoodNo()%>"><%=food.getFoodName() %></option>
	            
	          <%} %>
	          </select>
<!-- 	        </div> -->
<!-- 	        <input type="hidden" name="" value="" /> -->
<!--         </div> -->
        <hr>
<!-- 		부모창에서 전달받은 값 : <input type="text" id="childText" name="childText" value=""/> -->
<!-- 		<input type="button" value="부모값 가져오기" onclick="getParentText()" /> -->
		<br>
		<hr>
	    <button type="button" id="" onclick="setParentText();">선택 완료</button>
    </form> 

</body>
</html>