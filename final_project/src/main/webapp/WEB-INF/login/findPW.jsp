<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>

<script type="text/javascript">
	function checkID() {
		var frm = document.getElementById("findPW")
		if (!frm.email.value) {
			alert("이메일을 입력하세요.");
			frm.email.focus();
			return false;
		}
		if (!frm.phone.value) {
			alert("연락처를 입력하세요.");
			frm.phone.focus();
			return false;
		}
		frm.submit();
	}
</script>
<body>
	<div class="container">

		<div class="signInBox">
			<form:form commandName="findIDCommand" id="findPW" class="form-signin">
				<label>이메일</label>
				<form:input path="email" name="email" id="email" class="form-control" placeholder="아이디로 사용하는 이메일을 입력해주세요." required="true" autofocus="true" />
				<br>
				<label>연락처</label>
				<form:input path="phone" name="phone" id="phone" class="form-control" placeholder="회원가입 시 입력한 연락처를 입력해주세요." required="true" />
				<hr>
				<div class="btn">
					<form:button class="btn btn-primary" onclick="checkID();">찾기</form:button>
					<form:button class="btn btn-primary" onclick="history.go(-1);">뒤로가기</form:button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>