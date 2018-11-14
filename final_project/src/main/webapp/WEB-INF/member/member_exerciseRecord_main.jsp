<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>운동 기록 메인</title>

<link rel="stylesheet" href="#">

</head>
<body>
	<div class="container">
		<h3>이달의 체중 변화</h3>
		<div class="analysis-result__chart-container">

			<div class="chartjs-size-monitor"
				style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
				<div class="chartjs-size-monitor-expand"
					style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
					<div
						style="position: absolute; width: 100000px; height: 100000px; left: 0; top: 0"></div>
				</div>
				<div class="chartjs-size-monitor-shrink"
					style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
					<div
						style="position: absolute; width: 200%; height: 200%; left: 0; top: 0"></div>
				</div>
			</div>
			<canvas width="1903" height="1057" id="analysis-result--mobile"
				class="chart-container__chart visible-mobile chartjs-render-monitor"
				style="display: block; width: 1903px; height: 1057px;"></canvas>
			<canvas width="1348" height="262" id="analysis-result--desktop"
				class="chart-container__chart visible-desktop chartjs-render-monitor"
				style="display: block; width: 1348px; height: 262px;"></canvas>
		</div>
		<br>
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>기록날짜</th>
					<th>프로그램명</th>
					<th>코치명</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>1</th>
					<th>2</th>
					<th>3</th>
				</tr>
				<tr>
					<th>1</th>
					<th>2</th>
					<th>3</th>
				</tr>
				<tr>
					<th>1</th>
					<th>2</th>
					<th>3</th>
				</tr>
			</tbody>
		</table>
		<hr>
		<a class="btn btn-primary" href="#" role="button">기록하기</a>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="#">이전</a></li>
				<li class="page-item active"><a class="page-link" href="#">1</a></li>
				<li class="page-item"><a class="page-link" href="#">2</a></li>
				<li class="page-item"><a class="page-link" href="#">3</a></li>
				<li class="page-item"><a class="page-link" href="#">다음</a></li>
			</ul>
		</nav>
	</div>
	
</body>
</html>