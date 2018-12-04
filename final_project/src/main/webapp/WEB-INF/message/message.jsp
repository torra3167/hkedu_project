<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("utf-8"); %>
		
<%
    	request.setCharacterEncoding("utf-8");
    	String memberEmail = (String)session.getAttribute("email");

    %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</head>

<body>
<span id="count" class="badge bg-theme">쪽지함</span>

<form>
	<input id="nick" name="memberEmail" type="hidden" value="<%=memberEmail%>"/>
			
			
			<div>보내는사람
				<input id="nick" type="text" value="<%=memberEmail%>" readonly="readonly"/>	
			</div>
			<div>받는사람
				<input id="nick" type="text" value=""/>	
			</div>
			<br>
			<div>제목</div>
			<br>
			<div>내용
				<textarea name="monitor" id="monitor" cols="30" rows="10"></textarea>
			</div>
			메시지 : <input id="msg" type="text"/>
			<div id="monitor" contentEditable="true"></div>
			<div>							
				
				<input type="reset" value="다시쓰기" />
				<input type="button" value="전송" onClick="sendMsg()"/>
				<input type="button" value="나가기" onClick="disConn()"/>

			</div>
		</form>		 

</body>
<script type="text/javascript">

	var url = "ws://192.168.6.129:8080/final_project/message/";
	var webSocket = null;
	var monitor = document.getElementById("monitor");
	//접속 URL
	
	
	$(document).ready(function() {
		
		url += '<%=memberEmail%>';
		
		
		console.log(url);
		webSocket = new WebSocket(url);
		
		//웹소켓 연결됐을 때(client <- server)
		webSocket.onopen = function(event) {
			console.log(event + " ONOPEN");
		}

		//웹소켓 끊겼을 때(client <- server)
		webSocket.onclose = function(event) {
			if (event.type == "close") {
				monitor.innerHTML += "채팅이 종료 되었습니다.<br/>";
			}
		}

		//메시지 수신(client <- server)
		webSocket.onmessage = function(event) {
			console.log(event.data + "EVENT DATA");
			$('#count').append(event.data);
 		
		}
	});
	

	//웹소켓 종료(client -> server)
	function disConn() {
		webSocket.close();
	}

	//메시지 전송(client -> server)
	function sendMsg() {
		webSocket.send($("#nick").val()+"> "+$("#msg").val());
		$("#msg").val("");
	}		

/* 	var websocket = null;
 	var wsurl ="ws://192.168.0.6:8080/final_project/message/";
 	var wsurl ="ws://192.168.6.129:8080/final_project/message/";
	 $(document).ready(function(){
		websocket = new WebSocket(wsurl);
 		send_message();

 	});
	 
	function send_message() {
    	
        
		
        websocket.onopen = function(evt) {

            onOpen(evt);

        };

        websocket.onmessage = function(evt) {

            onMessage(evt);

        };

        websocket.onerror = function(evt) {

            onError(evt);

        };

    }

   

    function onOpen(evt) 

    {

       websocket.send("${nick}");

    }

    function onMessage(evt) {

    		$('#count').append(evt.data);

    }

    function onError(evt) {

    } */


 </script>
</html>