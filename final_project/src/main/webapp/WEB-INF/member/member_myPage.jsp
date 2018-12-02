<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.text.SimpleDateFormat, java.util.Calendar"%>
<% String email=request.getAttribute("email").toString(); %>

<%
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
	String recordDate = simpleDateFormat.format(Calendar.getInstance().getTime());
	System.out.println("MyPage : "+recordDate);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

</head>
<body>
 <div class="container">
      <div class="masthead">
        <h3 class="text-muted">MY PAGE</h3>
        <nav>
          <ul class="nav nav-justified">
            <li><a href="member_info.gom">내 정보</a></li>
            <li><a href="food_recordMain.gom?dateText=<%=recordDate %>">식단 기록</a></li>
            <li><a href="#">운동 기록</a></li>
            <li><a href="#">피드백</a></li>
            <li><a href="#">주문 내역</a></li>
            <li><a href="#">내가 쓴 글</a></li>
          </ul>
        </nav>
      </div>

      <!-- Jumbotron -->
      <div class="jumbotron">
        <h3>${ email }님의 오늘을 기록해보세요!</h3>
        <p class="lead">식단과 운동을 꾸준히 기록하면 건강한 생활에 도움이 됩니다.</p>
        <p><a class="btn btn-lg btn-success" href="#" role="button">내 체중 그래프 확인하기</a></p>
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <h2>오늘의 식사</h2>
          <p>1111</p>
          <p><a class="btn btn-primary" href="food_recordMain.gom?dateText=<%=recordDate %>" role="button">기록하기 »</a></p>
        </div>
        <div class="col-lg-4">
          <h2>오늘의 운동</h2>
          <p>111</p>
          <p><a class="btn btn-primary" href="#" role="button">기록하기 »</a></p>
       </div>
        <div class="col-lg-4">
          <h2>내가 쓴 글 조회</h2>
          <p>11111</p>
          <p><a class="btn btn-primary" href="#" role="button">더보기 »</a></p>
        </div>
      </div>
    </div>

</body>
</html>