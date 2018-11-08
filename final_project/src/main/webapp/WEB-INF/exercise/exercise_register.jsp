<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
        <form name="frm" method="post" action="exercise_register.gom" enctype="multipart/form-data" id="exerciseForm">
        	<div class="form-group">
				<label>운동 이름</label> <input type="text" name="exerciseName" class="form-control">
			</div>
			<div class="form-group">
				<label>운동 사진 </label> <input type="file" name="exerciseImg" class="form-control">
			</div>
			
			<div class="form-group">
				<label>운동 영상</label> <input type="file" name="exerciseVideo" class="form-control">
			</div>
			
			<button type="submit" class="btn btn-primary">메뉴 등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
</body>
</html>