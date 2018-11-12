<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="command.FindIDCommand"%>
	
	<%
	String email=(String)request.getAttribute("findEmail");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<link rel="stylesheet" href="../css/custom-1.css">
<body>
	<%
		if(email == null){
	%>
	<div class="container">

		<div class="message">아이디가 존재하지 않습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로 가기</button>
			<button type="button" class="btn btn-primary" onclick="login.gom">로그인</button>
		</div>
	</div>	
	<%} else{ %>
	<div class="container">

		<div class="message">회원님의 아이디는 <%= email %>입니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary">비밀번호 찾기</button>
			<button type="button" class="btn btn-primary">로그인</button>
		</div>
	</div>
<%} %>
</body>