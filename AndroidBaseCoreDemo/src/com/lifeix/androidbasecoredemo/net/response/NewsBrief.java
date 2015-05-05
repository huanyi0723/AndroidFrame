package com.lifeix.androidbasecoredemo.net.response;

import java.io.Serializable;
import java.util.List;

public class NewsBrief implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String ID = "n_news_id";
	public static final String CATEGORY = "n_category";

	public static final int TYPE_SPECIAL = 1;// 专题
	public static final int TYPE_EXCLUSIVE = 2;// 独家
	public static final int VIDEO_YOUKU = 3; // 优酷
	public static final int VIDEO_SINA = 4; // 新浪

	private int dbid;

	private long id;

	private int category;

	private String image;

	private String title;

	private String text;

	private int label;

	private String label_name;

	private String video_type;

	private int image_type;
	// 是否为置顶新闻 0表示默认，1表示置顶
	private int topType;

	public int getTopType() {
		return topType;
	}

	public void setTopType(int topType) {
		this.topType = topType;
	}

	private List<String> images;// 数据库不能存放数组类型,所以要转化组合为字符串

	private String imgURLs;

	public String getImgURLs() {
		return imgURLs;
	}

	public void setImgURLs(List<String> images) {
		if (images == null)
			return;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < images.size(); i++) {
			if (i != images.size() - 1) {
				sb.append(images.get(i) + ",");
			} else {
				sb.append(images.get(i));
			}
		}
		imgURLs = sb.toString();
	}

	private int note_num;

	public int getNote_num() {
		return note_num;
	}

	public void setNote_num(int note_num) {
		this.note_num = note_num;
	}

	public int getImage_type() {
		return image_type;
	}

	public void setImage_type(int image_type) {
		this.image_type = image_type;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "NewsBrief [dbid=" + dbid + ", id=" + id + ", category="
				+ category + ", image=" + image + ", title=" + title
				+ ", text=" + text + ", label=" + label + ", label_name="
				+ label_name + ", video_type=" + video_type + ", image_type="
				+ image_type + ", topType=" + topType + ", images=" + images
				+ ", imgURLs=" + imgURLs + ", note_num=" + note_num + ", user="
				+ user + "]";
	}

	public String getLabel_name() {
		return label_name;
	}

	public void setLabel_name(String label_name) {
		this.label_name = label_name;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getDbid() {
		return dbid;
	}

	public void setDbid(int dbid) {
		this.dbid = dbid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getLabel() {
		return label;
	}

	public void setLabel(int label) {
		this.label = label;
	}

}
