<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% int result=(Integer)request.getAttribute("result");
		String email=(String)request.getParameter("email");
	%>
	<%@page import="javax.mail.internet.*"%>
	<%@page import="javax.mail.*"%>	
	<%@page import="javax.activation.*" %>
	<%@page import="java.util.*" %>
    <%if(result>0){
    	request.setCharacterEncoding("utf-8");
     	String sender="kdahae1129@gmail.com";
    	String title=email+"님의 비밀번호 변경 링크를 안내드립니다.";
    	String contents="";
    	contents+="안녕하세요, "+email+" 계정의 비밀번호 변경 링크를 안내드립니다.<br>";
    	contents+="비밀번호는 타 사이트에서 사용하지 않는 것으로 변경 부탁드립니다.";
    	contents+="<br><br>";
    	contents+="비밀번호 변경 : http://localhost:8080/final_project/changePW.gom?app="+email;
    	
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
    		Address receiverAddr=new InternetAddress(email);
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
    }
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<body>
<% if(result>0){ %>
	<div class="container">
		<div class="message">회원님의 회원정보에 있는 이메일로 비밀번호를 전송했습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary" onclick="index">메인으로</button>
			<button type="button" class="btn btn-primary" onclick="login.gom">로그인</button>
		</div>
	</div>
<%} else { %>
	<div class="container">
		<div class="message">일치하는 회원정보가 없습니다.</div>
		<div class="btn">
			<button type="button" class="btn btn-primary" onclick="history.go(-1);">뒤로가기</button>
			<button type="button" class="btn btn-primary" onclick="member_join.gom">회원가입</button>
		</div>
	</div>
	<%} %>
</body>