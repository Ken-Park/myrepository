package kh.spring.webchat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/chat",configurator=HttpSessionSetter.class)
public class WebChat {

	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());//websocket 세션
	
	@OnMessage
	public void onMessage(String message, Session session) throws Exception{

		synchronized(clients) {
			for(Session each : clients) {
				if(each != session) {//자기 자신에게는 안보내는 것
					each.getBasicRemote().sendText(message);
				}
			}
		}
	}


	@OnOpen
	public void onOpen(Session session, EndpointConfig ec) {//함수의 이름이 중요한 것이 아니라 OnOpen annotation이 붙어야 하는 것이 중요하다.
		HttpSession hsession = (HttpSession)ec.getUserProperties().get("httpSession");
		System.out.println(hsession.getAttribute("id"));
		
		clients.add(session);
	}

	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}
}
