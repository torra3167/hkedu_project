<%@page import="model.FoodAndApplication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.FoodAndApplication"%>
<%
	//전체식품
	List<FoodAndApplication> foodAppliList = (List<FoodAndApplication>)request.getAttribute("foodAppliList");

	//코치 추천 식품
	List<FoodAndApplication> coachRecomFoodList = (List<FoodAndApplication>)request.getAttribute("coachRecomFoodList");
	System.out.println("szie : "+coachRecomFoodList.size());
// 	int tempNo = 0;
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
<h5>코치 추천 식품</h5>
<br>

<div class="container">
	<div class="row">
<%-- 		<% for(int i=0; i<3; i++){
			FoodAndApplication coachRecomFoodAppli = coachRecomFoodList.get(i);
			%>
		
	      <% for(Object temp : coachRecomFoodList) {
	        	FoodAndApplication coachRecomFoodAppli = (FoodAndApplication)temp;       
	        	tempNo += 1;

		  %> --%>
		  <% for(int i=0; i<3; i++){
			FoodAndApplication coachRecomFoodAppli = coachRecomFoodList.get(i);
			%>
                <div class="col-md-4">
                  <div class="card">
                        <a href="food_detail.gom?foodNo=<%=coachRecomFoodAppli.getFoodNo() %>"><img class="card-img-top" src="http://localhost:8080//final_project//resource//<%=coachRecomFoodAppli.getFoodStored() %>" style="width:100%"/></a>
                        <div class="card-body">
                        	<h6 class="card-text"><%=coachRecomFoodAppli.getStoreName() %></h6>
                            <h4 class="card-title"><a href="food_detail.gom?foodNo=<%=coachRecomFoodAppli.getFoodNo() %>"><%=coachRecomFoodAppli.getFoodName() %></a></h4>
                            <div class="regularPrice"><%=coachRecomFoodAppli.getFoodPrice() %>원</div>
                            <h4 class="card-text"><%=coachRecomFoodAppli.getFoodSale() %>% OFF</h4>
                            <%
                                int salePrice = (int) (coachRecomFoodAppli.getFoodPrice() - (coachRecomFoodAppli.getFoodPrice() * (coachRecomFoodAppli.getFoodSale()*0.01)));
                            %>
                            <h4 class="card-text"><%=salePrice %>원</h4>
                            <div class="row">
                                <div class="col-6 text-left">★★★★★</div>
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
                  <div class="card">
                        <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><img class="card-img-top" src="http://localhost:8080/final_project/resource/<%=foodAppli.getFoodStored() %>" style="width:100%"/></a>
                        <div class="card-body">
                        	<h6 class="card-text"><%=foodAppli.getStoreName() %></h6>
                            <h4 class="card-title"><a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %>원</div>
                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
                            <%
                                int salePrice = (int) (foodAppli.getFoodPrice() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
                            %>
                            <h4 class="card-text"><%=salePrice %>원</h4>
                            <div class="row">
                                <div class="col-6 text-left">★★★★★</div>
                            </div>
                        </div>
                  </div>
                </div>
                <% } %>
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
		                         <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><img class="card-img-top" src="http://localhost:8080/final_project/resource/<%=foodAppli.getFoodStored() %>"/></a>
		                        <div class="card-block card">
		                            <h6 class="card-text"><%=foodAppli.getFoodStored() %></h6>
		                            <h4 class="card-title"> <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
		                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %></div>
		                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
		                            <%
		                                int salePrice = (int) (foodAppli.getFoodSale() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
		                            %>
		                            <h4 class="card-text"><%=salePrice %>원</h4>
		                            <div class="row">
		                                <div class="col-6 text-left">★★★★★</div>
		                            </div>
		                        </div>
                  			</div>
                		</div>
	        <%		}
				}
			%>
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
		                         <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><img class="card-img-top" src="http://localhost:8080/final_project/resource/<%=foodAppli.getFoodStored() %>"/></a>
		                        <div class="card-block card">
		                            <h6 class="card-text"><%=foodAppli.getFoodStored() %></h6>
		                            <h4 class="card-title"> <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
		                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %></div>
		                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
		                            <%
		                                int salePrice = (int) (foodAppli.getFoodSale() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
		                            %>
		                            <h4 class="card-text"><%=salePrice %>원</h4>
		                            <div class="row">
		                                <div class="col-6 text-left">★★★★★</div>
		                            </div>
		                        </div>
                  			</div>
                		</div>
	        <%		}
				}
			%>
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
		                         <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><img class="card-img-top" src="http://localhost:8080/final_project/resource/<%=foodAppli.getFoodStored() %>"/></a>
		                        <div class="card-block card">
		                            <h6 class="card-text"><%=foodAppli.getFoodStored() %></h6>
		                            <h4 class="card-title"> <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
		                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %></div>
		                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
		                            <%
		                                int salePrice = (int) (foodAppli.getFoodSale() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
		                            %>
		                            <h4 class="card-text"><%=salePrice %>원</h4>
		                            <div class="row">
		                                <div class="col-6 text-left">★★★★★</div>
		                            </div>
		                        </div>
                  			</div>
                		</div>
	        <%		}
				}
			%>
		   </div>
	  </div>
	  
	  
	</div>
</div>
</body>
</html>