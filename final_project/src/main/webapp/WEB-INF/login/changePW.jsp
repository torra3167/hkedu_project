<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% String email=(String)request.getAttribute("email");
	String id=(String)request.getAttribute("id");
	System.out.println(email);
	System.out.println("id "+id);
	%>
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
		if (frm.newPW.value=="" || frm.newPW.value==null) {
			alert("비밀번호를 입력하세요.");
			frm.newPW.focus();
			return false;
		}
		if (frm.newPWchk.value=="" || frm.newPWchk.value==null) {
			alert("비밀번호 확인을 입력하세요.");
			frm.newPWchk.focus();
			return false;
		}
		if(frm.newPW.value!=frm.newPWchk.value){
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			frm.newPWchk.reset();
			return false;
		}
		frm.submit();
	}
</script>
<body>
	<div class="container">
		<div class="signInBox">
			<form id="changePW" action="changePW.gom?app=<%=email%>" method="POST" class="form-signin">
				<% if(id!=null&&id!=""){ %>
				<label>현재 비밀번호</label>
				<input name="nowPW" id="nowPW" class="form-control" placeholder="현재 비밀번호를 입력해주세요." required="true" />
				<%} %>
				<input type="hidden" name="email" id="email" value="<%= email %>"/>
				<label>새 비밀번호</label>
				<input type="text" name="newPW" id="newPW" class="form-control" placeholder="새 비밀번호를 입력해주세요." required="true" />
				<br>
				<label>새 비밀번호 확인</label>
				<input type="text" name="newPWchk" id="newPWchk" class="form-control" placeholder="새 비밀번호 확인을 입력해주세요." required="true" />
				<hr>
				<div class="btn">
					<button type="button" class="btn btn-primary" onclick="checkID();">변경</button>
					<button type="button" class="btn btn-primary" onclick="location.href='index'">메인으로</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>