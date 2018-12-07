<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.ProReview"%>
    
    
    <%
    	List list = (List)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/program_review_list.css">
<script src="js/program_review_list.js" type="text/javascript"></script>
</head>
<body>
  <% for(Object temp : list) {
				ProReview proReview = (ProReview)temp; %>
<div class="container">
<div class="reviews">
  <div class="row blockquote review-item">
    <div class="col-md-3 text-center">
  
      <img class="rounded-circle reviewer" src="http://localhost:8080/final_project/resource/<%=proReview.getProReviewStored() %>" width="80" height="80">
      <div class="caption">
      
        <small>by <a href="pro_review_update.gom?proReviewNo=<%=proReview.getProReviewNo()%>
        &proReviewTitle=<%=proReview.getProReviewTitle()%>
        &proReviewScore=<%=proReview.getProReviewScore()%>
        &proReviewComment=<%=proReview.getProReviewComment()%>
        &proReviewOriginal=<%=proReview.getProReviewOriginal()%>
        ">
        <%=proReview.getMemberEmail() %></a></small>
      </div>

    </div>
    <div class="col-md-9">
      <h4><%=proReview.getProReviewTitle() %></h4>
      <div class="ratebox text-center" data-id="0" data-rating="5"></div>
      <p class="review-text">
      	<%=proReview.getProReviewComment() %>
      </p>

      <small class="review-date"><%=proReview.getProReviewRegdate() %></small>
      
      
      <a href="pro_review_report_write.gom?proReviewNo=<%=proReview.getProReviewNo()%>
      &memberEmail=<%=proReview.getMemberEmail() %>
      &proNo=<%=proReview.getProNo() %>
      &coachEmail=<%=proReview.getCoachEmail() %>
      "><button class="text-right btn btn-secondary">신고하기</button></a>
    </div>
    
      
  </div>  
  
  	</div>
</div>
  <% } %>
</body>
</html>