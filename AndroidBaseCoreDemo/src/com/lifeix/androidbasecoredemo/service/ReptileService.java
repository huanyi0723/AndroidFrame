package com.lifeix.androidbasecoredemo.service;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EService;

import com.lifeix.androidbasecoredemo.DemoApplication;
import com.lifeix.androidbasecoredemo.events.HitEvent;
import com.lifeix.androidbasecoredemo.utils.Constants;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 爬虫服务
 * 
 * @author Tiger
 * 
 */

@EService
public class ReptileService extends Service {

	@App DemoApplication application;
	
	AntThread antThread;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(antThread == null){
			antThread = new AntThread();
			antThread.start();
		}
		return super.onStartCommand(intent, flags, startId);
	}

	private class AntThread extends Thread {
		private int step = 0;
		@Override
		public void run() {
			while(true){
				step ++;
				int result = (step %= 3);
				if(0 == result){
					Intent intent = new Intent();
					intent.setAction(Constants.ACTION.ACTION_HIT);
					intent.putExtra("", "");
					sendBroadcast(intent);
					application.getEventBus().post(new HitEvent(System.currentTimeMillis(), String.format("hit:%s", step)));
				}
				try{
					Thread.sleep(1000l);
				}catch(Exception exception){
					
				}
			}
		}
	}

}
