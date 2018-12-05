<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% int result=(Integer)request.getAttribute("result"); %>
<!doctype html>

<html>
<head>
<title>회원가입</title>
<!-- <script src="//code.jquery.com/jquery-latest.min.js"></script> -->
<script type="text/javascript">
	function checkIt() {
		var frm = document.getElementById("memberRegister");
		if (!frm.emailMember.value) {
			alert("이메일을 입력하세요");
			frm.memberEmail.focus();
			return false;
		}
		if (!frm.memberPass.value) {
			alert("비밀번호를 입력하세요");
			frm.memberPass.focus();
			return false;
		}
		if (!frm.memberName.value) {
			alert("이름을 입력하세요");
			frm.memberName.focus();
			return false;
		}
		if (!frm.memberPhone.value) {
			alert("연락처를 입력하세요");
			frm.memberPhone.focus();
			return false;
		}
		if (!frm.memberAddrNo.value) {
			alert("우편번호를 입력하세요");
			return false;
		}
		if (!frm.memberAddr1.value) {
			alert("주소를 입력하세요");
			return false;
		}
		if (!frm.memberAddr2.value) {
			alert("상세주소를 입력하세요");
			frm.memberAddr2.focus();
			return false;
		}
		frm.submit();
	}

	$(document).ready(function() {
		$("#checkbtn").unbind("click").click(function(e) {
			e.preventDefault();
			memberIDCheck();
		});
	});

	function memberIDCheck() {
		var memberEmail = $("#emailMember").val();
		console.log(memberEmail);

		if (emailMember.length < 1) {
			alert("아이디를 입력해주세요.")
		} else {
			$.ajax({
				type : "POST",
				url : "memberEmailCheck.gom",
				data : "emailMember=" + $('#emailMember').val(),
				dataType : "html",
				error : function(error) {
					alert("서버가 응답하지 않습니다. \n 다시 시도해주세요.");
				},
				success : function(result) {
					if (result == 0) {
						$('#emailMember').attr('disabled', true);
						document.getElementById('memberEmail').value = memberEmail;
						alert(memberEmail+"은 사용 가능한 아이디입니다.");
					} else if (result == 1) {
						alert("이미 존재하는 아이디입니다. 다른 아이디를 사용해주세요.");
					} else {
						alert(result + " 에러가 발생했습니다.");
					}
				}
			});
		}
	}
	
	function sample6_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var fullAddr = ''; // 최종 주소 변수
						var extraAddr = ''; // 조합형 주소 변수

						// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							fullAddr = data.roadAddress;

						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							fullAddr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
						if (data.userSelectedType === 'R') {
							//법정동명이 있을 경우 추가한다.
							if (data.bname !== '') {
								extraAddr += data.bname;
							}
							// 건물명이 있을 경우 추가한다.
							if (data.buildingName !== '') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
							fullAddr += (extraAddr !== '' ? ' (' + extraAddr
									+ ')' : '');
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('memberAddrNo').value = data.zonecode; //5자리 새우편번호 사용
						document.getElementById('memberAddr1').value = fullAddr;

						// 커서를 상세주소 필드로 이동한다.
						document.getElementById('memberAddr2').focus();
					}
				}).open();
	}
</script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<link rel="stylesheet" href="css/custom-1.css">
</head>
<body>
	<div class="container">
		<div class="row">
		<div class="col-12">
			<form action="member_join.gom" method="post" id="memberRegister" class="justify" name="Register1">
				<div class="form-group">
				
					<label>이메일</label>
		    		<div class="form-group input-group">
			    	<div class="input-group-prepend">
					    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
					 </div>
					<input name="emailMember" type="email" class="form-control" id="emailMember" />
					<input name="memberEmail" type="hidden" class="form-control" id="memberEmail" />
					</div>
					<button type="button" id="checkbtn" name="checkbtn" class="btn btn-default">중복확인</button>
				</div>
				<div class="form-group">
					<label>비밀번호</label>
					<div class="form-group input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"><i class="fa fa-lock fa-lg"></i></span>
					</div>	
					<input type="password" name="memberPass" id="memberPass" class="form-control" />
					
					</div>
				</div>
				<div class="form-group">
				<label>이름</label>
				<div class="form-group input-group">
    				<div class="input-group-prepend">
		    		<span class="input-group-text"> <i class="fa fa-user"></i> </span></div>
					<input type="text" name="memberName" id="memberName" class="form-control" />
				</div>
				</div>
				<div class="form-group">
					<label>연락처</label>
					 <div class="input-group">
                     <div class="input-group-prepend">
                     <div class="input-group-text"><i class="fa fa-comment text-info"></i></div>
                     </div>
					<input id="memberPhone" name="memberPhone" type="text"	class="form-control" />
					</div>
				</div>
				<div class="form-group">
				<div class="form-group">
				<label>우편번호</label>
				<input class="form-control" id="memberAddrNo" name="memberAddrNo" placeholder="우편번호" readonly="readonly"/>
				<button type="button" class="btn btn-default" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">우편번호 찾기</button>
				</div>
				<div class="form-group">
				<label>주소</label>
				<input class="form-control" id="memberAddr1" name="memberAddr1" placeholder="주소"/>
				</div>
				<div class="form-group">
				<label>상세주소</label>
				<input class="form-control" id="memberAddr2" name="memberAddr2" placeholder="상세주소"/>
				</div>
				
				</div>
				<div>
					<input type="hidden" id="memberDivide" name="memberDivide" value="p" />
				</div>
				<div class="justify">
					<button type="button" class="btn btn-primary" onclick="checkIt()">회원가입</button>
					<button type="reset" class="btn btn-default">다시 작성</button>
					<button type="button" class="btn btn-default" onclick="history.go(-1);">뒤로가기</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>