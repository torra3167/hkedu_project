<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴하기</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <link rel="stylesheet" href="../css/custom-1.css">
<body>
<div class="container">
		<div class="signInBox">
	      <form:form commandName="memberWithdrawal">
	        <label>비밀번호</label>
	        <form:input path="memberPass" type="password" class="form-control" placeholder="비밀번호" required=""/><hr>
	        <div class="btn">
	        <button class="btn btn-lg btn-primary" type="submit">탈퇴하기</button>
	        <button class="btn btn-lg btn-primary" type="button">뒤로가기</button>
	        </div>
	      </form:form>
		</div>
    </div>
</body>
</html>