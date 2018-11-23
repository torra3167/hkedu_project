<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, category.*" %>
    
    <%
    	List exerciselist = (List)request.getAttribute("exerciselist");
    %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">


 function aca() {
	 var num = document.getElementById("bca").value;
/* 	 alert("aaaa : " + num); */
	 $.ajax({
		 type:"POST",
		 url:"aca.gom",
		 dataType:"html",
		 data:"exerciseCatBNumber=" + num,
		 success: function(result) {
/* 			 alert("bbb"); */
			 $('#aca').html(result);
			 /* $('#cca').html(""); */
		 }
		 
	 });
 }
 

 
</script>
	
</head>
<body>

<div class="container" style="max-width: 560px;">
        <form action="exercise_register.gom" enctype="multipart/form-data" method="post">

			<div class="form-group">
				<select name="exerciseCatBNumber" id="bca" class="form-control" onclick="javascript:aca();">
					<%
						for (Object temp : exerciselist) {
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
				<label>운동 사진 </label> <input type="file" multiple="multiple" name="uploadImage" class="form-control">
			</div>
			
			<div class="form-group">
				<label>운동 영상</label> <input type="file" name="uploadVideo" class="form-control">
			</div> 
			
			<div class="form-group">
				<label>운동 설명 </label> <input type="text" name="exerciseContent" class="form-control">
			</div>
		
			<button type="submit" class="btn btn-primary">등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
</body>
</html>