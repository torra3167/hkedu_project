<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>


<%-- <% 
	String id = (String)session.getAttribute("ID");
%> --%>
<%-- <%
	int nowpage = ((Integer) request.getAttribute("page")).intValue();
	int maxpage = (Integer) request.getAttribute("maxpage");
	int startpage = (Integer) request.getAttribute("startpage");
	int endpage = (Integer) request.getAttribute("endpage");
	int listcount = (Integer) request.getAttribute("listcount");
	List noticeList = (List) request.getAttribute("noticelist");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<style type="text/css">
table {
	border-bottom: 3px solid black;
	margin-bottom: 20px;
}

#border {
	border-top: 1px solid black;
	border-bottom: 1px solid black;
	padding: 5px;
}

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

#border2 {
	border-top: 1px dotted black;
	padding: 10px;
}

#border3 {
	border-top: 1px dotted black;
	padding: 20px;
}

#tborder {
	margin-top: 10px;
	margin-bottom: 20px
}

#noticetd {
	padding-bottom: 20px;
}

#border4 {
	padding: 10px;
}
</style>
</head>
<body>
	<table width=80% border="0" cellpadding="0" cellspacing="0"
		align="center" id="tborder">
		
		<tr align="center" valign="middle">
			<td colspan="4" align="center" id="noticetd"><font size=5>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					공지사항 게시판</td>
			<td align=right><font size=3>글 개수 : ${listcount }</font></td>
		</tr>

		<tr align="center" valign="middle" bordercolor="#333333">
			<td style="font-family: Tahoma; font-size: 10pt;" width="8%"
				height="26">
				<div id="border" align="center">번호</div>
			</td>
			<td style="font-family: Tahoma; font-size: 10pt;" width="50%">
				<div id="border" align="center">제목</div>
			</td>
			<td style="font-family: Tahoma; font-size: 10pt;" width="14%">
				<div id="border" align="center">작성자</div>
			</td>
			<td style="font-family: Tahoma; font-size: 10pt;" width="17%">
				<div id="border" align="center">날짜</div>
			</td>
			<td style="font-family: Tahoma; font-size: 10pt;" width="11%">
				<div id="border" align="center">조회수</div>
			</td>
		</tr>
	
		<tr>
			<td align="center" id="border4"></td>
			<td><a href="./NoticeDetailAction.sh?num="></a>
			</td>
			<td align="center"><</td>
			<td align="center"></td>
			<td align="center"></td>
		</tr>
		

		<tr align=center height=20>
			<td colspan=7 style="font-family: Tahoma; font-size: 10pt;"
				id="border2">
				 [이전] [다음]  
 	

			</td>
		</tr>
		
		<td colspan="5" align=right><input type="button" value="글쓰기"
			onclick="location.href='./NoticeWrite.sh'" /></td>
		
	</table>
	
	<table width=80% border="0" cellpadding="0" cellspacing="0"
		align="center">
		<tr align="center" valign="middle">
			<td colspan="4" id="noticetd"><font size=5>공지사항 게시판</td>
		</tr>
		<tr>
			<td align=left id="border3"><font size=3>등록된 글이 없습니다.</font></td>
		</tr>
		<tr align="right">
			
			<td colspan="5"><input type="button" value="글쓰기"
				onclick="location.href='./NoticeWrite.sh'" /></td>
			
		</tr>
	</table>
	
</body>
</html>