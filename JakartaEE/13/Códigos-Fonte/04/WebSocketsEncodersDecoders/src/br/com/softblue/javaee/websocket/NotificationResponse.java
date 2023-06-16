package br.com.softblue.javaee.websocket;

import java.time.LocalTime;

public class NotificationResponse {

	private LocalTime time;
	private int assignedId;

	public NotificationResponse(LocalTime time, int assignedId) {
		this.time = time;
		this.assignedId = assignedId;
	}

	public LocalTime getTime() {
		return time;
	}

	public int getAssignedId() {
		return assignedId;
	}

	@Override
	public String toString() {
		return "NotificationResponse [time=" + time + ", assignedId=" + assignedId + "]";
	}
}
