<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>

<html>
  <head>
    <title>공지사항 등록</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
  </head>

  <body>
    <div class="container mt-3">
      <form:form commandName="noticeInsertCommand">
      	<form:hidden path="noticeNo" type="hidden" value=""/>
      	<div class="form-group">
          <label>제목</label>
          <form:input path="noticeTitle"/>
        </div>
        <div class="form-group">
          <label>내용</label><br>
          <form:textarea path="noticeContent"/>
        </div>
        <div class="form-button">
        <button type="submit" class="btn btn-primary">작성</button>
        <button type="reset" class="btn btn-secondary">다시 작성</button>
        <button type="button" class="btn btn-secondary" onclick="history.go(-1);">뒤로가기</button>
        </div>
      </form:form>
    </div>
  </body>
</html>