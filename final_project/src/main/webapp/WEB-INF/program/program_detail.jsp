<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*, category.ExerciseCatACatB,
    model.ProgramExerciseUpload, command.ProgramDetailCommand, model.ProReview"%>

<%
	request.setCharacterEncoding("utf-8");
	List<ProReview> proReviewList = (List<ProReview>) request.getAttribute("proReviewList");
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
	function aca() {
		var num = document.getElementById("bca").value;
		$.ajax({
			type : "POST",
			url : "aca.gom",
			dataType : "html",
			data : "exerciseCatBNumber=" + num,
			success : function(result) {
				$('#aca').html(result);
			}

		});
	}
</script>
<style type="text/css">
.card-body {
	margin-top: 20px;
}

img {
	display: block;
	margin-left: auto;
	margin-right: auto;
}

#card-p {
	text-align: center;
	font-weight: bold;
	font-size: 20px;
}
</style>
<link rel="stylesheet" href="css/program_review_list.css">
<script src="js/program_review_list.js" type="text/javascript"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<!-- Image -->
			<div class="col-12 col-lg-6">
				<div class="card bg-light mb-3">
					<div class="card-body text-center" style="text-align: center;">
						<img src="resource\\<%=programDetailCommand.getProStored()%>"
							width="400" height="400" style="text-align: center;" />


					</div>
				</div>
			</div>

			<!-- Add to cart -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div class="card bg-light mb-3">
					<div class="card-body">
						<div class="input-group-prepend">
							<label for="colors">프로그램 내용 </label>

						</div>
						<input type="text" class="form-control"
							value="<%=programDetailCommand.getProContent()%>"
							readonly="readonly">
						<div class="input-group-prepend">
							<label for="colors">프로그램 가격 </label>

						</div>
						<input type="text" class="form-control"
							value="<%=programDetailCommand.getProPrice()%>"
							readonly="readonly">


						<div class="form-group">
							<label>Quantity :</label>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<button type="button"
										class="quantity-left-minus btn btn-danger btn-number"
										data-type="minus" data-field="">
										<i class="fa fa-minus"></i>
									</button>
								</div>
								<input type="text" class="form-control" id="quantity"
									name="quantity" min="1" max="100" value="1" readonly="readonly"
									style="text-align: center;">
								<div class="input-group-append">
									<button type="button"
										class="quantity-right-plus btn btn-success btn-number"
										data-type="plus" data-field="">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>
						</div>

						<form action="program_cart_addlist.gom" method="post">

							<input type="hidden" name="proNo"
								value="<%=programDetailCommand.getProNo()%>">

							<button type="submit"
								class="btn btn-success btn-lg btn-block text-uppercase">장바구니
								담기</button>
							<br>
						</form>
						<div class="product_rassurance">
							<ul class="list-inline">
								<li class="list-inline-item"><i class="fa fa-truck fa-2x"></i><br />Fast
									delivery</li>
								<li class="list-inline-item"><i
									class="fa fa-credit-card fa-2x"></i><br />Secure payment</li>
								<li class="list-inline-item"><i class="fa fa-phone fa-2x"></i><br />010
									2862 3167</li>
							</ul>
						</div>

						<div class="datasheet p-3 mb-2 bg-info text-white">
							<a href="" class="text-white"><i class="fa fa-file-text"></i>&nbsp;
								프로그램 상세정보</a>
						</div>
					</div>
				</div>
			</div>
		</div>



			<%
				String  str = "";
 				String str1 = "";
				for (Object temp : programExerciseUploadList) {
					ProgramExerciseUpload programexerciseUpload = (ProgramExerciseUpload) temp;
					str1 = programexerciseUpload.getExerciseContent();
					if (!str.equals(str1) ) {
			%>

		<div class="card border-light mb-3">
			<div class="card-header bg-primary text-white text-uppercase">
				<i class="fa fa-align-justify"></i>운동설명
			</div>
			<br>
			<%
				}
					if (programexerciseUpload.getUploadDivide().equals("i")) {
			%>
			<img src="resource\\<%=programexerciseUpload.getUploadStored()%>"
				width="700" height="400">
			<%
				}

					if (programexerciseUpload.getUploadDivide().equals("v")) {
			%>
			<video width="100%" height="400" controls="controls"
				>
				<source src="resource\\<%=programexerciseUpload.getUploadStored()%>"
					type="video/mp4" />
			</video>
			<%
				}

					if (!str.equals(str1)) {
			%>
			<br>
			<p id="card-p">칼로리: <%=programexerciseUpload.getExerciseCal()%>cal</p>
			<p id="card-p">운동내용: <%=programexerciseUpload.getExerciseContent()%></p>
				
			<%
				}
					str = programexerciseUpload.getExerciseContent();
			%>

			
		<%
			}
		%>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-12" id="reviews">
					<div class="card border-light mb-3">
						<div class="card-header bg-primary text-white text-uppercase">
							<i class="fa fa-comment"></i> Reviews
						</div>
					</div>			
				</div>
			</div>
		</div>					
		 <% for(Object temp : proReviewList) {
				ProReview proReview = (ProReview)temp; %>
				
<div class="container">
<div class="reviews">				
  <div class="row blockquote review-item col-12">
    <div class="col-md-3 text-center"> 
      <img class="rounded-circle reviewer" src="resource\\<%=proReview.getProReviewStored() %>" width="80" height="80">
      <div class="caption">
      
        <small>by <a href="pro_review_update.gom?proReviewNo=<%=proReview.getProReviewNo()%>
        &proReviewTitle=<%=proReview.getProReviewTitle()%>
        &proReviewScore=<%=proReview.getProReviewScore()%>
        &proReviewComment=<%=proReview.getProReviewComment()%>
        &proReviewOriginal=<%=proReview.getProReviewOriginal()%>
        ">
        <%=proReview.getMemberEmail() %></a></small>
      </div>

    </div>
    <div class="col-md-9">
      <h4><%=proReview.getProReviewTitle() %></h4>
      <div class="ratebox text-center" data-id="0" data-rating="5"></div>
      <p class="review-text">
      	<%=proReview.getProReviewComment() %>
      </p>

      <small class="review-date"><%=proReview.getProReviewRegdate() %></small>
      
      
      <a href="pro_review_report_write.gom?proReviewNo=<%=proReview.getProReviewNo()%>
      &memberEmail=<%=proReview.getMemberEmail() %>
      &proNo=<%=proReview.getProNo() %>
      &coachEmail=<%=proReview.getCoachEmail() %>
      "><button class="text-right btn btn-secondary">신고하기</button></a>
    </div>
	</div>	
  </div> 
	
						
  <% } %>

	</div>					
				
					
				

	<hr>
</body>
</html>
