<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.FoodReviewReport"%>
<%
	List<FoodReviewReport> foodReviewReports = (List<FoodReviewReport>)request.getAttribute("foodReviewReports");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품리뷰신고 게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body>

	<div class="container">
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>작성자</th>
					<th>제목</th>
					<th>등록일</th>
				</tr>
			</thead>
			<%
				for(Object temp : foodReviewReports){
				FoodReviewReport foodReviewReport = (FoodReviewReport)temp;
			%>
			<tbody>
				<tr class="active">
					<th><a href="food_reviewReportDetail.gom?foodReportRegdate=<%=foodReviewReport.getFoodReportRegdate() %>"><%=foodReviewReport.getFoodReportWriter() %></a></th>
					<th><a href="food_reviewReportDetail.gom?foodReportRegdate=<%=foodReviewReport.getFoodReportRegdate() %>"><%=foodReviewReport.getFoodReportTitle() %></a></th>
					<th><a href="food_reviewReportDetail.gom?foodReportRegdate=<%=foodReviewReport.getFoodReportRegdate() %>"><%=foodReviewReport.getFoodReportRegdate() %></a></th>
				</tr>
			</tbody>
			<%} %>
		</table>
		
		
		
			
	
	</div>
</body>
</html>