package br.com.softblue.javaee.websocket;

import java.io.IOException;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/random")
public class RandomEndpoint {
	
	private static Queue<Session> sessions = new ConcurrentLinkedQueue<Session>();
	
	static {
		Random random = new Random();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					int number = random.nextInt(1000);
					System.out.println("Número: " + number);
					sendAll(number);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println("Conexão aberta: " + session.getId());
		sessions.add(session);
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		System.out.println("Conexão fechada: " + session.getId());
		sessions.remove(session);
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.out.println("Erro");
		throwable.printStackTrace();
	}

	@OnMessage
	public void onMessage(Session session, String message) throws IOException {
		System.out.println("Mensaem recebida: " + message + " - " + session.getId());
	}
	
	private static void sendAll(int number) {
		try {
			for (Session s : sessions) {
				if (s.isOpen()) {
					s.getBasicRemote().sendText(String.valueOf(number));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
