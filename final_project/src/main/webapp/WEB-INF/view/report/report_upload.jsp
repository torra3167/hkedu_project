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
<div class=""  tabindex="-1" role="dialog" >

            <h5 class="page-header">신고하기</h5>



          </div>

         

            <form method="post" action="./reportAction.jsp">

              <div class="form-group">

                <label>신고 제목</label>

                <input type="text" name="reportTitle" class="form-control" maxlength="20">

              </div>

              <div class="form-group">

                <label>신고 내용</label>

                <textarea type="text" name="reportContent" class="form-control" maxlength="2048" ></textarea>

              </div>

              <div class="modal-footer">

                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>

                <button type="submit" class="btn btn-danger">신고하기</button>

              </div>

            </form>

        

    
</body>
</html>