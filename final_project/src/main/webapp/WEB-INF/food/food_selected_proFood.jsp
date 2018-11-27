<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, model.Food, category.*" %>
<%
	List<Food> selectedFoodList = (List<Food>)session.getAttribute("selectedFoodList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>food_selected_for_proFood</title>
<script type="text/javascript">

	function valueAdd(val) {
	 var selectedFoodOne = document.getElementById("selectedFoodInput").value;
	 var splitedFood = selectedFoodOne.split(',');
	 
	 
	 
	 alert(selectedFoodOne);
	 document.frm.foodNos.value += splitedFood[0] + "/";
	 
	 var catANos = document.getElementById('foodNos').value;	
	
	 document.frm.foodNames.value += splitedFood[1] + "/";

	
}
</script>
</head>
<body>

<label>프로그램 식품 선택</label>
<select id="selectedFoodInput" name="selectedFoodInput" class="form-control" onchange="javascript:valueAdd(this);" >
<option value="">--선택하세요--</option>
<% for(Object o : selectedFoodList) { 
	Food food = (Food)o;
%>
	<option value="<%=food.getFoodNo() %>,<%=food.getFoodName()%>"> <%= food.getFoodName() %></option>
	
<% } %>
</select>
</body>
</html>