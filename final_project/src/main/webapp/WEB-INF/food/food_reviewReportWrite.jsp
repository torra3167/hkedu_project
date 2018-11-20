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
</head>    
<body>
<div class="container">
          <h5>식품리뷰 신고</h5>
          <div class="body">
            <form:form action="food_reviewReportWrite.gom"  commandName="foodReviewReportWriteCommand">
            <!-- <label>foodReviewNo</label> -->
                	<form:hidden path="foodReviewNo" class="form-control"/>
            <!-- <label>memberEmail</label> -->
                	<form:hidden path="memberEmail" class="form-control"/>
            <!-- <label>foodNo</label> -->
                	<form:hidden path="foodNo" class="form-control"/>
            <!-- <label>sellerEmail</label> -->
                 	<form:hidden path="sellerEmail" class="form-control"/>
            <!-- <label>foodCatANo</label> -->
                	<form:hidden path="foodCatANo" class="form-control"/>
            <!-- <label>foodCatBNo</label> -->
                	<form:hidden path="foodCatBNo" class="form-control"/>
            <!-- <label>foodCatCNo</label> -->
                	<form:hidden path="foodCatCNo" class="form-control"/>
            <!-- <label>foodReportWriter</label> -->
                	<form:hidden path="foodReportWriter" class="form-control"/>  
              <div class="form-row">
                <div class="form-group col-sm-6">
                	<label>제목</label>
                	<form:input path="foodReportTitle" class="form-control" />
              	</div>
              </div>
              <div class="form-group">
                <label>내용</label>
                <form:textarea path="foodReportContent" class="form-control" style="height: 180px;" />
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary">등록하기</button>
                <button type="button" class="btn btn-secondary"onclick="history.go(-1);">취소</button>
              </div>
            </form:form>
          </div>
</div>
</body>
</html>