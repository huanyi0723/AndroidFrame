package com.lifeix.androidbasecoredemo.net.response;

import java.io.Serializable;
import java.util.List;

/**
 * 服务器返回的响应数据
 * 
 * @author Jack
 * @version 创建时间：2014-3-13 下午8:04:28
 */
public class DoveboxResponseData implements Serializable {

	private static final long serialVersionUID = 4553678787390496908L;
	public int accountId;
	public String email;
	public String firstName;
	public String lastName;
	public String name;
	public String password;
	public int status;
	public String domainName;
	public String photoPath;
	public long longNO;
	public int avatarsId;
	public boolean online;
	public String mobilePhoto;
	public String spaceName;
	public int accountType;
	public String namePinyin;
	public String objectName;
	public final UserFull user;
	// public final Setting setting;
	public final String android_homepage_image;
	public final int index_image_count;
	public final int follower_num;
	public final int following_num;
	public final int friends_num;
	public final int dashboard_num;
	public final int medal_num;
	// public final List<NYXUser> users;
	public final int number;
	public final int page_num;
	public final int now_page;
	public final int limit;
	public final int user_status;
	// public final Dashboard dashboard;
	// public final Village village;
	// public final List<Dashboard> dashboards;
	// public final long startId;
	public final List<Comment> comments;
	public final Comment comment;
	public final List<Subscribe> subscribes;
	public final Subscribe subscribe;
	// public final List<Notify> notifys;
	// public final List<PinMediaType> pinmediatypes;
	// public final List<PinDashboard> pindashboards;
	// public final List<PinStick> pinsticks;
	// public final List<relationUser> relationUsers;
	// public final List<Oauth> oauths;
	// public final Avatar avatar;
	// public final List<Avatar> avatars;
	public final int relationship;
	public int notify_number;
	public int friend_request_number;
	public int timeline_post_number;
	public int follower_number;
	public String rand_code;
	public String imageFileName;

	public DoveboxResponseData(
			int notify_number,
			int friend_request_number,
			int timeline_post_number,
			int follower_number,
			UserFull user,
			// Setting setting,
			String android_homepage_image,
			int indeximage_count,
			int follower_num,
			int following_num,
			int friends_num,
			int dashboard_num,
			int medal_num,
			// List<NYXUser> users,
			int number,
			int page_num,
			int now_page,
			int limit,
			int user_status,
			List<Comment> comments,
			Comment comment,
			List<Subscribe> subscribes,
			Subscribe subscribe,
			// Dashboard dashboard,
			// Village village,
			// List<Dashboard> dashboards,
			// long startId,

			// List<Notify> notifys,
			// List<PinMediaType> pinmediatypes,
			// List<PinDashboard> pindashboards,
			// List<PinStick> pinsticks,
			// List<relationUser> relationUsers,
			// List<Oauth> oauths,
			// List<FilterTime> times,
			// List<TypeDashboard> types,
			// List<AccountDashboard> accounts,
			// Avatar avatar,
			// List<Avatar> avatars,
			int relationship, int accountId, String email, String firstName,
			String lastName, String name, String password, int status,
			String domainName, String photoPath, long longNO, int avatarsId,
			boolean online, String mobilePhoto, String spaceName,
			int accountType, String namePinyin, String objectName,
			String rand_code, String imageFileName) {

		this.notify_number = notify_number;
		this.friend_request_number = friend_request_number;
		this.timeline_post_number = timeline_post_number;
		this.follower_number = follower_number;
		this.user = user;
		// this.setting = setting;
		this.android_homepage_image = android_homepage_image;
		this.index_image_count = indeximage_count;
		this.follower_num = follower_num;
		this.following_num = following_num;
		this.friends_num = friends_num;
		this.dashboard_num = dashboard_num;
		this.medal_num = medal_num;
		// this.users = users;
		this.number = number;
		this.page_num = page_num;
		this.now_page = now_page;
		this.limit = limit;
		this.user_status = user_status;
		this.notify_number = notify_number;
		this.follower_number = follower_number;
		// this.dashboard = dashboard;
		// this.village = village;
		// this.dashboards = dashboards;
		// this.startId = startId;
		this.comments = comments;
		this.comment = comment;
		this.subscribes = subscribes;
		this.subscribe = subscribe;
		// this.notifys = notifys;
		// this.pinmediatypes = pinmediatypes;
		// this.pindashboards = pindashboards;
		// this.pinsticks = pinsticks;
		// this.times = times;
		// this.types = types;
		// this.relationUsers=relationUsers;
		// this.oauths=oauths;
		// this.avatar = avatar;
		// this.avatars = avatars;
		this.relationship = relationship;
		// this.accounts = accounts;
		this.accountId = accountId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.name = name;
		this.password = password;
		this.status = status;
		this.domainName = domainName;
		this.photoPath = photoPath;
		this.longNO = longNO;
		this.avatarsId = avatarsId;
		this.online = online;
		this.mobilePhoto = mobilePhoto;
		this.spaceName = spaceName;
		this.accountType = accountType;
		this.namePinyin = namePinyin;
		this.objectName = objectName;
		this.rand_code = rand_code;
		this.imageFileName = imageFileName;
	}

	@Override
	public String toString() {
		return "DoveboxResponseData [accountId=" + accountId + ", email="
				+ email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", name=" + name + ", password=" + password + ", status="
				+ status + ", domainName=" + domainName + ", photoPath="
				+ photoPath + ", longNO=" + longNO + ", avatarsId=" + avatarsId
				+ ", online=" + online + ", mobilePhoto=" + mobilePhoto
				+ ", spaceName=" + spaceName + ", accountType=" + accountType
				+ ", namePinyin=" + namePinyin + ", objectName=" + objectName
				+ ", user=" + user + ", android_homepage_image="
				+ android_homepage_image + ", index_image_count="
				+ index_image_count + ", follower_num=" + follower_num
				+ ", following_num=" + following_num + ", friends_num="
				+ friends_num + ", dashboard_num=" + dashboard_num
				+ ", medal_num=" + medal_num + ", number=" + number
				+ ", page_num=" + page_num + ", now_page=" + now_page
				+ ", limit=" + limit + ", user_status=" + user_status
				+ ", comments=" + comments + ", comment=" + comment
				+ ", subscribes=" + subscribes + ", subscribe=" + subscribe
				+ ", relationship=" + relationship + ", notify_number="
				+ notify_number + ", friend_request_number="
				+ friend_request_number + ", timeline_post_number="
				+ timeline_post_number + ", follower_number=" + follower_number
				+ ", rand_code=" + rand_code + ", imageFileName="
				+ imageFileName + "]";
	}

}