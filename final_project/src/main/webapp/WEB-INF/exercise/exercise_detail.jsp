<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import= "java.util.*, model.Exercise"%>
    
    <%
    	Exercise exercise = (Exercise)request.getAttribute("Exercise");
    %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
	<div><h3><strong>운동 정보수정</strong></h3></div>
	<br>
	<div class="container mt-3" >
    <form:form commandName="uploadCommand" action="exercise_detail.gom" method="POST">
        
        
        <div class="form-group">
          <label>운동 내용</label>
          <form:input path="exerciseContent" class="form-control"/>
        </div>
        
        <div class="form-group">
          <label>운동 칼로리</label>
          <form:input path="exerciseCal" class="form-control"/>
        </div>
        
        <%-- <div class="form-group">
          <label>운동 이미지</label>
          <form:input path="exercise" class="form-control" />
        </div>
        <div class="form-group">
          <label>운동 비디오</label>
          <form:input path="memberPhone" class="form-control" />
        </div> --%>
        
        <button type="submit" class="btn btn-primary" >정보 수정</button>
        <button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
    </form:form>
    </div>
    </div>
</body>
</html>