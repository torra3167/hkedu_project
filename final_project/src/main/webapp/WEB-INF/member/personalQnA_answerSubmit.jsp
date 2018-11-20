<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="javax.mail.internet.*"%>
	<%@page import="javax.mail.*"%>	
	<%@page import="javax.activation.*" %>
	<%@page import="java.util.*" %>
    <%
    	request.setCharacterEncoding("utf-8");
     	String sender=(String)request.getAttribute("sender");
    	String receiver=(String)request.getParameter("email");
    	String title=request.getParameter("title");
    	String contents="";
    	contents+=request.getParameter("contents");
    	
/*     	contents+="asdfasdfasdf"; */
    	/* form에서 받아온 값들 변수에 저장 */
    	
    	String server="imap.gmail.com";
    	String port="465";
    	Properties properties=new Properties();
    	
    	properties.put("mail.smtp.host", server);
    	properties.put("mail.smtp.port", port);
    	properties.put("mail.smtp.starttls.enable", "true");
    	properties.put("mail.smtp.auth", "true");
    	properties.put("mail.smtp.debug", "true");
    	properties.put("mail.smtp.socketFactory.port", port);
    	properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    	properties.put("mail.smtp.socketFactory.fallback", "false");
    	
    	/* 이메일 사용하기 위해 설정한 값 */
    	
    	try{
    		Session s=Session.getInstance(properties, new Authenticator(){
    			protected PasswordAuthentication getPasswordAuthentication(){
    				return new PasswordAuthentication("kdahae1129@gmail.com", "~~lida9629");
    			}
    		});
    		Message message=new MimeMessage(s);
    		Address senderAddr=new InternetAddress(sender);
    		Address receiverAddr=new InternetAddress(receiver);
    		message.setHeader("content-type", "text/html;charset=UTF-8");
    		message.setFrom(senderAddr);
    		message.addRecipient(Message.RecipientType.TO, receiverAddr);
    		message.setSubject(title);
    		message.setContent(contents, "text/html;charset=UTF-8");
    		message.setSentDate(new java.util.Date());
    		Transport.send(message, message.getAllRecipients());
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>1대 1 문의하기</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/custom-1.css">
</head>
<body>
<div class="container">
	<div class="board">
	문의 답변이 정상적으로 발송되었습니다. <br>
	<button type="button" value="메인으로" class="btn btn-primary float-1" onclick="location.href='index'">메인으로</button>
	</div>
</div>
</body>
</html>