package com.lifeix.androidbasecoredemo.view;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import com.lifeix.androidbasecoredemo.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

@EViewGroup(R.layout.view_group_titlewithsub)
public class TitleWithSubtitle extends RelativeLayout {

	public TitleWithSubtitle(Context context) {
		super(context);
	}
	
	public TitleWithSubtitle(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@ViewById
	protected TextView title, subtitle;

	

	public void setTitle(String titleText) {
		title.setText(titleText);
	}

	public void setSubTitle(String subTitleText) {
		subtitle.setText(subTitleText);
	}

	public void setTitles(String titleText, String subTitleText) {
		setTitle(subTitleText);
		setSubTitle(subTitleText);
	}

}
