<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

		



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</head>

<body>
<span id="count" class="badge bg-theme">쪽지함</span>
		

</body>
<script>

	var websocket = null;
	var wsurl ="ws://192.168.0.6:8080/final_project/message/";
	 $(document).ready(function(){
 		
 		send_message();

 	});
	 
	function send_message() {
    	
        
		websocket = new WebSocket(wsurl);
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

    }


 </script>
</html>