<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Exercise"%>
	
	<%
    	List list = (List)request.getAttribute("Exercise");
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
				Exercise exercise = (Exercise)temp; %>
				<tr>
					<%-- <th>${exerciseCatANumber }</th>
					<th>${exerciseCatBNumber }</th>
					<th>${exerciseNumber}</th>
					<th>${exerciseSize }</th>
					<th>${exerciseOriginal }</th>
					<th>${exerciseStored }</th>
					<th>${exerciseDivide }</th>  --%>
					
					
					 <td><a href="exercise_detail.gom?exerciseNumber=<%=exercise.getExerciseNumber() %>"><%=exercise.getExerciseNumber() %></a></td>
					<td><%=exercise.getExerciseCatANumber() %></td>
					<td><%=exercise.getExerciseCatBNumber() %></td>
					<td><%=exercise.getExerciseSize() %></td>
					<td><%=exercise.getExerciseOriginal() %></td>
					<td><img src="./resource/<%=exercise.getExerciseStored()%>" width="40" height="40"></td>
					<td><%=exercise.getExerciseDivide() %></td> 
					
					
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