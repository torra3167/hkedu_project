<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String email=(String)request.getAttribute("email");
	System.out.println("jsp"+email);
	Integer result = 0;
 	if(email == null){
		result = 1;
	} 
%>
<!doctype html>
<html>
<head>
<title>설문지</title>
</head>
<script type="text/javascript">
function idChk(){
	var frm=document.getElementById('frm');
	if(<%=result%>==1){
		window.location.href='http://localhost:8080/final_project/survey_success.gom';
	}else{
		frm.submit();
	}
}
</script>
<body>
	<div class="container mt-3">
		<form:form id="frm" action="member_write_survey1.gom" commandName="memberSurveyCommand" method="POST">
			<form:hidden path="survNo" value=""/>
			<form:hidden path="memberEmail" value="<%= email %>"/>
			<div class="form-group">
				<label>신장</label> <form:input class="form-control" path="survHeight" placeholder="cm"/>
			</div>
			<div class="form-group">
				<label>체중</label> <form:input class="form-control" path="survWeight" placeholder="kg"/>
			</div>
			<div class="form-group">
				<label>BMI</label> <form:input class="form-control" path="survBMI"/>
			</div>
			<div class="form-group">
				<label>연령</label> <form:input class="form-control" path="survAge"/>
			</div>
			<div class="form-group">
				<label>식습관</label> <select class="form-control" id="survEat" name="survEat">
					<option value="" selected>--선택--</option>
					<option value="a">1</option>
					<option value="s">2</option>
				</select>
			</div>
			<form:hidden path="survSex" value=""/>
			<form:hidden path="survLifestyle" value=""/>
			<form:hidden path="survPhoto" value=""/>
			<form:hidden path="survShape" value=""/>
			<form:hidden path="survDisease" value=""/>
			<form:hidden path="survConcern" value=""/>
			
			
			<button type="button" class="btn btn-primary" onclick="idChk();">완료</button>
			
			<button type="reset" class="btn btn-secondary">다시 작성</button>
			<button type="button" class="btn btn-secondary">뒤로가기</button>
		</form:form>
	</div>
</body>
</html>