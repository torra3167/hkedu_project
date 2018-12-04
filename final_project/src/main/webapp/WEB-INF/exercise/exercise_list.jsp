<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.UploadExerciseCatA"%>
	
	<%
    	List list = (List)request.getAttribute("Upload");
    %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
]
<style type="text/css">
	h1 {
	text-align: cetner;
	}
</style>
</head>

<body>
	
	<div class="container">
	<h1 class="">운동 관리</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>운동 번호</th>
					<th>운동 이름</th>
					<th>운동 사이즈</th>
					<th>운동 파일명</th>
					<th>운동 구분</th>
				</tr>
			</thead>
			<tbody>
			<% for(Object temp : list) {
				UploadExerciseCatA upload = (UploadExerciseCatA)temp; %>
				<tr>
					
					
					
					<td><a href="exercise_detail.gom?exerciseNumber=<%=upload.getExerciseNumber() %>"><%=upload.getExerciseNumber() %></a></td>
					<td><%=upload.getExerciseCatAName() %></td>
					<td><%=upload.getUploadSize() %></td>
					
					<% if(upload.getUploadDivide().equals("i"))  {%>
					<td><img src="resource//<%=upload.getUploadStored() %>" width="240" height="150"></td>
						
					<%} %>
					
					<% if(upload.getUploadDivide().equals("v"))  {%>
					<td><video width="240"
						height="150" controls="controls" >
						<source src="resource//<%=upload.getUploadStored() %>" type="video/mp4" />
					</video>
					<%} %>	</td>
					<td><%=upload.getUploadDivide() %></td> 
					
				
					
				</tr>
				
				
				<% } %>
				
			</tbody>
		</table>

		<hr>

	</div>
</body>
</html>