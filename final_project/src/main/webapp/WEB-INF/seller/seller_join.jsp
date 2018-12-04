<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script type="text/javascript">
var emailCheck = false;
	function idCheck(){
		var sellerEmail = $("#sellerEmail").val();
	
		if(!sellerEmail){
			alert("조회하실 이메일주소를 입력해주세요.");
			return false;
		}else{
		        $.ajax({
		            type: "POST",
		            url: "seller_emailDuplication.gom",
					data: "sellerEmail="+sellerEmail,
					dataType:"html",
		            success: function(result) {
							if(result=="true"){
								alert("이미 가입된 이메일입니다.");
								return false;
							}else{
								alert("사용가능한 이메일입니다.");
								emailCheck = true;
							}
		            }
		    });
			
		}
	}
	
function emailCheckFalse(){
	emailCheck = false;
}

function checkVal(){
	var stChecked = $("#sellerTerm").prop("checked");
			
	if(!$("#sellerEmail").val()){
		alert("이메일을 입력해주세요.");
		return false;
	}else if(!$("#sellerName").val()){
		alert("이름을 입력해주세요.");
		return false;
	}else if(!$("#sellerPw").val()){
		alert("비밀번호를 입력해주세요.");
		return false;
	}else if(!$("#sellerConfirmPw").val()){
		alert("비밀번호 재입력란을 입력해주세요.");
		return false;
	}else if(!$("#sellerPhone").val()){
		alert("휴대폰번호를 입력해주세요.");
		return false;
	}else if(!stChecked){
		alert("개인정보 수집 및 이용에 동의해주세요.");
		return false;
	}else if(emailCheck==false){
		alert("이메일 중복확인을 해주세요.");
		return false;
	}else if($("#sellerPw").val()!=$("#sellerConfirmPw").val()){
		alert("재입력한 비밀번호가 비밀번호와 일치하지 않습니다.");
		return false;
	}
	
	document.getElementById('frm').submit();
}
</script>
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
	<div><h3><strong>판매자 회원가입</strong></h3></div>
	<br>		
	<form method="post" action="seller_join.gom" id="frm">
		<div class="form-group">
			<label>이메일</label> <input type="text" id="sellerEmail" name="sellerEmail" class="form-control" onkeydown="emailCheckFalse()">
			<input type="button" class="btn btn-primary" name="sellerEmailDuplicate" value="중복 확인" onclick="idCheck()">
		</div>
		<div class="form-group">
			<label>이름</label> <input type="text" id="sellerName" name="sellerName" class="form-control">
		</div>
		<div class="form-group">
			<label>비밀번호</label> <input type="password" id="sellerPw" name="sellerPw" class="form-control">
		</div>
		<div class="form-group">
			<label>비밀번호 확인</label> <input type="password" id="sellerConfirmPw" name="sellerConfirmPw" class="form-control"><!-- 속성추가 필요 -->
		</div>
		<div class="form-group">
			<label>휴대폰번호</label> <input type="text" id="sellerPhone" name="sellerPhone" class="form-control" placeholder="010-1234-5678">
		</div>
		<textarea rows="4" cols="50" readonly>
			개인정보 수집 및 이용 동의
			"회사"는 다음과 같이 "사업주"의 개인정보를 수집합니다. 처리하고 있는 개인정보는 다음의 수집·이용목적 이외의 용도로는 활용되지 않으며, 수집·이용목적이 변경되는 경우에는 「개인정보보호법」에 따라 별도의 동의를 받는 등 필요한 조치를 이행합니다.
			"회사"에 온라인 입점신청 시 수집하는 개인정보
			개인정보 수집 목적  수집하는 개인정보 항목  보유 및 이용기간 수집방법
			입점신청  [필수] 사업자번호, 사업자등록증, 영업신고등록증, 사업주명, 사업자 휴대폰번호, 인증번호, 업체 이름, 업체 주소
			온라인 입점신청을 위해 동의받는 개인정보 수집 및 이용동의를 제외한 나머지 개인정보처리 관련 사항은 회사 사이트 정책의 개인정보처리방침과 동일하게 적용됩니다.
		</textarea><br>
		<input type="checkbox" id="sellerTerm" name="sellerTerm" checked="checked"> 개인정보 수집 및 이용에 동의합니다.(필수)<br><br>
		<button type="button" class="btn btn-primary" onclick="checkVal()">확인</button>
		<button type="reset" class="btn btn-primary">다시 작성</button>
	</form>
</div>

</body>
</html>