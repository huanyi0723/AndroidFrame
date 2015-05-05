/**
 * 
 */
package com.lifeix.androidbasecoredemo.net.response;

import com.android.volley.response.NormalResponse;

/**
 * @author WhatXiao
 * 
 *         2014年11月17日
 */
public class NewsDetailResponse extends NormalResponse {
	public final int status;
	public final NewsDetailData data;

	/**
	 * @param code
	 * @param message
	 */
	public NewsDetailResponse(
	/** 访问的接口编码 */
	int code,
	/** 响应状态 */
	int status,
	/** 响应消息 */
	String msg,
	/** 响应数据 */
	NewsDetailData data) {
		super(code, msg);
		this.status = status;
		this.data = data;
	}

	@Override
	public boolean isSuccess() {

		return NormalResponse.RESPONSE_CODE_SUCCESS == code;
	}

	@Override
	public String toString() {
		return "NewsDetailResponse [status=" + status + ", data=" + data + "]";
	}

}
