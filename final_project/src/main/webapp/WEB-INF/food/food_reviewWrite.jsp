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
            <h5>식품리뷰 등록</h5>
          <div class="body">
            <form:form action="food_reviewWrite.gom" method="post" enctype="multipart/form-data" commandName="foodReviewWriteCommand">
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
<!-- <<<<<<< HEAD -->
                	<!-- <label>foodReviewOrderdate</label> -->
                	<form:hidden path="foodReviewRegdate" class="form-control"/>
<!-- ======= -->
<!-- >>>>>>> 867a84a10d52b8e8197eac8a00e2b5282705c69d -->
              <div class="row">
                <div class="col-sm-8">
                	<label>제목</label>
                	<form:input path="foodReviewTitle" class="form-control" maxlength="50"/>
              	</div>
              </div>
              <br>
              <div class="row">
	              <div class="col-sm-8">
	                <label>내용</label>
	                <form:textarea path="foodReviewComment" class="form-control" maxlength="2048" style="height: 180px;" />
	              </div>
              </div>
              <br>
              <div class="row">
	              <div class="col-sm-8">
	                <label>이미지</label>
	                <input type="file" name="foodReviewImage" class="form-control">
	              </div>
              </div>
              <br>
              <div class="row">
                <div class="col-sm-8">
                  <label>총점</label>
                  <form:select path="foodReviewScore" class="form-control">
                    <form:option value="★">★</form:option>
                    <form:option value="★★">★★</form:option>
                    <form:option value="★★★">★★★</form:option>
                    <form:option value="★★★★">★★★★</form:option>
                    <form:option value="★★★★★">★★★★★</form:option>
                  </form:select>
                </div>
              </div>
              <div class="row">
	              <div class="modal-footer col-sm-8">
	                <button type="submit" class="btn btn-primary">등록하기</button>
	                <button type="button" class="btn btn-secondary" onclick="history.go(-1);">뒤로가기</button>
	              </div>
              </div>
            </form:form>
          </div>
</div>
</body>
</html>