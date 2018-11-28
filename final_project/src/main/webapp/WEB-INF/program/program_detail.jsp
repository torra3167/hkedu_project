<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, category.ExerciseCatACatB,
    model.ProgramExerciseUpload, command.ProgramDetailCommand"%>

<%
	request.setCharacterEncoding("utf-8");
	List<ProgramExerciseUpload> programExerciseUploadList = 
	(List<ProgramExerciseUpload>) request.getAttribute("ProgramExerciseUpload");
	String email = (String)session.getAttribute("email");
	ProgramDetailCommand programDetailCommand = (ProgramDetailCommand) request.getAttribute("ProgramDetailCommand");
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function rejectFunction() {
	
	var inputString = prompt('반려 이유를 작성해주세요', '반려이유');
	location.href="program_reject.gom?proNo=<%=programDetailCommand.getProNo()%>&proDes=" + inputString;
	
	}
</script>


</head>
<body>
	<!--1: N  -->
	<div class="container mt-3">
		<h1>프로그램+운동+업로드</h1>
		<table class="table table-striped text-center">
			<tr>
				<th>프로그램 번호</th>
				<th>프로그램 내용</th>
				<th>가격</th>
				<th>장바구니</th>
				<% 	if((email.equals("admin") && programDetailCommand.getProStatus().equals("대기")) || (email.equals("admin") && programDetailCommand.getProStatus().equals("거절"))) { %>
				<th><a href="program_approve.gom?proNo=<%=programDetailCommand.getProNo()%>"><button class="btn btn-primary">승인</button></a></th>
				
				
				<%  } %>
				
			</tr>

			<tr class="active">
				<td><%=programDetailCommand.getProNo()%></td>
				<td><%=programDetailCommand.getProContent()%></td>	
		        <td>가격: <%=programDetailCommand.getProPrice() %></td>
		        <form action="program_cart_addlist.gom" method="post">
				<td><button type="submit" class="btn btn-primary">장바구니 담기</button><td>
				
 				<input type="hidden" name="proNo" value="<%=programDetailCommand.getProNo() %>">
 				</form>
				<% 	if(email.equals("admin") && programDetailCommand.getProStatus().equals("대기"))  { %> 
				<td>
				<button class="btn btn-primary" onclick="rejectFunction();">반려</button></td>	
				<% } %>
		        
				
		</tr>
		</table>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">

					<th>운동 번호</th>
					<th>운동내용</th>
					<th>운동칼로리</th>
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
					<td><a
						href="exercise_update.gom?exerciseNumber=<%=programexerciseUpload.getExerciseNumber()%>
				&exerciseContent=<%=programexerciseUpload.getExerciseContent()%>
				&exerciseCatANumber=<%=programexerciseUpload.getExerciseCatANumber()%>
				&exerciseCatBNumber=<%=programexerciseUpload.getExerciseCatBNumber()%>
				&exerciseCal=<%=programexerciseUpload.getExerciseCal()%>">
				<%=programexerciseUpload.getExerciseContent()%></a></td>
					<td><%=programexerciseUpload.getExerciseCal()%></td>				
 					<td><%=programexerciseUpload.getExerciseCatANumber()%></td>
					<td><%=programexerciseUpload.getExerciseCatBNumber()%></td>
					<td><%=programexerciseUpload.getUploadNumber()%></td>
					<td><%=programexerciseUpload.getUploadSize()%></td>
					<td><a
						href="upload_update.gom?proNo=<%=programDetailCommand.getProNo()%>
					&uploadNumber=<%=programexerciseUpload.getUploadNumber()%>
					&exerciseNumber=<%=programexerciseUpload.getExerciseNumber()%>
					&exerciseContent=<%=programexerciseUpload.getExerciseContent()%>
					&exerciseCatANumber=<%=programexerciseUpload.getExerciseCatANumber()%>
					&exerciseCatBNumber=<%=programexerciseUpload.getExerciseCatBNumber()%>
					&uploadStored=<%=programexerciseUpload.getUploadStored()%>					
					&uploadOriginal=<%=programexerciseUpload.getUploadOriginal()%>
					"><img
							src="http://localhost:8080/final_project/resource/<%=programexerciseUpload.getUploadStored()%>"
							width="80" height="80"></a></td>
					<td><%=programexerciseUpload.getUploadOriginal()%></td>
					<td><%=programexerciseUpload.getUploadDivide()%></td>
				

				
				</tr>
				<%
					}
				%>

			</tbody>
		</table>

		<hr>