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
        	foodNo : foodNo
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
        
//         var para = document.getElementById("selectOrderedFood").value;
   //   alert("pppppppppppppppppppppppppp : "+ para);
   		//opener에 있는 값과 입력값이 같으면 DB에 추가 안 되고(중복 입력 불가) 경고창 생성하기
//   		var openerData = opener.searchDuplData(selectedFood, num);
//    		console.log(openerData);
   		
   		
    	var data2 = $("#frm").serialize();
   //   alert(data2);
	     $.ajax({
	        type:"POST",
	        url : "food_record.gom",
	        data : data2 + "&mealtime=" + num,
	        success : function()
	              {                           
	                 window.close();
	              }
	     });
        
        
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
         </div>
        </div>
      <br>
      <hr>
       <button type="button" onclick="setParentText()">선택 완료</button>
    </form> 

</body>
</html>