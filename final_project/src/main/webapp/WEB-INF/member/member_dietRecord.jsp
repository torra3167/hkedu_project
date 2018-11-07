<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식단 기록</title>

    <link rel="stylesheet" href="../css/bootstrap.min.css">
    
</head>    
<body>
<div class="container">
	<div  id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">

            <h5>식단 기록하기</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="body">
            <form action="" method="post">
            <div class="form-row">
                <div class="form-group col-sm-3">
                  <label>상품 가져오기</label>
                  <select class="form-control">
                    <option value="" selected>--선택--</option>
                  </select>
                </div>
              </div>
              <div class="record">
              	<button type="button" class="btn btn-primary">일반식 추가하기</button> <!-- 추가하기 누르면 table 추가되게 -->
              </div>
              <div class="record">
              <table>
              	<tr>
              		<td>식품 이름</td>
              		<td>칼로리</td>
              		<td>탄수화물</td>
              		<td>단백질</td>
              		<td>지방</td>
              	</tr>
              	<tr>
              		<td><input type="text" class="records"></td>
              		<td><input type="text" class="records">kcal</td>
              		<td><input type="text" class="records">g</td>
              		<td><input type="text" class="records">g</td>
              		<td><input type="text" class="records">g</td>
              	</tr>
              </table>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="submit" class="btn btn-primary">등록하기</button>
              </div>
            </form>
          </div>
          </div>
          
       <script src="../js/jquery.min.js"></script>
    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
</body>
</html>