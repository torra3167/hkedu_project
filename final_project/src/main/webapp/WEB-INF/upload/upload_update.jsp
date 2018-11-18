<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*,  command.UploadUpdateCommand"%>

<%
	UploadUpdateCommand uploadUpdateCommand = (UploadUpdateCommand)request.getAttribute("uploadUpdateCommand");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>

<body>

	<div class="container mt-3" style="max-width: 560px;">
		<form:form commandName="uploadUpdateCommand" method="post"
			action="upload_update.gom" enctype="multipart/form-data">
			
			<div class="form-group">
				<label>업로드 번호</label>
				<form:input path="uploadNumber" class="form-control" readonly="true" />
			</div>
			<div class="form-group">
				<label>운동 번호</label>
				<form:input path="exerciseNumber" class="form-control" readonly="true"/>
			</div>
			
			<div class="form-group">
				<label>운동 내용</label>
				<form:input path="exerciseContent" class="form-control" />
			</div>
			
			
					<div class="form-group">
					<label>운동 분류</label>
					<form:input path="exerciseCatBName" class="form-control" readonly="true" />
					<form:input path="exerciseCatAName" class="form-control" readonly="true"/>
				
			</div>
			
		
			
			<div class="form-group">
				<label>변경전 운동파일</label>
				 <form:input path="uploadOriginal" class="form-control" readonly="true" /> 
			
	 		<input type="hidden" name="uploadStored" value="<%=uploadUpdateCommand.getUploadStored()%>">
			<input type="hidden" name="proNo" value="<%=uploadUpdateCommand.getProNo()%>"> 
			</div>
			
			<div class="form-group">
				<label>변경할 운동 파일</label> 
				<input type="file" name="uploadFile" class="form-control">
					
					
			</div>
			
			
			<button type="submit" class="btn btn-primary">수정 완료</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
			<button type="button" class="btn btn-primary"
				onclick="history.go(-1);">뒤로가기</button>
		</form:form>
	</div>

</body>
</html>