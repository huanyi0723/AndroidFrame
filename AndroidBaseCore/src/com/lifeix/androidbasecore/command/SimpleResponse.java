package com.lifeix.androidbasecore.command;

public class SimpleResponse implements Response {

	private String simpleInfo;

	public SimpleResponse(String simpleInfo) {
		this.simpleInfo = simpleInfo;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + simpleInfo;
	}
}
