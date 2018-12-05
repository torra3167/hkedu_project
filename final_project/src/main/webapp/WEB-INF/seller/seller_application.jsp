<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script type="text/javascript">
var bnCheck = false;
	function idCheck(){
		var applicBn = $("#sellerAppliBn").val();
	
		if(!applicBn){
			alert("조회하실 사업자번호를 입력해주세요.");
			return false;
		}else if(isNaN(applicBn)){
			alert("사업자번호는 숫자를 입력해주세요.");
			return false;
		}else{
// 			alert("applicBn : "+applicBn);
		        $.ajax({
		            type: "POST",
		            url: "seller_appliBnDuplication.gom",
					data: "applicBn="+applicBn,
					dataType:"html",
		            success: function(result) {
							if(result=="true"){
								alert("이미 가입된 사업자번호입니다.");
								return false;
							}else{
								alert("사용가능한 사업자번호입니다.");
								bnCheck = true;
							}
		            }
		    });
			
		}
	}
	
function bnCheckFalse(){
	bnCheck = false;
// 	alert(bnCheck);
}

function checkVal(){
	var stChecked = $("#storeTerm").prop("checked");
	
	if(!$("#sellerAppliBn").val()){
		alert("사업자 번호를 입력해주세요.");
		return false;
	}else if(!$("#sellerLicense").val()){
		alert("사업자 등록증 사본을 선택해주세요.");
		return false;
	}else if(!$("#sellerBusinessRegistration").val()){
		alert("영업신고증 사본을 선택해주세요.");
		return false;
	}else if(!$("#storeName").val()){
		alert("업체 이름를 입력해주세요.");
		return false;
	}else if(!$("#storeTelphone").val()){
		alert("업체 전화번호를 입력해주세요.");
		return false;
	}else if(isNaN($("#storeTelphone").val())){
		alert("업체 전화번호는 숫자만 입력해주세요.");
		return false;
	}else if(!$("#storeAddr").val()){
		alert("업체주소를 입력해주세요.");
		return false;
	}else if(!stChecked){
		alert("개인정보 수집 및 이용에 동의해주세요.");
		return false;
	}
	
	document.getElementById('frm').submit();
}
</script>
</head>
<body>
<div class="container mt-3" style="max-width: 560px;">
     <form:form id="frm" method="POST" action="seller_application.gom" enctype="multipart/form-data" commandName="sellerApplicationWriteCommand">
     	<div class="form-group">
			<label>사업자 번호</label> <input type="text" id="sellerAppliBn" name="sellerAppliBn" class="form-control" value="" onkeydown="bnCheckFalse()" maxlength="10">
			<input type="button" class="btn btn-primary" name="sellerAppliBnDuplicate" value="중복 확인" onclick="idCheck()">
		</div>
		<div class="form-group">
			<label>사업자 등록증 사본</label> <input type="file" id="sellerLicense" name="sellerLicense" class="form-control">
		</div>
		<div class="form-group">
			<label>영업 신고증 사본</label> <input type="file" id="sellerBusinessRegistration" name="sellerBusinessRegistration" class="form-control">
		</div>
		<div class="form-group">
			<label>업체 이름</label> <input type="text" id="storeName" name="storeName" class="form-control">
		</div>
		<div class="form-group">
			<label>업체 전화번호</label> <input type="text" id="storeTelphone" name="storeTelphone" class="form-control">
		</div>
		<div class="form-group">
			<label>업체 주소</label> <input type="text" id="storeAddr" name="storeAddr" class="form-control">
		</div>
		<textarea class="form-group" rows="4" cols="50" readonly>
			개인정보 수집 및 이용 동의
			"회사"는 다음과 같이 "사업주"의 개인정보를 수집합니다. 처리하고 있는 개인정보는 다음의 수집·이용목적 이외의 용도로는 활용되지 않으며, 수집·이용목적이 변경되는 경우에는 「개인정보보호법」에 따라 별도의 동의를 받는 등 필요한 조치를 이행합니다.
			"회사"에 온라인 입점신청 시 수집하는 개인정보
			개인정보 수집 목적  수집하는 개인정보 항목  보유 및 이용기간 수집방법
			입점신청  [필수] 사업자번호, 사업자등록증, 영업신고등록증, 사업주명, 사업자 휴대폰번호, 인증번호, 업체 이름, 업체 주소
			온라인 입점신청을 위해 동의받는 개인정보 수집 및 이용동의를 제외한 나머지 개인정보처리 관련 사항은 회사 사이트 정책의 개인정보처리방침과 동일하게 적용됩니다.
        </textarea><br>
        <input type="checkbox" id="storeTerm" name="storeTerm"> 개인정보 수집 및 이용에 동의합니다.(필수)<br>
		<button type="button" class="btn btn-primary" onclick="checkVal()">확인</button>
		<button type="reset" class="btn btn-primary">다시 작성</button>
     </form:form>
 </div>
</body>
</html>