package com.lifeix.androidbasecoredemo.activity;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FromHtml;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.SystemService;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.ColorRes;
import org.androidannotations.annotations.res.DimensionPixelOffsetRes;
import org.androidannotations.annotations.res.DimensionPixelSizeRes;
import org.androidannotations.annotations.res.DimensionRes;
import org.androidannotations.annotations.res.HtmlRes;
import org.androidannotations.annotations.res.StringRes;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.common.eventbus.Subscribe;
import com.lifeix.androidbasecore.BaseFragmentActivity;
import com.lifeix.androidbasecore.utils.ToastUtils;
import com.lifeix.androidbasecore.utils.logger.Logger;
import com.lifeix.androidbasecoredemo.DemoApplication;
import com.lifeix.androidbasecoredemo.R;
import com.lifeix.androidbasecoredemo.bean.User;
import com.lifeix.androidbasecoredemo.bean.User_;
import com.lifeix.androidbasecoredemo.events.HitEvent;
import com.lifeix.androidbasecoredemo.fragment.SimpleFragment;
import com.lifeix.androidbasecoredemo.fragment.SimpleFragment_;
import com.lifeix.androidbasecoredemo.service.ReptileService_;
import com.lifeix.androidbasecoredemo.utils.Constants;
import com.lifeix.androidbasecoredemo.view.*;

// 注解@EActivity使用时，若未在AndroidManifest.xml文件中注册该activity或者未指定布局文件时，会再编译时警告
@EActivity(R.layout.activity_simple)
@OptionsMenu(R.menu.main)
public class SimpleActivity extends BaseFragmentActivity {

	@App
	/* protected */DemoApplication application; // 注入Application，无需再写赋值代码，可直接使用

	@NonConfigurationInstance
	@SystemService
	NotificationManager manager; // 注入系统服务，无需再写赋值代码，可直接使用。
	
	@StringRes
	String app_name; //注入string.xml资源，变量名与资源名称一致，无需指定资源id
	@StringRes(R.string.app_name)
	String title; //注入string.xml资源，变量名与资源名称不一致，须指定资源id

	@ColorRes(R.color.backgroundColor)
	int someColor; //注入colors.xml资源
	@ColorRes
	int backgroundColor;

	@DimensionRes(R.dimen.fontsize)
	float fontSizeDimension; //注入dimens.xml资源
	@DimensionRes
	float fontsize;

	@DimensionPixelOffsetRes(R.dimen.fontsizePix)
	int fontSizeDimensionPix; //注入dimens.xml资源
	@DimensionPixelOffsetRes
	int fontsizePix;

	@DimensionPixelSizeRes(R.dimen.fontsizePix)
	int fontSizeDimensionPix2; //注入dimens.xml资源
	@DimensionPixelSizeRes
	int fontsizePix2;

	@HtmlRes(R.string.content_html)
	Spanned htmlCotent; //注入string.xml资源，支持html格式

	@ViewById(R.id.txt_html_content)
	@FromHtml(R.string.content_html)
	TextView textView;  //注入view视图和注入string.xml资源，支持html格式

	// @BooleanRes
	// @ColorStateListRes
	// @DrawableRes
	// @IntArrayRes
	// @IntegerRes
	// @LayoutRes
	// @MovieRes
	// @TextRes
	// @TextArrayRes
	// @StringArrayRes

	@ViewById(R.id.btn_custom)
	CustomButton button; //注入页面控件，指定控件id
	@ViewById
	CustomButton btn_custom; //注入页面控件，变量名与控件id一致
	
	@OptionsMenuItem(R.id.action_settings)
	MenuItem menuSettings;

	/************************ Extra ***********************/
	@Extra("comeFrom") //注入页面跳转传递的参数
	String comeFromParam;
	@Extra
	String comeFrom;

	@Bean
	User user;

	private void initBean() {
		user = User_.getInstance_(this);
	}

	private void initCustomView() {
		CustomButton button = CustomButton_.build(this);
		TitleWithSubtitle titleWithSubtitle = TitleWithSubtitle_.build(this);
	}

	private void startService() {
		ReptileService_.intent(this).start();
	}

	private void stopService() {
		ReptileService_.intent(this).stop();
	}

	private void registerBroadcastReceiver() {
		// 与原生api一致
	}

	//注册广播监听，当有action=Constants.ACTION.ACTION_HIT的广播发出时，该方法会被调用
	// {Constants.ACTION.ACTION_HIT, Constants.ACTION.ACTION_NET_DISABLED}
	@Receiver(actions = Constants.ACTION.ACTION_HIT)
	protected void onBroadcastReceiverAction_Click(Intent intent) {
		Logger.d(String.format("on hit:%s", intent.getAction()));
	}

	/******************************************************/
	@Click(R.id.btn_custom) //为id=R.id.btn_custom的控件注册点击事件
	void customClick() {
		ToastUtils.show(this, "customClick");
		StringRequestActivity_.intent(this).start();
	}
	
	@Click(R.id.btn_to_download)
	void toDownlaod(){
		NetSimpleActivity_.intent(this).start();
	}

	@Click(R.id.btn_to_sub)
	void toSub() {
		SubActivity_.intent(this)
				.startForResult(Constants.REQUEST_CODE_GET_SUM);
	}

	@Click
	void vg_title() { //为id=R.id.vg_title的控件注册点击事件
		ToastUtils.show(this, "vg_title");
	}
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		Logger.d(String.format("function onCreate invoked."));
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Logger.d(String.format("function onResume invoked."));
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Logger.d(String.format("function onPause invoked."));
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		application.getEventBus().unregister(this); //解除当前实例的事件订阅者身份
	}

	@AfterInject //在页面注入完毕后调用该方法
	void afterInject() {
		Logger.d(String.format("function afterInject invoked."));
	}

	@AfterViews //在视图初始化完毕后调用该方法
	void afterViews() {
		Logger.d(String.format("function afterViews invoked."));
		initFragment();
		startService();
		application.getEventBus().register(this); //当前实例注册为guava事件总线的一个事件订阅者
		try{
			int i = 3 / 0;
		}catch(Throwable e){
			Logger.e(e, "test");
		}
	}

	@AfterExtras //在获取完毕上一个页面传递过来的参数之后，调用该方法
	void afterExtras() {
		Logger.d(String.format("function afterExtras invoked."));
		Logger.e("param|comeFrom:%s, comeFromParam:%s", comeFrom, comeFromParam);
	}

	private void initFragment() {
		SimpleFragment fragment = SimpleFragment_.builder().title("SubPage")
				.msg("Hello,World!").build();
		getSupportFragmentManager().beginTransaction()
				.add(R.id.fl_sub_page, fragment).commit();
	}

	@OptionsItem(R.id.action_settings) //注册菜单项点击事件
	void onMenuSettings() {
		Logger.d(String.format("function onMenuSettings invoked."));
	}
	
	@OnActivityResult(Constants.REQUEST_CODE_GET_SUM) //在onActivityResult方法中调用
	void onActivityResult(int resultCode, Intent data) {
		if(RESULT_OK != resultCode){
			return;
		}
		if(data == null){
			return;
		}
		int resultNumber = data.getIntExtra("resultNumber", -1);
		Logger.d(String.format("resultNumber:%s", resultNumber));
	}

	@OnActivityResult(Constants.REQUEST_CODE_GET_SUM)  //在onActivityResult方法中调用
	void onActivityResultDetails(
			@org.androidannotations.annotations.OnActivityResult.Extra int resultNumber) {
		Logger.d(String.format("resultNumber:%s", resultNumber));
	}
	
	@Subscribe //guava中EventBus，有@Subscribe注解的方法会在事件分发器中被调用，该方法的参数即为事件总线post出来的事件
	public void onHitEvent(HitEvent event){
		Logger.d(String.format("event:%s", event.toString()));
	}
}
