<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="command.MemberSurveyCommand, model.Member, java.util.*" %>
<%
	MemberSurveyCommand survey=(MemberSurveyCommand)request.getAttribute("memberSurvey");
%>
<!doctype html>

<html>
<head>
<title>설문지</title>
<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/1027.css">
</head>
<script type="text/javascript">
	
</script>
<body>
	<div class="container mt-3">
		<form:form commandName="memberSurvey">
			<form:hidden path="survNo" value="<%= survey.getSurvNo() %>"/>
			<form:hidden path="memberEmail" value=""/>
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
				<label>식습관</label> <select class="form-control" id="survEat">
					<option value="" selected>--선택--</option>
					<option value="1">1</option>
					<option value="2">2</option>
				</select>
			</div>
			<form:hidden path="survAge" value=null/>
			<form:hidden path="survLifestyle" value=null/>
			<form:hidden path="survPhoto" value=null/>
			<form:hidden path="survShape" value=null/>
			<form:hidden path="survDisease" value=null/>
			<form:hidden path="survConcern" value=null/>
			<button type="submit" class="btn btn-primary">완료</button>
			<button type="reset" class="btn btn-secondary">다시 작성</button>
			<button type="button" class="btn btn-secondary">뒤로가기</button>
		</form:form>>
	</div>
</body>
</html>