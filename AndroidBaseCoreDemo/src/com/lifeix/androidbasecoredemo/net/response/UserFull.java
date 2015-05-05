package com.lifeix.androidbasecoredemo.net.response;

import java.util.Map.Entry;
import java.util.WeakHashMap;

/**
 * @author lifeix
 * 
 */
public class UserFull extends User {
	private static final long serialVersionUID = -1956032090269692769L;
	/**
	 * 用户邮箱
	 */
	public String email;
	/**
	 * 手机号码
	 */
	public String mobile_phone;
	/**
	 * 名
	 */
	public String first_name;
	/**
	 * 姓
	 */
	public String last_name;
	/**
	 * 密码
	 */
	public String password;
	/**
	 * 1 黑名单用户 2.未激活用户 4.正常用户
	 */
	public int status;
	/**
	 * 个人空间域名
	 */
	public String domain_name;
	/**
	 * 头像图片id
	 */
	public int avatars_id;
	/**
	 * 手机头像
	 */
	public String mobile_photo;
	/**
	 * 个性空间
	 */
	public String space_name;

	public int follow;

	/** 设计师头衔 **/
	public int editor_id;

	public static boolean needJumpToMe = false;

	public UserFull() {
		super();
	}

	public UserFull(long account_id, String name, String photo_path,
			long long_no, boolean online, int account_type, int relationship,
			boolean delete, String name_pinyin, String email,
			String mobile_phone, String first_name, String last_name,
			String password, int status, String domain_name, int avatars_id,
			String mobile_photo, String space_name, int follow, int editor_id) {
		super(account_id, name, photo_path, long_no, online, account_type,
				relationship, delete, name_pinyin);
		this.follow = follow;
		this.email = email;
		this.mobile_phone = mobile_phone;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.status = status;
		this.domain_name = domain_name;
		this.avatars_id = avatars_id;
		this.mobile_photo = mobile_photo;
		this.space_name = space_name;
		this.editor_id = editor_id;
	}

	public synchronized static void setNeedJump2Me(boolean needJump2Me) {
		UserFull.needJumpToMe = needJump2Me;
	}

	@Override
	public String toString() {
		return "UserFull [email=" + email + ", mobile_phone=" + mobile_phone
				+ ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + ", status=" + status
				+ ", domain_name=" + domain_name + ", avatars_id=" + avatars_id
				+ ", mobile_photo=" + mobile_photo + ", space_name="
				+ space_name + ", follow=" + follow + ", editor_id="
				+ editor_id + "]";
	}
	
}