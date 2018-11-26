<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Integer i = (Integer) request.getAttribute("result");
	String id=(String)session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보 수정</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/custom-1.css">
</head>
<body>
	<% if (i <= 0) { %>
	<div class="container">
		<div class="board">
			<div class="ment">
				수정이 정상적으로 완료되지 않았습니다. 다시 한 번 확인해주세요. 이 문제가 계속 발생한다면 고객센터에서 문의해주세요.<br>
			</div>
			<div class="btn">
				<button type="button" class="btn btn-primary" onclick="location.href='index'">메인으로</button>
				<button type="button" class="btn btn-primary" onclick="location.href='coach_list.gom'">리스트로</button>
			</div>
		</div>
	</div>
	<% } else { %>
	<div class="container">
		<div class="board">
			<div class="ment">
				수정이 완료되었습니다.<br>
			</div>
			<div class="btn">
				<button type="button" class="btn btn-primary" onclick="location.href='index'">메인으로</button>
				<button type="button" class="btn btn-primary" onclick="location.href='coach_list.gom'">리스트로</button>
			</div>
		</div>
	</div>
	<% } %>
</body>
</html>