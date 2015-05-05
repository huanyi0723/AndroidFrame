package com.lifeix.androidbasecoredemo.view;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.res.StringRes;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.lifeix.androidbasecoredemo.DemoApplication;
import com.lifeix.androidbasecoredemo.R;

@EView
public class CustomButton extends Button {

	@App
	DemoApplication application;

	@StringRes(R.string.app_name)
	String defaultLabel;

	public CustomButton(Context context) {
		super(context);
	}

	public CustomButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

}
