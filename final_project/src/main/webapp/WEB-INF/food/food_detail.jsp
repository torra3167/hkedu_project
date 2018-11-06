<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품 상세보기</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="../js/jquery.min.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<style type="text/css">
    .regularPrice { text-decoration:line-through }
</style>
</head>
  <body>
    <div class="container">
    	<div class="row">
    		<div class="col-sm-6"><img src="#"></div>
    		<div class="col-sm-6">
	    		<h5>아임웰</h5><!-- (업체명) -->
	    		<h3>신선한 샐러드 파우치</h3>
	    		<div class="regularPrice">10,000원</div><!-- (정상가) -->
	    		<h3 class="savingsOff">20% OFF</h3>
	    		<h3>8,000원</h3><!-- (판매가) -->
	    		<div>배송비 2,500원</div>
	    		<div>
	    			<form action="" method="post" name="">
						<div class="form-row">
			                <div class="form-group col-sm-2">
			                	<label>수량</label>
			                	<input type="text" name="" class="form-control" maxlength="20">
			              	</div>
		              	</div>
		              	<div>총 150,000원(8개)</div>
						<input type="hidden" name="num" value="">
						<button type="submit" class="btn btn-primary">장바구니 담기</button>
					</form>
    			</div>
    	
    		</div>
    	</div>
    	
    	
    	
    	<hr>
    	
    	<div>
    		<div>식품설명</div>
    		<div>탄수화물</div>
    		<div>단백질</div>
    		<div>지방</div>
    		<div>칼로리</div>
    		<div>유통기한</div>
    		<div>원산지</div>
    		<div>소비자상담관련 업체 고객센터 1522-1234</div>
    	</div>
    	
    
<!-- ------------------------------------------------------------------------------- -->  
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- ------------------------------------------------------------------------------- -->
<!-- -------------------리뷰목록------------------------------------------------------------ -->

  
    
    <hr>
    <h3>전체 구매후기</h3>
    상품을 구매하신 분들이 작성하신 구매 후기입니다.
      <form method="#" action="#" class="form-inline mt-3">
        <select name="lectureDivide" class="form-control mx-1 mt-2">
          <option value="작성자">작성자</option>
          <option value="식품명">제목</option>
        </select>
        <input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요.">
        <button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
        <a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="reviewRegister.jsp">등록하기</a>
        <a class="btn btn-danger ml-1 mt-2" data-toggle="modal" href="report.jsp">신고</a>
      </form>
      <div class="card bg-light mt-3">
        <div class="card-header bg-light">
          <div class="row">
            <div class="col-8 text-left">리뷰 제목&nbsp;&nbsp;&nbsp;&nbsp;<small>작성자이름</small></div>
            <div class="col-4 text-right">2018/10/02(등록일)
            </div>
          </div>
        </div>
        <div class="card-body">
          <p class="card-text">리뷰 총평
          </p>
          <img src="#" width="200" height="200">(이미지)
          <div class="row">
            <div class="col-9 text-left">
            	<p>★★★★★(별점)</p>
            </div>
          </div>
        </div>
        <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo">답변 보기</button>
        <div id="demo" class="collapse">
	        <div class="card bg-light mt-3">
		        <div class="card-header bg-light">
		          <div class="row">
		            <div class="col-8 text-left">리뷰답변 제목&nbsp;&nbsp;&nbsp;&nbsp;<small>작성자이름</small></div>
		            <div class="col-4 text-right">2018/10/03(등록일)
		            </div>
		          </div>
		        </div>
		        <div class="card-body">
		          <p class="card-text">리뷰답변 내용</p>
		        </div>
	        </div>
        </div>
        <div class="card bg-light mt-3">
        <div class="card-header bg-light">
          <div class="row">
            <div class="col-8 text-left">리뷰 제목&nbsp;&nbsp;&nbsp;&nbsp;<small>작성자이름</small></div>
            <div class="col-4 text-right">2018/10/02(등록일)
            </div>
          </div>
        </div>
        <div class="card-body">
          <p class="card-text">리뷰 총평
          </p>
          <img src="#" width="200" height="200">(이미지)
          <div class="row">
            <div class="col-9 text-left">
            	<p>★★★★★(별점)</p>
            </div>
          </div>
        </div>
      </div>
	    <ul class="pagination justify-content-center mt-3">
	      <li class="page-item">
	        <a class="page-link" href="#">이전</a>
	      </li>
	      <li class="page-item">
	        <a class="page-link" href="#">다음</a>
	      </li>
	    </ul>
    </div>
    </div>
  </body>
</html>

