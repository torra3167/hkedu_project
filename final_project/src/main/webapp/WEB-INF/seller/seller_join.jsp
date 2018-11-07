<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">

</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
	<form method="post" action="#">
		<div class="form-group">
			<label>이메일</label> <input type="text" name="sellerEmail" class="form-control">
			<input type="button" class="btn btn-primary" name="sellerEmailDuplicate" value="중복 확인" onclick="">
		</div>
		
		<div class="form-group">
			<label>비밀번호</label> <input type="password" name="sellerPw" class="form-control">
		</div>
		<div class="form-group">
			<label>비밀번호 확인</label> <input type="password" name="sellerConfirmPw" class="form-control"><!-- 속성추가 필요 -->
		</div>
		<div class="form-group">
			<label>휴대폰번호</label> <input type="text" name="sellerPhone" class="form-control">
			<input type="button" class="btn btn-primary" name="sellerPhoneDuplicate" value="중복 확인" onclick="">
		</div>
		<textarea rows="4" cols="50" readonly>
			개인정보 수집 및 이용 동의
			"회사"는 다음과 같이 "사업주"의 개인정보를 수집합니다. 처리하고 있는 개인정보는 다음의 수집·이용목적 이외의 용도로는 활용되지 않으며, 수집·이용목적이 변경되는 경우에는 「개인정보보호법」에 따라 별도의 동의를 받는 등 필요한 조치를 이행합니다.
			"회사"에 온라인 입점신청 시 수집하는 개인정보
			개인정보 수집 목적  수집하는 개인정보 항목  보유 및 이용기간 수집방법
			입점신청  [필수] 사업자번호, 사업자등록증, 영업신고등록증, 사업주명, 사업자 휴대폰번호, 인증번호, 업체 이름, 업체 주소
			온라인 입점신청을 위해 동의받는 개인정보 수집 및 이용동의를 제외한 나머지 개인정보처리 관련 사항은 회사 사이트 정책의 개인정보처리방침과 동일하게 적용됩니다.
		</textarea><br>
		<input type="checkbox" name="sellerTerm" value="agree"> 개인정보 수집 및 이용에 동의합니다.(필수)<br><br>
		<button type="submit" class="btn btn-primary">확인</button>
		<button type="reset" class="btn btn-primary">다시 작성</button>
	</form>
</div>

<script src="../js/jquery.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</body>
</html>