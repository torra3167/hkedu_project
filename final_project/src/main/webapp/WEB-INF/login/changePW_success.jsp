<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="command.FindIDCommand"%>
	
	<%
	String result=(String)request.getAttribute("result");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<link rel="stylesheet" href="css/custom-1.css">
<body>
	<%
		if(result == null){
	%>
	<div class="container">

		<div class="message">비밀번호 변경에 실패했습니다. 다시 시도해주세요.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로 가기</button>
			<button type="button" class="btn btn-primary" onclick="location.href='member_join.gom'">회원가입</button>
			<button type="button" class="btn btn-primary" onclick="index">메인으로</button>
		</div>
	</div>	
	<%} else{ %>
	<div class="container">

		<div class="message">비밀번호 변경이 완료되었습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary" onclick="location.href='findPW.gom'">비밀번호 찾기</button>
			<button type="button" class="btn btn-primary" onclick="location.href='login.gom'">로그인</button>
		</div>
	</div>
<%} %>
</body>