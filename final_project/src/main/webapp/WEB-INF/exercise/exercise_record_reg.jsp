<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.ExerciseExerciseCatA, java.util.List, model.ExerciseRecCommand"%>
	
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%
	ExerciseRecCommand exerciseRecCommand = (ExerciseRecCommand)request.getAttribute("exerciseRecCommand");
	List<ExerciseExerciseCatA> eecaList = (List<ExerciseExerciseCatA>)request.getAttribute("eecaList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">
<script type='text/javascript'
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
<script type='text/javascript'>

	$(function() {
		$('.form-group.date').datepicker({
			calendarWeeks : false,
			todayHighlight : true,
			autoclose : true,
			format : "yyyy-mm-dd",
			language : "kr"
		});
	});
</script>

</head>
<body>

	<div class="body">
		<h5>운동기록 등록</h5>
		<form:form commandName="exerciseRecCommand" action="exercise_record_reg.gom" >


			<%-- <div class="form-group">
				<label>운동기록번호</label>
				<form:input path="exerciseRecordNo" class="form-control" readonly="true"/>
			</div> --%>

			<div class="form-group">
				<label>구매자이메일주소</label>
				<form:input path="memberEmail" class="form-control" readonly="true" value="<%=exerciseRecCommand.getMemberEmail() %>"/>
			</div>
			<div class="form-group">
				<label>프로그램번호</label>
				<form:input path="proNo" class="form-control" readonly="true" value="<%=exerciseRecCommand.getProNo() %>"/>
			</div>
			<div class="form-group">
				<label>코치 이메일</label>
				<form:input path="coachEmail" class="form-control" readonly="true" value="<%=exerciseRecCommand.getCoachEmail() %>"/>
			</div>
		
			<% for(Object temp : eecaList) { 
				ExerciseExerciseCatA eeca = (ExerciseExerciseCatA)temp;
			%>
				
		
			
			<div class="form-group">
				<label>수행해야할 운동 이름</label>
				
				<form:input path="exerciseRecordName" class="form-control" readonly="true" value="<%=eeca.getExerciseCatAName() %>"/>
			</div>
			<div class="form-group">
				<label>수행한 운동 무게</label>
				<form:input path="exerciseRecordKg" class="form-control" />kg
			</div>
			<div class="form-group">
				<label>수행한 운동 횟수</label>
				<form:input path="exerciseRecordTimes" class="form-control" />
			</div>
			
			<hr>
			

		<% } %>
			
			<div class="form-group">
				<label>운동 기록 체중</label>
				<form:input path="exerciseRecordWeight" class="form-control" />
			</div>
		
			<div class="form-group date" data-provide="datepicker">
				<label>운동 기록 등록날짜</label>
				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i>
				<form:input path="exerciseRecordRegdate" class="form-control" />
				</span>
	
			</div>		
		
			<div class="form-group">
				<button type="submit" class="btn btn-primary">등록하기</button>
				<button type="reset" class="btn btn-primary">다시 작성</button>
				<button type="button" class="btn btn-secondary" >취소</button>
			</div>
		</form:form>
	</div>
</body>
<script type="text/javascript">
(function($){
	$.fn.datepicker.dates['kr'] = {
		days: ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일", "일요일"],
		daysShort: ["일", "월", "화", "수", "목", "금", "토", "일"],
		daysMin: ["일", "월", "화", "수", "목", "금", "토", "일"],
		months: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		monthsShort: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
	};
}(jQuery));

</script>
</html>




