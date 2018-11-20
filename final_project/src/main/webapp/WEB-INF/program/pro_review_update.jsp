<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*, model.*, category.*, command.ProReviewUpdateCommand"%>

<%
 	List list = (List)request.getAttribute("list");
ProReviewUpdateCommand proReviewUpdateCommand = 
(ProReviewUpdateCommand)request.getAttribute("ProReviewUpdateCommand");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>

<body>

	<div class="container mt-3" style="max-width: 560px;">
		<form:form commandName="proReviewUpdateCommand"
			action="pro_review_update.gom" enctype="multipart/form-data">
			
			<div class="form-group">
				<label>프로그램리뷰 번호</label>
				<form:input path="proReviewNo" class="form-control" readonly="true" />
			</div>
			<div class="form-group">
				<label>프로그램리뷰 제목</label>
				<form:input path="proReviewTitle" class="form-control" />
			</div>
			
			<div class="form-group">
					<label>총점</label> <select name="proReviewScore" class="form-control">
						<option value="1">★</option>
						<option value="2">★★</option>
						<option value="3">★★★</option>
						<option value="4">★★★★</option>
						<option value="5">★★★★★</option>
					</select>
				</div>
			
			<div class="form-group">
				<label>프로그램리뷰 총평</label>
				<form:input path="proReviewComment" class="form-control" />
			</div>
			
			<div class="form-group">
				<label>변경전 프로그램리뷰 이미지 파일</label>
				 <form:input path="proReviewOriginal" class="form-control" readonly="true" /> 
				
				<input type="hidden" name="proReviewStored" value="<%=proReviewUpdateCommand.getProReviewStored()%>">
	 		
			</div>
			
			<div class="form-group">
				<label>변경할 프로그램리뷰 이미지 파일</label> 
				<input type="file" name="proReviewImage" class="form-control">
					
					
			</div>
			
			
			<button type="submit" class="btn btn-primary">수정 완료</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
			<button type="button" class="btn btn-primary"
				onclick="history.go(-1);">뒤로가기</button>
		</form:form>
	</div>

</body>
</html>