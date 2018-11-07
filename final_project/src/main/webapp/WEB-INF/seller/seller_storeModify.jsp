<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
     <form method="post" action="#">
     	<div class="form-group">
			<label>사업자 번호</label> <input type="text" name="sellerAppliBn" class="form-control" placeholder="123-456" disabled>
		</div>
		<div class="form-group">
			<label>사업주 이름</label> <input type="text" name="sellerName" class="form-control">
		</div>
		<div class="form-group">
			<label>업체 이름</label> <input type="text" name="storeName" class="form-control">
		</div>
		<div class="form-group">
			<label>업체 전화번호</label> <input type="text" name="sellerTelphone" class="form-control">
		</div>
		<div class="form-group">
			<label>업체 주소</label> <input type="text" name="sellerAddr" class="form-control">
		</div>
		<button type="submit" class="btn btn-primary">확인</button>
		<button type="reset" class="btn btn-primary">다시 작성</button>
     </form>
 </div>
</body>
</html>