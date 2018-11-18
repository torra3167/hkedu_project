<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, 
    model.ProgramExerciseUpload, command.ProgramDetailCommand"%>

<%
	List<ProgramExerciseUpload> programExerciseUploadList = (List<ProgramExerciseUpload>) request
			.getAttribute("ProgramExerciseUpload");

	ProgramDetailCommand programDetailCommand = (ProgramDetailCommand) request
			.getAttribute("ProgramDetailCommand");
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!--1: N  -->
	<div class="container mt-3">
		<h1>프로그램+운동+업로드</h1>
		<table class="table table-striped text-center">
			<tr>
				<th>프로그램 번호</th>
				<th>프로그램 내용</th>
			</tr>

			<tr class="active">
				<td><%=programDetailCommand.getProNo()%></td>
				<td><%=programDetailCommand.getProContent()%></td>
			</tr>
		</table>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">

					<th>운동 번호</th>
					<th>운동내용</th>
					<th>운동카테고리A 번호</th>
					<th>운동카테고리B 번호</th>
					<th>업로드번호</th>
					<th>사이즈</th>
					<th>저장파일명</th>
					<th>오리지널파일명</th>
					<th>구분</th>

				</tr>
			</thead>
			<tbody>
				<tr>
				<%
					for (Object temp : programExerciseUploadList) {
						ProgramExerciseUpload programexerciseUpload = (ProgramExerciseUpload) temp;
				%>

				<td><%=programexerciseUpload.getExerciseNumber()%></td>
				<td><%=programexerciseUpload.getExerciseContent()%></td>
				<td><%=programexerciseUpload.getExerciseCatANumber()%></td>
				<td><%=programexerciseUpload.getExerciseCatBNumber()%></td>
				<td><a
					href="upload_update.gom?proNo=<%=programDetailCommand.getProNo()%>
					&uploadNumber=<%=programexerciseUpload.getUploadNumber()%>
					&exerciseNumber=<%=programexerciseUpload.getExerciseNumber()%>
					&exerciseContent=<%=programexerciseUpload.getExerciseContent()%>
					&exerciseCatANumber=<%=programexerciseUpload.getExerciseCatANumber()%>
					&exerciseCatBNumber=<%=programexerciseUpload.getExerciseCatBNumber()%>
					&uploadStored=<%=programexerciseUpload.getUploadStored()%>					
					&uploadOriginal=<%=programexerciseUpload.getUploadOriginal()%>
					">
					<%=programexerciseUpload.getUploadNumber()%></a>
				</td>
				<td><%=programexerciseUpload.getUploadSize()%></td>
				<td><img
					src="http://localhost:8080/final_project/resource/<%=programexerciseUpload.getUploadStored()%>"
					width="80" height="80"></td>
				<td><%=programexerciseUpload.getUploadOriginal()%></td>
				<td><%=programexerciseUpload.getUploadDivide()%></td>
				</tr>

				<%
					}
				%>

			</tbody>
		</table>

		<hr>

		
		