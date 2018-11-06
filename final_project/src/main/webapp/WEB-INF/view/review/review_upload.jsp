<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
    <script src="../js/jquery.min.js"></script>

    <script src="../js/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css">

  </head>

  <body>

    <div class="container">

      <form method="get" action="./index.jsp" class="form-inline mt-3">

        <select name="lectureDivide" class="form-control mx-1 mt-2">

          <option value="전체">전체</option>

          <option value="운동">운동</option>

          <option value="코치">코치</option>

          <option value="프로그램">프로그램</option>

        </select>

        <input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요.">

        <button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>

        <a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="reviewRegister.jsp">등록하기</a>

        <a class="btn btn-danger ml-1 mt-2" data-toggle="modal" href="report.jsp">신고</a>

      </form>

      <div class="card bg-light mt-3">

        <div class="card-header bg-light">

          <div class="row">

            <div class="col-8 text-left">프로그램이름&nbsp;<small>고객명</small></div>

            <div class="col-4 text-right">

              종합 <span style="color: red;">A</span>

            </div>

          </div>

        </div>

        <div class="card-body">

          <h5 class="card-title">

            정말 좋은 프로그램이에요.&nbsp;<small>(프로그램 이름)</small>

          </h5>

          <p class="card-text">너무 좋은 것 같습니다.</p>

          <div class="row">

            <div class="col-9 text-left">

         구성 <span style="color: red;">A</span>

              효과 <span style="color: red;">A</span>

              가격 <span style="color: red;">B</span>

              <span style="color: green;">(추천: 15★)</span>

            </div>

            <div class="col-3 text-right">

              <a onclick="return confirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=">추천</a>

              <a onclick="return confirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=">삭제</a>

            </div>

          </div>

        </div>

      </div>

      <div class="card bg-light mt-3">

        <div class="card-header bg-light">

          <div class="row">

            <div class="col-8 text-left">프로그램이름2&nbsp;<small>이름2</small></div>

            <div class="col-4 text-right">

              종합 <span style="color: red;">B</span>

            </div>

          </div>

        </div>

        <div class="card-body">

          <h5 class="card-title">

            나쁘지 않은 것 같습니다.&nbsp;<small>(프로그램 이름)</small>

          </h5>

          <p class="card-text">상당히 재미있었던 것 같아요.</p>

          <div class="row">

            <div class="col-9 text-left">

              구성 <span style="color: red;">B</span>

              효과 <span style="color: red;">C</span>

              가격 <span style="color: red;">B</span>

              <span style="color: green;">(추천: 1)</span>

            </div>

            <div class="col-3 text-right">

              <a onclick="return confirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=">추천</a>

              <a onclick="return confirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=">삭제</a>

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

    


  </body>

</html>

