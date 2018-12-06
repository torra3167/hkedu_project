<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, model.FoodOrderReceiverPay"%>
<%
	List<FoodOrderReceiverPay> fosDayList = (List<FoodOrderReceiverPay>)request.getAttribute("fosDayList");
	List<FoodOrderReceiverPay> fosMonthList = (List<FoodOrderReceiverPay>)request.getAttribute("fosMonthList");
	
	int todayTotalSalesStock = 0;
	int todayTotalStock = 0;
	int todayTotalSales = 0;
	int todayEtcSalesStock = 0;
	int todayEtcStock = 0;
	int todayEtcSales = 0;
	
	int thisMonthTotalSalesStock = 0;
	int thisMonthTotalStock = 0;
	int thisMonthTotalSales = 0;
	int thisMonthEtcSalesStock = 0;
	int thisMonthEtcStock = 0;
	int thisMonthEtcSales = 0;
	
	FoodOrderReceiverPay todayForp1 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay todayForp2 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay todayForp3 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay todayEtcForp = new FoodOrderReceiverPay();
	
	FoodOrderReceiverPay thisMonthForp1 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay thisMonthForp2 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay thisMonthForp3 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay thisMonthEtcForp = new FoodOrderReceiverPay();
	
	//today
	for(Object temp : fosDayList){
		FoodOrderReceiverPay foodOrderReceiverPay = (FoodOrderReceiverPay)temp;
		todayTotalSalesStock += foodOrderReceiverPay.getFoodOrderQuant();
		todayTotalStock += foodOrderReceiverPay.getFoodQuant();
		todayTotalSales += foodOrderReceiverPay.getFoodPayPrice();
		if(foodOrderReceiverPay.getRownum()==1){
			todayForp1 = new FoodOrderReceiverPay(1, foodOrderReceiverPay.getFoodOrderName(), foodOrderReceiverPay.getFoodOrderQuant(), foodOrderReceiverPay.getFoodPayPrice(), foodOrderReceiverPay.getFoodPayDate(), foodOrderReceiverPay.getFoodQuant(), foodOrderReceiverPay.getSellerEmail()); 
		}else if(foodOrderReceiverPay.getRownum()==2){
			todayForp2 = new FoodOrderReceiverPay(2, foodOrderReceiverPay.getFoodOrderName(), foodOrderReceiverPay.getFoodOrderQuant(), foodOrderReceiverPay.getFoodPayPrice(), foodOrderReceiverPay.getFoodPayDate(), foodOrderReceiverPay.getFoodQuant(), foodOrderReceiverPay.getSellerEmail());
		}else if(foodOrderReceiverPay.getRownum()==3){
			todayForp3 = new FoodOrderReceiverPay(3, foodOrderReceiverPay.getFoodOrderName(), foodOrderReceiverPay.getFoodOrderQuant(), foodOrderReceiverPay.getFoodPayPrice(), foodOrderReceiverPay.getFoodPayDate(), foodOrderReceiverPay.getFoodQuant(), foodOrderReceiverPay.getSellerEmail());
		}else{
			todayEtcSalesStock += foodOrderReceiverPay.getFoodOrderQuant();
			todayEtcStock += (foodOrderReceiverPay.getFoodQuant());
			todayEtcSales += foodOrderReceiverPay.getFoodPayPrice();
		}
		todayEtcForp.setFoodOrderQuant(todayEtcSalesStock);
		todayEtcForp.setFoodQuant(todayEtcStock);
		todayEtcForp.setFoodPayPrice(todayEtcSales);
	}
	
	//this month
	for(Object temp : fosMonthList){
		FoodOrderReceiverPay foodOrderReceiverPay = (FoodOrderReceiverPay)temp;
		thisMonthTotalSalesStock += foodOrderReceiverPay.getFoodOrderQuant();
		thisMonthTotalStock += foodOrderReceiverPay.getFoodQuant();
		thisMonthTotalSales += foodOrderReceiverPay.getFoodPayPrice();
		if(foodOrderReceiverPay.getRownum()==1){
			thisMonthForp1 = new FoodOrderReceiverPay(1, foodOrderReceiverPay.getFoodOrderName(), foodOrderReceiverPay.getFoodOrderQuant(), foodOrderReceiverPay.getFoodPayPrice(), foodOrderReceiverPay.getFoodPayDate(), foodOrderReceiverPay.getFoodQuant(), foodOrderReceiverPay.getSellerEmail()); 
		}else if(foodOrderReceiverPay.getRownum()==2){
			thisMonthForp2 = new FoodOrderReceiverPay(2, foodOrderReceiverPay.getFoodOrderName(), foodOrderReceiverPay.getFoodOrderQuant(), foodOrderReceiverPay.getFoodPayPrice(), foodOrderReceiverPay.getFoodPayDate(), foodOrderReceiverPay.getFoodQuant(), foodOrderReceiverPay.getSellerEmail());
		}else if(foodOrderReceiverPay.getRownum()==3){
			thisMonthForp3 = new FoodOrderReceiverPay(3, foodOrderReceiverPay.getFoodOrderName(), foodOrderReceiverPay.getFoodOrderQuant(), foodOrderReceiverPay.getFoodPayPrice(), foodOrderReceiverPay.getFoodPayDate(), foodOrderReceiverPay.getFoodQuant(), foodOrderReceiverPay.getSellerEmail());
		}else{
			thisMonthEtcSalesStock += foodOrderReceiverPay.getFoodOrderQuant();
			thisMonthEtcStock += (foodOrderReceiverPay.getFoodQuant());
			thisMonthEtcSales += foodOrderReceiverPay.getFoodPayPrice();
		}
		thisMonthEtcForp.setFoodOrderQuant(thisMonthEtcSalesStock);
		thisMonthEtcForp.setFoodQuant(thisMonthEtcStock);
		thisMonthEtcForp.setFoodPayPrice(thisMonthEtcSales);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품주문 통계</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<style type="text/css">
    	 a:link { color: black; text-decoration: none;}
		 a:visited { color: black; text-decoration: none;}
		 a:hover { color: black; text-decoration: none;}
</style>
</head>
<body>
<div class="container">
		<div class="row">
		<%
			double percent = 0;
			double result = 0;
		%>
			<div class="col col-md-6"  style="border-style: ridge; border-width: 1px;">
				<br>
				<h3>당일 매출</h3><br>
			<% if(fosDayList.size()==0){%>
				<h5>당일 매출이 없습니다.</h5>
			<% }else{ %>
				<div class="row">
					<h4 class="col-sm-6 text-left">총 판매량</h4>
					<h4 class="col-sm-6 text-right"><%=todayTotalSalesStock %>개</h4>
				</div>
				<div class="row">
				<h4 class="col text-right" style="font-size:15px">(총 재고:<%=todayTotalStock %>개)</h4>
				</div>
				<a href="#" style="float:left"><%=todayForp1.getFoodOrderName() %></a><span style="float:right">판매량:<%=todayForp1.getFoodOrderQuant() %>개  (재고:<%=todayForp1.getFoodQuant() %>개)</span><br>
				 <div class="progress">
				 <% percent = (double)todayForp1.getFoodOrderQuant() / todayTotalSalesStock * 100; result = Math.round(percent*100)/100.0;%>
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% if(todayForp2.getFoodOrderName()!=null){ %>
					<a href="#" style="float:left"><%=todayForp2.getFoodOrderName() %></a><span style="float:right">판매량:<%=todayForp2.getFoodOrderQuant() %>개 / 재고:<%=todayForp2.getFoodQuant() %>개</span><br>
					<% percent = (double)todayForp2.getFoodOrderQuant() / todayTotalSalesStock * 100; result = Math.round(percent*100)/100.0;%>
					 <div class="progress">
						<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
					</div>
				<% }else{
				   } %>
				<% if(todayForp3.getFoodOrderName()!=null){ %>
				<a href="#" style="float:left"><%=todayForp3.getFoodOrderName() %></a><span style="float:right">판매량:<%=todayForp3.getFoodOrderQuant() %>개 / 재고:<%=todayForp3.getFoodQuant() %>개</span><br>
				<% percent = (double)todayForp3.getFoodOrderQuant() / todayTotalSalesStock * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<a style="float:left">기타</a><span style="float:right">판매량:<%=todayEtcForp.getFoodOrderQuant() %>개 / 재고:<%=todayEtcForp.getFoodQuant() %>개</span><br>
				<% percent = (double)todayEtcForp.getFoodOrderQuant() / todayTotalSalesStock * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% }else{
				   } %>
				<br>
				<br>
				<div class="row">
					<h4 class="col-sm-6 text-left">총 매출액</h4>
					<h4 class="col-sm-6 text-right"><%=todayTotalSales %>원</h4>
				</div>
				<a href="#" style="float:left"><%=todayForp1.getFoodOrderName() %></a><span style="float:right">매출액: <%=todayForp1.getFoodPayPrice() %>원</span><br>
				<% percent = (double)todayForp1.getFoodPayPrice() / todayTotalSales * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% if(todayForp2.getFoodOrderName()!=null){ %>
				<a href="#" style="float:left"><%=todayForp2.getFoodOrderName() %></a><span style="float:right">매출액: <%=todayForp2.getFoodPayPrice() %>원</span><br>
				<% percent = (double)todayForp2.getFoodPayPrice() / todayTotalSales * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% }else{
				   } %>
				<% if(todayForp3.getFoodOrderName()!=null){ %>
				<a href="#" style="float:left"><%=todayForp3.getFoodOrderName() %></a><span style="float:right">매출액: <%=todayForp3.getFoodPayPrice() %>원</span><br>
				<% percent = (double)todayForp3.getFoodPayPrice() / todayTotalSales * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<a style="float:left">기타</a><span style="float:right">매출액: <%=todayEtcForp.getFoodPayPrice() %>원</span><br>
				<% percent = (double)todayEtcForp.getFoodPayPrice() / todayTotalSales * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% }else{
				   } %>
				<br>
			<%} %>
			</div>
			
			
			<div class="col col-md-6" style="border-style: ridge; border-width: 1px;">
			<br>
				<h3>당월 매출</h3><br>
			<% if(fosMonthList.size()==0){%>
				<h5>당월 매출이 없습니다.</h5>
		  	 <%}else{ %>
				<div class="row">
					<h4 class="col-sm-6 text-left">총 판매량</h4>
					<h4 class="col-sm-6 text-right"><%=thisMonthTotalSalesStock %>개</h4>
				</div>
				<div class="row">
				<h4 class="col text-right" style="font-size:15px">(총 재고:<%=thisMonthTotalStock %>개)</h4>
				</div>
				<a href="#" style="float:left"><%=thisMonthForp1.getFoodOrderName() %></a><span style="float:right">판매량:<%=thisMonthForp1.getFoodOrderQuant() %>개 / 재고:<%=thisMonthForp1.getFoodQuant() %>개</span><br>
				<% percent = (double)thisMonthForp1.getFoodOrderQuant() / thisMonthTotalSalesStock * 100; result = Math.round(percent*100)/100.0;%>
				<div class="progress">
					<div class="progress-bar progress-bar bg-primary" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% if(thisMonthForp2.getFoodOrderName()!=null){ %>
				<a href="#" style="float:left"><%=thisMonthForp2.getFoodOrderName() %></a><span style="float:right">판매량:<%=thisMonthForp2.getFoodOrderQuant() %>개 / 재고:<%=thisMonthForp2.getFoodQuant() %>개</span><br>
				<% percent = (double)thisMonthForp2.getFoodOrderQuant() / thisMonthTotalSalesStock * 100; result = Math.round(percent*100)/100.0;%>
				<div class="progress">
					<div class="progress-bar progress-bar bg-primary" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% }else{
				   } %>
				<% if(thisMonthForp3.getFoodOrderName()!=null){ %>
				<a href="#" style="float:left"><%=thisMonthForp3.getFoodOrderName() %></a><span style="float:right">판매량:<%=thisMonthForp3.getFoodOrderQuant() %>개 / 재고:<%=thisMonthForp3.getFoodQuant() %>개</span><br>
				<% percent = (double)thisMonthForp3.getFoodOrderQuant() / thisMonthTotalSalesStock * 100; result = Math.round(percent*100)/100.0;%>
				<div class="progress">
					<div class="progress-bar progress-bar bg-primary" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<a style="float:left">기타</a><span style="float:right">판매량:<%=thisMonthEtcForp.getFoodOrderQuant() %>개 / 재고:<%=thisMonthEtcForp.getFoodQuant() %>개</span><br>
				<% percent = (double)thisMonthEtcForp.getFoodOrderQuant() / thisMonthTotalSalesStock * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-primary" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% }else{
				   } %>
				<br>
				<br>
				<div class="row">
					<h4 class="col-sm-6 text-left">총 매출액</h4>
					<h4 class="col-sm-6 text-right"><%=thisMonthTotalSales %>원</h4>
				</div>
				<a href="#" style="float:left"><%=thisMonthForp1.getFoodOrderName() %></a><span style="float:right">매출액: <%=thisMonthForp1.getFoodPayPrice() %>원</span><br>
				<% percent = (double)thisMonthForp1.getFoodPayPrice() / thisMonthTotalSales * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-primary" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% if(thisMonthForp2.getFoodOrderName()!=null){ %>
				<a href="#" style="float:left"><%=thisMonthForp2.getFoodOrderName() %></a><span style="float:right">매출액: <%=thisMonthForp2.getFoodPayPrice() %>원</span><br>
				<% percent = (double)thisMonthForp2.getFoodPayPrice() / thisMonthTotalSales * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-primary" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% }else{
				   } %>
				<% if(thisMonthForp3.getFoodOrderName()!=null){ %>
				<a href="#" style="float:left"><%=thisMonthForp3.getFoodOrderName() %></a><span style="float:right">매출액: <%=thisMonthForp3.getFoodPayPrice() %>원</span><br>
				<% percent = (double)thisMonthForp3.getFoodPayPrice() / thisMonthTotalSales * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-primary" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<a style="float:left">기타</a><span style="float:right">매출액: <%=thisMonthEtcForp.getFoodPayPrice() %>원</span><br>
				<% percent = (double)thisMonthEtcForp.getFoodPayPrice() / thisMonthTotalSales * 100; result = Math.round(percent*100)/100.0;%>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-primary" role="progressbar" aria-valuenow="<%=result%>"aria-valuemin="0" aria-valuemax="100" style="width:<%=result%>%"><%=result%>%</div>
				</div>
				<% }else{
				   } %>
				<br>
			<%} %>
			</div>
		</div>
</div>
</body>
</html>