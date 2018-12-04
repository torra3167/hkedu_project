package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint(value="/message/{userId}")
public class WebSocketMessageController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	static HashMap<String, Session> userList = new HashMap<String, Session>();
	
	//서버접속
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String userId) {
		//@PathParam 은 웹소켓에서 사용하는 @PathVariables	
		if(userList.get(userId) != null) {
			logger.info("중복");
			sendMessage(session, "사용중인 아이디");
			
		} else {
			logger.info("중복ㄴㄴ");
			userList.put(userId, session);
			broadCast(userId + "쪽지 시작~");
			
		}
	}

	//서버 종료
	@OnClose
	public void onClose(Session session) {
		String value = session.getId(); //id확인
		Set<String> keys = userList.keySet();
		for(String key : keys) {
			if(value.equals(userList.get(key).getId())) {
				logger.info("종료아이디" + key);
				userList.remove(key, session);
				broadCast(key + " 삭제");
			}
		}
	}
	
	
	
	//한명에게 메세지 보내기??
	private void sendMessage(Session session, String message) {
		// TODO Auto-generated method stub
		System.out.println(message + " 한명message");
		
		broadCast(message);
	}
	
	//메세지 전체보내기
	private void broadCast(String message) {
		// TODO Auto-generated method stub
		logger.info("전체보내기" + userList.size());
		Set<String> keys = userList.keySet();
		try {
			for(String key : keys) {
				Session session = userList.get(key);
				session.getBasicRemote().sendText(message);
				System.out.println(message + " 전체메세지");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//에러 발생시
	@OnError
	public void onError(Session session, Throwable error) {
		logger.info("에러세션" + session);
		System.out.println(error.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
