package com.lifeix.androidbasecore;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.lifeix.androidbasecore.command.Response;
import com.lifeix.androidbasecore.command.Task;
import com.lifeix.androidbasecore.netstatus.NetChangeObserver;
import com.lifeix.androidbasecore.netstatus.NetworkStateReceiver;
import com.lifeix.androidbasecore.utils.NetWorkUtil.NetType;
import com.umeng.analytics.MobclickAgent;

import de.greenrobot.dao.AbstractDaoSession;

public class BaseFragmentActivity extends FragmentActivity implements
		NetChangeObserver {

	public String tag = getClass().getSimpleName();

	BaseApplication application;

	@Override
	protected void onCreate(Bundle arg0) {
		application = BaseApplication.getInstance();
		super.onCreate(arg0);
	}

	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		unRegisterNetChangeListener();
	}

	/**
	 * 获取application
	 */
	public BaseApplication getBaseApplication() {
		return application;
	}

	/**
	 * 监听网络状态变化
	 */
	protected void registerNetChangeListener() {
		NetworkStateReceiver.registerObserver(this);
	}

	/**
	 * 取消监听网络状态变化
	 */
	protected void unRegisterNetChangeListener() {
		NetworkStateReceiver.removeRegisterObserver(this);
	}

	@Override
	public void onConnect(NetType type) {
		Log.e(tag,
				"net change call back onConnect(NetType type) not implements");
		Log.e(tag, String.format("NetType:", type.name()));
	}

	@Override
	public void onDisConnect() {
		Log.e(tag, "net change call back onDisConnect() not implements");
	}

	protected AbstractDaoSession getDaoSessionReadble() {
		return application.getDaoSessionReadble();
	}

	protected AbstractDaoSession getDaoSessionWritable() {
		return application.getDaoSessionWritable();
	}

	/**
	 * 发送任务
	 * 
	 * @param task
	 */
	protected final void doCommand(Task<Response> task) {
		application.sendTask(task);
	}
}