package com.lifeix.androidbasecoredemo.service;

import org.androidannotations.annotations.EService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * AndroidAnnotations生成的对应类可能会报错，需手动添加构造方法
 * 
 * @author Kim.Huang
 * 
 */

@EService
public class DownloadService extends /*Intent*/Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}


}
