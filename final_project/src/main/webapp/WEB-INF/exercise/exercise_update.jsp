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
		<form:form commandName="uploadUpdateCommand" method="post"
			action="upload_update.gom" enctype="multipart/form-data">
			
			<div class="form-group">
				<label>업로드 번호</label>
				<form:input path="uploadNumber" class="form-control" />
			</div>
			<div class="form-group">
				<label>운동 번호</label>
				<form:input path="exerciseNumber" class="form-control" />
			</div>
			
			
			
			
			
			
			<button type="submit" class="btn btn-primary">수정 완료</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
			<button type="button" class="btn btn-primary"
				onclick="history.go(-1);">뒤로가기</button>
		</form:form>
	</div>

</body>
</html>