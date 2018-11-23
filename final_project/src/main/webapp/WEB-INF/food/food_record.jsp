<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Food, java.util.*"%>

<%
	List<Food> foodList = (List<Food>)request.getAttribute("foodList");	//결제한 식품들정보
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식단&운동기록하기</title>
<script type="text/javascript">
function selectOrderedFood() {
// 	// 선택된 옵션의 index 구하기
// 	$("#셀렉트ID option").index($("#셀렉트ID option:selected"));


}

function delKeywordForm(thisCount){
	  /**
	    * 이 부분에는 추가될 부분의 div 이름을 넣으시면 됩니당
	   */   
	   var addedFormDiv = document.getElementById("addedKeyword");
	   if(count > 1){
	       var thisDiv = document.getElementById("keyword_Frm"+thisCount);
	        // 마지막으로 생성된 폼의 ID를 통해 Div객체를 가져옴
	       addedFormDiv.removeChild(thisDiv); // 폼 삭제 
	   }else{
	       document.addedFormDiv.reset(); // 폼 내용 삭제
	   }
	   count --;
	}


function addKeywordForm() {
	var count = 0;
	   var addedFormDiv = document.getElementById("addedKeyword");
	   var str = '<br><tr><td><input type="text" id="image_keyword'+count+'" class="records" name="image_keyword'+count+'"></td><td><input type="text" class="records">kcal</td><td><input type="text" class="records">g</td><td><input type="text" class="records">g</td><td><input type="text" class="records">g</td><td><button type="button" class="btn btn-primary" onclick="addKeywordForm()">항목 추가</button><button type="button" class="btn btn-danger" onclick="delKeywordForm('+count+')">항목 삭제</button></td></tr>';
		if (count <= 5) {
	  var addedDiv = document.createElement("div"); // 폼 생성
	   addedDiv.setAttribute("id", "keyword_Frm"+count);
	   addedDiv.innerHTML  = str; // 폼 Div안에 HTML삽입
	   addedFormDiv.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
		count++;
		} else {
			alert("Keyword는 5개까지 입력하실 수 있습니다.");
		}
	}




</script>
</head>
<body>
<!-- 식단기록하기 -->
<div class="container">
          <div class="body">
            <form action="#" method="post">
            <div class="form-row">
	            <div class="form-group col-sm-3">
	              <label>주문한 식품정보 가져오기</label>
	              <select class="form-control" id="orderedFoodList">
	              
	              	<%for(Object temp : foodList){ 
	              		Food food = (Food)temp;
	              	%>
	              	
	                <option value="<%=food.getFoodName() %>" selected><%=food.getFoodName() %></option>
	                <%} %>
	              </select>
	            </div>
           </div>
              <div class="record">
              	<button type="button" class="btn btn-primary">일반식 추가하기</button> <!-- 추가하기 누르면 table 추가되게 -->
              </div>
              <div class="record">
              <table>
              	<tr>
              		<td>식품 이름</td>
              		<td>칼로리</td>
              		<td>탄수화물</td>
              		<td>단백질</td>
              		<td>지방</td>
              	</tr>
              	<tr>
              		<td><input type="text" class="records"></td>
              		<td><input type="text" class="records">kcal</td>
              		<td><input type="text" class="records">g</td>
              		<td><input type="text" class="records">g</td>
              		<td><input type="text" class="records">g</td>
              		<td><button type="button" class="btn btn-primary" onclick="addKeywordForm()">항목 추가</button><button type="button" class="btn btn-danger" onclick="delKeywordForm()">항목 삭제</button></td>
              	</tr>
              	<div id="addedKeyword">
              	</div>
              </table>
              	<div id="addedKeyword">
              	</div>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="submit" class="btn btn-primary">등록하기</button>
              </div>
            </form>
          </div>
          </div>
          

          
          
</body>
</html> --%>