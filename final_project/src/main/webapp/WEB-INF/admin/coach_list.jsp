<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Coach"%>
<%
	List<Coach> coachList = (List<Coach>) request.getAttribute("coachList");
	Integer result = (Integer) coachList.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코치 리스트</title>
</head>
<body>
	<table>
		<tr>
			<td colspan=3>코치 목록</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>삭제</td>
		</tr>
		<%
			if (result > 0) {
		%>
		<%
			for (Coach coach : coachList) {
		%>
		<tr>
			<td><a
				href="coach_detail.gom?email=<%=coach.getCoachEmail()%>"><%=coach.getCoachEmail()%></a></td>
			<td><%=coach.getCoachName()%></td>
			<td><a
				href="coach_delete.gom?email=<%=coach.getCoachEmail()%>">삭제</a></td>
		</tr>
		<%
			}
		%>
		<%
			} else if (result == 0 || result == null) {
		%>
		<tr>
			<td colspan="3">코치가 존재하지 않습니다.</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>