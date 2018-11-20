<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import= "command.ProReviewWriteCommand"%>
	
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%
	ProReviewWriteCommand proReviewWriteCommand = 
	(ProReviewWriteCommand) request.getAttribute("ProReviewWriteCommand");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="modal" tabindex="-1" role="dialog">
		<h5>프로그램리뷰 등록</h5>
		<button type="button" class="close" data-dismiss="modal"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div class="body"> 
		<form:form commandName="proReviewWriteCommand" action="pro_review_write.gom" enctype="multipart/form-data">
			<input type="hidden" name="proNo" value="<%=proReviewWriteCommand.getProNo()%>">
			<input type="hidden" name="coachEmail" value="<%=proReviewWriteCommand.getCoachEmail() %>">
			<div class="form-group">
				<label>제목</label> <form:input path="proReviewTitle" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label>총평</label>
				<textarea type="text" name="proReviewComment" class="form-control col-sm-3"
					 style="height: 180px;"></textarea>
			</div>
			<div class="form-group">
				<label>이미지</label> <input type="file" name="proReviewImage"
					class="form-control">
			</div>
			<div class="form-row">
				<div class="form-group">
					<label>총점</label> <select name="proReviewScore" class="form-control">
						<option value="1" selected>★</option>
						<option value="2">★★</option>
						<option value="3">★★★</option>
						<option value="4">★★★★</option>
						<option value="5">★★★★★</option>
					</select>
				</div>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary">등록하기</button>
				<button type="reset" class="btn btn-primary">다시 작성</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</form:form>
	</div>
</body>
</html>