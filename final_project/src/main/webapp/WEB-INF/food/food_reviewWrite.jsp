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
<div  id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
            <h5>식품리뷰 등록</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="body">
            <form action="#" method="post">
              <div class="form-row">
                <div class="form-group col-sm-6">
                	<label>제목</label>
                	<input type="text" name="reviewTitle" class="form-control" maxlength="20">
              	</div>
              </div>
              <div class="form-group">
                <label>총평</label>
                <textarea type="text" name="reviewContent" class="form-control" maxlength="2048" style="height: 180px;"></textarea>
              </div>
              <div class="form-group">
                <label>이미지</label>
                <input type="file" name="reviewImage" class="form-control">
              </div>
              <div class="form-row">
                <div class="form-group col-sm-3">
                  <label>총점</label>
                  <select name="totalScore" class="form-control">
                    <option value="A" selected>★</option>
                    <option value="B">★★</option>
                    <option value="C">★★★</option>
                    <option value="D">★★★★</option>
                    <option value="F">★★★★★</option>
                  </select>
                </div>
              </div>
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary">등록하기</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
              </div>
            </form>
          </div>
</body>
</html>