<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String receiver=(String)request.getAttribute("receiver");
	String id=(String)session.getAttribute("email");
	System.out.println("jsp "+id);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대 1 문의하기</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/custom-1.css">
</head>
<body>
	<% if(id.equals("admin")){ %>
 	<div class="container">
		<form action="personalQna_answer.gom" method="post">
			<div right="left">
			<input type="hidden" name="sender" value="<%= id %>"/>
				<label>받는 사람</label>
				<input type="text" name="email" value=<%= receiver %> readonly="true"/><br>	
			</div>
			<hr>
			<div>
				<label>제목</label>
				<input type="text" class="titleBox" name="title" value="Re : <%= receiver %>님께서 문의하신 내용에 대한 답변입니다."/><br>
			</div>
			<div>
				<label>내용</label><br>
				<textarea rows="20" cols="155" name="contents"></textarea>
				<!-- <textarea class="autoSize" onkeydown="resize(this)" onkeyup="resize(this)" name="contents"></textarea>
				<script>
					function resize(obj) {
					  obj.style.height = "1px";
					  obj.style.height = (12+obj.scrollHeight)+"px";
					}
				</script> -->
			</div>
			<input type="submit" class="btn btn-primary" value="전송"/>
			<input type="reset" class="btn btn-secondary" value="다시 작성"/>
		</form>	
	</div>
 <%} else {%>
 <div class="container">
		관리자 메뉴입니다. 로그인 후 이용해주십시오.<br>
		<button type="button" value="메인으로" class="btn btn-primary" onclick="location.href='index'">메인으로</button>
		<button type="button" value="로그인" class="btn btn-secondary" onclick="location.href='login.gom'">로그인</button>
	</div>
  <%} %>
</body>
</html>