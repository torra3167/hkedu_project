<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, category.*"%>

<%
		List list = (List)request.getAttribute("foodCat");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
 exerciseInfo = new Array(
	       
	      new Array(    
	      new Array(":::: 2차 분류 선택 ::::" ,-1 )   
	      ),
	       
	      new Array(    
	         new Array(":::: 2차 분류 선택 ::::" ,-1 ),
	         new Array("풀업", 1),
	         new Array("바벨로우",2),
	         new Array("랫풀다운", 3)
	        
	      ),
	         
	      new Array(
	         new Array(":::: 2차 분류 선택 ::::" ,-1 ),
	         new Array("밀리터리프레스", 1),
	         new Array("래터럴레이즈", 2),
	         new Array("업라이트로우", 3),
	      
	      ),
	       
	      new Array(
	         new Array(":::: 2차 분류 선택 ::::" ,-1 ), 
	         new Array("바벨컬", 1),
	         new Array("딥스", 2),
	         new Array("트라이셉스푸시다운", 3),
	       
	      ),   
	       
	      new Array(
	         new Array(":::: 2차 분류 선택 ::::" ,-1 ), 
	         new Array("벤치프레스", 1),
	         new Array("벤치플라이", 2),
	         new Array("인클라인벤치프레스", 3),
	        
	      ),
	         
	      new Array(
	         new Array(":::: 2차 분류 선택 ::::" ,-1 ), 
	         new Array("스쿼트", 1),
	         new Array("데드리프트", 2),
	         new Array("런지", 3),
	         
	         ),
	         
	      new Array(
	         new Array(":::: 2차 분류 선택 ::::" ,-1 ), 
	         new Array("크런치", 1),
	         new Array("플랭크", 2),
	         new Array("마운틴클라이머", 3),
	        
	         ),
	         
	      new Array(
	         new Array(":::: 2차 분류 선택 ::::" ,-1 ), 
	         new Array("달리기", 1),
	         new Array("걷기", 2),
	         new Array("사이클", 3),
	        
	         )
	     
	      
	   );

 
	function fillSelectFromArray1(selectCtrl, itemArray, goodPrompt, badPrompt, defaultItem) {
	   var i, j;
	   var prompt;
	   // empty existing items
	   var exerciseName1 = document.frm.exerciseName1.value;
	         for (i = selectCtrl.options.length; i >= 0; i--) {
	            selectCtrl.options[i] = null;
	         }
	         prompt = (itemArray != null) ? goodPrompt : badPrompt;
	         if (prompt == null) {
	            j = 0;
	         } else {
	            selectCtrl.options[0] = new Option(prompt);
	            j = 1;
	         }
	         if (itemArray != null) {
	            // add new items
	            for (i = 0; i < itemArray.length; i++) {
	               selectCtrl.options[j] = new Option(itemArray[i][0]);
	               if (itemArray[i][1] != null) {
	                  selectCtrl.options[j].value = exerciseName1 + "," +itemArray[i][0];
	               }
	               j++;
	            }
	            // select first item (prompt) for sub list
	            selectCtrl.options[0].selected = true;
	         }
	 
	}
	function test1(){ 
	   //alert(selIndex);
	   //text1=$("#exerciseName2").val().replace(/\s/g,""); //앞,뒤,중간 모든 공백 없앰 
	   text1=$("#exerciseName2").val();
/* 	   alert(text1);
 */	   text11 = text1.split(','); 
	   //alert(text11[0]);
	   //alert(text11[1]);
	   if(text11[1]==":::: 2차 분류 선택 ::::"){
	         return false;
	   }
	   var form = document.frm;
	   selIndex  = form.select_box2.length;
	   
	      for(i = 0 ; i<selIndex; i++){
	      //alert($("#select_box2 option:eq("+i+")").val());
	         if($("#select_box2 option:eq("+i+")").val() == text1 ){
	            return false;
	         }
	      }
	      if(text1.length > 0){   
	    	  $("#select_box2").append("<option value='"+text1+    "'  >"+text11[0] + " > " + text11[1]+"</option>");
	         document.frm.exerciseCatAName.value += text11[1] + "/"; 
	      }                     
	  
	   
	}
	function del1() {   
		
	    var selIndex = $("#select_box2 option").index($("#select_box2 option:selected")); //선택된 값의 index   
	    var hidden = document.getElementById('exerciseCatAName').value;
	    var exerciseIndex = $("#select_box2 option:eq("+selIndex+")").text()+"/";
	    alert($("#select_box2 option:eq("+selIndex+")").text());
	    document.frm.exerciseCatAName.value = hidden.replace(exerciseIndex, "");
	    $("#select_box2 option:eq("+selIndex+")").remove();   
	    	
	    /* alert(hidden);
	    alert(selIndex); */
	    
	    


	}
	
	function funcBca() {
		 var num = document.getElementById("FCC").value;
		 $.ajax({
			 type:"POST",
			 url:"bca.gom",
			 dataType:"html",
			 data:"foodCatCNo=" + num,
			 success: function(result) {
				 $('#divBca').html(result);
/* 				 $('#divAca').html("");
 */			 }
			 
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
					/* $('#divBca').html(); */	

				}
			});		
		}
	function selectedFood(val) {
		 var foodCategoryANum = document.getElementById('FCA').value;

		 $.ajax({
				type:"POST",
				url:"food_for_pro_food.gom",
				dataType:"html",
				data:"foodCategoryANum=" + foodCategoryANum,
				success:function(result){
					$('#selectedFood').html(result);
		

				}
			});		
	 
	 }
	 	
	
	 function valueAdd(val) {
		 var selectedFoodOne = $("#selectedFoodInput").text();
		 document.frm.foodNos.value += val.value + "/";
		 
		 var catANos = document.getElementById('foodNos').value;	
		 foodNames
		 document.frm.foodNames.value += selectedFoodOne + "/";

 		 alert(selectedFoodOne + '추가성공!');
	 }
	 
	 
	 
	
</script>	
</head>
<body>

	<div class="container" style="max-width: 560px;">
	
		<form name="frm" action="program_register.gom" enctype="multipart/form-data"
			method="post">
			<input type="text" name="exerciseCatAName" id="exerciseCatAName" value="" >
			 <div class="form-group">
                  
                     <select id="svSelect" class="form-control" name="exerciseName1" onChange="fillSelectFromArray1(this.form.exerciseName2,((this.selectedIndex == -1) ? null : exerciseInfo[this.selectedIndex]));">
                        <option value = -1>-- 1차 분류 선택 --</option>
                        <option value = 등  >등</option>
                        <option value = 어깨  >어깨</option>
                        <option value = 팔  >팔</option>
                        <option value = 가슴  >가슴</option>
                        <option value = 하체  >하체</option>
                        <option value = 복근  >복근</option>
                        <option value = 유산소 >유산소</option>
  					 </select>
  			</div>		 
            <div class="form-group">         
                     <select  class="form-control" name="exerciseName2" id="exerciseName2"  onChange="test1()" >
                        
                     </select>
            </div>	        
			<div class="form-group">
                     <select class="form-control" name="select_box2" id="select_box2" onChange="del1()"></select>
                     
          			 
            </div>                  
			<div class="form-group">
				<label>프로그램 이름</label> <input type="text" name="proName"
					class="form-control">
			</div>
			<div class="form-group">
				<label>프로그램 설명 </label> <input type="text" name="proContent"
					class="form-control">
			</div>
			
			<div class="form-group">
				<label>프로그램 가격 </label> <input type="text" name="proPrice"
					class="form-control">
			</div>
			<div class="form-group">
				<label>프로그램 사진 </label> <input type="file" name="proImg"
					class="form-control">
			</div>
			
			<div class="form-group">
				<label>프로그램 식품 </label> 
				
			</div>

			<div class="form-group">
                  
            <select id="FCC" name="foodCatCNo" onclick="javascript:funcBca();" class="form-control"> 
			  <% for(Object temp : list) {
					FoodCatC acar = (FoodCatC)temp; %>
				 	<option value="<%=acar.getFoodCatCNo() %>"> <%=acar.getFoodCatCName() %></option>
				<% } %> 
			</select>
  			</div>		 
            <div class="form-group" id="divBca" >         
                     <select class="form-control">
                        
                     </select>
            </div>	        
			<div class="form-group" id="divAca" >
                     <select class="form-control">
                     
                     </select>
                     
          			 
            </div>
            
            <div class="form-group" id="selectedFood" >
            <label>프로그램 식품 선택</label>
                     <select class="form-control">
                     
                     </select>
                     
          			 
            </div>    
            <div class="form-group"  >
            <label>선택된 프로그램 식품 </label>
                   <input type="text" id="foodNos" name="foodNos"  class="form-control"> 
                   <input type="text" id="foodNames" readonly="readonly" name="foodNames"  class="form-control"> 
                     
          			 
            </div>  
                

			<button type="submit" class="btn btn-primary">메뉴 등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
		</form>
	</div>
</body>
</html>