<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.Coach"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%	Coach coach=(Coach)request.getAttribute("coach");
	String id=(String)session.getAttribute("email");
	System.out.println();
	%>
<!doctype html>
<html>
  <head>
    <title>코치 정보 수정</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
  </head>
  <body>
<% if(!id.equals("admin")){ %>
 	<div class="container mt-3">
 		<div class="board">
 			로그인해주십시오.
	        <button type="button" class="btn btn-primary" onclick="location.href='login.gom'" >로그인</button>
	        <button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
 		</div>
 	</div>
  <%} else { %> 
    <div class="row">
    <div class="container mt-3 col-sm-6 col-md-4 col-sm-offset-3 col-md-offset-4" >
    <form:form commandName="coach" action="coach_detail.gom" method="POST">
        <div class="form-group">
          <label>이메일</label>
          <form:input path="coachEmail" class="form-control" value="${coach.coachEmail}" readonly="true"/>
        </div>
        <div class="form-group">
          <label>이름</label>
          <form:input path="coachName" class="form-control" value="${ coach.coachName }"/>
        </div>
        <div class="form-group">
          <label>비밀번호</label>
          <form:input path="coachPw" class="form-control" value="${ coach.coachPw }"/>
        </div>
        <div class="form-group">
          <label>경력</label>
          <form:input path="coachCareer" class="form-control" value="${ coach.coachCareer }"/>
        </div>
        <button type="submit" class="btn btn-primary" >정보 수정</button>
        <button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
    </form:form>
    </div>
    </div>
   
    <% } %>
  </body>
</html>