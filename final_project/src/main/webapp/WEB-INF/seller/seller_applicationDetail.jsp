<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.SellerApplication"%>
<%
	SellerApplication sellerApplication = (SellerApplication)request.getAttribute("sellerApplication");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<h3>입점신청서 상세보기</h3>
<div class="container mt-3" style="max-width: 560px;">
     <form method="POST" action="seller_applicationDelete.gom">
     	<div class="form-group">
			<!-- <label>입점신청 번호</label> --> <input type="hidden" name="sellerAppliNo" class="form-control" value="<%=sellerApplication.getSellerAppliNo() %>">
		</div>
     	<div class="form-group">
			<label>사업자 번호</label> <input type="text" name="sellerAppliBn" class="form-control" value="<%=sellerApplication.getSellerAppliBn() %>" readonly="readonly">
		</div>
		<div class="form-group">
			<label>사업자 등록증 사본</label>
			<img src="http://localhost:8080/final_project/resource/<%=sellerApplication.getSellerLicenseStored()%>">
		</div>
		<div class="form-group">
			<label>영업 신고증 사본</label>
			<img src="http://localhost:8080/final_project/resource/<%=sellerApplication.getSellerBrStored()%>">
		</div>
		<div class="form-group">
			<label>사업주 이름</label> <input type="text" name="sellerName" class="form-control" value="<%=sellerApplication.getSellerName() %>" readonly="readonly">
		</div>
		<div class="form-group">
			<label>업체 이름</label> <input type="text" name="storeName" class="form-control" value="<%=sellerApplication.getStoreName() %>" readonly="readonly">
		</div>
		<div class="form-group">
			<label>업체 전화번호</label> <input type="text" name="storeTelphone" class="form-control" value="<%=sellerApplication.getStoreTelphone() %>" readonly="readonly">
		</div>
		<div class="form-group">
			<label>업체 주소</label> <input type="text" name="storeAddr" class="form-control" value="<%=sellerApplication.getStoreAddr() %>" readonly="readonly">
		</div>
		<button type="submit" class="btn btn-danger">신청 취소</button>
     </form>
 </div>
</body>
</html>