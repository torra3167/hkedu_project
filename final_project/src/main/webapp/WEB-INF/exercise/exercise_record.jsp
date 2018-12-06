<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.ExerciseRec, java.util.List"%>
	
	<%
	String memberEmail = (String)session.getAttribute("email");
	List<ExerciseRec> exerciseRecordList = (List<ExerciseRec>)request.getAttribute("exerciseRecordList");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>운동 기록 메인</title>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
 --><script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script> 
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
</head>
<body>
<% if(exerciseRecordList == null || exerciseRecordList.isEmpty()) { %>
<div class="text-center">
	<h3 style="text-align: center;">등록된 운동기록이 없습니다. 등록하기를 눌러 운동을 기록해보세요!</h3>
	<a style="text-align: right;" class="btn btn-primary" href="exercise_record_reg.gom" role="button">기록하기</a>
</div>	
<% } else { %>

	<div class="container">
		<h3>이달의 체중 변화</h3>
		
		<div id="myfirstchart" style="height: 250px;"></div>
		
		
		<br>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					
					<th>구매자이메일</th>
					<th>프로그램번호</th>
					<th>코치 이메일</th>
					<th>수행한 운동 이름</th>
					<th>수행한 운동 무게</th>
					<th>수행한 운동 횟수</th>
					<th>운동 기록 체중</th>
					<th>운동 기록 등록날짜</th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<%
					for(Object temp : exerciseRecordList) {
						ExerciseRec exerciseRecord = (ExerciseRec)temp;
				%>
					<td><%=exerciseRecord.getMemberEmail() %></td>
					<td><%=exerciseRecord.getProNo() %></td>
					<td><%=exerciseRecord.getCoachEmail() %></td>
					<td><%=exerciseRecord.getExerciseRecordName() %></td>
					<td><%=exerciseRecord.getExerciseRecordKg() %>kg</td>
					<td><%=exerciseRecord.getExerciseRecordTimes() %>회</td>
					<td><%=exerciseRecord.getExerciseRecordWeight() %>kg</td>
					<td><%=exerciseRecord.getExerciseRecordRegdate() %></td>
					
					<%-- <form>
						<input type="text" name="exerciseRecordWeight" id="exerciseRecordWeight" value="<%=exerciseRecord.getExerciseRecordWeight() %>">
						<input type="text" name="exerciseRecordRegdate" id="exerciseRecordRegdate" value="<%=exerciseRecord.getExerciseRecordRegdate() %>">
					</form>  --%>
				</tr>
				
				
			<%} %>
				<hr>
				
				
			</tbody>
		</table>
		<hr>
		<a class="btn btn-primary text-right" href="exercise_record_reg.gom" role="button">기록하기</a>
		
	</div>

<% } %>
<script type="text/javascript">

	/* var weight = document.getElementById('exerciseRecordWeight');
	var regDate = document.getElementById('exerciseRecordRegdate');
	console.log(weight);
	console.log(regDate); */

	new Morris.Line({
		
		// ID of the element in which to draw the chart.
		element : 'myfirstchart',
		// Chart data records -- each entry in this array corresponds to a point on
		// the chart.
		data : [ 
			<% for(Object temp : exerciseRecordList)  { 
				ExerciseRec exerciseRec = (ExerciseRec)temp;
			%>
			{ 	regDate: '<%=exerciseRec.getExerciseRecordRegdate()%>',
				weight: '<%=exerciseRec.getExerciseRecordWeight()%>kg'			  	
			},	
			<% } %>
			],
		// The name of the data record attribute that contains x-values.
		xkey : 'regDate',
		// A list of names of data record attributes that contain y-values.
		ykeys :[ 'weight'],
		// Labels for the ykeys -- will be displayed when you hover over the
		// chart.
		hidehover: 'auto',
		xmax : 'auto',
		xmin : 'auto',
		ymin : 'auto',
		labels : ['체중']
	});
</script>
	
</body>
</html>