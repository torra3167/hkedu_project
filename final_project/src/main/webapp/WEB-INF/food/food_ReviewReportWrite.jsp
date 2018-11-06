<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</head>    
<body>
<div id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
            <h5>식품리뷰 신고</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="body">
            <form action="#" method="post">
              <div class="form-row">
                <div class="form-group col-sm-6">
                	<label>제목</label>
                	<input type="text" name="" class="form-control" maxlength="20">
              	</div>
              </div>
              <div class="form-group">
                <label>내용</label>
                <textarea type="text" name="" class="form-control" maxlength="2048" style="height: 180px;"></textarea>
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary">등록하기</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
              </div>
            </form>
          </div>
</body>
</html>