<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%	Member member=(Member)request.getAttribute("member");
	String id=(String)request.getAttribute("id");%>
<!doctype html>
<html>
  <head>
    <title>회원정보 수정</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
  </head>
  <body>
<%-- <% if(id!="admin"){ %>
 	<div class="container mt-3">
 		<div class="board">
 			로그인해주십시오.
	        <button type="button" class="btn btn-primary" onclick="location.href='login.gom'" >로그인</button>
	        <button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
 		</div>
 	</div>
  <%} else { %> --%>
    <div class="row">
    <div class="container mt-3 col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4" >
    <form:form commandName="member" action="member_info.gom" method="POST">
        <div class="form-group">
          <label>이메일</label>
          <form:input path="memberEmail" class="form-control" value="${member.memberEmail}" readonly="true"/>
        </div>
        <div class="form-group">
          <label>이름</label>
          <form:input path="memberName" class="form-control" value="${ member.memberName }"/>
        </div>
        <div class="form-group">
          <label>연락처</label>
          <form:input path="memberPhone" class="form-control" value="${ member.memberPhone }"/>
        </div>
        <div class="form-group">
          <label>우편번호</label>
          <form:input path="memberAddrNo" class="form-control" value="${ member.memberAddrNo }"/>
        </div>
        <div class="form-group">
          <label>기본주소</label>
          <form:input path="memberAddr1" class="form-control" value="${ member.memberAddr1 }"/>
        </div>
        <div class="form-group">
          <label>상세주소</label>
          <form:input path="memberAddr2" class="form-control" value="${ member.memberAddr2 }"/>
          </div>
        <button type="submit" class="btn btn-primary" >정보 수정</button>
        <button type="button" class="btn btn-primary" onclick="location.href='member_list.gom'">리스트로</button>
    </form:form>
    </div>
    </div>
   
<%--     <% } %> --%>
  </body>
</html>