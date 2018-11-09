<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>
</head>
<script type="text/javascript">
	
</script>
<body>
	<div class="container mt-3">
		<form:form commandName="memberSurveyCommand">
			<div class="form-group">
				<label>신장</label>
				<form:input class="form-control" path="survHeight" placeholder="cm"/>
			</div>
			<div class="form-group">
				<label>체중</label>	
				<form:input class="form-control" path="survWeight" placeholder="kg" />
			</div>
			<div class="form-group">
				<label>BMI</label>
				<form:input class="form-control" path="survBMI"  />
			</div>
			<div class="form-group">
				<label>연령</label>
				<form:input class="form-control" path="survAge" />
			</div>
			<div class="form-group">
				<label>식습관</label>
				<select class="form-control" id="survEat">
					<option value="" selected>--선택--</option>
					<option value="1">1</option>
					<option value="2">2</option>
				</select>
			</div>
			<div>
				<form:input type="hidden" path="survLifestyle" value=""/>
				<form:input type="hidden" path="survPhoto" value=""/>
				<form:input type="hidden" path="survShape" value=""/>
				<form:input type="hidden" path="survDisease" value=""/>
				<form:input type="hidden" path="survConcern" value=""/>
				<form:input type="hidden" path="survCause" value=""/>
				<form:input type="hidden" path="survCareer" value=""/>
			</div>
			<button type="submit" class="btn btn-primary">완료</button>
			<button type="reset" class="btn btn-secondary">다시 작성</button>
			<button type="button" class="btn btn-secondary" onclick="history.back(-1);">뒤로가기</button>
		</form:form>
	</div>
</body>
</html>