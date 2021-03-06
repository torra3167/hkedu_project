<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- <link rel="stylesheet" href="http://localhost:8080/final_project/css/bootstrap.min.css"> -->
<!-- <script src="../js/jquery.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script> -->
</head>    
<body>
<div  id="container">
            <h5>식품리뷰 답변 수정</h5>
          <div class="body">
            <form:form action="food_reviewAnswerUpdate.gom" method="POST" commandName="foodReviewAnswerUpdateCommand">
            		<!-- <label>foodReviewAnswerNo</label> -->
                	<form:hidden path="foodReviewAnswerNo" class="form-control"/>
            		<!-- <label>memberEmail</label> -->
                	<form:hidden path="memberEmail" class="form-control"/>
            		<!-- <label>foodReviewNo</label> -->
                	<form:hidden path="foodReviewNo" class="form-control"/>
            		<!-- <label>FoodNo</label> -->
                	<form:hidden path="foodNo" class="form-control"/>
            		<!-- <label>SellerEmail</label> -->
                	<form:hidden path="sellerEmail" class="form-control"/>
                	<!-- <label>FoodCatANo</label> -->
                	<form:hidden path="foodCatANo" class="form-control"/>
                	<!-- <label>FoodCatBNo</label> -->
                	<form:hidden path="foodCatBNo" class="form-control"/>
                	<!-- <label>FoodCatCNo</label> -->
                	
              <div class="form-group">
                <label>내용</label>
                <form:textarea path="foodReviewAnswerContent" class="form-control" maxlength="2048" style="height: 180px;" />
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary">등록하기</button>
                <button type="button" class="btn btn-secondary" onclick="history.go(-1);">뒤로가기</button>
              </div>
            </form:form>
          </div>
</div>
</body>
</html>