<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- , javax.servlet.http.HttpSession -->


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
var gbl_data; // 전역변수 선언
var dietRecordNo;
function windowClose(){
	window.close();
}


function setParentText(){
//         opener.document.getElementById("parentText").value = document.getElementById("childText").value;
	console.log("자식창 setParentText num : "+ num);
	
		var foodQuant = document.getElementById("foodQuantity").value
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
        
//         if(num==1){
//         	opener.addFoodRow(selectedFood, num);
//         }else if(num==2){
//         	opener.addFoodRow(selectedFood, num);
//         }else if(num==3){
//         	opener.addFoodRow(selectedFood, num);
//         }else if(num==4){
//         	opener.addFoodRow(selectedFood, num);
//         }
        
    	//insertRecord
//     	var data2 = $("#frm").serialize();
    	var selectedOption = document.getElementById("selectOrderedFood").value;
    	
    	var rs = "";
    	
    	var recordDate = "2019년 12월 11일";
    	 $.ajax({
          type:"POST",
          url : "food_recordDuplication.gom",
          async : false,
          data : "selectedOption=" + selectedOption + "&mealtime=" + num + "&recordDate=" + recordDate,
          success : function(result){	//food_recordDuplication.gom에서 반환된 중복여부(result) 테스트 완료
          			console.log(result);
	          		if(result=="true"){
	          			console.log("truetruetruetruetruetrue");
	          	 	    
	          	 	    
	          	 	    
	          			/* $.ajax({
		         	        type:"POST",
		         	        url : "food_recordInsert.gom",
		         	        async : false,
		         	        data : 
		         	        success : function(result)
		         	              {	
		         	        		alert("resultresultresultresultresult : " + result);
		         	        		dietRecordNo = result; 
		         	        		alert("dietRecordNodietRecordNodietRecordNo : " + dietRecordNo);
		         	        		opener.dietRecordNum = dietRecordNo;
		         	        		opener.addFoodRow(num);
		         	        		location.href="member_dietRecordList.gom";
		         	              }
		         	     	}); */
		         	     	
		         	     	
// 		        	     console.log("window.close()뒤다");
// 		         	     
// 	         	     opener.addFoodRow(selectedFood, num);
//	                 var recordDate = opener.$("#recordDate").each();
	                
//	                 var targetDivText = opener.$("#addedRow").text();
//	                 alert(targetDivText);
	          			
	          			
	          			
	          			
// 	          			windowClose(); //함수로 window닫기 테스트 완료
	          		}else{
	          			alter("이미 기록된 식품입니다.");
	//           			return false;
	          		}
                }
       });


    	
    	
    	


// 		var arrNumber = new Array();
// 		for(var i=0;i<5;i++){
// 		    arrNumber[i]=opener.$("#addedRow").text();
// 		    alert(arrNumber[i]);
// 		}
//         var data2 = $("#frm").serialize();
        
//        
        
        
        
//         var para = document.getElementById("selectOrderedFood").value;
   //   alert("pppppppppppppppppppppppppp : "+ para);
   		//opener에 있는 값과 입력값이 같으면 DB에 추가 안 되고(중복 입력 불가) 경고창 생성하기
//   		var openerData = opener.searchDuplData(selectedFood, num);
//    		console.log(openerData);
   		
   		
    	
        
        
}
	
	 
        
   
        
   


</script>

</head>
<body>

</body>
</html>