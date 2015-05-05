package com.lifeix.androidbasecoredemo.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.widget.TextView;

import com.android.volley.Request.Method;
import com.android.volley.VolleyError;
import com.android.volley.listener.VolleyRequestListener;
import com.lifeix.androidbasecore.BaseFragmentActivity;
import com.lifeix.androidbasecore.download.DownLoadCallback;
import com.lifeix.androidbasecore.download.DownloadManager;
import com.lifeix.androidbasecore.utils.logger.Logger;
import com.lifeix.androidbasecoredemo.DemoApplication;
import com.lifeix.androidbasecoredemo.R;
import com.lifeix.androidbasecoredemo.net.GsonRequest;
import com.lifeix.androidbasecoredemo.net.StringRequest;
import com.lifeix.androidbasecoredemo.net.response.NewsDetailResponse;

@EActivity(R.layout.activity_netsimple)
public class NetSimpleActivity extends BaseFragmentActivity {

	@App
	DemoApplication application;

	/**
	 * 文件下载管理器
	 */
	DownloadManager downloadManager;

	@ViewById(R.id.txt_info)
	TextView textView;

	@AfterViews
	void afterViews() {
		downloadManager = DownloadManager.getDownloadManager();
		downloadManager.setDownLoadCallback(new DownLoadCallback() {

			@Override
			public void onStart() {
				super.onStart();
				String newInfo = String.format("onStart");
				Logger.i(newInfo);
				refreshInfo(newInfo);
			}

			@Override
			public void onAdd(String url, Boolean isInterrupt) {
				super.onAdd(url, isInterrupt);

				String newInfo = String.format("onAdd|url:%s, isInterrupt:%s",
						url, isInterrupt);
				Logger.i(newInfo);
				refreshInfo(newInfo);
			}

			@Override
			public void onLoading(String url, long totalSize, long currentSize,
					long speed) {
				super.onLoading(url, totalSize, currentSize, speed);

				String newInfo = String
						.format("onLoading|url:%s, totalSize:%s, currentSize:%s, speed:%s",
								url, totalSize, currentSize, speed);
				Logger.i(newInfo);
				refreshInfo(newInfo);
			}

			@Override
			public void onSuccess(String url) {
				super.onSuccess(url);

				String newInfo = String.format("onSuccess|url:%s", url);
				Logger.i(newInfo);
				refreshInfo(newInfo);
			}

			@Override
			public void onFailure(String url, String strMsg) {
				super.onFailure(url, strMsg);

				String newInfo = String.format("onFailure|url:%s, strMsg:%s",
						url, strMsg);
				Logger.i(newInfo);
				refreshInfo(newInfo);
			}

			@Override
			public void onFinish(String url) {
				super.onFinish(url);

				String newInfo = String.format("onFinish|url:%s", url);
				Logger.i(newInfo);
				refreshInfo(newInfo);
			}

			@Override
			public void onStop() {
				super.onStop();

				String newInfo = String.format("onStop");
				Logger.i(newInfo);
				refreshInfo(newInfo);
			}

		});
	}

	@UiThread
	void refreshInfo(String newInfo) {
		String oldInfo = textView.getText().toString();
		textView.setText(oldInfo + "\n" + newInfo);
	}

	@Click(R.id.btn_download)
	void download() {
		String url = "http://www.ctps.cn/PhotoNet/Profiles/luyi28/200891584949179026706.jpg";
		downloadManager.deleteHandler(url);
		downloadManager.addHandler(url);
	}

	@Click(R.id.btn_gson_request)
	void excuteGsonRequest() {
		String url = "http://192.168.2.156:8080/tiyu/rest/content/view?id=12";
		GsonRequest<NewsDetailResponse> request = new GsonRequest<NewsDetailResponse>(
				NewsDetailResponse.class, url, Method.GET,
				new VolleyRequestListener<NewsDetailResponse>() {

					@Override
					public void onFail(VolleyError error) {
						Logger.e(error, "error info is null");
						refreshInfo("error");
					}

					@Override
					public void onSuccess(NewsDetailResponse newsDetailResponse) {
						String info = newsDetailResponse.toString();
						Logger.i(info);
						refreshInfo(info);
					}
				});
		application.getVolleyManager().add(request, this);
	}

	@Click
	void btn_string_request() {
		String url = "http://192.168.2.156:8080/tiyu/rest/content/view?id=12";
		StringRequest request = new StringRequest(url, Method.GET,
				new VolleyRequestListener<String>() {

					@Override
					public void onFail(VolleyError error) {
						Logger.e(error, "error info is null");
						refreshInfo("error");
					}

					@Override
					public void onSuccess(String newsDetailResponse) {
						String info = newsDetailResponse;
						Logger.json(info);
						refreshInfo(info);
					}
				});
		application.getVolleyManager().add(request, this);
	}
}
