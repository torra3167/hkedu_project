<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<script type="text/javascript">
	function modifynotice() {
		modifyform.submit();
	}
</script>
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

#tborder {
	margin-top: 10px;
	margin-bottom: 20px
}

#noticetd {
	padding: 20px
}
</style>
<body>
	<form action="NoticeModifyAction.sh" method="post" name="modifyform">
		<input type="hidden" name="NOTICE_NUM"
			value="">
		<table cellpadding="0" cellspacing="0" align="center" width=80%
			id="tborder">
			<tr align="center" valign="middle">
				<td colspan="5" id="noticetd"><font size=5>공지사항 게시판</td>
			</tr>
			<tr>
				<td height="16" style="font-family: 돋음; font-size: 12">
					<div align="center">제 목</div>
				</td>
				<td><input name="NOTICE_SUBJECT" size="50" maxlength="100"
					value=""></td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12">
					<div align="center">내 용</div>
				</td>
				<td><textarea name="NOTICE_CONTENT" cols="67" rows="15"></textarea>
				</td>
			</tr>
			<tr>
				<td style="font-family: 돋음; font-size: 12">
					<div align="center">파일 첨부</div>
				</td>
				<td>&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td height="16" style="font-family: 돋음; font-size: 12">
					<div align="center">비밀번호</div>
				</td>
				<td><input name="NOTICE_PASS" type="password"></td>
			</tr>

			<tr bgcolor="cccccc">
				<td colspan="2" style="height: 1px;"></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>

			<tr align="center" valign="middle">
				<td colspan="5"><font size=2> <a
						href="javascript:modifynotice()">[수정]</a>&nbsp;&nbsp; <a
						href="javascript:history.go(-1)">[뒤로]</a>&nbsp;&nbsp;
				</font></td>
			</tr>
		</table>
	</form>
</body>
</html>