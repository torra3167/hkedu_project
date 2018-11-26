<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.Member" %>
<%
	List<Member> memberList=(List<Member>)request.getAttribute("memberList");
	Integer result=memberList.size();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 리스트</title>
</head>
<body>
<table>
	<tr>
		<td colspan=3>회원 목록</td>
	</tr>
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>삭제</td>
	</tr>
	<%if(result>0){ %>
	<%
    		for(Member member:memberList){
    	%>
	<tr>
		<td><a href="member_detail.gom?email=<%= member.getMemberEmail() %>"><%= member.getMemberEmail() %></a></td>
		<td><%= member.getMemberName() %></td>
		<td>
			<a href="member_list_delete.gom?email=<%= member.getMemberEmail() %>">삭제</a>
		</td>
	</tr>
	<%} %>
	<%} else if(result==0||result==null){ %>
		<tr>
		<td colspan="3">회원이 존재하지 않습니다.</td>
	</tr>
	<%} %>
</table>
</body>
</html>