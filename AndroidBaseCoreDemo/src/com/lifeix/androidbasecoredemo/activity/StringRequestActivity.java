package com.lifeix.androidbasecoredemo.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.webkit.WebView;

import com.android.volley.VolleyError;
import com.android.volley.Request.Method;
import com.android.volley.listener.VolleyRequestListener;
import com.lifeix.androidbasecore.BaseFragmentActivity;
import com.lifeix.androidbasecore.utils.logger.Logger;
import com.lifeix.androidbasecoredemo.DemoApplication;
import com.lifeix.androidbasecoredemo.R;
import com.lifeix.androidbasecoredemo.net.StringRequest;

@EActivity(R.layout.activity_stringrequest)
public class StringRequestActivity extends BaseFragmentActivity {

	@App
	DemoApplication application;

	@ViewById(R.id.wv_baidu)
	WebView webView;

	@AfterViews
	void afterViews() {
		StringRequest request = new StringRequest("http://www.baidu.com",
				Method.GET, new VolleyRequestListener<String>() {

					@Override
					public void onSuccess(String data) {
						Logger.i("data:%s", data);
						showWebViewContent(data);
					}

					@Override
					public void onFail(VolleyError error) {
						Logger.e(error, "");
					}
				});
		application.getVolleyManager().add(request, this);
	}

	@UiThread
	void showWebViewContent(String data) {
		webView.loadDataWithBaseURL(null, data, "text/html", "ISO9985-1", null);
	}

}
