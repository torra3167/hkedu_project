<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.SimpleDateFormat, model.*, java.util.*"%>
<%
	String recDate = (String)request.getAttribute("dateText");
	System.out.println("recordMain : "+recDate);
%>

<%	
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
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
<script type="text/javascript">
var recordDate;
$(function() {
	$("#recordDate").datepicker({
		changeMonth: true, 
		changeYear: true,
		nextText: '다음 달',
		prevText: '이전 달' ,
		dateFormat: "yy년 mm월 dd일",
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
	
		onSelect: function(dateText, inst) {
// 		    alert('선택하신 날짜는'+dateText);
		    recordDate = dateText;
		   location.href="food_recordMain.gom?dateText="+recordDate;
		}
	});
});




</script>
</head>
<body>
<div class="container">
  <h2>My Diet Diary</h2>
  <p>매일 식단을 기록해서 회원님의 신장과 체중에 적합한 권장 열량과 섭취 열량을 비교할 수 있습니다.</p>
  <div class="row">
  <ul class="nav nav-pills">
    <li class="nav-item col">
      <input type="text" name="recordDate" id="recordDate" placeholder="<%=recDate%>"/>
    </li>
    <li class="nav-item col">
      <a class="nav-link" href="food_dietRecordList.gom?dateText=<%=recDate%>" style="width:200px;color:gray;border:1px solid;">섭취 칼로리 : 0 kcal <br> 권장 %</a>
    </li>
    <li class="nav-item col">
      <a class="nav-link" href="#마이페이지 정보변경(체중)으로" style="width:200px;color:gray;border:1px solid;">체중 : 67 kg<br>신장 : 177 cm</a>
    </li>
  </ul>
  </div>
</div>

<!-- ----------------------------------------------------------------------- -->
<div class="container">
  <h3>Diet Records</h3>
  <% if(dietRecordFoodList.size()==0){ %>
  <p>기록된 식단이 없습니다.</p>
  <% }else{%>
  <p>회원님이 기록하신 식단 기록입니다.</p>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th></th>
        <th>식품명</th>
        <th>탄수화물</th>
        <th>단백질</th>
        <th>지방</th>
        <th>칼로리</th>
        <th>개수</th>
      </tr>
    </thead>
  <% } %>
    <tbody>
      <% for(Object temp2 : breakfastList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
  	  %>
      <tr>
   		<th>아침식사</th>
   		<td><%=dietRecord.getFoodNutrientName() %></td>
        <td><%=dietRecord.getFoodCarbo() %>g</td>
        <td><%=dietRecord.getFoodProtein() %>g</td>
        <td><%=dietRecord.getFoodFat() %>g</td>
        <td><%=dietRecord.getFoodCal() %>kcal</td>
        <td><%=dietRecord.getFoodQuantity() %>개</td>
      </tr>  
   <%	} %>
    <tbody>
      <% for(Object temp2 : lunchList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
   	  %>
      <tr>
   		<th>점심식사</th>
   		<td><%=dietRecord.getFoodNutrientName() %></td>
        <td><%=dietRecord.getFoodCarbo() %>g</td>
        <td><%=dietRecord.getFoodProtein() %>g</td>
        <td><%=dietRecord.getFoodFat() %>g</td>
        <td><%=dietRecord.getFoodCal() %>kcal</td>
        <td><%=dietRecord.getFoodQuantity() %>개</td>
   	  </tr>
   <%	} %>
    <tbody>
      <% for(Object temp2 : dinnerList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
      %>
      <tr>
   		<th>저녁식사</th>
   		<td><%=dietRecord.getFoodNutrientName() %></td>
        <td><%=dietRecord.getFoodCarbo() %>g</td>
        <td><%=dietRecord.getFoodProtein() %>g</td>
        <td><%=dietRecord.getFoodFat() %>g</td>
        <td><%=dietRecord.getFoodCal() %>kcal</td>
        <td><%=dietRecord.getFoodQuantity() %>개</td>
      </tr>
   <%	} %>
    <tbody>
      <% for(Object temp2 : snackList){ 
	   DietRecordFood dietRecord = (DietRecordFood)temp2;
      %>
      <tr>
   		<th>간식</th>
   		<td><%=dietRecord.getFoodNutrientName() %></td>
        <td><%=dietRecord.getFoodCarbo() %>g</td>
        <td><%=dietRecord.getFoodProtein() %>g</td>
        <td><%=dietRecord.getFoodFat() %>g</td>
        <td><%=dietRecord.getFoodCal() %>kcal</td>
        <td><%=dietRecord.getFoodQuantity() %>개</td>
   	  </tr>
   <%	} %>
  </table>
</div>
</body>
</html>