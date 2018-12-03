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
					<th><a href="admin_sellerApplicationDetail.gom?sellerAppliNo=<%=sellerApplication.getSellerAppliNo() %>"><%=sellerApplication.getApplicationStatus() %></a></th>
				</tr>
			</tbody>
			<%} %>
		</table>
		
		<hr>
		
	</div>
</body>
</html>