<%@page import="model.FoodAndApplication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.FoodAndApplication, model.AvgReviewScore"%>
<%
	//전체식품
	List<FoodAndApplication> foodAppliList = (List<FoodAndApplication>)request.getAttribute("foodAppliList");

	//코치 추천 식품
	List<FoodAndApplication> coachRecomFoodList = (List<FoodAndApplication>)request.getAttribute("coachRecomFoodList");
// 	System.out.println("size : "+coachRecomFoodList.size());
	
	//리뷰총점 평균값
	List<AvgReviewScore> avgrsList = new ArrayList<AvgReviewScore>();
	avgrsList = (List<AvgReviewScore>)request.getAttribute("avgrsList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>판매식품 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<style type="text/css">
    	.regularPrice { text-decoration:line-through }
    	 a:link { color: black; text-decoration: none;}
		 a:visited { color: black; text-decoration: none;}
		 a:hover { color: black; text-decoration: none;}
	</style>
</head>
<body>
<div class="container mt-3 mt-sm-5">
<%if(!(coachRecomFoodList.size()>0)){ %>
	<div class="row">
		<div class="card bg-light"><h6><a href="member_write_survey1.gom">프로그램을 구매하시면 회원님께 적합한 식품을 코치로부터 추천 받을 수 있습니다.</a></h6></div>
	</div>
<% }else{ %>
	<h5>코치 추천 식품</h5>
<br>
<%} %>

<div class="container">
	<div class="row">
		  <% for(int i=0; i<coachRecomFoodList.size(); i++){
			FoodAndApplication coachRecomFoodAppli = coachRecomFoodList.get(i);
			if(i==3){
				break;
			}
		  %>

                <div class="col-md-4">
                  			<div class="">
		                         <a href="food_detail.gom?foodNo=<%coachRecomFoodAppli.getFoodNo(); %>"><img class="card-img-top" src="http://localhost:8080//final_project//resource//<%=coachRecomFoodAppli.getFoodStored() %>"/></a>
		                        <div class="card-block card">
		                            <h6 class="card-text"><%=coachRecomFoodAppli.getFoodStored() %></h6>
		                            <h4 class="card-title"> <a href="food_detail.gom?foodNo=<%=coachRecomFoodAppli.getFoodNo() %>"><%=coachRecomFoodAppli.getFoodName() %></a></h4>
		                            <div class="regularPrice"><%=coachRecomFoodAppli.getFoodPrice() %></div>
		                            <h4 class="card-text"><%=coachRecomFoodAppli.getFoodSale() %>% OFF</h4>
		                            <%
		                            	int salePrice = (int) (coachRecomFoodAppli.getFoodPrice() - (coachRecomFoodAppli.getFoodPrice() * (coachRecomFoodAppli.getFoodSale()*0.01)));
		                            %>
		                            <h4 class="card-text"><%=salePrice %>원</h4>
			                         <% AvgReviewScore avgrs = new AvgReviewScore();
			                            int totalScore = 0;
			                            String star = "☆";
			                            	for(Object tp : avgrsList){
			                            		avgrs = (AvgReviewScore)tp;
			                            		if(avgrs.getFoodNo()==coachRecomFoodAppli.getFoodNo()){
			                            			totalScore += (int)avgrs.getAvgReviewScore();
			                            			System.out.println("totalScore : "+totalScore);
			                            			star = "";
					                            		for(int s=0; s<totalScore; s++){
					                            			star += "★";
					               						} %>
					                        <% } %>
		       	                    	<% } %>
		                           <div class="row">
		                                <div class="col-6 text-left"><%=star %></div>
		                           </div>
	                        </div>
               			</div>
               		</div>
         <% } %>
	
	</div>
</div>
	<br>
  	<br>
  	<hr>
  	<br>
  	<br>
<!--   ------------------------------------------------------------------------ -->
	
	  <!-- Nav tabs -->
	<ul class="nav nav-tabs nav-justified">
	  <li class="nav-item">
	    <a class="nav-link active" data-toggle="tab" href="#home">전체</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu1">다이어트식</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu2">증량식</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu3">특별식</a>
	  </li>
	</ul>
	
	<br>
	<br>
	<!-- Tab panes -->
<div class="tab-content">
		<div class="tab-pane container active" id="home">
			<div class="row">
		      <% for(Object temp : foodAppliList) {
	        	FoodAndApplication foodAppli = (FoodAndApplication)temp; %>
                <div class="col-md-4">
                  			<div class="">
		                         <a href="food_detail.gom?foodNo=<%foodAppli.getFoodNo(); %>"><img class="card-img-top" src="http://localhost:8080//final_project//resource//<%=foodAppli.getFoodStored() %>"/></a>
		                        <div class="card-block card">
		                            <h6 class="card-text"><%=foodAppli.getFoodStored() %></h6>
		                            <h4 class="card-title"> <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
		                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %></div>
		                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
		                            <%
		                            	int salePrice = (int) (foodAppli.getFoodPrice() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
		                            %>
		                            <h4 class="card-text"><%=salePrice %>원</h4>
			                         <% AvgReviewScore avgrs = new AvgReviewScore();
			                            int totalScore = 0;
			                            String star = "☆";
			                            	for(Object tp : avgrsList){
			                            		avgrs = (AvgReviewScore)tp;
			                            		if(avgrs.getFoodNo()==foodAppli.getFoodNo()){
			                            			totalScore += (int)avgrs.getAvgReviewScore();
			                            			System.out.println("totalScore : "+totalScore);
			                            			star = "";
					                            		for(int s=0; s<totalScore; s++){
					                            			star += "★";
					               						} %>
					                        <% } %>
		       	                    	<% } %>
		                           <div class="row">
		                                <div class="col-6 text-left"><%=star %></div>
		                           </div>
	                        </div>
               			</div>
               		</div>
				<%	} %>
			</div>
		</div>
		
		
		
	  <div class="tab-pane container fade" id="menu1">
		<div class="row">
			<%
				for(Object food : foodAppliList) {
	        		FoodAndApplication foodAppli = (FoodAndApplication)food;
	        		if(foodAppli.getFoodCatCNo()==1){
	        %>
	        			<div class="col-md-4">
                  			<div class="">
		                         <a href="food_detail.gom?foodNo=<%foodAppli.getFoodNo(); %>"><img class="card-img-top" src="http://localhost:8080//final_project//resource//<%=foodAppli.getFoodStored() %>"/></a>
		                        <div class="card-block card">
		                            <h6 class="card-text"><%=foodAppli.getFoodStored() %></h6>
		                            <h4 class="card-title"> <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
		                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %></div>
		                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
		                            <%
		                            	int salePrice = (int) (foodAppli.getFoodPrice() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
		                            %>
		                            <h4 class="card-text"><%=salePrice %>원</h4>
			                         <% AvgReviewScore avgrs = new AvgReviewScore();
			                            int totalScore = 0;
			                            String star = "☆";
			                            	for(Object tp : avgrsList){
			                            		avgrs = (AvgReviewScore)tp;
			                            		if(avgrs.getFoodNo()==foodAppli.getFoodNo()){
			                            			totalScore += (int)avgrs.getAvgReviewScore();
			                            			System.out.println("totalScore : "+totalScore);
			                            			star = "";
					                            		for(int s=0; s<totalScore; s++){
					                            			star += "★";
					               						} %>
					                        <% } %>
		       	                    	<% } %>
		                           <div class="row">
		                                <div class="col-6 text-left"><%=star %></div>
		                           </div>
	                        </div>
               			</div>
               		</div>
	        		<% } %>
				<%	} %>
		</div>
	  </div>
	  
	  
	  
	  
	  <div class="tab-pane container fade" id="menu2">
		<div class="row">
			<%
				for(Object food : foodAppliList) {
	        		FoodAndApplication foodAppli = (FoodAndApplication)food;
	        		if(foodAppli.getFoodCatCNo()==2){
	        %>
	        			<div class="col-md-4">
                  			<div class="">
		                         <a href="food_detail.gom?foodNo=<%foodAppli.getFoodNo(); %>"><img class="card-img-top" src="http://localhost:8080//final_project//resource//<%=foodAppli.getFoodStored() %>"/></a>
		                        <div class="card-block card">
		                            <h6 class="card-text"><%=foodAppli.getFoodStored() %></h6>
		                            <h4 class="card-title"> <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
		                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %></div>
		                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
		                            <%
		                            	int salePrice = (int) (foodAppli.getFoodPrice() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
		                            %>
		                            <h4 class="card-text"><%=salePrice %>원</h4>
			                         <% AvgReviewScore avgrs = new AvgReviewScore();
			                            int totalScore = 0;
			                            String star = "☆";
			                            	for(Object tp : avgrsList){
			                            		avgrs = (AvgReviewScore)tp;
			                            		if(avgrs.getFoodNo()==foodAppli.getFoodNo()){
			                            			totalScore += (int)avgrs.getAvgReviewScore();
			                            			System.out.println("totalScore : "+totalScore);
			                            			star = "";
					                            		for(int s=0; s<totalScore; s++){
					                            			star += "★";
					               						} %>
					                        <% } %>
		       	                    	<% } %>
		                           <div class="row">
		                                <div class="col-6 text-left"><%=star %></div>
		                           </div>
	                        </div>
               			</div>
               		</div>
	        	<% } %>
			<%	} %>
		   </div>
	  </div>
	  
	  
	  
	  
	  
	  <div class="tab-pane container fade" id="menu3">
		<div class="row">
			<%
				for(Object food : foodAppliList) {
	        		FoodAndApplication foodAppli = (FoodAndApplication)food;
	        		if(foodAppli.getFoodCatCNo()==3){
	        %>
	        			<div class="col-md-4">
                  			<div class="">
		                         <a href="food_detail.gom?foodNo=<%foodAppli.getFoodNo(); %>"><img class="card-img-top" src="http://localhost:8080/final_project/resource/<%=foodAppli.getFoodStored() %>"/></a>
		                        <div class="card-block card">
		                            <h6 class="card-text"><%=foodAppli.getFoodStored() %></h6>
		                            <h4 class="card-title"> <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
		                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %></div>
		                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
		                            <%
		                            	int salePrice = (int) (foodAppli.getFoodPrice() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
		                            %>
		                            <h4 class="card-text"><%=salePrice %>원</h4>
			                         <% AvgReviewScore avgrs = new AvgReviewScore();
			                            int totalScore = 0;
			                            String star = "☆";
			                            	for(Object tp : avgrsList){
			                            		avgrs = (AvgReviewScore)tp;
			                            		if(avgrs.getFoodNo()==foodAppli.getFoodNo()){
			                            			totalScore += (int)avgrs.getAvgReviewScore();
			                            			System.out.println("totalScore : "+totalScore);
			                            			star = "";
					                            		for(int s=0; s<totalScore; s++){
					                            			star += "★";
					               						} %>
					                        <% } %>
		       	                    	<% } %>
		                           <div class="row">
		                                <div class="col-6 text-left"><%=star %></div>
		                           </div>
	                        </div>
               			</div>
               		</div>
	        	<% } %>
			<%	} %>
		   </div>
	  </div>
	  
	  
	</div>
</div>
</body>
</html>