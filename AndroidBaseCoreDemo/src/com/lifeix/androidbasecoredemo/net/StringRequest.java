package com.lifeix.androidbasecoredemo.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.listener.VolleyRequestListener;
import com.android.volley.param.ApiParam;
import com.android.volley.param.IApi;
import com.android.volley.request.AbstractStringRequest;

public class StringRequest extends AbstractStringRequest {

	public StringRequest(List<ApiParam<?>> params, int apiCode, IApi api,
			VolleyRequestListener<String> volleyRequestListener) {
		super(params, apiCode, api, volleyRequestListener);
	}

	public StringRequest(List<ApiParam<?>> params, int method, String url,
			VolleyRequestListener<String> volleyRequestListener) {
		super(params, method, url, volleyRequestListener);
	}

	public StringRequest(Map<String, String> headers, int method,
			List<ApiParam<?>> params, String url,
			VolleyRequestListener<String> volleyRequestListener) {
		super(headers, method, params, url, volleyRequestListener);
	}

	public StringRequest(Map<String, String> headers, List<ApiParam<?>> params,
			int apiCode, IApi api,
			VolleyRequestListener<String> volleyRequestListener) {
		super(headers, params, apiCode, api, volleyRequestListener);
	}

	public StringRequest(String url, int method,
			VolleyRequestListener<String> volleyRequestListener) {
		super(url, method, volleyRequestListener);
	}

	@Override
	public void addCommonParams() {
		if (this.params == null) {
			this.params = new ArrayList<ApiParam<?>>();
		}
	}

	@Override
	public Map<String, String> getHeaders() {
		if (this.headers == null) {
			this.headers = new HashMap<String, String>();
		}
		return headers;
	}

}
