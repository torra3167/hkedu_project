<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, category.*" %>
    
   
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>

<div class="container" style="max-width: 560px;">
        <form action="program_register.gom" enctype="multipart/form-data" method="post">
      
        	<div class="form-group">
				<label>프로그램 이름</label> <input type="text" name="proName" class="form-control">
			</div>
			<div class="form-group">
				<label>프로그램 사진 </label> <input type="file" name="proImg" class="form-control">
			</div>
		
			
			
			<button type="submit" class="btn btn-primary">메뉴 등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
</body>
</html>