package com.lifeix.androidbasecoredemo.utils;

import com.lifeix.androidbasecoredemo.DemoApplication;

import de.greenrobot.db.DaoSession;

public class DBUtils {

	public static DaoSession getDaoSessionReadble() {
		return (DaoSession) DemoApplication.getInstance()
				.getDaoSessionReadble();
	}

	public static DaoSession getDaoSessionWritable() {
		return (DaoSession) DemoApplication.getInstance()
				.getDaoSessionWritable();
	}
}
