package com.lifeix.androidbasecoredemo.bean;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.util.Log;

import com.lifeix.androidbasecoredemo.MainActivity;

// 注意：在单例类里面不可以注入view和事件绑定
// 因为单例的生命周期比Activity和Service的要长，以免发生内存泄露
@EBean
/* (scope = Scope.Singleton) */
public class User {

	@RootContext
	Context context;

	// Only injected if the root context is an activity
	@RootContext
	Activity activity;

	// Only injected if the root context is a service
	@RootContext
	Service service;

	// Only injected if the root context is an instance of MyActivity
	@RootContext
	MainActivity myActivity;

	private long id;
	private String name;
	private int gender;
	private int age;
	
	public User() {
		Log.d("Bean", String.format("bean{%s} init.", getClass().getSimpleName()));
	}

	public void login() {

	}

	public void sayHello() {

	}

	public void run() {

	}

	@Override
	public String toString() {
		return "User [context=" + context + ", id=" + id + ", name=" + name
				+ ", gender=" + gender + ", age=" + age + "]";
	}

}
