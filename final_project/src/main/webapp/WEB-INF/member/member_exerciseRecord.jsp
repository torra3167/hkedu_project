<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운동 기록</title>

    <link rel="stylesheet" href="../css/bootstrap.min.css">
</head>    
<body>
<div class="container">
	<div  id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">

            <h5>운동 기록하기</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="body">
            <form action="" method="post">
              <div class="toDo">
              <label>정규 운동</label>
              	<table>
              	<tr>
              		<td>운동 이름</td>
              		<td>개수</td>
              		<td>무게</td>
              	</tr>
              	<tr>
              		<td></td>
              		<td><input type="text" class="records">번</td>
              		<td><input type="text" class="records">kg</td>
              	</tr>
              </table>
              </div>
              <div class="record">
              <!-- 운동 개수(받아온 것)에 따라서 table 개수 늘리고 이름 받아오기 -->
              <div class="record">
              <label>추가 운동</label>
              	<button type="button" class="btn btn-primary">운동 추가하기</button> <!-- 추가하기 누르면 table 추가되게 -->
              </div>
              <div class="record">
              <table>
              	<tr>
              		<td>운동 이름</td>
              		<td>개수</td>
              		<td>무게</td>
              	</tr>
              	<tr>
              		<td><input type="text" class="records"></td>
              		<td><input type="text" class="records">번</td>
              		<td><input type="text" class="records">kg</td>
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
</body>
</html>