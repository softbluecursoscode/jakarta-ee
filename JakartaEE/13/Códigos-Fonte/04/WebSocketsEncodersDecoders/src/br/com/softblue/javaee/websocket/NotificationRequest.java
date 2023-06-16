package br.com.softblue.javaee.websocket;

public class NotificationRequest {

	private String title;
	private String content;

	
	public NotificationRequest(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "NotificationRequest [title=" + title + ", content=" + content + "]";
	}
}
