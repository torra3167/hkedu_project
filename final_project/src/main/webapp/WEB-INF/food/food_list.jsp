<%@page import="model.FoodAndApplication"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.FoodAndApplication"%>
<%
    List foodAppliList = (List)request.getAttribute("foodAppliList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>판매식품 목록</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- 	<script src="../js/jquery.min.js"></script> -->
<!-- 	<script src="../js/popper.min.js"></script> -->
<!-- 	<script src="../js/bootstrap.min.js"></script> -->
<!-- 	<link rel="stylesheet" href="../css/bootstrap.min.css"> -->
	<style type="text/css">
    	.regularPrice { text-decoration:line-through }
    	 a:link { color: black; text-decoration: none;}
		 a:visited { color: black; text-decoration: none;}
		 a:hover { color: black; text-decoration: none;}
	</style>
</head>
<body>
<div>
  <div class="container mt-3 mt-sm-5">
  	<ul class="nav nav-tabs justify-content-end">
  	 	<li class="nav-item">
			<div>
		    	<form class="form-inline" action="#">
				    <input class="form-control" type="text" placeholder="검색어 입력">
				    <button class="btn btn-primary" type="submit">검색</button>
			  	</form>
			</div>
		</li>
	</ul>
<!------------------------------------------------------------------------------------- -->
<br>
<br>
<h5>코치 추천 식품</h5>
<br>
	<div class="row">
	    <div class="col-md-4">
	      <div class="">
	      	<img class="card-img-top" src="#" alt="#"/>
	        	<div class="card-block card">
	         	<h6 class="card-text">아임웰</h6>
	           <h4 class="card-title"><a href=#>신선한 샐러드 파우치</a></h4>
	           <div class="regularPrice">10,000원</div>
	           <h4 class="card-text">20% OFF</h4>
	           <h4 class="card-text">8,000원</h4>
	           <div class="row">
	            <div class="col-6 text-left">★★★★★</div>
	            <div class="col-6 text-right"><a href=#>상품후기 7</a></div>
	        </div>
	        	</div>
	      </div>
	    </div>
	    <div class="col-md-4">
	      <div class="">
	      	<img class="card-img-top" src="#" alt="#"/>
	        	<div class="card-block card">
	         	<h6 class="card-text">아임웰</h6>
	           <h4 class="card-title"><a href=#>신선한 샐러드 파우치</a></h4>
	           <div class="regularPrice">10,000원</div>
	           <h4 class="card-text">20% OFF</h4>
	           <h4 class="card-text">8,000원</h4>
	           <div class="row">
	            <div class="col-6 text-left">★★★★★</div>
	            <div class="col-6 text-right"><a href=#>상품후기 7</a></div>
	        </div>
	        	</div>
	      </div>
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
	    <a class="nav-link" data-toggle="tab" href="#menu1">냉동 도시락</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu2">가벼운 간식</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu3">신선 샐러드</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link" data-toggle="tab" href="#menu4">음료</a>
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
                        <a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><img class="card-img-top" src="http://localhost:8080/final_project/resource/<%=foodAppli.getFoodStored() %>"/></a>
                        <div class="card-block card">
                            <h6 class="card-text"><%=foodAppli.getFoodStored() %></h6>
                            <h4 class="card-title"><a href="food_detail.gom?foodNo=<%=foodAppli.getFoodNo() %>"><%=foodAppli.getFoodName() %></a></h4>
                            <div class="regularPrice"><%=foodAppli.getFoodPrice() %></div>
                            <h4 class="card-text"><%=foodAppli.getFoodSale() %>% OFF</h4>
                            <%
                                int salePrice = (int) (foodAppli.getFoodSale() - (foodAppli.getFoodPrice() * (foodAppli.getFoodSale()*0.01)));
                            %>
                            <h4 class="card-text"><%=salePrice %>원</h4>
                            <div class="row">
                                <div class="col-6 text-left">★★★★★</div>
                                <div class="col-6 text-right"><a href=#>상품후기 7</a></div>
                            </div>
                        </div>
                  </div>
                </div>
                <% } %>
                
                <!--                 <tr> -->
                
<%--                     <td><%=program.getProNo() %></td> --%>
<%--                     <td><%=program.getCoachEmail() %></td> --%>
<%--                     <td><a href="program_detail.gom?proNo=<%=program.getProNo() %>&proContent=<%=program.getProContent()%>"><%=program.getProName() %></a></td> --%>
<%--                     <td><%=program.getProRegdate() %></td> --%>
<%--                     <td><img src="http://localhost:8080/final_project/resource/<%=program.getProStored() %>" width="80" height="80"></td> --%>
                    
                    
<!--                 </tr> -->
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
		                                <div class="col-6 text-right"><a href=#>상품후기 7</a></div>
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
		                                <div class="col-6 text-right"><a href=#>상품후기 7</a></div>
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
		                                <div class="col-6 text-right"><a href=#>상품후기 7</a></div>
		                            </div>
		                        </div>
                  			</div>
                		</div>
	        <%		}
				}
			%>
		   </div>
	  </div>
	  
	  
	  <div class="tab-pane container fade" id="menu4">
	  </div>
	</div>
  
    
  </div>
</div>
</body>
</html>