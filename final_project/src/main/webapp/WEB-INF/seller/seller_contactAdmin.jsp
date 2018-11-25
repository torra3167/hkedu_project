<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
     <form method="post" action="#">
     	<div class="form-group">
			<label>업체명</label> <input type="text" name="storeName" class="form-control">
		</div>
		<div class="form-group">
			<label>연락처</label> <input type="text" name="sellerPhone" class="form-control">
		</div>
		<div class="form-group">
			<label>이메일 주소</label> <input type="text" name="sellerEmail" class="form-control">
		</div>
		<div class="form-group">
			<label>제목</label> <input type="text" name="contactAdminTitle" class="form-control">
		</div>
		<div class="form-group">
			<label>내용</label> <textarea type="text" name="" class="form-control" maxlength="2048" style="height: 180px;"></textarea>
		</div>
<!-- 		<input type="button" value="메일발송" onclick="check()"> -->
<!-- 		<input type="hidden" name="to" value="abcd@naver.com"> -->
<!-- 		<input type="hidden" name="from" value="abcd@naver.com"> -->
		<button type="submit" class="btn btn-primary">메일 전송</button>
		<button type="reset" class="btn btn-primary">다시 작성</button>
     </form>
 </div>
</body>
</html>