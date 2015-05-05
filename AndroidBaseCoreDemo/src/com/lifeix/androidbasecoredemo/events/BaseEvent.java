package com.lifeix.androidbasecoredemo.events;

public class BaseEvent {

	public long eventId;
	public String eventName;

	public BaseEvent(long eventId, String eventName) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
	}

	@Override
	public String toString() {
		return "BaseEvent [eventId=" + eventId + ", eventName=" + eventName
				+ "]";
	}

}
