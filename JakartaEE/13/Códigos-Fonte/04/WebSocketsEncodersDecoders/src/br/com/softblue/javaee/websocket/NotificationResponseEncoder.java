package br.com.softblue.javaee.websocket;

import java.io.StringWriter;
import java.time.format.DateTimeFormatter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class NotificationResponseEncoder implements Encoder.Text<NotificationResponse> {

	@Override
	public void init(EndpointConfig config) {
	}

	@Override
	public String encode(NotificationResponse notificationResponse) throws EncodeException {
		JsonObject jsonObj = Json.createObjectBuilder()
			.add("time", notificationResponse.getTime().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
			.add("assignedId", notificationResponse.getAssignedId())
			.build();
		
		StringWriter out = new StringWriter();
		Json.createWriter(out).writeObject(jsonObj);
		return out.toString();
	}

	@Override
	public void destroy() {
	}
}
