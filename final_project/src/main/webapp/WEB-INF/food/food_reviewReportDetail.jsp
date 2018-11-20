<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.FoodReviewReport"%>
<%
	FoodReviewReport foodReviewReport = (FoodReviewReport)request.getAttribute("foodReviewReport");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품리뷰신고 상세페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<div class="container">
	<div class="card bg-light mt-3">
	    <div class="card-header bg-light">
	      <div class="row">
	        <div class="col-7 text-left"><%=foodReviewReport.getFoodReportTitle() %></div>
	        <div class="col-2 text-right"><small><%=foodReviewReport.getFoodReportWriter() %></small></div>
	        <div class="col-2 text-right"><%=foodReviewReport.getFoodReportRegdate() %></div>
	      </div>
	    </div>
	    <div class="card-body">
	      <p class="card-text"><%=foodReviewReport.getFoodReportContent() %></p>
	    </div>
	    <div class="card-footer">
	      <div class="row">
	        <div class="col-12 text-center">
	        	<a href="#" class="card-link">삭제</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="#" class="card-link">목록으로</a>
	        </div>
	      </div>
	    </div>
	</div>
</div>
</body>
</html>