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
	<div class="container ">
		<div class="row">
		<div class="col-12">
		<div class="signInBox">
			<form:form commandName="findIDCommand" id="findID" class="form-signin">
				<label>연락처</label>
				<form:input path="phone" class="form-control"	placeholder="연락처" required="true" autofocus="true" />
				<br>
				<label>이름</label>
				<form:input path="name" class="form-control" placeholder="이름" required="true" />
				<hr>
				<div class="btn text-center">
					<form:button class="btn btn-primary" onclick="checkID();">찾기</form:button>
					<form:button class="btn btn-primary" onclick="history.go(-1);">뒤로가기</form:button>
					<form:button class="btn btn-primary" onclick="location.href='findPW.gom'">비밀번호 찾기</form:button>
				</div>
			</form:form>
		</div>
		</div>
		</div>
	</div>
</body>
</html>