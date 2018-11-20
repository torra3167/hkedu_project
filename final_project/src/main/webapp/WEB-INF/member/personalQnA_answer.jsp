<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String receiver=(String)request.getAttribute("receiver");
	String id=(String)request.getAttribute("id");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대 1 문의하기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/custom-1.css">
</head>
<body>
<% if(id!="admin"){ %>
	<div class="container">
		관리자 메뉴입니다. 로그인 후 이용해주십시오.
		<button type="button" value="메인으로" class="btn btn-primary" onclick="location.href='index'">메인으로</button>
		<button type="button" value="로그인" class="btn btn-secondary" onclick="location.href='login.gom'">로그인</button>
	</div>
<%} else {%>
	<div class="container">
		<form action="personalQna_answer" method="post">
			<div right="left">
				<label>받는 사람</label>
				<input type="text" name="email" value=<%= receiver %> readonly="true"/><br>				
			</div>
			<hr>
			<div>
				<label>제목</label><br>
				<input type="text" name="title"/>
			</div>
			<div>
				<label>내용</label><br>
				<select>
					<option>
				</select>
				<textarea cols="155" rows="20" name="contents"></textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="전송"/>
			<input type="reset" class="btn btn-secondary" value="다시 작성"/>
		</form>
	</div>
<%} %>
</body>
</html>