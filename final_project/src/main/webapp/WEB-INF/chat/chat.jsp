<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%
    	request.setCharacterEncoding("utf-8");
    	String memberEmail = (String)session.getAttribute("email");
    	
    	if(memberEmail == null) {
    		memberEmail = "비회원";
    	}
    
    %>
    
    
   
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Chat</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="css/kakaotalk.css">
</head>
<body>
  <div class="chat-container">
		<div class="chat-header">
			<button id="close" class="header-btn"></button>
			<button id="minimize" class="header-btn"></button>
			<button id="maximize" class="header-btn"></button>
			<img id="profile-pic" src="images/profile.jpg" width="50"
				height="50"> <span id="username"><%=memberEmail %></span>
		</div>
		<form>
			<!-- 대화명 : <input id="nick" type="text" /><input id="login" type="button"
				value="로그인" /> -->
			<div id="monitor" class="chatbox" contentEditable="true">
				<div class="user"><%=memberEmail%></div>
			</div>
			<div class="text-box">
				
				<textarea id="msg" placeholder="대화내용을 입력해주세요">
					
				</textarea>
				<input id="send" type="button" value="전송" onClick="sendMsg()" /> 
 				<!-- <input type="button" value="나가기" onClick="disConn()" /> -->
 		</div>
		</form>
</div>
</body>



<script>

	
	/*pay관련오류  */
/* 	var url = "ws://192.168.6.100:8080/controller/chat/";
 */	var url = "ws://192.168.0.6:8080/final_project/chat/";
	var webSocket = null;
	var monitor = document.getElementById("monitor");
	//접속 URL
	
	
	$(document).ready(function() {
		
		url += '<%= memberEmail %>';
	
		
		console.log(url);
		webSocket = new WebSocket(url);
		
		//웹소켓 연결됐을 때(client <- server)
		webSocket.onopen = function(e) {
			console.log(e);
		}

		//웹소켓 끊겼을 때(client <- server)
		webSocket.onclose = function(e) {
			if (e.type == "close") {
				monitor.innerHTML += "채팅이 종료 되었습니다.<br/>";
			}
		}

		//메시지 수신(client <- server)
		webSocket.onmessage = function(e) {
			console.log(e);
			monitor.innerHTML += e.data + "<br/>";
		}
	});
	
	/* $("#login").click(function() {
		url += $("#nick").val();
		console.log(url);
		webSocket = new WebSocket(url);//웹 소켓 객체 생성	

		//웹소켓 연결됐을 때(client <- server)
		webSocket.onopen = function(e) {
			console.log(e);
		}

		//웹소켓 끊겼을 때(client <- server)
		webSocket.onclose = function(e) {
			if (e.type == "close") {
				monitor.innerHTML += "접속이 종료 되었습니다.<br/>";
			}
		}

		//메시지 수신(client <- server)
		webSocket.onmessage = function(e) {
			console.log(e);
			monitor.innerHTML += e.data + "<br/>";
		}

	}); */

	//웹소켓 종료(client -> server)
	function disConn() {
		webSocket.close();
	}

	//메시지 전송(client -> server)
	function sendMsg() {
		var textVal = $('textarea').val();
		/* if( $('textarea').val() !== '') {
		       console.log( $('textarea').val() );
		       $('textarea').val('');
		       var message = $('<div>' + textVal + '</div>');
		       message.addClass('my-bubble');
		       $('.chatbox').append(message);
		    } else {
		       console.log("비어있음");
		    } */
		    var curDate = new Date();
		    var curTime = curDate.getFullYear() + "-" + (curDate.getMonth() + 1) + "-" + curDate.getDate() + " " 
		    + curDate.getHours() + ":" + curDate.getMinutes();
		    
		    
			webSocket.send(
				'<br>'+
				'<div class="my-bubble">' + textVal + '</div>' + '<br>'
				+'<span class="time_date">'+ curTime +'</span>');
			$("#msg").val("");
	}
</script>
<script src="js/kakaotalk.js"></script>
</html>