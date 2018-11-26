<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>

<html>
<head>
<title>회원가입</title>
<script type="text/javascript">
	function checkIt() {
		var frm = document.getElementById("memberRegister");
		if (!frm.memberEmail.value) {
			alert("이메일을 입력하세요");
			frm.memberEmail.focus();
			return false;
		}
		if (!frm.memberPass.value) {
			alert("비밀번호를 입력하세요");
			frm.memberPass.focus();
			return false;
		}
		if (!frm.memberName.value) {
			alert("이름을 입력하세요");
			frm.memberName.focus();
			return false;
		}
		if (!frm.memberPhone.value) {
			alert("연락처를 입력하세요");
			frm.memberPhone.focus();
			return false;
		}
		if (!frm.memberAddrNo.value) {
			alert("우편번호를 입력하세요");
			frm.memberAddrNo.focus();
			return false;
		}
		if (!frm.memberAddr1.value) {
			alert("주소를 입력하세요");
			frm.memberAddr1.focus();
			return false;
		}
		if (!frm.memberAddr2.value) {
			alert("상세주소를 입력하세요");
			frm.memberAddr2.focus();
			return false;
		}
		frm.submit();
	}
    </script>
</head>
<body>
	<div class="container mt-3">
		<div class="row jstify-content-center">
			<form:form commandName="memberJoinCommand" id="memberRegister">
				<div class="form-group">
					<label>이메일</label>
					<form:input path="memberEmail" type="email" class="form-control" id="memberEmail" />
					<div id="checkMsg"></div>
					<button type="button" id="checkbtn" class="btn btn-default" onclick="">중복확인</button>
				</div>
				<div class="form-group">
					<label>비밀번호</label>
					<form:input type="password" path="memberPass" id="memberPass" class="form-control" />
				</div>
				<div class="form-group">
					<label>이름</label>
					<form:input path="memberName" id="memberName" class="form-control" />
				</div>
				<div class="form-group">
					<label>연락처</label>
					<form:input path="memberPhone" id="memberPhone"	class="form-control" />
				</div>
				<div class="form-group">
					<!--             검색 기능을 표시할 <div>를 생성한다 -->
					<div id="postcodify" class="form-group"></div>

					<!--          주소와 우편번호를 입력할 <input>들을 생성하고 적당한 name과 id를 부여한다 -->
					<label>우편번호</label>
					<form:input path="memberAddrNo" id="memberAddrNo" class="form-control" value="" readonly="readonly" /><br /> 
					<label>기본주소</label>
					<form:input path="memberAddr1" id="memberAddr1"	class="form-control" value="" readonly="readonly" /><br />
					<label>상세주소</label>
					<form:input path="memberAddr2" id="memberAddr2" class="form-control" />
					<br />

					<!--          jQuery와 Postcodify를 로딩한다 -->
					<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
					<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>

					<!--          위에서 생성한 <div>에 검색 기능을 표시하고, 결과를 입력할 <input>들과 연동한다 -->
					<script>
						$(function() {
							$("#postcodify").postcodify({
								insertPostcode5 : "#memberAddrNo",
								insertAddress : "#memberAddr1",
								insertDetails : "#memberAddr2",
								hideOldAddresses : false
							});
						});
					</script>
				</div>
				<div>
					<form:input type="hidden" path="memberDivide" value="p" />
				</div>
				<div>
					<button type="button" class="btn btn-primary" onclick="checkIt()">회원가입</button>
					<button type="reset" class="btn btn-primary">다시 작성</button>
					<button type="button" class="btn btn-primary"
						onclick="history.go(-1);">뒤로가기</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>