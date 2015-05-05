package com.lifeix.androidbasecoredemo;

import java.util.List;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.StringRes;

import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.lifeix.androidbasecore.BaseFragmentActivity;
import com.lifeix.androidbasecore.command.Response;
import com.lifeix.androidbasecore.command.TPError;
import com.lifeix.androidbasecore.command.TaskProcessListener;
import com.lifeix.androidbasecore.utils.NetWorkUtil.NetType;
import com.lifeix.androidbasecoredemo.activity.SimpleActivity_;
import com.lifeix.androidbasecoredemo.bean.User;
import com.lifeix.androidbasecoredemo.command.NoteInsertTask;

import de.greenrobot.db.DaoSession;
import de.greenrobot.db.Note;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseFragmentActivity {

	@App
	DemoApplication application;
	
	@Bean User user;

	@ViewById(R.id.img_show) ImageView imageView;

	@StringRes
	String app_name;

	@AfterViews
	void afterViews() {
		Log.e(tag, "afterViews...");
		registerNetChangeListener();
	}
	
	@AfterViews
	void afterViews_1(){
		
	}

	@AfterInject
	void afterInject() {
		Log.e(tag, "afterInject...");
	}

	@Override
	protected void onStop() {
		super.onStop();
		unRegisterNetChangeListener();
	}

	@Click(R.id.btn_db_insert)
	void insertDb() {
		doCommand(new NoteInsertTask(new TaskProcessListener<Response>() {

			@Override
			public void onSuccess(Response response) {
				Log.e(tag, String.format(
						" NoteInsert onSuccess | Taskresponse:%s", response));
			}

			@Override
			public void onPrepare() {
				Log.e(tag, String.format("NoteInsertTask onPrepare..."));
			}

			@Override
			public void onFail(TPError error) {
				Log.e(tag, String.format("NoteInsertTask onFail | error:%s",
						error));
			}
		}));
	}
	
	@Click(R.id.btn_db_query)
	@Background
	void queryNote() {
		DaoSession daoSession = (DaoSession) getDaoSessionReadble();
		List<Note> notes = daoSession.getNoteDao().loadAll();
		Log.e(tag, String.format("notes:%s", notes));
	}

	@Click(R.id.btn_imgLoad)
	void loadImage() {
		String imgUrl = "http://www.vaikan.com/wordpress/wp-content/uploads/2012/08/Google_Go_language.jpg";
		application.getImageLoader().displayImage(imgUrl, imageView);
	}

	@Click(R.id.btn_jump)
	void jump() {
		Toast.makeText(this, app_name, Toast.LENGTH_SHORT).show();
		SimpleActivity_.intent(this).comeFrom("MainActivity").start();
	}

	@Override
	public void onConnect(NetType type) {
		super.onConnect(type);
		Log.e(tag, String.format("网络已连接 NetType：%s", type.name()));
	}
}