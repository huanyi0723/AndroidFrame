package com.lifeix.androidbasecoredemo.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import android.content.Intent;

import com.lifeix.androidbasecore.BaseFragmentActivity;
import com.lifeix.androidbasecore.command.SimpleResponse;
import com.lifeix.androidbasecore.command.TPError;
import com.lifeix.androidbasecore.command.TaskProcessListener;
import com.lifeix.androidbasecore.utils.logger.Logger;
import com.lifeix.androidbasecoredemo.DemoApplication;
import com.lifeix.androidbasecoredemo.R;
import com.lifeix.androidbasecoredemo.tasks.TaskCounter;

@EActivity(R.layout.activity_sub)
public class SubActivity extends BaseFragmentActivity {

	@App
	DemoApplication application;

	String taskId;

	@Click(R.id.btn_finish)
	void exit() {

		application.cancelTaskEvenInExecutting(taskId);
		application.cancelTaskEvenInExecutting(taskId);

		Intent intent = new Intent();
		intent.putExtra("resultNumberName", "returned int value");
		intent.putExtra("resultNumber", 100);
		setResult(RESULT_OK, intent);
		finish();
	}

	@SuppressWarnings("unchecked")
	@AfterViews
	void afterViews() {
		TaskCounter<SimpleResponse> counter = new TaskCounter<SimpleResponse>(
				new TaskProcessListener<SimpleResponse>() {

					@Override
					public void onPrepare() {
						Logger.i("TaskCounter:%s", "onPrepare");
					}

					@Override
					public void onFail(TPError error) {
						Logger.e("TaskCounter:error:%s", error.getCause());
					}

					@Override
					public void onSuccess(SimpleResponse response) {
						Logger.i("TaskCounter:onSuccess:%s",
								response.toString());
					}
				});
		taskId = counter.getId();
		doCommand(counter);
	}

}
