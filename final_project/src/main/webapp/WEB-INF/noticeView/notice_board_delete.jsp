<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
</head>
<style type="text/css">
a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: black;
	text-decoration: underline;
}

table {
	border: 1px solid black;
	margin-top: 50px;
	margin-bottom: 20px;
}

#border1 {
	border-top: 1px dotted black;
}
</style>
<body>
	<form name="deleteForm" action="./NoticeDeleteAction.sh" method="post">
		<input type="hidden" name="num" value="<%=num%>" />
		<table border=0 align="center" width="300px" height="100px">
			<tr>
				<td align=center><font size=3>글 비밀번호 : </font></td>
				<td><input name="NOTICE_PASS" type="password"></td>
			</tr>
			<tr>
				<td colspan=2 align=center id="border1"><a
					href="javascript:deleteForm.submit()">삭제</a>&nbsp;&nbsp; <a
					href="javascript:history.go(-1)">돌아가기</a></td>
			</tr>
		</table>
	</form>
</body>
</html>