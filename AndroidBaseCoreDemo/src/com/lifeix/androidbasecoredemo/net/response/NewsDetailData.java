/**
 * 
 */
package com.lifeix.androidbasecoredemo.net.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author WhatXiao
 * 
 *         2014年11月17日
 */
public class NewsDetailData implements Serializable {
	
	public static final String NEWS_ID = "t_id";
	
	public static final String BOARD_ID = "t_dashboard_id";
	
	public static final String TYPE = "t_type";
	
	public static final int TYPE_CACHE = 1;
	
	
	public static final int VIDEO_TYPE = 1;
	
	public static final int PICTURE_TYPE = 0;
	
	public static final int VIDEO_YOUKU = 0;
	
	public static final int VIDEO_SINA = 1;
	// 新闻id
	public String id;
	public int user_id;
	// 新闻标题
	public String title;
	public int status;
	public String create_time;
	public String update_time;
	// 新闻来源
	public String name;
	// 评论数
	public int note_num;
	// 新闻内容
	public String text_content;
	// 推荐阅读
	public String recssaved;
	
	public List<NewsBrief> recs;
	// 新闻类型 0表示普通，1表示收藏
	public int type = 0;
	// 新闻链接
	public String newsUrl;
	// 新闻图片url
	public String image;
	// 新闻摘要
	public String text;
	// 信鸽id
	public long dashboard_id;
	// 收藏时间
	public long collectTime;
	public long dashboard_type;
	public long dashboard_data;
	public String photoes;
	public int content_type;
	public int video_type;
	public String video_link;
	public String getVideo_link() {
		return video_link;
	}

	public void setVideo_link(String video_link) {
		this.video_link = video_link;
	}

	public int getContent_type() {
		return content_type;
	}

	public void setContent_type(int content_type) {
		this.content_type = content_type;
	}

	public int getVideo_type() {
		return video_type;
	}

	public void setVideo_type(int video_type) {
		this.video_type = video_type;
	}

	public String getPhotoes() {
		return photoes;
	}

	public void setPhotoes(List<String> strs) {
		if (strs == null)//TODO
			return;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.size(); i++) {
			if (i != strs.size() - 1) {
				sb.append(strs.get(i) + ",");
			} else {
				sb.append(strs.get(i));
			}
		}
		photoes = sb.toString();
	}

	
	public DoveboxResponseData user;
	
	public List<String> text_images;

	public DoveboxResponseData getUser() {
		return user;
	}

	public void setUser(DoveboxResponseData user) {
		this.user = user;
	}

	public long getCollectTime() {
		return collectTime;
	}

	public void setCollectTime(long collectTime) {
		this.collectTime = collectTime;
	}

	public long getDashboard_id() {
		return dashboard_id;
	}

	public void setDashboard_id(long dashboard_id) {
		this.dashboard_id = dashboard_id;
	}

	public List<String> getText_images() {
		return text_images;
	}

	public void setText_images(List<String> text_images) {
		this.text_images = text_images;
	}

	public String getNewsUrl() {
		return newsUrl;
	}

	public void setNewsUrl(String newsUrl) {
		this.newsUrl = newsUrl;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNote_num() {
		return note_num;
	}

	public void setNote_num(int note_num) {
		this.note_num = note_num;
	}

	public String getText_content() {
		return text_content;
	}

	public void setText_content(String text_content) {
		this.text_content = text_content;
	}
	
	public String getRecssaved() {
		return recssaved;
	}

	public void setRecssaved(String recssaved) {
		this.recssaved = recssaved;
	}

	public long getDashboard_type() {
		return dashboard_type;
	}

	public void setDashboard_type(long dashboard_type) {
		this.dashboard_type = dashboard_type;
	}

	public long getDashboard_data() {
		return dashboard_data;
	}

	public void setDashboard_data(long dashboard_data) {
		this.dashboard_data = dashboard_data;
	}

	@Override
	public String toString() {
		return "NewsDetailData [id=" + id + ", user_id=" + user_id + ", title="
				+ title + ", status=" + status + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", name=" + name
				+ ", note_num=" + note_num + ", text_content=" + text_content
				+ ", recssaved=" + recssaved + ", recs=" + recs + ", type="
				+ type + ", newsUrl=" + newsUrl + ", image=" + image
				+ ", text=" + text + ", dashboard_id=" + dashboard_id
				+ ", collectTime=" + collectTime + ", dashboard_type="
				+ dashboard_type + ", dashboard_data=" + dashboard_data
				+ ", photoes=" + photoes + ", content_type=" + content_type
				+ ", video_type=" + video_type + ", video_link=" + video_link
				+ ", user=" + user + ", text_images=" + text_images + "]";
	}
	
}
