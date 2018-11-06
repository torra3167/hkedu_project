<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="container mt-3" style="max-width: 560px;">
        <form method="post" action="#">
        	<div class="form-group">
				<label>판매식품 이름</label> <input type="text" name="foodName" class="form-control">
			</div>
			<div class="form-group">
				<label>판매식품 이미지</label> <input type="file" name="foodImage" class="form-control">
			</div>
			<div>
				<select id="aaa" name="aaa" onclick="">
					<option value="aaa">aaa</option>
				</select>
			</div>
			<div class="form-group">
				<label>판매할 식품 개수</label> <input type="text" name="foodQuant" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 유통기한</label> <input type="text" name="foodExpiryDate" class="form-control">
			</div>
			<div class="form-group">
				<label> 식품재료 원산지</label> <input type="text" name="foodOrigin" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 할인율</label> <input type="text" name="foodSale" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 맛</label> <input type="text" name="foodFlavor" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 판매가격</label> <input type="text" name="foodPrice" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 탄수화물 함량</label> <input type="text" name="foodCarbo" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 단백질 함량</label> <input type="text" name="foodProtein" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 지방 함량</label> <input type="text" name="foodFat" class="form-control">
			</div>
			<div class="form-group">
				<label>식품 칼로리</label> <input type="text" name="foodCal" class="form-control">
			</div>
			<button type="submit" class="btn btn-primary">메뉴 등록</button>
			<button type="reset" class="btn btn-primary">다시 작성</button>
        </form>
    </div>
</body>
</html>