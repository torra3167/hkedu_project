<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자에게 문의하기</title>

<link rel="stylesheet" href="../css/bootstrap.min.css">
</head>
<body>
	<div class="container" tabindex="-1" role="dialog">
		<button type="button" class="close" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	<div class="modal-body">
		<form method="post" action="./reportAction.jsp">
			<div class="form-group">
				<label>문의 제목</label> <input type="text" name="reportTitle"
					class="form-control" maxlength="20">
			</div>
			<div class="form-group">
				<label>문의 내용</label>
				<textarea type="text" name="reportContent" class="form-control"
					maxlength="2048" style="height: 180px;"></textarea>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
				<button type="submit" class="btn btn-primary">문의하기</button>
			</div>
		</form>
	</div>
	</div>
</body>
</html>