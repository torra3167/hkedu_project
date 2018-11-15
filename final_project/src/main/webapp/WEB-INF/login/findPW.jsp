<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<body>

<div class="container">
	      <form:form commandName="emailCommand" action="findPW.gom">
	        <label>이메일</label>
	        <form:input path="memberEmail" class="form-control" placeholder="이메일" required="true" autofocus="true"/><br>
	        <label>이름</label>
	        <form:input path="memberName" class="form-control" placeholder="이름" required="true"/><hr>
	        <div class="btn">
	        <button class="btn btn-primary" type="submit">찾기</button>
	        <button class="btn btn-primary" type="button" onclick="history.go(-1);">뒤로가기</button>
	        </div>
	      </form:form>
    </div>
</body>
</html>