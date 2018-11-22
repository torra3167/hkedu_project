<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.SellerApplication"%>
<%
	List<SellerApplication> sellerApplicationList = (List<SellerApplication>)request.getAttribute("sellerApplicationList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입점신청서 게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body>

	<div class="container">
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>입점신청 번호</th>
					<th>판매업체 이름</th>
					<th>사업주 이름</th>
					<th>신청서 검토 상태</th>
				</tr>
			</thead>
			<%
				for(Object temp : sellerApplicationList){
					SellerApplication sellerApplication = (SellerApplication)temp;
			%>
			<tbody>
				<tr class="active">
					<th><a href="admin_sellerApplicationDetail.gom?sellerAppliNo=<%=sellerApplication.getSellerAppliNo() %>"><%=sellerApplication.getSellerAppliNo() %></a></th>
					<th><a href="admin_sellerApplicationDetail.gom?sellerAppliNo=<%=sellerApplication.getSellerAppliNo() %>"><%=sellerApplication.getStoreName() %></a></th>
					<th><a href="admin_sellerApplicationDetail.gom?sellerAppliNo=<%=sellerApplication.getSellerAppliNo() %>"><%=sellerApplication.getSellerName() %></a></th>
					<th><a href="admin_sellerApplicationDetail.gom?sellerAppliNo=<%=sellerApplication.getSellerAppliNo() %>"><%=sellerApplication.getApplicationStatus() %></a></th>
				</tr>
			</tbody>
			<%} %>
		</table>
		
		<hr>
		
		<div class="row justify-content-end ">
			<form method="get" action="./index.jsp" class="form-inline mt-3">
		        <select name="foodReviewReportDivide" class="form-control mx-1 mt-2">
		          <option value="foodReportWriter">작성자</option>
		          <option value="foodReportTitle">제목</option>
		          <option value="foodReportRegdate">등록일</option>
		        </select>
		        <input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요.">
		        <button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
			</form>
		</div>
		
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center mt-3">
					<li class="page-item"><a class="page-link" href="#">이전</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#">다음</a></li>
				</ul>
			</nav>
	
	</div>
</body>
</html>