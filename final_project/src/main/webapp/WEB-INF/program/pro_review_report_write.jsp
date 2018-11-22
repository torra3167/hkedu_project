<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import= "command.ProReviewReportWriteCommand"%>
	
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%
ProReviewReportWriteCommand proReviewReportWriteCommand = 
	(ProReviewReportWriteCommand) request.getAttribute("ProReviewReportWriteCommand");


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="" >
		<h5>프로그램리뷰 신고등록</h5>

	</div>
	<div class="body"> 
		<form:form commandName="proReviewReportWriteCommand" action="pro_review_report_write.gom" >
			<form:hidden path="proReviewNo" class="form-control"/>
			<form:hidden path="proNo" class="form-control"/>
			<form:hidden path="coachEmail" class="form-control"/>
			<form:hidden path="memberEmail" class="form-control" />
		
            
              <div class="form-group">
                <label>제목</label>
                <form:input path="proReviewReportTitle" class="form-control"  />
              </div>
              
              <div class="form-group">
                <label>내용</label>
                <form:textarea path="proReviewReportContent" class="form-control"  />
              </div>
			
			<div class="">
				<button type="submit" class="btn btn-primary">등록하기</button>
				<button type="reset" class="btn btn-primary">다시 작성</button>
				<button type="button" class="btn btn-secondary">취소</button>
			</div>
			
		  </div>
		  </form:form>
	
</body>
</html>