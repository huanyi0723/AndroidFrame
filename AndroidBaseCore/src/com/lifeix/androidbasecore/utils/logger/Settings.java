package com.lifeix.androidbasecore.utils.logger;

import android.content.Context;
import android.os.Looper;

/**
 * @author Orhan Obut
 */
public final class Settings {

	private int methodCount = 2;
	private boolean showThreadInfo = true;
	private Logger2File logger2File;

	/**
	 * Determines how logs will printed
	 */
	private LogLevel logLevel = LogLevel.FULL;

	public Settings hideThreadInfo() {
		showThreadInfo = false;
		return this;
	}

	public Settings setMethodCount(int methodCount) {
		this.methodCount = methodCount;
		return this;
	}

	public Settings setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
		return this;
	}

	public int getMethodCount() {
		return methodCount;
	}

	public boolean isShowThreadInfo() {
		return showThreadInfo;
	}

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public Logger2File getLogger2File() {
		return logger2File;
	}
	
	public boolean isLogger2File(){
		return logger2File != null;
	}

	public void needFileLog(Context context) {
		logger2File = new Logger2File(context);
		logger2File.open();
	}

	public void closeFileLog() {
		if (logger2File != null) {
			logger2File.close();
		}
	}
}
