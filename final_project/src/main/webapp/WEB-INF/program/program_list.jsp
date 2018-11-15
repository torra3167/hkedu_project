<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Program"%>
	
	<%
    	List list = (List)request.getAttribute("Program");
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
	<h1 class="">프로그램 리스트</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>프로그램 번호</th>
					<th>코치 이메일</th>
					<th>프로그램 이름</th>
					<th>프로그램 등록날짜</th>
					<th>프로그램 사진</th>
				</tr>
			</thead>
			<tbody>
			<% for(Object temp : list) {
				Program program = (Program)temp; %>
				<tr>
				
					<td><%=program.getProNo() %></td>
					<td><%=program.getCoachEmail() %></td>
					<td><a href="program_detail.gom?proNo=<%=program.getProNo() %>&proContent=<%=program.getProContent()%>"><%=program.getProName() %></a></td>
					<td><%=program.getProRegdate() %></td>
					<td><img src="http://localhost:8080/final_project/resource/<%=program.getProStored() %>" width="80" height="80"></td>
					
					
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