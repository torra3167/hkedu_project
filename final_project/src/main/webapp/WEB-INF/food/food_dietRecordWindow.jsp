<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Food, java.util.*"%>
<!-- , javax.servlet.http.HttpSession -->
<%
   List<Food> orderedFoodList = (List<Food>)request.getAttribute("orderedFoodList");   //결제한 식품들정보
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>foodSearchWindow</title>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
$(document).ready();
var num;
console.log("자식창 전역변수 num : " + num);
function setParentText(){
//         opener.document.getElementById("parentText").value = document.getElementById("childText").value;
	console.log("자식창 setParentText num : "+ num);
	
		var foodQuant = document.getElementById("foodQuantity").value
// 		if(foodQuant == null){
// 			foodQuant = 0;
// 		}
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
            	var foodNo = element;
             }
        }
        
        var selectedFood = {
        	foodName: foodName,
        	carbo: carbo,
        	protein: protein,
        	fat: fat,
        	cal: cal,
        	foodNo : foodNo,
        	foodQuantity : foodQuant
        }
        
        var recordDate = opener.$("#recordDate").text();
        
//         var targetDivText = {};
//         targetDivText = opener.$("#addedRow").text();
//         alert(targetDivText);

// 		var arrNumber = new Array();
// 		for(var i=0;i<5;i++){
// 		    arrNumber[i]=opener.$("#addedRow").text();
// 		    alert(arrNumber[i]);
// 		}
//         var data2 = $("#frm").serialize();
        
//         $.ajax({
//             type:"POST",
//             url : "food_recordDuplication.gom",
//             data : data2 + "&mealtime=" + num + "&recordDate=" + recordDate,
//             async : false,
//             success : function(result){
//             			alert(result);
//             		if(result=="true"){
		            	if(num==1){
		                	opener.addFoodRow(selectedFood, num);
		                }else if(num==2){
		                	opener.addFoodRow(selectedFood, num);
		                }else if(num==3){
		                	opener.addFoodRow(selectedFood, num);
		                }else if(num==4){
		                	opener.addFoodRow(selectedFood, num);
		                }
		            	
		            	var data2 = $("#frm").serialize();
		            	   //   alert(data2);
		            		     $.ajax({
		            		        type:"POST",
		            		        url : "food_recordInsert.gom",
		            		        data : data2 + "&mealtime=" + num + "&quantity=" + foodQuant,
		            		        success : function()
		            		              {                           
		            		                 window.close();
		            		              }
		            		     });
//             		}else{
//             			alter("이미 기록된 식품입니다.");
//             			return false;
//             		}
//                   }
//          });
        
        
        
//         var para = document.getElementById("selectOrderedFood").value;
   //   alert("pppppppppppppppppppppppppp : "+ para);
   		//opener에 있는 값과 입력값이 같으면 DB에 추가 안 되고(중복 입력 불가) 경고창 생성하기
//   		var openerData = opener.searchDuplData(selectedFood, num);
//    		console.log(openerData);
   		
   		
    	
        
        
}
	
	 
        
   
        
   


</script>

</head>
<body>
<h3>식사 입력하기</h3>
<hr>
   <form name="frm" id="frm" action="#" method="POST">
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
             <input type="number" id="foodQuantity" value="0"/>
         </div>
        </div>
      <br>
      <hr>
       <button type="button" onclick="setParentText()">선택 완료</button>
    </form> 

</body>
</html>