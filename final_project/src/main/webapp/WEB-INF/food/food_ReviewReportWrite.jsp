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
<!-- <link rel="stylesheet" href="../css/bootstrap.min.css"> -->
<!-- <script src="../js/jquery.min.js"></script> -->
<!-- <script src="../js/popper.min.js"></script> -->
<!-- <script src="../js/bootstrap.min.js"></script> -->
</head>    
<body>
<div class="container">
          <h5>식품리뷰 신고</h5>
          <div class="body">
            <form:form action="food_reviewReportWrite.gom" method="post" commandName="foodReviewReportWriteCommand">
              <div class="form-row">
                <div class="form-group col-sm-6">
                	<label>제목</label>
                	<form:input path="foodReportTitle" class="form-control" maxlength="40" />
              	</div>
              </div>
              <div class="form-group">
                <label>내용</label>
                <form:textarea path="foodReportContent" class="form-control" maxlength="2048" style="height: 180px;" />
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary">등록하기</button>
                <button type="button" class="btn btn-secondary">취소</button>
              </div>
            </form:form>
          </div>
</div>
</body>
</html>