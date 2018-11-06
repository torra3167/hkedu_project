<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품리뷰신고 게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/earlyaccess/notosanskr.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">
		<table class="table table-striped text-center">
			<thead>
				<tr class="active">
					<th>작성자</th>
					<th>제목</th>
					<th>등록일</th>
				</tr>
			</thead>
			
			<tbody>
				<tr class="active">
					<th>1</th>
					<th><a href="#">2</a></th>
					<th>3</th>
				</tr>
			</tbody>
		</table>
		
		<hr>
		<div class="row justify-content-end ">
			<form method="get" action="./index.jsp" class="form-inline mt-3">
		        <select name="foodReviewReportDivide" class="form-control mx-1 mt-2">
		          <option value="foodReportWriter">작성자</option>
		          <option value="foodReportTitle">제목</option>
		          <option value="foodReportRegdate">등록일</option>
		        </select>
		        <input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요.">
		        <button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
			</form>
		</div>
			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-center mt-3">
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