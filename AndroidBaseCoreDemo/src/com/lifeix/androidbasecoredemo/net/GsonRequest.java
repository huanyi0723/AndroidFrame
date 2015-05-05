package com.lifeix.androidbasecoredemo.net;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.listener.VolleyRequestListener;
import com.android.volley.param.ApiParam;
import com.android.volley.param.IApi;
import com.android.volley.request.AbstractGsonRequest;
import com.android.volley.response.NormalResponse;

public class GsonRequest<T extends NormalResponse> extends
		AbstractGsonRequest<T> {

	/**
	 * Gson 请求
	 * 
	 * @param clazz
	 *            请求结果转换类型
	 * @param params
	 *            请求参数
	 * @param apiCode
	 *            url对应api编号
	 * @param api
	 *            url 生成器, <strong>{@link IApi}</strong>的实现类
	 * @param volleyRequestListener
	 *            网络处理回调接口
	 */
	public GsonRequest(Class<T> clazz, List<ApiParam<?>> params, int apiCode,
			IApi api, VolleyRequestListener<T> volleyRequestListener) {
		super(clazz, params, apiCode, api, volleyRequestListener);
	}

	/**
	 * Gson 请求
	 * 
	 * @param clazz
	 *            请求结果转换类型
	 * @param params
	 *            请求参数
	 * @param method
	 *            请求方式（目前仅支持GET和POST,默认请求方式为POST. 详情查看 <strong>{@link Method}
	 * @param url
	 *            请求地址
	 * @param volleyRequestListener
	 *            网络处理回调接口
	 */
	public GsonRequest(Class<T> clazz, List<ApiParam<?>> params, int method,
			String url, VolleyRequestListener<T> volleyRequestListener) {
		super(clazz, params, method, url, volleyRequestListener);
	}

	/**
	 * Gson 请求
	 * 
	 * @param clazz
	 *            请求结果转换类型
	 * @param headers
	 *            请求头
	 * @param method
	 *            请求方式（目前仅支持GET和POST,默认请求方式为POST. 详情查看 <strong>{@link Method}
	 * @param params
	 *            请求参数
	 * @param url
	 *            请求地址
	 * @param volleyRequestListener
	 *            网络处理回调接口
	 */
	public GsonRequest(Class<T> clazz, Map<String, String> headers, int method,
			List<ApiParam<?>> params, String url,
			VolleyRequestListener<T> volleyRequestListener) {
		super(clazz, headers, method, params, url, volleyRequestListener);
	}

	/**
	 * Gson 请求
	 * 
	 * @param clazz
	 *            请求结果转换类型
	 * @param headers
	 *            请求头
	 * @param params
	 *            请求参数
	 * @param apiCode
	 *            url对应api编号
	 * @param api
	 *            url 生成器, <strong>{@link IApi}</strong>的实现类
	 * @param volleyRequestListener
	 *            网络处理回调接口
	 */
	public GsonRequest(Class<T> clazz, Map<String, String> headers,
			List<ApiParam<?>> params, int apiCode, IApi api,
			VolleyRequestListener<T> volleyRequestListener) {
		super(clazz, headers, params, apiCode, api, volleyRequestListener);
	}

	/**
	 * Gson 请求
	 * 
	 * @param clazz
	 *            请求结果转换类型
	 * @param url
	 *            请求地址
	 * @param method
	 *            请求方式（目前仅支持GET和POST,默认请求方式为POST. 详情查看 <strong>{@link Method}
	 *            </strong>）
	 * @param volleyRequestListener
	 *            网络处理回调接口
	 */
	public GsonRequest(Class<T> clazz, String url, int method,
			VolleyRequestListener<T> volleyRequestListener) {
		super(clazz, url, method, volleyRequestListener);
	}

	/**
	 * Gson 请求
	 * 
	 * @param clazz
	 *            请求结果转换类型
	 * @param url
	 *            请求地址
	 * @param volleyRequestListener
	 *            网络处理回调接口
	 */
	public GsonRequest(Class<T> clazz, String url,
			VolleyRequestListener<T> volleyRequestListener) {
		super(clazz, url, Method.POST, volleyRequestListener);
	}

	@Override
	public void addCommonParams() {
		if (this.params == null) {
			this.params = new ArrayList<ApiParam<?>>();
		}
		// TODO
	}

	@Override
	public Map<String, String> getHeaders() {
		if (this.headers == null) {
			this.headers = new HashMap<String, String>();
		}
		// TODO
		return headers;
	}

}
