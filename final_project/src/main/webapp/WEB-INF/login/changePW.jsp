<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% String email=(String)request.getAttribute("email"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script type="text/javascript">
	function checkID() {
		var frm = document.getElementById("changePW")
		if (!frm.newPW.value) {
			alert("비밀번호를 입력하세요.");
			frm.newPW.focus();
			return false;
		}
		if (!frm.newPWchk.value) {
			alert("비밀번호 확인을 입력하세요.");
			frm.newPWchk.focus();
			return false;
		}
		frm.submit();
	}
</script>
<body>
	<div class="container">

		<div class="signInBox">
			<form:form commandName="changePWCommand" id="changePW" class="form-signin">
				<form:hidden path="email" value="<%= email %>"/>
				<label>새 비밀번호</label>
				<form:input path="newPW" name="newPW" id="newPW" class="form-control" placeholder="새 비밀번호를 입력해주세요." required="true" autofocus="true" />
				<br>
				<label>연락처</label>
				<form:input path="phone" name="phone" id="phone" class="form-control" placeholder="새 비밀번호 확인을 입력해주세요." required="true" />
				<hr>
				<div class="btn">
					<form:button class="btn btn-primary" onclick="checkID();">변경</form:button>
					<form:button class="btn btn-primary" onclick="location.href='index'">메인으로</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>