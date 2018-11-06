<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member_info.jsp</title>
<script type="text/javascript">
function fn_setAddr(){
   var width = 500;
   var height = 600;
   daum.postcode.load(function(){
      new daum.Postcode({
         oncomplete: function(data) {
            $("#zipAddr").val(data.address);
            $("#addr").val(data.buildingname);
         }
      }).open({
         left: (window.screen.width / 2) - (width / 2),
         top: (window.screen.height / 2) - (height / 2), 
      });
   });
}

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
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
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('memberZipCode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('memberAddr1').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('memberAddr2').focus();
        }
    }).open();
}
   function checkIt() {
      var pattern1 = /[0-9]{1}/;
      var pattern2 = /[a-zA-Z]{1}/;
      var pattern3 = /[~!@#$%^&*()_+|<>?{}]{1}/;
      var pattern4 = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
      var frm = document.getElementById("joinform");
      var joinform_pw = document.joinform.memberPw.value;
      var joinform_name = document.joinform.memberName.value;
      var joinform_phone2 = document.joinform.memberPhone2.value;
      var joinform_phone3 = document.joinform.memberPhone3.value;
      var joinform_cellphone2 = document.joinform.memberCellPhone2.value;
      var joinform_cellphone3 = document.joinform.memberCellPhone3.value;
      var joinform_email1 = document.joinform.memberEmail1.value;
      var joinform_email2 = document.joinform.memberEmail2.value;
      var checkPass = /^(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_+|<>?{}])(?=.*[0-9]).{10,15}$/;

      if (!frm.memberPw.value) {
         alert("비밀번호를 입력하세요");
         frm.memberPw.focus();
         return false;
      }
      if (!checkPass.test(joinform_pw)){
         alert("비밀번호는 영어,숫자,특수문자로 10~15자 이내로 입력해주시기 바랍니다..");
         frm.memberPw.focus();
         return false;
      }
      if (!frm.memberPw2.value) {
         alert("비밀번호확인을 입력하세요.");
         frm.memberPw2.focus();
         return false;
      }
      if (frm.memberPw.value != frm.memberPw2.value) {
         alert("비밀번호가 다릅니다.");
         frm.memberPw2.focus();
         return false;
      }
      if (!frm.memberName.value) {
         alert("이름를 입력하세요");
         frm.memberName.focus();
         return false;
      }
      if (pattern1.test(joinform_name)||pattern3.test(joinform_name)){
         alert("이름에는 숫자나 특수문자를 사용할 수 없습니다.");
         frm.memberName.focus();
         return false;
      }
      if(!frm.memberZipCode.value) {
         alert("우편번호를 입력하세요");
         frm.memberZipCode.focus();
         return false;
      }
      if(!frm.memberAddr1.value) {
         alert("주소을 입력하세요");
         frm.memberAddress1.focus();
         return false;
      }
      if(!frm.memberAddr2.value) {
         alert("나머지주소을 입력하세요");
         frm.memberAddress2.focus();
         return false;
      }
      if(!frm.memberPhone2.value || !frm.memberPhone3.value) {
         alert("전화번호을 입력하세요");
         frm.phone2.focus();
         return false;
      }
      if (frm.memberPhone2.value.length<3 || frm.memberPhone3.value.length<4) {
         alert("전화번호를 정확히 입력해주시기 바랍니다.");
         frm.phone2.focus();
         return false;
      }
      if ((pattern2.test(joinform_phone2)||pattern3.test(joinform_phone2)||pattern4.test(joinform_phone2))||(pattern2.test(joinform_phone3)||pattern3.test(joinform_phone3)||pattern4.test(joinform_phone3))){
         alert("전화번호에는 숫자만 입력 가능합니다.");
         frm.phone2.focus();
         return false;
      }
      if(!frm.memberCellPhone2.value || !frm.memberCellPhone3.value) {
         alert("핸드폰번호을 입력하세요");
         frm.cellphone2.focus();
         return false;
      }
      if (frm.memberCellPhone2.value.length<4 || frm.memberCellPhone3.value.length<4) {
         alert("핸드폰번호를 정확히 입력해주시기 바랍니다.");
         frm.cellphone2.focus();
         return false;
      }
      if ((pattern2.test(joinform_cellphone2)||pattern3.test(joinform_cellphone2)||pattern4.test(joinform_cellphone2))||(pattern2.test(joinform_cellphone3)||pattern3.test(joinform_cellphone3)||pattern4.test(joinform_cellphone3))){
         alert("핸드폰번호에는 숫자만 입력 가능합니다.");
         frm.cellphone2.focus();
         return false;
      }
      if(!frm.memberEmail1.value || !frm.memberEmail2.value) {
         alert("이메일을 입력하세요");
         frm.memberEmail1.focus();
         return false;
      }
      if (pattern4.test(joinform_email1)||pattern4.test(joinform_email2)){
         alert("이메일을 다시 입력해주세요.");
         frm.memberEmail2.focus();
         return false;
      }
      frm.submit();
   }
</script>
<style type="text/css">
#tborder{margin-top:20px; margin-bottom:20px;}
table{border:3px solid black;}
#border{border-top:1px dotted black; padding:20px;}
#border1{padding:20px; border-bottom:1px solid black;}
#border2{border-top:1px dotted black;padding:10px;} 
#border3{padding:20px;}  
</style>
</head>
</head>
<body>
<form name="joinform" action="MemberDetailAction.sh" method="post" 
   id="joinform">
   <input type="hidden" name="memberId" value=""/>
   <table border=0 align="center" id="tborder">
      <tr align="center"><td colspan =2 id="border1">
            <font size=5>회원정보 수정페이지</font>
         </td>
      </tr>
      <tr><td id="border3" align="center">아이디 : </td>
         <td id="border3" align="left"></td>
      </tr>
      <tr><td id="border" align="center">비밀번호 : </td>
         <td id="border" align="left">
            <input type="password" name="memberPw" value=""/>
         </td>
      </tr>
      <tr><td id="border" align="center">비밀번호 확인 : </td>
         <td id="border" align="left">
            <input type="password" name="memberPw2" value="" />
         </td>
      </tr>
      <tr><td id="border" align="center">이름 : </td>
          <td id="border" align="left"><input type="text"  name="memberName" value=""/></td>
      </tr>
      <tr><td id="border" align="center">성별 : </td>
          <td id="border" align="left"></td>
      </tr>
      <tr><td id="border" align="center">주소 : </td>
          <td id="border" align="left">
            <input type="text" id="memberZipCode" name="memberZipCode" value="" placeholder="우편번호" />
            <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"/><br> 
            <input type="text" id="memberAddr1" placeholder="주소" name="memberAddr1" value=""/> 
            <input type="text" id="memberAddr2" placeholder="상세주소" name="memberAddr2" value=""/>    
          </td>
      </tr>
      <tr>
         <td id="border" align="center">생년월일 : </td>
            <td id="border" align="left"><input type="text" name="memberBDay" value="" /></td>
         </tr>
      <tr>
         <td id="border" align="center">일반전화 : </td>
         <td id="border" align="left"><select name="memberPhone1" id="memberPhone1" value="" >
               <option value="02">02</option>
               <option value="031">031</option>
               <option value="032">032</option>
               <option value="033">033</option>
               <option value="041">041</option>
               <option value="042">042</option>
               <option value="043">043</option>
               <option value="051">051</option>
               <option value="052">052</option>
               <option value="053">053</option>
               <option value="061">061</option>
               <option value="062">062</option>
               <option value="063">063</option>
            </select> - <input type="text" name="memberPhone2" maxlength=4 size="5" value="" /> - <input
               type="text" name="memberPhone3" maxlength=4 size="5" value="" /></td>

         </tr>
         <tr>
            <td id="border" align="center">핸드폰 : </td>
            <td id="border" align="left"><select name="memberCellPhone1" id="memberCellPhone1" value="">
                  <option value="010">010</option>
                  <option value="011">011</option>
                  <option value="016">016</option>
                  <option value="019">019</option>
            </select> - <input type="text" name="memberCellPhone2" maxlength=4 size="5" value="" /> - <input
               type="text" name="memberCellPhone3" maxlength=4 size="5" value="" /> <input
               type="button" value="핸드폰인증" onclick="" /></td>
         </tr>
         <tr>
            <td id="border" align="center">sms 수신</td>
            <td id="border" align="left"><input type="radio" name="memberSMS" value="동의함" />동의함 <input
               type="radio" name="memberSMS" value="동의안함" checked />동의안함 <br />
               쇼핑몰에서 제공하는 유익한 이벤트 소식을 SMS로 받으실 수 있습니다.</td>
         </tr>
         <tr>
            <td id="border" align="center">이메일 : </td>
            <td id="border" align="left"><input type="text" name="memberEmail1" size=20 value=""/> @ <input
               type="text" name="memberEmail2" size=20 value=""/></td>
         </tr>
         <tr>
            <td id="border" align="center">이메일 수신</td>
            <td id="border" align="left"><input type="radio" name="memberEmailAgree" value="동의함" />동의함 <input
               type="radio" name="memberEmailAgree" value="동의안함" checked />동의안함 <br />
               쇼핑몰에서 제공하는 유익한 이벤트 소식을 이메일로 받으실 수 있습니다.</td>
         </tr>
      
      <tr><td colspan=2 align="center" id="border2">
            <a href="javascript:checkIt();">
            회원정보 수정</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="MemberMain.sh"> 메인으로</a>
         </td>
      </tr>
   </table>
</form>
</body>
</html>