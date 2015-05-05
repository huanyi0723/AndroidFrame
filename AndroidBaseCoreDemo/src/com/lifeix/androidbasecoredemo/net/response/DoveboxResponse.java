package com.lifeix.androidbasecoredemo.net.response;

import com.android.volley.response.NormalResponse;


/**
 * Volley请求的响应对象
 * @author lifeix
 */
public class DoveboxResponse extends NormalResponse {
    
    public final int status;
    public final DoveboxResponseData data;
    
    public DoveboxResponse(
    		/**访问的接口编码*/
            int code, 
            /**响应状态*/
            int status,
            /**响应消息*/
            String msg, 
            /**响应数据*/
            DoveboxResponseData data) {
    	super(code, msg);
        this.status = status;
        this.data = data;
    }

    @Override
    public boolean isSuccess() {
    	
        return NormalResponse.RESPONSE_CODE_SUCCESS == code;
    }
}
