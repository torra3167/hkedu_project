<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/program_review_list.css">
<script src="js/program_review_list.js" type="text/javascript"></script>
</head>
<body>

<div class="reviews">
  <div class="row blockquote review-item">
    <div class="col-md-3 text-center">
      <img class="rounded-circle reviewer" src="http://standaloneinstaller.com/upload/avatar.png">
      <div class="caption">
      
        <small>by <a href="#joe">Joe</a></small>
      </div>

    </div>
    <div class="col-md-9">
      <h4>제목</h4>
      <div class="ratebox text-center" data-id="0" data-rating="5"></div>
      <p class="review-text">
      	내용
      </p>

      <small class="review-date">등록일</small>
    </div>     
  </div>  
      <a class="btn btn-primary text-right" href="program_review_write.gom" role="button">리뷰작성</a>                     
  
  	
</div>

</body>
</html>