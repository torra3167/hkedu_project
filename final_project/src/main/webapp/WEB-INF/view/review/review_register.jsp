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



            <h5>평가 등록</h5>

            <button type="button" class="close" data-dismiss="modal" aria-label="Close">

              <span aria-hidden="true">&times;</span>

            </button>

          </div>

          <div class="body">

            <form action="./evaluationRegisterAction.jsp" method="post">

              <div class="form-row">

                <div class="form-group col-sm-6">

                  <label>프로그램명</label>

                  <input type="text" name="lectureName" class="form-control" maxlength="20">

                </div>

                <div class="form-group col-sm-6">

                  <label>코치명</label>

                  <input type="text" name="professorName" class="form-control" maxlength="20">

                </div>

              </div>

              <div class="form-row">

                <div class="form-group col-sm-4">

                  <label>수강 년도</label>

                  <select name="lectureYear" class="form-control">

                    <option value="2011">2011</option>

                    <option value="2012">2012</option>

                    <option value="2013">2013</option>

                    <option value="2014">2014</option>

                    <option value="2015">2015</option>

                    <option value="2016">2016</option>

                    <option value="2017">2017</option>

                    <option value="2018" selected>2018</option>

                    <option value="2019">2019</option>

                    <option value="2020">2020</option>

                    <option value="2021">2021</option>

                    <option value="2022">2022</option>

                    <option value="2023">2023</option>

                  </select>

                </div>

                <div class="form-group col-sm-4">

                  <label>수강 학기</label>

                  <select name="semesterDivide" class="form-control">

                    <option name="1학기" selected>1학기</option>

                    <option name="여름학기">여름학기</option>

                    <option name="2학기">2학기</option>

                    <option name="겨울학기">겨울학기</option>

                  </select>

                </div>

                <div class="form-group col-sm-4">

                  <label>강의 구분</label>

                  <select name="lectureDivide" class="form-control">

                    <option name="1" selected>1</option>

                    <option name="2">2</option>

                    <option name="3">3</option>

                  </select>

                </div>

              </div>

              <div class="form-group">

                <label>제목</label>

                <input type="text" name="evaluationTitle" class="form-control" maxlength="20">

              </div>

              <div class="form-group">

                <label>내용</label>

                <textarea type="text" name="evaluationContent" class="form-control" maxlength="2048" style="height: 180px;"></textarea>

              </div>

              <div class="form-row">

                <div class="form-group col-sm-3">

                  <label>종합</label>

                  <select name="totalScore" class="form-control">

                    <option value="A" selected>A</option>

                    <option value="B">B</option>

                    <option value="C">C</option>

                    <option value="D">D</option>

                    <option value="F">F</option>

                  </select>

                </div>

                <div class="form-group col-sm-3">

                  <label>효과</label>

                  <select name="creditScore" class="form-control">

                    <option value="A" selected>A</option>

                    <option value="B">B</option>

                    <option value="C">C</option>

                    <option value="D">D</option>

                    <option value="F">F</option>

                  </select>

                </div>

                <div class="form-group col-sm-3">

                  <label>구성</label>

                  <select name="comfortableScore" class="form-control">

                    <option value="A" selected>A</option>

                    <option value="B">B</option>

                    <option value="C">C</option>

                    <option value="D">D</option>

                    <option value="F">F</option>

                  </select>

                </div>

                <div class="form-group col-sm-3">

                  <label>가격</label>

                  <select name="Score" class="form-control">

                    <option value="A" selected>A</option>

                    <option value="B">B</option>

                    <option value="C">C</option>

                    <option value="D">D</option>

                    <option value="F">F</option>

                  </select>

                </div>

              </div>

              <div class="modal-footer">

                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>

                <button type="submit" class="btn btn-primary">등록하기</button>

              </div>

            </form>

          </div>


</body>
</html>