<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String email=(String)session.getAttribute("email");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1대 1 문의하기</title>
<meta charset="utf-8">
<link rel="stylesheet" href="css/custom-1.css">
</head>
<body>

	<div class="container">
		<form action="personalQna.gom" method="post">
			<%if(email==null){ %>
				<div class="text-left"><p>문의 답변을 받을 이메일을 작성해주세요.</p></div>
			<%} else { %>
				<div class="text-left"><p>다른 주소로 문의를 전송하시려면 이메일 주소를 작성해주세요.</p></div>
			<%}%>
			<div right="left">
			
<%-- 				<input type="hidden" name="email" value=<%= email %> readonly="true"/>
 --%>
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-envelope"></i>
						</span>
					</div>
					<input type="email" class="form-control" name="sender"
						value="<%=email%>"><br>
				</div>


			</div>
			<hr>
			<div>
				<label>제목</label>
				<input type="text" class="form-control"  name="title"/>
			</div>
			<div>
				<label>내용</label><br>
				<textarea cols="135" rows="20" name="contents" class="form-control"></textarea>
			</div>
			<br>
			<input type="submit" class="btn btn-primary" value="전송"/>
			<input type="reset" class="btn btn-secondary" value="다시 작성"/>
		</form>
	</div>
</body>
</html>