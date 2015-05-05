package com.lifeix.androidbasecore;

import com.lifeix.androidbasecore.command.Response;
import com.lifeix.androidbasecore.command.Task;
import com.umeng.analytics.MobclickAgent;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {

	private BaseApplication application;

	public String tag = getClass().getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		application = (BaseApplication) getActivity().getApplication();
	}

	@Override
	public void onResume() {
		super.onResume();
		MobclickAgent.onPageStart(tag); // 统计页面
	}

	@Override
	public void onPause() {
		super.onPause();
		MobclickAgent.onPageEnd(tag);
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
