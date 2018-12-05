<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.MemberSurvey, java.util.Calendar"%>
    <%int result=Integer.parseInt(request.getAttribute("period").toString()); %>
    <% Calendar cal=Calendar.getInstance();
    int y=cal.get(cal.YEAR);
    int m=cal.get(cal.MONTH);
    int nBMI=Integer.parseInt(request.getAttribute("normal").toString());
    int BMI=Integer.parseInt(request.getAttribute("BMI").toString());
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
<!-- <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
 --><script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script> 
<script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
</head>
<body>
<div class="container mt-3">
      설문 작성이 완료되었습니다.<br>
      <div class="box-header with-border">
              <h3 class="box-title">나의 목표</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body chart-responsive">
              <div class="chart" id="line-chart" style="height: 300px;"></div>
            </div>
            <!-- /.box-body -->
          </div>
      <button type="button" class="btn btn-primary" onclick="location.href='index'">메인으로</button>

</body>
<script type="text/javascript">
new Morris.Line({
    element: 'line-chart',
    data: [
      <%for(int i=1; i<=result; i++){%>
    {y: '<%=y%>-<%=m%>', item1: '<%=BMI%>'},
   <% 
         /* int line=BMI-nBMI/result;
         BMI=BMI-line; */
      }%>
    ],
    xkey: 'y',
    ykeys: ['item1'],
    labels: ['Item 1'],
    lineColors: ['#3c8dbc'],
    hideHover: 'auto'
  });
</script>
</html>