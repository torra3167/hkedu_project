<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Program"%>
	
	<%
    	List list = (List)request.getAttribute("Program");
		String email = (String)session.getAttribute("email");
    %>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

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
					<th>프로그램 내용</th>
					<th>프로그램 가격</th>
					<th>프로그램 리뷰</th>
					<th>프로그램 리뷰보기</th>
					
				<% 	if(email.equals("admin"))  { %>
					<th>신청서 검토상태</th>
				<% } %>
				</tr>
			</thead>
			<tbody>
				<% for(Object temp : list) {
				Program program = (Program)temp; %>


				<tr>
				
					<td><%=program.getProNo() %></td>
					<td><%=program.getCoachEmail() %></td>
					<td><a href="admin_program_detail.gom?proNo=<%=program.getProNo() %>
					&proContent=<%=program.getProContent()%>
					&proPrice=<%=program.getProPrice()%>
					&proStatus=<%=program.getProStatus()%>
					"><%=program.getProName() %>
					</a></td>
					<td><%=program.getProRegdate() %></td>
					<td><img src="resource\\<%=program.getProStored() %>" width="80" height="80"></td>
					<td><%=program.getProContent() %></td>
					<td><%=program.getProPrice() %></td>
					<td><a href="pro_review_write.gom?proNo=<%=program.getProNo() %>&coachEmail=<%=program.getCoachEmail() %>">리뷰작성</a></td>
					<td><a href="pro_review_list.gom?proNo=<%=program.getProNo() %>">리뷰확인하러가기</a></td>
					
					<% 	if(email.equals("admin"))  { %>
					<td><%=program.getProStatus() %></td>
				<% } %>
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