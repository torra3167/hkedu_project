<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*, model.*, category.*"%>

<%
 	List list = (List)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">


 function aca() {
	 var num = document.getElementById("bca").value;
/* 	 alert("aaaa : " + num);
 */	 $.ajax({
		 type:"POST",
		 url:"aca.gom",
		 dataType:"html",
		 data:"exerciseCatBNumber=" + num,
		 success: function(result) {
/* 			 alert("bbb")
 */			 $('#aca').html(result);
			 /* $('#cca').html(""); */
		 }
		 
	 });
 }
 

 
</script>	
</head>

<body>
	<div class="container mt-3" style="max-width: 560px;">
		<form:form commandName="uploadCommand" method="post"
			action="upload_update.gom" enctype="multipart/form-data">
			
			
	
			<div class="form-group">
				<label>업로드 번호</label>
				<form:input path="uploadNumber" class="form-control" />
			</div>
			<div class="form-group">
				<label>운동 번호</label>
				<form:input path="exerciseNumber" class="form-control" />
			</div>
			
			<div class="form-group">
				<select id="bca" name="exerciseCatBNumber" class="form-control"
					onclick="javascript:aca();">
					<%
						for (Object temp : list) {
								ExerciseCatB exerciseCatB = (ExerciseCatB) temp;
					%>
					<option value="<%=exerciseCatB.getExerciseCatBNumber()%>">
						<%=exerciseCatB.getExerciseCatBName()%>
					</option>
					<%
						}
					%>
				</select>
			</div>
			
			<div id="aca" class="form-group"></div>
			
			<div class="form-group">
				<label>변경할 운동 파일</label> <input type="file" name="uploadImage"
					class="form-control">
			</div>
			
			<div>
				<select id="FCC" name="foodCatCNo" onclick="javascript:funcBca();">
					<%
						for (Object temp : list) {
								FoodCatC acar = (FoodCatC) temp;
					%>
					<option value="<%=acar.getFoodCatCNo()%>">
						<%=acar.getFoodCatCName()%></option>
					<%
						}
					%>
				</select>
			</div>
			<div id="divBca"></div>
			<div id="divAca"></div>
			<div class="form-group">
				<label>식품 맛</label>
				<form:input path="foodFlavor" class="form-control" />
			</div>
			<div class="form-group">
				<label>판매할 식품 개수</label>
				<form:input path="foodQuant" class="form-control" />
			</div>
			<div class="form-group">
				<label>식품 유통기한</label>
				<form:input path="foodExpiryDate" class="form-control" />
			</div>
			<div class="form-group">
				<label>식품재료 원산지</label>
				<form:input path="foodOrigin" class="form-control" />
			</div>
			<div class="form-group">
				<label>식품 탄수화물 함량(g)</label>
				<form:input path="foodCarbo" class="form-control" />
			</div>
			<div class="form-group">
				<label>식품 단백질 함량(g)</label>
				<form:input path="foodProtein" class="form-control" />
			</div>
			<div class="form-group">
				<label>식품 지방 함량(g)</label>
				<form:input path="foodFat" class="form-control" />
			</div>
			<div class="form-group">
				<label>식품 칼로리(kcal)</label>
				<form:input path="foodCal" class="form-control" />
			</div>
			<button type="submit" class="btn btn-primary">수정 완료</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
			<button type="button" class="btn btn-primary"
				onclick="history.go(-1);">뒤로가기</button>
		</form:form>
	</div>

</body>
</html>