<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String email=(String)request.getAttribute("email"); %>

<!doctype html>

<html>
  <head>
    <title>설문지</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
  </head>

  <body>
    <div class="container mt-3">
      <form:form commandName="memberSurveyCommand">
      	<form:input path="memberEmail" type="hidden" value="<%= email %>"></form:input>
      	<div class="form-group">
          <label>성별</label>
          <form:select path="survSex" class="form-control">
                    <option value="" selected>--선택--</option>
                    <option value="여">여</option>
                    <option value="남">남</option>
          </form:select>
        </div>
      <div class="form-group">
          <label>나의 라이프스타일</label>
          <form:select path="survLifestyle" class="form-control">
                    <option value="" selected>--선택--</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
          </form:select>
        </div>
        <div class="form-group">
          <label>선호하는 체형</label>
          <form:select path="survShape" class="form-control">
                    <option value="" selected>--선택--</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
          </form:select>
        </div>
        <div class="form-group">
          <label>고려해야 할 질환</label><br>
          <form:textarea path="survDisease" rows="5" cols="155" placeholder="당뇨, 갑상선 질환 등 운동과 식단을 계획하는 데 고려해야 할 질환이 있다면 여기에 작성해주세요."></form:textarea>
        </div>
        <div class="form-group">
          <label>다이어트를 하는 데 가장 큰 걱정</label><br>
          <form:textarea path="survConcern" rows="5" cols="155" placeholder="불규칙한 식습관, 수면습관 등 다이어트를 하는 데 걱정이 있다면 여기에 작성해주세요."></form:textarea>
        </div>
        <div class="form-group">
          <label>지난 다이어트 실패 원인</label><br>
          <form:textarea path="survCause" rows="5" cols="155" placeholder="자신이 생각하는 지난 다이어트의 실패 원인을 여기에 작성해주세요."></form:textarea>
        </div>
        <div class="form-group"> 
          <label>과거 운동 경력</label><br>
          <form:textarea path="survCareer" rows="5" cols="155" placeholder="과거에 해본 운동이 있으면 여기에 작성해주세요."></form:textarea>
        </div>
        <div class="form-group">
        	<label>내 전신 사진 파일 업로드</label><br>
        	<form:input path="survPhoto" type="file"></form:input>
        </div>
        <div class="form-button">
        <button type="submit" class="btn btn-primary">제출하기</button>
        <button type="reset" class="btn btn-secondary">다시 작성</button>
        <button type="button" class="btn btn-secondary">뒤로가기</button>
        </div>
      </form:form>
    </div>
  </body>
</html>