<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, category.FoodCatA" %>
<%
	List list = (List)request.getAttribute("foodCat");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function selectedFoodFun(val) {
	 var foodCategoryANum = document.getElementById('FCA').value;
	 
	 $.ajax({
			type:"POST",
			url:"food_for_pro_food.gom",
			dataType:"html",
			data:"foodCategoryANum="+foodCategoryANum,
			success:function(result){
				$('#selectedFood').html(result);
	
			}
		});		

}
</script>
</head>
<body>
<select id="FCA" name="foodCatANo" class="form-control" onchange="javascript:selectedFoodFun(this);"> <!-- onchange="javascript:selectedFood(this);" -->
<option value="">--선택하세요--</option>
<% for(Object o : list) { 
	FoodCatA ccar = (FoodCatA)o;
%>
	<option value="<%=ccar.getFoodCatANo() %>"> <%= ccar.getFoodCatAName() %></option>
<% } %>
</select>
</body>
</html>