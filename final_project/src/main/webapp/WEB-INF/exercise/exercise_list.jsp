<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Upload"%>
	
	<%
    	List list = (List)request.getAttribute("Upload");
    %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>


<link rel="stylesheet" href="#">


</head>

<body>
	
	<div class="container">
	<h1 class="">운동 관리</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>운동 번호</th>
					<th>운동 카테고리A</th>
					<th>운동 카테고리B</th>
					<th>운동 사이즈</th>
					<th>운동 오리지널</th>
					<th>운동 저장된</th>
					<th>운동 구분</th>
				</tr>
			</thead>
			<tbody>
			<% for(Object temp : list) {
				Upload upload = (Upload)temp; %>
				<tr>
					
					
					
					 <td><a href="exercise_detail.gom?exerciseNumber=<%=upload.getExerciseNumber() %>"><%=upload.getExerciseNumber() %></a></td>
					<td><%=upload.getExerciseCatANumber() %></td>
					<td><%=upload.getExerciseCatBNumber() %></td>
					<td><%=upload.getUploadSize() %></td>
					<td><%=upload.getUploadOriginal() %></td>
					<td><img src="http://localhost:8080/final_project/resource/<%=upload.getUploadStored() %>" width="80" height="80"></td>
					<td><%=upload.getUploadDivide() %></td> 
					
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