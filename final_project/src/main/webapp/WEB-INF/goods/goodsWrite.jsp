<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
   function checkIt() {
      var frm = document.getElementById("goodsWrite");
      if (!frm.goodsName.value) {
         alert("상품명을 입력하세요");
         frm.goodsName.focus();
         return false;
      }
      if (!frm.goodsKind.value) {
         alert("종류를 입력하세요");
         frm.goodsKind.focus();
         return false;
      }
      if (!frm.goodsPrice.value) {
         alert("가격을 입력하세요");
         frm.goodsPrice.focus();
         return false;
      }
      if (!frm.goodsContent.value) {
         alert("내용을 입력하세요");
         frm.goodsContent.focus();
         return false;
      }
      frm.submit();
   }
</script>
<style type="text/css">
table{border:3px solid black; margin-top:20px; margin-bottom:20px; }
#border1{padding:20px; border-bottom:1px solid black;}
#border2{padding-bottom:20px;} 
#border3{padding:20px;} 
#border{border-top:1px dotted black; padding:20px;}
</style> 
</head>
<body>
   <form  name="frm" action="goodsAddAction.sh" method="post"
      enctype="multipart/form-data" id="goodsWrite">
      <table align="center" width="50%" border="0" >
         <tr align="center">
            <td colspan=2 id="border1" align="center"><font size=5>상품 업로드</font></td>
         </tr>
         <tr>
            <td id="border3" align="center">종류 :</td>
            <td id="border3" align="left">
               <input type="radio" name="goodsKind" value="모자" >모자&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio" name="goodsKind" value="상의" >상의&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio" name="goodsKind" value="하의" >하의&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio" name="goodsKind" value="신발" >신발&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio" name="goodsKind" value="가방" >가방&nbsp;&nbsp;&nbsp;&nbsp;
               <input type="radio" name="goodsKind" value="드레스" >드레스&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
         </tr>
         <tr>
            <td id="border" align="center">상품명 :</td>
            <td id="border" align="left">
            <input type="radio" name="goodsName" value="셔츠">셔츠&nbsp;&nbsp;&nbsp;
            <input type="radio" name="goodsName" value="반팔티">반팔티 &nbsp;&nbsp;<input type="radio" name="goodsName" value="긴팔티">긴팔티
            <input type="radio" name="goodsName" value="자켓">자켓 <br />
            <hr>
            <input type="radio" name="goodsName" value="반바지">반바지<input type="radio" name="goodsName" value="긴바지">긴바지
            <input type="radio" name="goodsName" value="치마">치마 <br />
            <hr>
            <input type="radio" name="goodsName" value="샌들">샌들&nbsp;&nbsp;&nbsp;<input type="radio" name="goodsName" value="슬리퍼">슬리퍼
            <input type="radio" name="goodsName" value="구두">구두&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="goodsName" value="운동화">운동화<br />
            <hr>
            <input type="radio" name="goodsName" value="백팩">백팩&nbsp;&nbsp;&nbsp;<input type="radio" name="goodsName" value="에코백">에코백
            <input type="radio" name="goodsName" value="크로스백">크로스백<input type="radio" name="goodsName" value="숄더백">숄더백 <br />
            <hr>
            <input type="radio" name="goodsName" value="원피스">원피스<input type="radio" name="goodsName" value="투피스">투피스
            <input type="radio" name="goodsName" value="점프슈트">점프슈트<br>
            <hr>
            <input type="radio" name="goodsName" value="모자">모자
            
            
            </td>
         </tr>
         <tr>
            <td id="border" align="center">이미지</td>
            <td id="border" align="left"><input type="file" name="goodsImage"></td>
         </tr>
         <tr>
            <td id="border" align="center">가격 :</td>
            <td id="border" align="left"><input type="text" name="goodsPrice" size="5"> 원</td>
         </tr>
         <tr>
            <td id="border" align="center">제조국 :</td>
            <td id="border" align="left"><input type="text" name="goodsCountry"></td>
         </tr>
         <tr>
            <td id="border" align="center">사이즈 :</td>
            <td id="border" align="left"><input type="text" name="goodsSize"></td>
         </tr>
         <tr>
            <td id="border" align="center">색상 :</td>
            <td id="border" align="left"><input type="text" name="goodsColor"></td>
         </tr>
         <tr>
            <td id="border" align="center">내용 :</td>
            <td id="border" align="left"><textarea rows="50" cols=90 " name="goodsContent"></textarea></td>
         </tr>
         <tr>
         <tr>
            <td colspan="2" align="center" id="border2"><a href="goodsList.sh">목록보기</a>&nbsp;&nbsp;&nbsp;&nbsp;
               &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:checkIt();">저장</a></td>
         </tr>
</table>
</form>
</body>
</html>