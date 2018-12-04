<%@page import="model.FoodReviewAndAnswer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.FoodAndApplication, model.FoodReviewAndAnswer, model.FoodReviewAnswer"%>
<%
	//식품, 판매자, 업체 정보
	FoodAndApplication foodAndApplication = (FoodAndApplication)request.getAttribute("fa");
	//식품리뷰, 식품리뷰답변 정보
	List<FoodReviewAndAnswer> foodReviewAndAnswers = (List<FoodReviewAndAnswer>)request.getAttribute("foodReviewAndAnswers");
	//답변보기버튼 구분자
	int answerButton = 0;

	String memberDivide = (String)request.getAttribute("memberDivide");
	String loginEmail = (String)session.getAttribute("email");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품 상세보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<style type="text/css">
    .regularPrice { text-decoration:line-through }
</style>
</head>
<body>
    <div class="container">
    	<div class="row">
    		<div class="col-sm-6"><img src="http://localhost:8080/final_project/resource/<%=foodAndApplication.getFoodStored() %>"></div>
    		<div class="col-sm-6">
	    		<h5><%=foodAndApplication.getStoreName() %></h5><!-- (업체명) -->
	    		<h3><%=foodAndApplication.getFoodName() %></h3>
	    		<div class="regularPrice"><%=foodAndApplication.getFoodPrice() %>원</div><!-- (정상가) -->
	    		<h3 class="savingsOff"><%=foodAndApplication.getFoodSale() %>% OFF</h3>
	    		<%
                                int salePrice = (int) (foodAndApplication.getFoodPrice() - (foodAndApplication.getFoodPrice() * (foodAndApplication.getFoodSale()*0.01)));
                %>
	    		<h3><%=salePrice %>원</h3><!-- (판매가) -->
<!-- 	    		<div>배송비 2,500원</div> -->
	    		<div>
	    			<form action="cart_addList.gom" method="post">
						<div class="form-row">
			                <div class="form-group col-sm-2">
			                	<label>수량</label>
			                	<input type="text" name="demandQty" class="form-control" maxlength="20">
			              	</div>
		              	</div>
						<input type="hidden" name="foodNo" value="<%=foodAndApplication.getFoodNo() %>">
						
						<button type="submit" class="btn btn-primary">장바구니 담기</button>
					</form>
    			</div>
    	
    		</div>
    	</div>
<!--     	<hr> -->
<!--     	<div class="row"> -->
<!--     	<table class="table-light col"> -->
<!--     		<thead> -->
<!--     			<tr><td colspan="2">식품 설명</td></tr> -->
<!--     		</thead> -->
<!--     		<tbody> -->
<%--     			<tr><td>탄수화물 함량</td><td><%=foodAndApplication.getFoodCarbo() %>g</td></tr> --%>
<%--     			<tr><td>단백질 함량</td><td><%=foodAndApplication.getFoodProtein() %>g</td></tr> --%>
<%--     			<tr><td>지방 함량</td><td><%=foodAndApplication.getFoodFat() %>g</td></tr> --%>
<%--     			<tr><td>열량</td><td><%=foodAndApplication.getFoodCal() %>kcal</td></tr> --%>
<%--     			<tr><td>유통기한</td><td><%=foodAndApplication.getFoodExpiryDate() %></td></tr> --%>
<%--     			<tr><td>소비자상담관련 업체 연락처</td><td><%=foodAndApplication.getStoreTelphone() %></td></tr> --%>
<%--     			<tr><td>업체 주소</td><td><%=foodAndApplication.getStoreAddr() %></td></tr> --%>
<!--     		</tbody> -->
<!--     	</table> -->
<!--     	</div> -->
<br>
<br>
    	<ul class="list-group list-group-flush">
			  <li class="list-group-item">탄수화물 함량 : <%=foodAndApplication.getFoodCarbo() %>g</li>
			  <li class="list-group-item">단백질 함량 : <%=foodAndApplication.getFoodProtein() %>g</li>
			  <li class="list-group-item">지방 함량 : <%=foodAndApplication.getFoodFat() %>g</li>
			  <li class="list-group-item">열량 : <%=foodAndApplication.getFoodCal() %>kcal</li>
			  <li class="list-group-item">유통기한 : <%=foodAndApplication.getFoodExpiryDate() %></li>
			  <li class="list-group-item">소비자상담관련 연락처 : <%=foodAndApplication.getStoreTelphone() %></li>
			  <li class="list-group-item">업체 주소 : <%=foodAndApplication.getStoreAddr() %></li>
		</ul>
    	<%-- <div>
    		<div>탄수화물 함량 : <%=foodAndApplication.getFoodCarbo() %>g</div>
    		<div>단백질 함량: <%=foodAndApplication.getFoodProtein() %>g</div>
    		<div>지방 함량: <%=foodAndApplication.getFoodFat() %>g</div>
    		<div>열량 : <%=foodAndApplication.getFoodCal() %>kcal</div>
    		<div>유통기한 : <%=foodAndApplication.getFoodExpiryDate() %></div>
    		<div>소비자상담관련 업체 연락처 : <%=foodAndApplication.getStoreTelphone() %></div>
    		<div>업체 주소 : <%=foodAndApplication.getStoreAddr() %></div>
    	</div> --%>
    	
    
<!-- ------------------------------------------------------------------------------- -->  
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- -------------------리뷰목록------------------------------------------------------------ -->

  
    
<!--     <hr> -->
<br>
<br>
    <h3>전체 구매후기</h3>
    상품을 구매하신 분들이 작성하신 구매 후기입니다.
        <a class="btn btn-primary mx-1 mt-2" href="food_reviewWrite.gom?foodNo=<%=foodAndApplication.getFoodNo() %>">등록하기</a>
      <% 
      	  if(foodReviewAndAnswers.size() > 0){
	      	  for(Object temp : foodReviewAndAnswers){
	    	  FoodReviewAndAnswer foodReviewAndAnswer =  (FoodReviewAndAnswer)temp;
	  %>
			    <div class="card bg-light mt-3">
			        <div class="card-header bg-light">
			          <div class="row">
			            <div class="col-8 text-left"><%=foodReviewAndAnswer.getFoodReviewTitle() %>&nbsp;&nbsp;&nbsp;&nbsp;<small><%=foodReviewAndAnswer.getMemberEmail() %></small></div>
			            <div class="col-4 text-right"><%=foodReviewAndAnswer.getFoodReviewRegdate() %>
			            </div>
			          </div>
			        </div>
			        <div class="card-body">
			          <p class="card-text"><%=foodReviewAndAnswer.getFoodReviewComment() %>
			          </p>
			          <img src="http://localhost:8080/final_project/resource/<%=foodReviewAndAnswer.getFoodReviewStored() %>" width="200" height="200">
			          <div class="row">
			            <div class="col-9 text-left">
			            	<p><%=foodReviewAndAnswer.getFoodReviewScore() %></p>
			            </div>
			          </div>
			        </div>
			     </div>
			     <%
			     	answerButton = answerButton + 1;
			     %>
		         <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo<%=answerButton %>">답변 보기</button>
		         <a class="btn btn-primary mx-1 mt-2" href="food_reviewAnswerWrite.gom?foodReviewNo=<%=foodReviewAndAnswer.getFoodReviewNo() %>&foodNo=<%=foodReviewAndAnswer.getFoodNo() %>&memberEmail=<%=foodReviewAndAnswer.getMemberEmail() %>">답변 등록</a>
		         <a class="btn btn-danger ml-1 mt-2" href="food_reviewReportWrite.gom?foodReviewNo=<%=foodReviewAndAnswer.getFoodReviewNo() %>&foodNo=<%=foodReviewAndAnswer.getFoodNo() %>&memberEmail=<%=foodReviewAndAnswer.getMemberEmail() %>">리뷰 신고</a>
		         <%	if(loginEmail.equals(foodReviewAndAnswer.getMemberEmail())||loginEmail.equals("admin")){	%>
			         <a class="btn btn-primary ml-1 mt-2" href="food_reviewUpdate.gom?foodReviewNo=<%=foodReviewAndAnswer.getFoodReviewNo() %>&foodNo=<%=foodReviewAndAnswer.getFoodNo() %>">리뷰 수정</a>
			         <a class="btn btn-danger ml-1 mt-2" href="food_reviewDelete.gom?foodReviewNo=<%=foodReviewAndAnswer.getFoodReviewNo() %>">리뷰 삭제</a>
		         <%	} %>
		      		<%
		      			List<FoodReviewAnswer> foodReviewAnswers = foodReviewAndAnswer.getFoodReviewAnswers();
		      			if(foodReviewAnswers.size() > 0){
		      				for(Object temp2 : foodReviewAnswers){
		      					FoodReviewAnswer foodReviewAnswer = (FoodReviewAnswer)temp2;
		      				
		      		%>
				        <div id="demo<%=answerButton %>" class="collapse">
					        <div class="card bg-light mt-3">
						        <div class="card-header bg-light">
						          <div class="row">
						            <div class="col-6 text-left"><small><%=foodReviewAndAnswer.getSellerEmail() %></small></div>
						            <div class="col-4 text-right"><%=foodReviewAnswer.getFoodReviewAnswerRegdate() %></div>
						            <div class="col-1 text-right"><a class="" href="food_reviewAnswerUpdate.gom?foodReviewNo=<%=foodReviewAndAnswer.getFoodReviewNo() %>&foodNo=<%=foodReviewAndAnswer.getFoodNo() %>&memberEmail=<%=foodReviewAndAnswer.getMemberEmail() %>&foodReviewAnswerNo=<%=foodReviewAnswer.getFoodReviewAnswerNo() %>">수정</a></div>
						            <div class="col-1 text-right"><a class="" href="food_reviewAnswerDelete.gom?foodReviewAnswerNo=<%=foodReviewAnswer.getFoodReviewAnswerNo() %>">삭제</a></div>
						          </div>
						        </div>
						        <div class="card-body">
						          <p class="card-text"><%=foodReviewAnswer.getFoodReviewAnswerContent() %></p>
						        </div>
					        </div>
				        </div>
				        <% } %>
		        	<% }else {%>
		        		<div id="demo<%=answerButton %>" class="collapse">
					        <div class="card bg-light mt-3">
						        <div class="card-body">
						          <p class="card-text">등록된 답변이 없습니다.</p>
						        </div>
					       </div>
				      </div>
		        	<% } %>
		        <% } %>
        <% } else { %>
        	<div class="card bg-light mt-3">
		        <div class="card-body">
		          <p class="card-text">등록된 리뷰가 없습니다.</p>
		        </div>
			</div>
        <% } %>
    </div>
  </body>
</html>

