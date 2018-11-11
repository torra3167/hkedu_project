<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, category.*" %>
    
    <%
    	List list = (List)request.getAttribute("list");
    %>
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

<div class="container" style="max-width: 560px;">
        <form action="exercise_register.gom" enctype="multipart/form-data" method="post">
        <div class="form-group" >
        <select id="bca" name="exerciseCatBNumber" class="form-control"
        onclick="javascript:aca();"> 
		<% for(Object temp : list) {
	 	ExerciseCatB exerciseCatB = (ExerciseCatB)temp; %>
	 	<option value="<%=exerciseCatB.getExerciseCatBNumber() %>"> <%=exerciseCatB.getExerciseCatBName() %>
		</option>	 	
	<% } %>
	</select>
</div>

<div id="aca" class="form-group"></div>
			
        	
			<div class="form-group">
				<label>운동 사진 </label> <input type="file" multiple="multiple" name="exerciseFile" class="form-control">
			</div>
		<div class="form-group">
				<label>운동 영상</label> <input type="file" name="exerciseFile" class="form-control">
			</div> 
			
			<button type="submit" class="btn btn-primary">등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
</body>
</html>