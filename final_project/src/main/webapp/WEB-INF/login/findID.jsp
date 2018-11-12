<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- function : 자동 로그인, 이메일/비밀번호 공란 체크 -->
<script type="text/javascript">
function checkID(){
	var frm=document.getElementById("findID")
	if(!frm.memberPhone.value){
		alert("연락처를 입력하세요.");
		frm.memberPhone.focus();
		return false;
	}
	if(!frm.memberName.value){
		alert("이름을 입력하세요.");
		frm.memberName.focus();
		return false;
	}
	frm.submit();
}
</script>
<body>

<% 
	String str=(String)request.getAttribute("findIDComment");
	if(str!=null&&str.equals("아이디가 없습니다.")){
		out.print(str+" 다시 확인해주세요.");
	}
%>
<%
	if(str!=null&&!str.equals("아이디가 없습니다.")){
		out.print("아이디는 "+str+" 입니다.");
		out.print("<button type='button' class='btn btn-primary'>메인으로</button>");
	}else{
%>


<div class="container">

		<div class="signInBox">
	      <form:form commandName="findIDCommand" id="findID" class="form-signin">
	        <label>연락처</label>
	        <form:input path="memberPhone"  class="form-control" placeholder="연락처" required="" autofocus=""/><br>
	        <label>이름</label>
	        <form:input path="memberName"  class="form-control" placeholder="이름" required=""/><hr>
	        <div class="btn">
	        <button class="btn btn-lg btn-primary" type="button" onclick="checkID();">찾기</button>
	        <button class="btn btn-lg btn-primary" type="button" onclick="history.go(-1);">뒤로가기</button>
	        </div>
	      </form:form>
		</div>
    </div>
    <%} %>
</body>
</html>