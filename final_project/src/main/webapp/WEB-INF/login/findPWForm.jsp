<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% String email=(String)session.getAttribute("email");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대 1 문의하기</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/custom-1.css">
</head>
<body>

	<div class="container">
		<form action="personalQna.gom" method="post">
			
			<%if(email==null){ %>
				<div class="right">문의 답변을 받을 이메일을 작성해주세요.</div>
			<%} else { %>
				<div class="right div-text-min">다른 주소로 문의를 전송하시려면 이메일 주소를 작성해주세요.</div>
			<%}%>
			<div right="left">
				<input type="hidden" name="email" value=<%= email %> readonly="true"/>
				<label>보내는 사람</label>
				<input type="email" name="sender"><br>
				
			</div>
			<hr>
			<div>
				<label>제목</label>
				<input type="text" name="title"/>
			</div>
			<div>
				<label>내용</label><br>
				<textarea cols="155" rows="20" name="contents"></textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="전송"/>
			<input type="reset" class="btn btn-secondary" value="다시 작성"/>
		</form>
	</div>
</body>
</html>