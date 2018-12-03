<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*, model.FoodOrderReceiverPay"%>
<%
	List<FoodOrderReceiverPay> forpList = (List<FoodOrderReceiverPay>)request.getAttribute("fosList");
	
	int totalSalesStock = 0;
	int totalStock = 0;
	int totalSales = 0;
	
	int etcSalesStock = 0;
	int etcStock = 0;
	int etcSales = 0;
	
	FoodOrderReceiverPay forp1 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay forp2 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay forp3 = new FoodOrderReceiverPay();
	FoodOrderReceiverPay etcForp = new FoodOrderReceiverPay();
	for(Object temp : forpList){
		FoodOrderReceiverPay foodOrderReceiverPay = (FoodOrderReceiverPay)temp;
		totalSalesStock += foodOrderReceiverPay.getFoodOrderQuant();
		totalStock += foodOrderReceiverPay.getFoodQuant();
		totalSales += foodOrderReceiverPay.getFoodPayPrice();
		if(foodOrderReceiverPay.getRownum()==1){
			forp1.setFoodOrderName(foodOrderReceiverPay.getFoodOrderName());
			forp1.setFoodOrderQuant(foodOrderReceiverPay.getFoodOrderQuant());
			forp1.setFoodQuant(foodOrderReceiverPay.getFoodQuant()-foodOrderReceiverPay.getFoodOrderQuant());
			forp1.setFoodPayPrice(foodOrderReceiverPay.getFoodPayPrice());
			forp1.setFoodPayDate(foodOrderReceiverPay.getFoodPayDate());
		}else if(foodOrderReceiverPay.getRownum()==2){
			forp2.setFoodOrderName(foodOrderReceiverPay.getFoodOrderName());
			forp2.setFoodOrderQuant(foodOrderReceiverPay.getFoodOrderQuant());
			forp2.setFoodQuant(foodOrderReceiverPay.getFoodQuant()-foodOrderReceiverPay.getFoodOrderQuant());
			forp2.setFoodPayPrice(foodOrderReceiverPay.getFoodPayPrice());
			forp2.setFoodPayDate(foodOrderReceiverPay.getFoodPayDate());
		}else if(foodOrderReceiverPay.getRownum()==3){
			forp3.setFoodOrderName(foodOrderReceiverPay.getFoodOrderName());
			forp3.setFoodOrderQuant(foodOrderReceiverPay.getFoodOrderQuant());
			forp3.setFoodQuant(foodOrderReceiverPay.getFoodQuant()-foodOrderReceiverPay.getFoodOrderQuant());
			forp3.setFoodPayPrice(foodOrderReceiverPay.getFoodPayPrice());
			forp3.setFoodPayDate(foodOrderReceiverPay.getFoodPayDate());
		}else{
			etcSalesStock += foodOrderReceiverPay.getFoodOrderQuant();
			etcStock += (foodOrderReceiverPay.getFoodQuant()-foodOrderReceiverPay.getFoodOrderQuant());
			etcSales += foodOrderReceiverPay.getFoodPayPrice();
		}
		etcForp.setFoodOrderQuant(etcSalesStock);
		etcForp.setFoodQuant(etcStock);
		etcForp.setFoodPayPrice(etcSales);
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
<div class="container-fluid">
	<div class="col col-md-9">
		<div class="row">
			<div class="col col-md-5 col-md-offset-1">
				<h3>당일 매출</h3><br>
				<h4>판매량</h4>
				전체<span class="pull-right strong">판매량:<%=totalSalesStock %>개, 재고:<%=totalStock %>개</span><br>
				 <div class="progress">
					<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="40"aria-valuemin="0" aria-valuemax="100" style="width:40%">40%</div>
				</div>
				<a href="#"><%=forp1.getFoodOrderName() %></a><span class="pull-right strong">판매량:<%=forp1.getFoodOrderQuant() %>개, 재고:<%=forp1.getFoodQuant() %>개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
				<a href="#"><%=forp2.getFoodOrderName() %></a><span class="pull-right strong">판매량:<%=forp2.getFoodOrderQuant() %>개, 재고:<%=forp2.getFoodQuant() %>개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="30"aria-valuemin="0" aria-valuemax="100" style="width:30%">30%</div>
				</div>
				<a href="#"><%=forp3.getFoodOrderName() %></a><span class="pull-right strong">판매량:<%=forp3.getFoodOrderQuant() %>개, 재고:<%=forp3.getFoodQuant() %>개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				기타<span class="pull-right strong">판매량:<%=etcForp.getFoodOrderQuant() %>개, 재고:<%=etcForp.getFoodQuant() %>개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				<br>
				<div class="row">
					<h4 class="col-sm-6 text-left">매출액</h4>
					<h4 class="col-sm-6 text-right"><%=totalSales %>원</h4>
				</div>
				<a href="#">닭가슴살샐러드</a><span class="pull-right strong">매출액: 600,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				<a href="#">영양밥도시락</a><span class="pull-right strong">매출액: 300,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="30"aria-valuemin="0" aria-valuemax="100" style="width:30%">30%</div>
				</div>
				<a href="#">소풍도시락</a><span class="pull-right strong">매출액: 200,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
				기타<span class="pull-right strong">매출액: 200,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
			</div>
			<div class="col col-md-5">
				<h3>당월 매출</h3><br>
				<h4>판매량</h4>
				전체<span class="pull-right strong">판매량:400개 / 재고:1000개</span><br>
				<div class="progress">
					<div class="progress-bar progress-bar" role="progressbar" aria-valuenow="40"aria-valuemin="0" aria-valuemax="100" style="width:40%">40%</div>
				</div>
				<a href="#">닭가슴살샐러드</a><span class="pull-right strong">판매량:100개 / 재고:500개</span>
				<div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
				<a href="#">영양밥도시락</a><span class="pull-right strong">판매량:100개 / 재고:300개</span>
				<div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="30"aria-valuemin="0" aria-valuemax="100" style="width:30%">30%</div>
				</div>
				<a href="#">소풍도시락</a><span class="pull-right strong">판매량:100개 / 재고:200개</span>
				<div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				기타<span class="pull-right strong">판매량:100개 / 재고:200개</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				<br>
				<div class="row">
					<h4 class="col-sm-6 text-left">매출액</h4>
					<h4 class="col-sm-6 text-right">1,300,000원</h4>
				</div>
				<a href="#">닭가슴살샐러드</a><span class="pull-right strong">매출액: 500,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="50"aria-valuemin="0" aria-valuemax="100" style="width:50%">50%</div>
				</div>
				<a href="#">영양밥도시락</a><span class="pull-right strong">매출액: 300,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="30"aria-valuemin="0" aria-valuemax="100" style="width:30%">30%</div>
				</div>
				<a href="#">소풍도시락</a><span class="pull-right strong">매출액: 200,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
				기타<span class="pull-right strong">매출액: 200,000원</span>
				 <div class="progress">
					<div class="progress-bar progress-bar bg-success" role="progressbar" aria-valuenow="20"aria-valuemin="0" aria-valuemax="100" style="width:20%">20%</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>