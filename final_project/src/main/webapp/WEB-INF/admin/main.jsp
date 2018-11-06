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
#tborder {
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
<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
  <link rel="stylesheet" href="css/1027.css">
  
   <script src="./js/jquery.min.js"></script>
   <script src="./js/popper.min.js"></script>
   <script src="./js/bootstrap.min.js"></script>
</head>
<body>

	
	<!-- <form name="frm" action="MemberLoginAction.sh"
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
	</form> -->
	
	<!-- 로그인 된 상태 -->
	<table align="center" border="0" width=80% id="tborder">
		<tr>
			<td colspan=2 align="center" id="border1">관리자메인페이지</td>
		</tr>
		<tr>
			<td align="center" id="border1">23132님 환영합니다.</td>
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
	
</body>
</html>