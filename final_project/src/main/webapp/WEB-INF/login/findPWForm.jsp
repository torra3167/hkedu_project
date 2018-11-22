<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		var frm = document.getElementById("findID")
		if (!frm.memberPhone.value) {
			alert("연락처를 입력하세요.");
			frm.memberPhone.focus();
			return false;
		}
		if (!frm.memberName.value) {
			alert("이름을 입력하세요.");
			frm.memberName.focus();
			return false;
		}
		frm.submit();
	}
</script>
<body>
	<div class="container">

		<div class="signInBox">
			<form:form commandName="findIDCommand" id="findID" class="form-signin">
				<label>아이디</label>
				<form:input path="email" name="email" id="email" class="form-control" placeholder="아이디로 사용하는 이메일을 입력해주세요." required="true" autofocus="true" />
				<br>
				<label>연락처</label>
				<form:input path="phone" name="phone" id="phone" class="form-control" placeholder="가입 시 입력했던 연락처를 입력해주세요." required="true" />
				<hr>
				<div class="btn">
					<form:button class="btn btn-primary" onclick="checkID();">찾기</form:button>
					<form:button class="btn btn-primary" onclick="history.go(-1);">뒤로가기</form:button>
					<form:button class="btn btn-primary" onclick="location.href='findPW.gom'">비밀번호 찾기</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>