package com.lifeix.androidbasecoredemo.net.response;
import java.io.Serializable;
/**
 * @author lifeix
 * 
 */
public class User implements Serializable {
	
	public static final String ACCOUNT_ID = "u_account_id";
	
	public static final String OWNER_ID = "u_owner_id";
	
	private static final long serialVersionUID = 7176004080589850192L;
	private boolean flag = false;
	
	private int id;
	/**
	 * 用户ID
	 */
	public long account_id;
	/**
	 * 姓名
	 */
	public String name;
	/**
	 * 头像图片路径
	 */
	public String photo_path;
	public String photoPath;
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	/**
	 * 龙号
	 */
	public long long_no;
	/**
	 * 是否在线
	 */
	public boolean online;
	/**
	 * 0 普通用户 10 神秘人 11 酒店帐号 12 评委 21 机构
	 */
	public int account_type;
	/**
	 * 0 none 1 follow 2 friend
	 */
	public int relationship;
	public boolean delete;
	public String name_pinyin;
	public char name_first_letter = ',';
	public boolean isclicked = false;
	public long owner_id; //所属用户id
	
	public User() {
	}
	
	public User(long account_id, String name, String photo_path, long long_no, boolean online,
			int account_type, int relationship, boolean delete, String name_pinyin) {
		this.account_id = account_id;
		this.name = name;
		this.photo_path = photo_path;
		this.long_no = long_no;
		this.online = online;
		this.account_type = account_type;
		this.relationship = relationship;
		this.delete = delete;
		this.name_pinyin = name_pinyin;
	}
	@Override
	public boolean equals(Object obj) {
		if (null != obj && obj instanceof User) {
			User user = (User) obj;
			return user.account_id == account_id;
		}
		return false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto_path() {
		return photo_path;
	}

	public void setPhoto_path(String photo_path) {
		this.photo_path = photo_path;
	}

	public long getLong_no() {
		return long_no;
	}

	public void setLong_no(long long_no) {
		this.long_no = long_no;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}

	public int getRelationship() {
		return relationship;
	}

	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}

	public boolean isDelete() {
		return delete;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public String getName_pinyin() {
		return name_pinyin;
	}

	public void setName_pinyin(String name_pinyin) {
		this.name_pinyin = name_pinyin;
	}
	
	public long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(long owner_id) {
		this.owner_id = owner_id;
	}

	@Override
	public String toString() {
		return "User [flag=" + flag + ", id=" + id + ", account_id="
				+ account_id + ", name=" + name + ", photo_path=" + photo_path
				+ ", long_no=" + long_no + ", online=" + online
				+ ", account_type=" + account_type + ", relationship="
				+ relationship + ", delete=" + delete + ", name_pinyin="
				+ name_pinyin + ", name_first_letter=" + name_first_letter
				+ ", isclicked=" + isclicked + ", owner_id=" + owner_id + "]";
	}

}
