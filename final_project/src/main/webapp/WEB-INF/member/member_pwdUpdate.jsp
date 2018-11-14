<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>      
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="container mt-3">
		<div class="board">
			<form:form commandName="member" action="member_pwdUpdate.gom" method="POST">
				<div class="form-group">
					<label>현재 비밀번호</label>
					<form:input path="memberPass" class="form-control" readonly="true" />
				</div>
					<label>변경할 비밀번호</label>
					<form:input path="memberPass" id="newPass" class="form-control"	readonly="true" />
					<label>변경할 비밀번호 체크</label>
					<input type="password" id="newPassChk" class="form-control">
				<button type="submit" class="btn btn-primary" onclick="location.href='login.gom'">로그인</button>
				<button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
			</form:form>
		</div>
	</div>
</body>
</html>