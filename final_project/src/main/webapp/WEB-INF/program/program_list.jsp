<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, model.Program"%>

<%
	List list = (List) request.getAttribute("Program");
	String email = (String) session.getAttribute("email");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#info ul li {
	list-style: none;
	border-bottom:1px solid #84B6D0;
}


</style>
</head>

<body>
	<div class="container">
		<div class="row">
	<%
		if (list == null || list.size() == 0) {
	%>
	<%
		} else {
	%>

	<%
		for (Object temp : list) {
				Program program = (Program) temp;
	%>

	
			<div class="col-sm-12 col-md-6 col-lg-4 col-xl-3" >
				<div id="box">
					<a href="program_detail.gom?proNo=<%=program.getProNo()%>
					&proContent=<%=program.getProContent()%>
					&proPrice=<%=program.getProPrice()%>
					&proStatus=<%=program.getProStatus()%>
					&proStored=<%=program.getProStored()%>
					">
						<img class="d-block w-100"
						src="resource\\<%=program.getProStored()%>" width="250"
						height="250" alt="Third slide">
					</a>

					<div id="info" style="font-weight:normal;">
						<ul>
							<li><%=program.getProName()%></li>
							<li><%=program.getProContent()%></li>
							<li><%=program.getProPrice()%>원</li>
							<li><a href="pro_review_write.gom?proNo=<%=program.getProNo()%>&coachEmail=<%=program.getCoachEmail()%>">
			리뷰작성하기</a></li>
							<li><a href="pro_review_list.gom?proNo=<%=program.getProNo()%>">리뷰확인하러가기</a></li>
						</ul>
					</div>
				</div>
			</div>
	
	
	<%
		}
	%>
		</div>
	</div>
	<hr>

	<%
		}
	%>
</body>
</html>