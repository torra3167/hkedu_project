<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import= "command.ProReviewWriteCommand"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<div class="body"> 
		<h5>운동기록 등록</h5>
		<form:form commandName="exerciseRecord" action="exercise_record_reg.gom" >


			<div class="form-group">
				<label>운동기록번호</label>
				<form:input path="exerciseRecordNo" class="form-control" readonly="true"/>
			</div>

			<div class="form-group">
				<label>구매자이메일주소</label>
				<form:input path="memberEmail" class="form-control" readonly="true"/>
			</div>
			<div class="form-group">
				<label>프로그램번호</label>
				<form:input path="proNo" class="form-control" readonly="true"/>
			</div>
			<div class="form-group">
				<label>코치 이메일</label>
				<form:input path="coachEmail" class="form-control" readonly="true"/>
			</div>
			<div class="form-group">
				<label>수행한 운동 이름</label>
				<form:input path="exerciseRecordName" class="form-control" readonly="true"/>
			</div>
			<div class="form-group">
				<label>수행한 운동 무게</label>
				<form:input path="exerciseRecordKg" class="form-control" />
			</div>
			<div class="form-group">
				<label>수행한 운동 횟수</label>
				<form:input path="exerciseRecordTimes" class="form-control" />
			</div>
			<div class="form-group">
				<label>운동 기록 체중</label>
				<form:input path="exerciseRecordWeight" class="form-control" />
			</div>
			<div class="form-group">
				<label>운동 기록 등록날짜</label>
				<form:input path="exerciseRecordRegdate" class="form-control" />
			</div>


			<div class="form-group">
				<button type="submit" class="btn btn-primary">등록하기</button>
				<button type="reset" class="btn btn-primary">다시 작성</button>
				<button type="button" class="btn btn-secondary" >취소</button>
			</div>
		</form:form>
	</div>
</body>
</html>