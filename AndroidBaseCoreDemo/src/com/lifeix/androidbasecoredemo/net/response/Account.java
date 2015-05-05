package com.lifeix.androidbasecoredemo.net.response;

import java.io.Serializable;


/**
 * 用户信息的voo类
 * @author Jack  
 * @version 创建时间：2014-3-19  上午10:46:30
 * 
 * "account": {
                    "account_id": 582162,
                    "name": "大风车",
                    "photo_path": "21/MjAxMzA2MTMxNTIxMjlfMTI0LjIwNy4xMDQuMThfMjc3NTEw.jpg",
                    "long_no": 1548194,
                    "online": false,
                    "account_type": 0,
                    "relationship": 0,
                    "name_pinyin": "dafengche",
                    "block": 0
                }
 */
public class Account implements Serializable{

	public long account_id;
	public String name;
	public String photoPath;
	public int long_no;
	public boolean online;
	public int account_type;
	public int relationship;
	public String name_pinyin;
	public int block;
	
	
	public Account() {
		super();
	}

	public Account(long account_id, String name, String photo_path, int long_no,
			boolean online, int account_type, int relationship,
			String name_pinyin, int block) {
		super();
		this.account_id = account_id;
		this.name = name;
		this.photoPath = photo_path;
		this.long_no = long_no;
		this.online = online;
		this.account_type = account_type;
		this.relationship = relationship;
		this.name_pinyin = name_pinyin;
		this.block = block;
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", name=" + name
				+ ", photo_path=" + photoPath + ", long_no=" + long_no
				+ ", online=" + online + ", account_type=" + account_type
				+ ", relationship=" + relationship + ", name_pinyin="
				+ name_pinyin + ", block=" + block + "]";
	}
}
