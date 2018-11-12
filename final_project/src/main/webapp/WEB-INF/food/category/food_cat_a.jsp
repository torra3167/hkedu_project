<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "command.*, java.util.*"%>
    
    <%
    	List list = (List)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>

<script type="text/javascript">


 function bca() {
	 var num = document.getElementById("aca").value;
	 $.ajax({
		 type:"POST",
		 url:"bca.do",
		 dataType:"html",
		 data:"anum=" + num,
		 success: function(result) {
			 $('#bca').html(result);
			 $('#cca').html("");
		 }
		 
	 });
 }
 
 function cca() {
		var num1 = document.getElementById("aca").value; 
		var num2 = document.getElementById("bca").value;
		$.ajax({
			type:"POST",
			url:"cca.do",
			dataType:"html",
			data:"bnum="+num2 + "&anum=" + num1,
			success:function(result){
				$('#ccar').html(result);	
			}
		});		
	}
 
</script>
<body>
<div>
	<select id="aca" name="anum" onclick="javascript:bca();"> 
	<% for(Object temp : list) {
	 	Aca aca = (Aca)temp; %>
	 	<option value="<%=aca.getAnum()%>"> <%=aca.getAname() %></option>
	 	
	<% } %>
	</select>
</div>
<div id="bca"></div>
<div id="cca"></div>
</body>
</html>