<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!doctype html>

<html>
  <head>
    <title>회원가입</title>
  </head>
  <body>
    <div class="container mt-3">
    <div class="row jstify-content-center">
      <form:form commandName="memberJoinCommand">
        <div class="form-group">
          <label>이메일</label>
          <form:input path="memberEmail" class="form-control"/>
          <button type="button" class="btn btn-primary" onclick="">중복 체크</button>
        </div>
        <div class="form-group">
          <label>비밀번호</label>
          <form:input path="memberPass" class="form-control"/>
        </div>
        <div class="form-group">
          <label>이름</label>
          <form:input path="memberName" class="form-control"/>
        </div>
        <div class="form-group">
          <label>연락처</label>
        <form:input path="memberPhone" class="form-control"/>
        </div>
        <div class="form-group">
          <label>우편번호</label>
          <form:input path="memberAddrNo" class="form-control"/>
          <button type="button" id="findPostNo" class="btn btn-primary">우편번호 찾기</button>
        </div>
        <div class="form-group">
          <label>기본주소</label>
         <form:input path="memberAddr1" class="form-control"/>
        </div>
        <div class="form-group">
          <label>상세주소</label>
         <form:input path="memberAddr2" class="form-control"/>
        </div>
        <div>
        <form:input type="hidden" path="memberDivide" value="p"/>
        </div>
        <div>
        <button type="submit" class="btn btn-primary">회원가입</button>
        <button type="reset" class="btn btn-primary">다시 작성</button>
        <button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
        </div>
      </form:form>
    </div>
    </div>
  </body>
</html>