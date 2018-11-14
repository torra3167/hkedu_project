<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% String result=(String)request.getAttribute("result"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴하기</title>
</head>
<body>
<%if(result==null){ %>
	<div class="container">
		<div class="message">일치하는 회원정보가 없습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary">다시 입력</button>
			<button type="button" class="btn btn-primary">메인으로</button>
		</div>
	</div>
<% } else{ %>
	<div class="container">
		<div class="message">탈퇴가 완료되었습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary" onclick="location.href='index'">메인으로</button>
		</div>
	</div>
<% } %>


</body>