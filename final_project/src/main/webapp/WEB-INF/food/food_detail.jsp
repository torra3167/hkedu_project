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
	
// 	for(Object temp : foodReviewAndAnswers) {
// 		FoodReviewAndAnswer fraa = (FoodReviewAndAnswer)temp;
// 		System.out.println("jsp selectReviewAndAnswer selectReviewAndAnswer : " + fraa.getFoodReviewRegdate());
// 		List<FoodReviewAnswer> fra = fraa.getFoodReviewAnswers();
// 		System.out.println("jsp selectReviewAndAnswer FoodReviewAnswers : " + fra.size());
// 		for(Object temp2 : fra) {
// 			FoodReviewAnswer foodReviewAnswer = (FoodReviewAnswer)temp2;
// 			System.out.println("jsp selectReviewAndAnswer getFoodReviewAnswerRegdate : " + foodReviewAnswer.getFoodReviewAnswerRegdate());
// 		}
// 	}
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
                                int salePrice = (int) (foodAndApplication.getFoodSale() - (foodAndApplication.getFoodPrice() * (foodAndApplication.getFoodSale()*0.01)));
                %>
	    		<h3><%=salePrice %>원</h3><!-- (판매가) -->
	    		<div>배송비 2,500원</div>
	    		<div>
	    			<form action="cart_addList.gom" method="post">
						<div class="form-row">
			                <div class="form-group col-sm-2">
			                	<label>수량</label>
			                	<input type="text" name="demandQty" class="form-control" maxlength="20">
			              	</div>
		              	</div>
		              	<div>총 150,000원(8개)</div>
						<input type="hidden" name="foodNo" value="<%=foodAndApplication.getFoodNo() %>">
						
						<button type="submit" class="btn btn-primary">장바구니 담기</button>
					</form>
    			</div>
    	
    		</div>
    	</div>
    	
    	
    	
    	<hr>
    	
    	<div>
    		<div>식품설명</div>
    		<div>탄수화물 : <%=foodAndApplication.getFoodCarbo() %>g</div>
    		<div>단백질 : <%=foodAndApplication.getFoodProtein() %>g</div>
    		<div>지방 : <%=foodAndApplication.getFoodFat() %>g</div>
    		<div>열량 : <%=foodAndApplication.getFoodCal() %>kcal</div>
    		<div>유통기한 : <%=foodAndApplication.getFoodExpiryDate() %></div>
    		<div>원산지 :<%=foodAndApplication.getFoodOrigin() %></div>
    		<div>소비자상담관련 업체 연락처 <%=foodAndApplication.getStoreTelphone() %></div>
    		<div>업체 주소 <%=foodAndApplication.getStoreAddr() %></div>
    	</div>
    	
    
<!-- ------------------------------------------------------------------------------- -->  
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- -------------------리뷰목록------------------------------------------------------------ -->

  
    
    <hr>
    <h3>전체 구매후기</h3>
    상품을 구매하신 분들이 작성하신 구매 후기입니다.
      <form method="#" action="#" class="form-inline mt-3">
        <select name="lectureDivide" class="form-control mx-1 mt-2">
          <option value="작성자">작성자</option>
          <option value="식품명">제목</option>
        </select>
        <input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요.">
        <a class="btn btn-primary mx-1 mt-2" href="food_reviewWrite.gom?foodNo=<%=foodAndApplication.getFoodNo() %>">등록하기</a>
        
        <button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
      </form>
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
		         <a class="btn btn-primary ml-1 mt-2" href="food_reviewUpdate.gom?foodReviewNo=<%=foodReviewAndAnswer.getFoodReviewNo() %>&foodNo=<%=foodReviewAndAnswer.getFoodNo() %>">리뷰 수정</a>
		         <a class="btn btn-danger ml-1 mt-2" href="food_reviewDelete.gom?foodReviewNo=<%=foodReviewAndAnswer.getFoodReviewNo() %>">리뷰 삭제</a>
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
>>>>>>> 867a84a10d52b8e8197eac8a00e2b5282705c69d
	    <ul class="pagination justify-content-center mt-3">
	      <li class="page-item">
	        <a class="page-link" href="#">이전</a>
	      </li>
	      <li class="page-item">
	        <a class="page-link" href="#">다음</a>
	      </li>
	    </ul>
    </div>
  </body>
</html>

