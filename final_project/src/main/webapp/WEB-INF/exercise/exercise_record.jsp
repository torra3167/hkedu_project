<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.ProgramExerciseExercise, java.util.List"%>
	
	<%
	List<ProgramExerciseExercise> peeResultList = (List<ProgramExerciseExercise>)request.getAttribute("peeResultList");
	String memberEmail = (String)session.getAttribute("email");
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
	<div class="container">
		<h3>이달의 체중 변화</h3>
		
		<div id="myfirstchart" style="height: 250px;"></div>
		
		
		<br>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>구매자이메일주소</th>
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
					for(Object temp : peeResultList) {
						ProgramExerciseExercise peeResult = (ProgramExerciseExercise)temp;
				%>
					<td>구매자이메일</td>
					<td><%=peeResult.getProNo() %></td>
					<td><%=peeResult.getCoachEmail() %></td>
					<td><%=peeResult.getExerciseCatAName()%></td> 
					<td><%=peeResult.getExerciseCatANumber()%></td> 
			
			<%} %>
				</tr>
				
				
			</tbody>
		</table>
		<hr>
		<a class="btn btn-primary" href="exercise_record_reg.gom" role="button">기록하기</a>
		
	</div>

<script type="text/javascript">
new Morris.Line({
	  // ID of the element in which to draw the chart.
	  element: 'myfirstchart',
	  // Chart data records -- each entry in this array corresponds to a point on
	  // the chart.
	  data: [
	    { x: '2018-12', weight: 40 },
	    { x: '2019-01', weight: 30 },
	    { x: '2019-02', weight: 20 },
	    { x: '2019-03', weight: 40 },
	    { x: '2019-04', weight: 80 }
	  ],
	  // The name of the data record attribute that contains x-values.
	  xkey: 'x',
	  // A list of names of data record attributes that contain y-values.
	  ykeys: ['weight'],
	  // Labels for the ykeys -- will be displayed when you hover over the
	  // chart.
	  labels: ['kg']
	});

</script>
	
</body>
</html>