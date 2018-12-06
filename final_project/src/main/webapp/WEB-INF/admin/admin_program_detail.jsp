<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, category.ExerciseCatACatB,
    model.ProgramExerciseUpload, command.ProgramDetailCommand"%>

<%
	request.setCharacterEncoding("utf-8");
	List<ProgramExerciseUpload> programExerciseUploadList = (List<ProgramExerciseUpload>) request
			.getAttribute("ProgramExerciseUpload");
	String email = (String) session.getAttribute("email");
	ProgramDetailCommand programDetailCommand = (ProgramDetailCommand) request
			.getAttribute("ProgramDetailCommand");
%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	
	function rejectFunction() {
	
	var inputString = prompt('반려 이유를 작성해주세요', '반려이유');
	location.href="program_reject.gom?proNo=<%=programDetailCommand.getProNo()%>
	&proDes="
				+ inputString;

	}
</script>
<style type="text/css">
video {
	
}
</style>

</head>
<body>

	<div class="container">
		<div class="row">
			<!-- Image -->
			<div class="col-12 col-lg-6">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<a href="" data-toggle="modal" data-target="#productModal"> <img
							class="img-fluid"
							src="resource\\<%=programDetailCommand.getProStored()%>"
							width="800" height="800" />
							<p class="text-center">Zoom</p>
						</a>
					</div>
				</div>
			</div>

			<!-- Add to cart -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div class="card bg-light mb-3">
					<div class="card-body">


						<div class="form-group">
							<label for="colors">내용</label>
							<%=programDetailCommand.getProContent()%>
						</div>
						<div class="form-group">
							<label for="colors">가격</label>
							<%=programDetailCommand.getProPrice()%>
						</div>

						<form action="program_cart_addlist.gom" method="post">

							<input type="hidden" name="proNo"
								value="<%=programDetailCommand.getProNo()%>">

							<button type="submit"
								class="btn btn-success btn-lg btn-block text-uppercase">장바구니
								담기</button>
						</form>

					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<!-- Description -->
			<div class="col-12">
				<div class="card border-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-align-justify"></i>제품설명
					</div>

					<div class="container mt-3">
						<table class="table table-striped text-center">
							<thead>
								<tr class="active">

									<th>운동 번호</th>
									<th>운동내용</th>
									<th>운동칼로리</th>
									<th>업로드번호</th>
									<th>사이즈</th>
									<th>파일</th>
									<th>파일이름</th>
									<th>구분</th>

								</tr>
							</thead>
							<tbody>
								<tr>
									<%
										for (Object temp : programExerciseUploadList) {
											ProgramExerciseUpload programexerciseUpload = (ProgramExerciseUpload) temp;
									%>

									<td><%=programexerciseUpload.getExerciseNumber()%></td>
									<td><a
										href="exercise_update.gom?exerciseNumber=<%=programexerciseUpload.getExerciseNumber()%>
				&exerciseContent=<%=programexerciseUpload.getExerciseContent()%>
				&exerciseCatANumber=<%=programexerciseUpload.getExerciseCatANumber()%>
				&exerciseCatBNumber=<%=programexerciseUpload.getExerciseCatBNumber()%>
				&exerciseCal=<%=programexerciseUpload.getExerciseCal()%>">
											<%=programexerciseUpload.getExerciseContent()%></a></td>
									<td><%=programexerciseUpload.getExerciseCal()%></td>
									<td><a
										href="upload_update.gom?proNo=<%=programDetailCommand.getProNo()%>
					&uploadNumber=<%=programexerciseUpload.getUploadNumber()%>
					&exerciseNumber=<%=programexerciseUpload.getExerciseNumber()%>
					&exerciseContent=<%=programexerciseUpload.getExerciseContent()%>
					&exerciseCatANumber=<%=programexerciseUpload.getExerciseCatANumber()%>
					&exerciseCatBNumber=<%=programexerciseUpload.getExerciseCatBNumber()%>
					&uploadStored=<%=programexerciseUpload.getUploadStored()%>					
					&uploadOriginal=<%=programexerciseUpload.getUploadOriginal()%>
					"><%=programexerciseUpload.getUploadNumber()%></a></td>
									<td><%=programexerciseUpload.getUploadSize()%></td>

									<%
										if (programexerciseUpload.getUploadDivide().equals("i")) {
									%>
									<td><img
										src="resource//<%=programexerciseUpload.getUploadStored()%>"
										width="340" height="260"></td>
									<%
										}
									%>

									<%
										if (programexerciseUpload.getUploadDivide().equals("v")) {
									%>
									<td><video width="340" height="260" controls="controls">
											<source
												src="resource//<%=programexerciseUpload.getUploadStored()%>"
												type="video/mp4" />
										</video></td>
									<%
										}
									%>


									<td><%=programexerciseUpload.getUploadOriginal()%></td>
									<td><%=programexerciseUpload.getUploadDivide()%></td>



								</tr>
								<%
									}
								%>

							</tbody>
						</table>


					</div>
				</div>
			</div>


		</div>
	</div>

	<hr>
</body>
</html>
