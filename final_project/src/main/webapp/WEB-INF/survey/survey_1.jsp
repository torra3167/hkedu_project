<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
	String email=(String)session.getAttribute("email");
	System.out.println("jsp "+email);
	Integer result = 0;
 	if(email == null){
		email = "1";
	} 
%>
<!doctype html>
<html>
<head>
<title>설문지</title>
</head>
<script type="text/javascript">
<%-- function idChk(){
	var frm=document.getElementById('frm');
	if(<%=result%>==1){
		location.href='http://localhost:8080/final_project/survey_success.gom';
	}else{
		frm.submit();
	}
} --%>
    function bmi_calculator() {     //bmi와 적정체중 계산 함수
        var height = document.getElementById('survHeight').value;   //키(cm)를 입력받음
        var height_m_conversion = height / 100;     
        var weight = document.getElementById('survWeight').value; //무게를 입력받음
        var user_BMI = weight / (height_m_conversion * height_m_conversion);    
        var user_BMI_decimal = Math.round(user_BMI * 10) / 10; 
        var healthy_weight = (height - 100) * 0.9;  //적정 체중 계산
        
        var bmi_output;     //리턴할 변수 선언
        if (user_BMI < 18.6) {      //케이스에 따라 선언한 변수에 안내문 대입
            bmi_output = "당신의 BMI는 " + user_BMI_decimal + ", 저체중이며 적정 체중은 " + healthy_weight + "kg 입니다.";
        } else if (user_BMI < 22.9) {
            bmi_output = "당신의 BMI는 " + user_BMI_decimal + ", 정상이며 적정 체중은 " + healthy_weight + "kg 입니다.";
        } else if (user_BMI < 24.9) {
            bmi_output = "당신의 BMI는 " + user_BMI_decimal + ", 과체중이며 적정 체중은 " + healthy_weight + "kg 입니다.";
        } else if (user_BMI < 30) {
            bmi_output = "당신의 BMI는 " + user_BMI_decimal + ", 비만이며 적정 체중은 " + healthy_weight + "kg 입니다.";
        } else if (user_BMI >= 30) {
            bmi_output = "당신의 BMI는 " + user_BMI_decimal + ", 고도비만이며 적정 체중은 " + healthy_weight + "kg 입니다.";
        }
        document.getElementById('healthyWeight').value = Math.floor(healthy_weight);
        document.getElementById('survBMI').value = Math.floor(user_BMI_decimal);
        console.log(document.getElementById('survBMI').value);
        console.log(document.getElementById('healthyWeight').value);
        console.log('<%=email%>');
        return alert(bmi_output);       //리턴
    }
</script>
<body>
	<div class="container">
		<form:form id="frm" action="member_write_survey1.gom" commandName="memberSurveyCommand" >
<%-- 			<form:hidden path="survNo" value=""/>
 --%>			<form:hidden path="memberEmail" value="<%=email%>"/>
 				<form:hidden path="healthyWeight" name="healthyWeight" id="healthyWeight" value="" />
 				
			<div class="form-group">
				<label>신장</label> <form:input class="form-control" path="survHeight" id="survHeight" placeholder="cm"/>
			</div>				
			<div class="form-group">
				<label>체중</label> <form:input class="form-control" path="survWeight" id="survWeight" placeholder="kg"/>
			</div>
			<div class="form-group">
				<label>BMI</label> <form:input class="form-control" path="survBMI" id="survBMI" readonly="true" placeholder="신장과 키를 입력 후 버튼을 클릭하세요."/>
			</div>
			<button type="button" onclick="bmi_calculator();" class="btn btn-secondary">BMI 계산</button>
			
			<div class="form-group">
				<label>연령</label> <form:input class="form-control" path="survAge"/>
			</div>
			<div class="form-group">
				<label>식습관</label> <select class="selectpicker form-control" data-style="btn-primary"  id="survEat" name="survEat">
					<option value="" selected>--선택--</option>
					<option value="채식주의">채식주의</option>
					<option value="야채를 많이 섭취함">야채를 많이 섭취함</option>
					<option value="육류를 많이 섭취함">육류를 많이 섭취함</option>
					<option value="유제품을 많이 섭취함">유제품을 많이 섭취함</option>
					<option value="곡물을 많이 섭취함">곡물을 많이 섭취함</option>
					<option value="간헐적으로 폭식">간헐적으로 폭식</option>
					<option value="간헐적 단식">간헐적 단식</option>
				</select>
			</div>
			<div class="form-group">
            <label>다이어트 목표 기간</label> <select class="selectpicker form-control" data-style="btn-primary" id="surveyDietPeriod" name="surveyDietPeriod">
            	<option value="0" selected>--선택--</option>
            	<option value="3" >3개월</option>
            	<option value="6" >6개월</option>
             	<option value="9" >9개월</option>
            	
                </select>
        	</div>
			<%-- <form:hidden path="survSex" value=""/>
			<form:hidden path="survLifestyle" value=""/>
			<form:hidden path="survShape" value=""/>
			<form:hidden path="survDisease" value=""/>
			<form:hidden path="survConcern" value=""/> --%>
			
			
			<button type="submit" class="btn btn-primary" >완료</button>
			<button type="reset" class="btn btn-secondary">다시 작성</button>
			<button type="button" class="btn btn-secondary">뒤로가기</button>
		</form:form>
	</div>
</body>
</html>