<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>

<html>
  <head>
    <title>설문지</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
  </head>
  <style type="text/css">
  	.container{
  		width:70%;
  		max-width:560px;
  	}
  	.form-control{
  		width:49%;
  	}
  	.form-button{
  		float:center;
  	}
  </style>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="index.jsp">설문지</a>
    </nav>
    <div class="container mt-3">
      <form method="post" action="">
      <div class="form-group">
          <label>나의 라이프스타일</label>
          <select class="form-control">
                    <option value="" selected>--선택--</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
          </select>
        </div>
        <div class="form-group">
          <label>선호하는 체형</label>
          <select class="form-control">
                    <option value="" selected>--선택--</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
          </select>
        </div>
        <div class="form-group">
          <label>고려해야 할 질환</label><br>
          <textarea rows="5" cols="50" placeholder="당뇨, 갑상선 질환 등 운동과 식단을 계획하는 데 고려해야 할 질환이 있다면 여기에 작성해주세요."></textarea>
        </div>
        <div class="form-group">
          <label>다이어트를 하는 데 가장 큰 걱정</label><br>
          <textarea rows="5" cols="50" placeholder="불규칙한 식습관, 수면습관 등 다이어트를 하는 데 걱정이 있다면 여기에 작성해주세요."></textarea>
        </div>
        <div class="form-group">
          <label>지난 다이어트 실패 원인</label><br>
          <textarea rows="5" cols="50" placeholder="자신이 생각하는 지난 다이어트의 실패 원인을 여기에 작성해주세요."></textarea>
        </div>
        <div class="form-group">
          <label>과거 운동 경력</label><br>
          <textarea rows="5" cols="50" placeholder="과거에 해본 운동이 있으면 여기에 작성해주세요."></textarea>
        </div>
        <div class="form-group">
        	<label>내 전신 사진 파일 업로드</label><br>
        	<input type="file">
        </div>
        <div class="form-button">
        <button type="submit" class="btn btn-primary">제출하기</button>
        <button type="reset" class="btn btn-secondary">다시 작성</button>
        <button type="button" class="btn btn-secondary">뒤로가기</button>
        </div>
      </form>
    </div>
    <script src="./js/jquery.min.js"></script>
    <script src="./js/popper.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
  </body>
</html>