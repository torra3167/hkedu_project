<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String email = (String) session.getAttribute("email");
	Integer result = (Integer)request.getAttribute("result");
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
		<form action="sellerQnA.gom" method="post">

			<%
				if (result > 0) {
			%>
			<div right="left">
				<input type="hidden" name="email" value=<%=email%> readonly="true" />
			</div>
			<div>
				<label>제목</label> <input type="text" name="title" />
			</div>
			<div>
				<label>내용</label><br>
				<textarea cols="155" rows="20" name="contents" placeholder="입점 신청에 대한 문의를 작성해주세요. 문의 답변은 이메일을 통해 이루어집니다."></textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="전송" />
			<input type="reset" class="btn btn-secondary" value="다시 작성" />
		</form>
	</div>
	<%
		} else {
	%>
	<div class="right">
		판매자 메뉴입니다. 로그인해주세요.<br>
		<button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로 가기</button>
		<button type="button" class="btn btn-primary" onclick="location.href='login.gom'">로그인</button>
		<button type="button" class="btn btn-primary" onclick="index">메인으로</button>
	</div>
	<%
		}
	%>
</body>
</html>