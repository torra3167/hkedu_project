<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.ProOrder"%>
    
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
     <%
    String email = (String)session.getAttribute("email");
	ProOrder proOrder = (ProOrder)session.getAttribute("proOrder");
	
    int sum = 0;
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center"> <font color ="black"><font size = 15> 주문서</font></font></h1>
<div class="container">
<div class="row">
 <div class="col-12">



<table class="table">
	<tr>
		<td>판매자이메일</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>가격</td>

	</tr>

 	<form:form commandName="proOrder" action="pro_order_list_insert.gom"> 

 <% 	if(proOrder == null) { %>
	
<% 	} %>
	
<% 	if(proOrder != null) { %>

	<tr>
		<td><%=proOrder.getCoachEmail() %></td>
		<td><img src="resource/<%=proOrder.getProOrderStored() %>" width="70" height="70"/></td>
		<td><%=proOrder.getProOrderName() %></td>
		<td><%=proOrder.getProOrderTotal()%></td>
		
	</tr>
		
	



	</table>
	
        <div class="form-group col-12">
          <label>결제총금액</label>
          
          <input type="text" name="proOrderTotal" class="form-control" value="<%=proOrder.getProOrderTotal() %>" readonly="readonly">
        
       </div>
       	<%
		
	} 
  %>	
        <div class="form-group col-12">
					<label>결제방법</label> <select name="foodPayDivide" class="form-control">
						<option value="card" selected>카드결제</option>
						<option value="cash">현금결제</option>
					</select>
				</div>
        <button type="submit" class="btn btn-primary" >결제하기</button>
        <button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
		
	 </form:form>
</div>
</div>
</div>

</body>
</html>