<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, category.*" %>
    
    <%
    	List list = (List)request.getAttribute("list");
    %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous"> -->
	<script type="text/javascript" src="http://localhost:8080/final_project/js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="http://localhost:8080/final_project/js/jquery.form.js"></script>


<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>	 -->

<script type="text/javascript">


 function aca() {
	 var num = document.getElementById("bca").value;
	 alert("aaaa : " + num);
	 $.ajax({
		 type:"POST",
		 url:"aca.gom",
		 dataType:"html",
		 data:"exerciseCatBNumber=" + num,
		 success: function(result) {
			 alert("bbb")
			 $('#aca').html(result);
			 /* $('#cca').html(""); */
		 }
		 
	 });
 }
 
 
 
</script>	
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
        <form action="exercise_register.gom" enctype="multipart/form-data" method="post">
        <div>
        <select id="bca" name="bnum" onclick="javascript:aca();"> 
		<% for(Object temp : list) {
	 	ExerciseCatB exerciseCatB = (ExerciseCatB)temp; %>
	 	<option value="<%=exerciseCatB.getExerciseCatBNumber() %>"> <%=exerciseCatB.getExerciseCatBName() %>
		</option>	 	
	<% } %>
	</select>
</div>

<div id="aca"></div>

        	<div class="form-group">
				<label>운동 이름</label> <input type="text" name="exerciseName" class="form-control">
			</div>
			<div class="form-group">
				<label>운동 사진 </label> <input type="file" name="exerciseImg" class="form-control">
			</div>
			
			<div class="form-group">
				<label>운동 영상</label> <input type="file" name="exerciseVideo" class="form-control">
			</div>
			
			<button type="submit" class="btn btn-primary">메뉴 등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
</body>
</html>