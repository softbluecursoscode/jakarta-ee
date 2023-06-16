package br.com.softblue.javaee.websocket;

import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/notification", decoders = { NotificationRequestDecoder.class }, encoders = { NotificationResponseEncoder.class })
public class NotificationEndpoint {
	
	private static AtomicInteger currentId = new AtomicInteger(1);
	
	@OnOpen
	public void connected(Session session, EndpointConfig conf) throws IOException {
		System.out.println("connected()");
	}
	
	@OnClose
	public void disconnected(Session session, CloseReason reason) throws IOException {
		System.out.println("disconnected()");
	}
	
	@OnError
	public void error(Session session, Throwable t) {
		System.out.println("error()");
		t.printStackTrace();
	}
	
	@OnMessage
	public void messageReceived(Session session, NotificationRequest notificationRequest) throws IOException, EncodeException {
		System.out.println("messageReceived(): " + notificationRequest.toString());
		
		NotificationResponse notificationResponse = new NotificationResponse(LocalTime.now(), currentId.getAndIncrement());
		session.getBasicRemote().sendObject(notificationResponse);
	}
}
