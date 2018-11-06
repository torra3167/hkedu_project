<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String id = (String) session.getAttribute("ID");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
<style type="text/css">
#tborder {s
	border: 3px solid black;
	padding: 10px;
}

#border1 {
	border-bottom: 1px dotted black;
	padding: 10px;
}

#border2 {
	padding-top: 10px
}
</style>
</head>
<body>

	<%
		if (id == null) {
	%>
	<!-- 로그인 되지 않은 상태 -->
	<script type="text/javascript">
		function checkIt() {
			var frm = document.frm;
			if (!frm.memberId.value) {
				alert("아이디를 입력하세요.");
				frm.memberId.focus();
				return false;
			}
			if (!frm.memberPw.value) {
				alert("비밀번호를 입력하세요.");
				frm.memberPw.focus();
				return false;
			}
		}
	</script>
	<form name="frm" action="MemberLoginAction.sh"
		onSubmit="return checkIt();">
		<table border=3 align="center" width=30%>
			<tr>
				<td colspan="2" align=center><b><font size=5>로그인 페이지</font></b>
				</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="memberId" size="15" maxlength="10">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="memberPw" size="15"
					maxlength="10"></td>
			</tr>
			<tr>
				<td colspn=2 align="center"><input type="submit" name="Submit"
					value="로그인"> <input type="button" value="회원가입"
					onclick="javascript:window.location=
				 'MemberJoin.sh'" /></td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
	<!-- 로그인 된 상태 -->
	<table align="center" border="0" width=80% id="tborder">
		<tr>
			<td colspan=2 align="center" id="border1"><font size=5>메인페이지</td>
		</tr>
		<tr>
			<td align="center" id="border1"><%=id%>님 환영합니다.</td>
		</tr>
		<tr>
			<td colspan=2 align="center" id="border2">
				<form method="post" action="MemberLogoutAction.sh">
					<input type="submit" value="로그아웃">&nbsp;&nbsp; <input
						type="button" value="회원정보"
						onclick="javascript:window.location=
                   		'MemberUpdateAction.sh'" />&nbsp;&nbsp;
					<input type="button" value="회원리스트"
						onclick="javascript:window.location=
						'MemberListAction.sh'" />
				</form>
			</td>
		</tr>
	</table>
	<%
		}
	%>
</body>
</html>