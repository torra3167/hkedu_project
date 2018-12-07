<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.SellerApplication"%>
<%
	SellerApplication sellerApplication = (SellerApplication)request.getAttribute("sellerApplication");
	String loginDivide = (String)session.getAttribute("divide");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<h3 class="text-center">입점신청서 상세보기</h3>
<div class="container mt-3" style="max-width: 560px;">
		
     <form method="POST" action="admin_sellerApplicationReturn.gom">
		<div class="form-group">
			<!-- <label>입점신청 번호</label> --> <input type="hidden" name="sellerEmail" class="form-control" value="<%=sellerApplication.getSellerEmail() %>">
		</div>
     	<div class="form-group">
			<label>사업자 번호</label> <input type="text" name="sellerAppliBn" class="form-control" value="<%=sellerApplication.getSellerAppliBn() %>" readonly="readonly">
		</div>
		<div class="form-group">
			<label>사업자 등록증 사본</label><br>
			<img src="resource\\<%=sellerApplication.getSellerLicenseStored()%>" width="150" height="150">
		</div>
		<div class="form-group">
			<label>영업 신고증 사본</label><br>
			<img src="resource\\<%=sellerApplication.getSellerBrStored()%>" width="150" height="150">
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
		<div class="form-group">
			<label>입점신청서 처리 상태</label> <input type="text" name="applicationStatus" class="form-control" value="<%=sellerApplication.getApplicationStatus() %>" readonly="readonly">
		</div>
		<div class="form-group">
			<label>처리 내용</label> <input type="text" name="applicationDes" class="form-control" value="<%=sellerApplication.getApplicationDes() %>" readonly="readonly">
		</div>
		<%	
			if(loginDivide.equals("a") && sellerApplication.getApplicationStatus().equals("대기")){
		%>
		<div class="form-group">
			<label>반려 사유</label> <input type="text" name="returnCause" class="form-control" style="height: 180px;">
		</div>
		<button type="button" class="btn btn-primary" onclick="location.href='admin_sellerApplicationApproval.gom?sellerEmail=<%=sellerApplication.getSellerEmail() %>'">승인</button>
		<button type="submit" class="btn btn-danger">반려</button>
		<button type="button" class="btn btn-primary" onclick="window.history.go(-1)">목록으로</button>
		<%
			}else if(loginDivide.equals("a") && !sellerApplication.getApplicationStatus().equals("대기")){
				
		%>
		<button type="button" class="btn btn-danger" onclick="location.href='admin_sellerApplicationDelete.gom?sellerEmail=<%=sellerApplication.getSellerEmail() %>'">삭제</button>
		<button type="button" class="btn btn-primary" onclick="window.history.go(-1)">목록으로</button>
		<%
			}else if(loginDivide.equals("w") && sellerApplication.getApplicationStatus().equals("승인")){
		%>
		<button type="button" class="btn btn-primary" onclick="window.history.go(-1)">목록으로</button>
		<%	
			}else if(loginDivide.equals("w") && !sellerApplication.getApplicationStatus().equals("승인")){
		%>
		<button type="button" class="btn btn-danger" onclick="location.href='seller_applicationDelete.gom?sellerAppliNo=<%=sellerApplication.getSellerAppliNo() %>'">신청서 삭제</button>
		<button type="button" class="btn btn-primary" onclick="window.history.go(-1)">뒤로 가기</button>
		<%	} %>
	</form>
	
 </div>
</body>
</html>