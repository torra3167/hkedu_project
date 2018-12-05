<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="command.MemberSurveyCommand"%>
    
    <%
    MemberSurveyCommand memberSurvey = (MemberSurveyCommand)request.getAttribute("memberSurveyCommand");
    int goalWeight = (Integer)request.getAttribute("goalWeight");
    int monthlyDemandedWeight = (Integer)request.getAttribute("monthlyDemandedWeight");
	int weight = memberSurvey.getSurvWeight();
	int month = 0;
	String monthDay = "";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 완료</title>
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script> 
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
</head>
<body>
	<div id="line-chart" style="height: 300px;" class="chart"></div>

	<div class="container mt-3">
		설문 작성이 완료되었습니다.<br>
		<button type="button" class="btn btn-primary" onclick="location.href='index'">메인으로</button>
	</div>
<script type="text/javascript">

	/* var weight = document.getElementById('exerciseRecordWeight');
	var regDate = document.getElementById('exerciseRecordRegdate');
	console.log(weight);
	console.log(regDate); */

	new Morris.Line({
		
		// ID of the element in which to draw the chart.
		element : 'line-chart',
		// Chart data records -- each entry in this array corresponds to a point on
		// the chart.
		data : [ 
			<% for(int i = 0; i <= Integer.parseInt(memberSurvey.getSurveyDietPeriod()); i++) { 
				weight = weight - monthlyDemandedWeight;
 				month = i + 1;
 				if(month > 10){
 					monthDay = "0" + month;
 				}else{
 					monthDay =  month + "";
 				}
			%>
			{ 	regDate: '2019-' + <%=monthDay%>,
				weight: '<%=weight %>' 	
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
		lineColors: ['#3c8dbc'],
		labels : ['체중']
	});
</script>	
</body>
</html>