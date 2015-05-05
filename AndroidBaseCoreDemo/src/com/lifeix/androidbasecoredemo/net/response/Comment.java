package com.lifeix.androidbasecoredemo.net.response;

import java.io.Serializable;

public class Comment implements Serializable {

	public int comment_id;
	public String content;
	public String cited_content;
	public String create_time;
	public int status;
	public Account account;
	public Account replies_account;
	public String app_url;
	public String root_id;
	public String type;

	public Comment(int comment_id, String content, String cited_content,
			String create_time, int status, Account account,
			Account replies_account, String app_url, String root_id, String type) {
		this.comment_id = comment_id;
		this.content = content;
		this.cited_content = cited_content;
		this.create_time = create_time;
		this.status = status;
		this.account = account;
		this.replies_account = replies_account;
		this.app_url = app_url;
		this.root_id = root_id;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", content=" + content
				+ ", cited_content=" + cited_content + ", create_time="
				+ create_time + ", status=" + status + ", account=" + account
				+ ", replies_account=" + replies_account + ", app_url="
				+ app_url + ", root_id=" + root_id + ", type=" + type + "]";
	}

}
