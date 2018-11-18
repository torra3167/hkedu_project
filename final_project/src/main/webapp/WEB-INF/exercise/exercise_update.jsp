<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*, model.*, category.*, command.UploadUpdateCommand"%>

<%
 	List list = (List)request.getAttribute("list");
	UploadUpdateCommand uploadUpdateCommand = (UploadUpdateCommand)request.getAttribute("uploadUpdateCommand");
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
		<form:form commandName="uploadUpdateCommand" method="post"
			action="upload_update.gom" enctype="multipart/form-data">
			
			
			<div class="form-group">
				<label>운동 번호</label>
				<form:input path="exerciseNumber" class="form-control" readonly="true"/>
			</div>
			
			<div class="form-group">
				<label>운동 내용</label>
				<form:input path="exerciseContent" class="form-control" />
			</div>
			
			
					<div class="form-group">
					<label>운동 분류</label>
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
			
			
			
	 		<input type="hidden" name="uploadStored" value="<%=uploadUpdateCommand.getUploadStored()%>">
			<input type="hidden" name="proNo" value="<%=uploadUpdateCommand.getProNo()%>"> 
		
			
			
			<button type="submit" class="btn btn-primary">수정 완료</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
			<button type="button" class="btn btn-primary"
				onclick="history.go(-1);">뒤로가기</button>
		</form:form>
	</div>

</body>
</html>