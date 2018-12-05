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
<div  id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
            <h5>식품리뷰 수정</h5>
            <button type="button" class="close" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="body">
            <form:form action="food_reviewUpdate.gom" method="post" enctype="multipart/form-data" commandName="foodReviewUpdateCommand">
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
                	<form:hidden path="foodCatCNo" class="form-control"/>
                	<!-- <label>foodReviewFoodName</label> -->
                	<form:hidden path="foodReviewFoodName" class="form-control"/>
              <div class="form-row">
                <div class="form-group col-sm-6">
                	<label>제목</label>
                	<form:input path="foodReviewTitle" class="form-control" maxlength="50"/>
              	</div>
              </div>
              <div class="form-group">
                <label>총평</label>
                <form:textarea path="foodReviewComment" class="form-control" maxlength="2048" style="height: 180px;" />
              </div>
              <div class="form-group">
                <label>이미지</label>
                <input type="file" name="foodReviewImage" class="form-control">
              </div>
              <div class="form-row">
                <div class="form-group col-sm-3">
                  <label>총점</label>
                  <form:select path="foodReviewScore" class="form-control">
                    <form:option value="1">★</form:option>
                    <form:option value="2">★★</form:option>
                    <form:option value="3">★★★</form:option>
                    <form:option value="4">★★★★</form:option>
                    <form:option value="5">★★★★★</form:option>
                  </form:select>
                </div>
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary">등록하기</button>
                <button type="button" class="btn btn-secondary" onclick="history.go(-1);">뒤로가기</button>
              </div>
            </form:form>
          </div>
</body>
</html>