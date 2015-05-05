package com.lifeix.androidbasecoredemo.fragment;

import java.util.List;

import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.BeforeTextChange;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.SeekBarProgressChange;
import org.androidannotations.annotations.SeekBarTouchStart;
import org.androidannotations.annotations.SeekBarTouchStop;
import org.androidannotations.annotations.TextChange;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.UiThread.Propagation;
import org.androidannotations.annotations.ViewById;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.lifeix.androidbasecore.BaseFragment;
import com.lifeix.androidbasecore.command.Response;
import com.lifeix.androidbasecore.command.TPError;
import com.lifeix.androidbasecore.command.TaskProcessListener;
import com.lifeix.androidbasecore.utils.ToastUtils;
import com.lifeix.androidbasecoredemo.DemoApplication;
import com.lifeix.androidbasecoredemo.R;
import com.lifeix.androidbasecoredemo.adapter.ListViewAdapter;
import com.lifeix.androidbasecoredemo.adapter.ListViewAdapter_;
import com.lifeix.androidbasecoredemo.command.NoteInsertTask;

import de.greenrobot.db.Note;
import de.greenrobot.db.NoteDao;

@EFragment(R.layout.fragment_simple)
public class SimpleFragment extends BaseFragment {

	@App
	DemoApplication application;

	@FragmentArg
	String title;
	@FragmentArg
	String msg;

	@ViewById(R.id.sb_progrecess)
	SeekBar seekBar;
 
	@ViewById(R.id.txt_label)
	TextView txtLabel;

	@ViewById(R.id.lsv_contacts)
	ListView lsvContacts;

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		showParam();
	}

	/*********************** seekBar *************************/
	@SeekBarTouchStart(R.id.sb_progrecess)
	void onStartTrackingTouch(SeekBar seekBar) {
		Log.d(tag, String.format("seekBar-onStartTrackingTouch|Progress:%s", seekBar.getProgress()));
	}

	@SeekBarTouchStop(R.id.sb_progrecess)
	void onStopTrackingTouch(SeekBar seekBar) {
		Log.d(tag, String.format("seekBar-onStopTrackingTouch|Progress:%s", seekBar.getProgress()));
	}

	@SeekBarProgressChange(R.id.sb_progrecess)
	void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		Log.d(tag, String.format("seekBar-onProgressChanged|Progress:%s, fromUser:%s", progress, fromUser));
	}

	/*********************** seekBar *************************/

	/************************ textChange **************************/
	@TextChange(R.id.txt_label)
	void onTextChange(CharSequence sequence, TextView hello, int before, int start,
			int count) {
		Log.d(tag, String.format("txt_label:onTextChange:%s", sequence));
	}

	@TextChange(R.id.txt_label)
	void onTextChange(TextView textView, CharSequence sequence) {
		Log.d(tag, String.format("txt_label:onTextChange:%s", sequence));
	}

	@TextChange(R.id.txt_label)
	void onTextChange(TextView textView) {

	}

	@TextChange(R.id.txt_label)
	void onTextChange() {

	}

	/************************ textChange **************************/

	@BeforeTextChange(R.id.txt_label)
	void beforeTextChange(TextView hello, CharSequence sequence, int start,
			int count, int after) {
		Log.d(tag, String.format("txt_label:beforeTextChange:%s", sequence));
	}

	@AfterTextChange(R.id.txt_label)
	void afterTextChange(Editable text, TextView textView) {
		Log.d(tag, String.format("txt_label:afterTextChange:%s", text.toString()));
	}

	private void showParam() {
		Log.d(tag, String.format("title:%s | msg:%s", title, msg));
	}

	@ItemClick(R.id.lsv_contacts)
	public void onItemClicked(String item) {
		ToastUtils.show(getActivity(), String.format("ListView:lsv_contacts:onItemClicked:%s", item));
	}

	@ItemLongClick
	public void lsv_contacts(String item) {
		ToastUtils.show(getActivity(), String.format("ListView:lsv_contacts:lsv_contacts(longClick):%s", item));
	}

	@ItemSelect(R.id.lsv_contacts)
	public void onItemSelected(boolean selected, String item) {
		ToastUtils.show(getActivity(), String.format("ListView:lsv_contacts:onItemSelected:%s", item));
	}

	// @ItemClick(R.id.lsv_contacts)
	// public void onItemClicked(int position) {//位置id
	//
	// }
	//
	// @ItemLongClick(R.id.lsv_contacts)
	// public void onItemLongClicked(int position) {
	//
	// }
	//
	// @ItemSelect(R.id.lsv_contacts)
	// public void onItemSelected(boolean selected, int position) {
	//
	// }

	@AfterViews
	void init() {
		showListView();
		initData();
		//"loadData"
		loadDataFromDB();
		//取消执行
		// BackgroundExecutor.cancelAll("loadData", true);
		
		doInBackgroundAfterTwoSeconds();
	}

	private void initData() {
		doCommand(new NoteInsertTask(new TaskProcessListener<Response>() {

			@Override
			public void onSuccess(Response response) {
				Log.d(tag, String.format(
						" NoteInsert onSuccess | Taskresponse:%s", response));
			}

			@Override
			public void onPrepare() {
				Log.d(tag, String.format("NoteInsertTask onPrepare..."));
			}

			@Override
			public void onFail(TPError error) {
				Log.d(tag, String.format("NoteInsertTask onFail | error:%s",
						error));
			}
		}));
	}

	// id可不设置
	@Background(id = "loadData", delay=2000)
	void loadDataFromDB() {
		NoteDao noteDao = application.getDaoSessionReadble().getNoteDao();
		List<Note> users = noteDao.loadAll();
		Log.d(tag, String.format("users:%s", users));
	}

	@Background(serial = "test")
	void someSequentialBackgroundTask(int i){
		// SystemClock.sleep(new Random().nextInt(2000)+1000);
	    Log.d("AA", "value : " + i);
	}
	
	@Background(delay = 2000)
	void doInBackgroundAfterTwoSeconds(){
		Log.d(tag, String.format("@Background task excute delay 2000mm"));
	}
	
	@UiThread(delay = 500)
	void excuteInUIThread(){
		Log.d(tag, String.format("@UiThread task excute delay 500mm"));
	}
	
	@UiThread(propagation=Propagation.REUSE)
	void showListView() {
		ListViewAdapter adapter = ListViewAdapter_.getInstance_(getActivity());
		lsvContacts.setAdapter(adapter);
	}
}
