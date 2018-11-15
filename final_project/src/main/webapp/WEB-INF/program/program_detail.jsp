<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.util.*, model.ProgramExercise, model.ExerciseUpload, model.Upload"%>
    
    <%
    List<ProgramExercise> programExerciseList = (List<ProgramExercise>)request.getAttribute("ProgramExercise");
    ExerciseUpload exerciseUploadList = (ExerciseUpload)request.getAttribute("ExerciseUpload");
    %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="container">
	<h1 class="">프로그램 운동리스트</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>프로그램 번호</th>
					<th>코치 이메일</th>
					<th>운동 번호</th>
					<th>운동카테고리A 번호</th>
					<th>운동카테고리B 번호</th>
				</tr>
			</thead>
			<tbody>
			<% for(Object temp : programExerciseList) {
				ProgramExercise programExercise = (ProgramExercise)temp; %>
				<tr>
				
					<td><a href="exercise_detail.gom?programNumber=<%=programExercise.getProNo() %>"><%=programExercise.getProNo() %></a></td>
					<td><%=programExercise.getCoachEmail() %></td>
					<td><%=programExercise.getExerciseNumber() %></td>
					<td><%=programExercise.getExerciseCatANumber() %></td>
					<td><%=programExercise.getExerciseCatBNumber() %></td>
			
					
					
				</tr>
				
				<% } %>
				
			</tbody>
		</table>

		<hr>

		<a class="btn btn-primary text-right" href="#" role="button">글쓰기</a>


		<nav aria-label="Page navigation example ">
			<ul class="pagination text-right">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>

	</div>
	
	<hr>
	
	<!--1: N  -->
	<div class="container">
	<h1 class="">프로그램+운동+업로드</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>프로그램 번호</th>
					<th>프로그램 내용</th>
					<th>운동 번호</th>
					<th>운동카테고리A 번호</th>
					<th>운동카테고리B 번호</th>
					<th>운동내용</th>
					<th>사이즈</th>
					<th>오리지널파일명</th>
					<th>저장파일명</th>
					<th>구분</th>
					<th>업로드번호</th>
					
				</tr>
			</thead>
			<tbody>
				
			<% for(Object temp : exerciseUploadList.getUploads()) {
				Upload exerciseUpload = (Upload)temp; %>
				<tr>
					<td><%=exerciseUploadList.getProNo() %></td>
					<td><%=exerciseUploadList.getProContent() %></td>
					<td><%=exerciseUpload.getExerciseNumber() %></td>				
					<td><%=exerciseUpload.getExerciseCatANumber() %></td>
					<td><%=exerciseUpload.getExerciseCatBNumber() %></td>
					<td><%=exerciseUploadList.getExerciseContent() %></td>
					<td><%=exerciseUpload.getUploadSize() %>
					<td><img src="http://localhost:8080/final_project/resource/<%=exerciseUpload.getUploadOriginal() %>" width="80" height="80"></td>					
					<td><%=exerciseUpload.getUploadStored() %></td>
					<td><%=exerciseUpload.getUploadDivide() %></td>
					
					<td><a href="exercise_detail.gom?programNumber=<%=exerciseUpload.getUploadNumber() %>"><%=exerciseUpload.getUploadNumber() %></a></td>
					
			
					
				</tr>
				
				<% } %>
				
			</tbody>
		</table>

		<hr>

		<a class="btn btn-primary text-right" href="#" role="button">글쓰기</a>


		<nav aria-label="Page navigation example ">
			<ul class="pagination text-right">
				<li class="page-item"><a class="page-link" href="#">Previous</a></li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">Next</a></li>
			</ul>
		</nav>

	</div>
</body>
</html>