/**
 * 
 */
package com.lifeix.androidbasecoredemo.net.response;

import java.io.Serializable;

/**
 * @author WhatXiao
 *
 * 2014年11月20日
 */
public class Subscribe implements Serializable{
	public String user_id;
    public String user_no;
    public String user_name;
    public String user_path;
    public String status;
    public int sort;
    public String num;
    public String create_time;
    public boolean record_flag;
    public String last_time;
    public String last_title;
	public String aboutme;
    public long ordered_time;
	public long getOrdered_time() {
		return ordered_time;
	}
	public void setOrdered_time(long ordered_time) {
		this.ordered_time = ordered_time;
	}
	public String getAboutme() {
		return aboutme;
	}
	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}
	public String getLast_time() {
		return last_time;
	}
	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}
	public String getLast_title() {
		return last_title;
	}
	public void setLast_title(String last_title) {
		this.last_title = last_title;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_no() {
		return user_no;
	}
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_path() {
		return user_path;
	}
	public void setUser_path(String user_path) {
		this.user_path = user_path;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public boolean isRecord_flag() {
		return record_flag;
	}
	public void setRecord_flag(boolean record_flag) {
		this.record_flag = record_flag;
	}
	@Override
	public String toString() {
		return "Subscribe [user_id=" + user_id + ", user_no=" + user_no
				+ ", user_name=" + user_name + ", user_path=" + user_path
				+ ", status=" + status + ", sort=" + sort + ", num=" + num
				+ ", create_time=" + create_time + ", record_flag="
				+ record_flag + ", last_time=" + last_time + ", last_title="
				+ last_title + ", aboutme=" + aboutme + ", ordered_time="
				+ ordered_time + "]";
	}

}
