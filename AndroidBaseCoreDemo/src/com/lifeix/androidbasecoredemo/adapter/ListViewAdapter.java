package com.lifeix.androidbasecoredemo.adapter;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import com.lifeix.androidbasecoredemo.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

@EBean
public class ListViewAdapter extends BaseAdapter {

	private static final List<String> dataSet = new ArrayList<String>();
	static {
		dataSet.add("Android Annotation");
		dataSet.add("ButterKnife");
		dataSet.add("Dagger");
		dataSet.add("ThinkAndroid");
	}

	@RootContext
	Context context;
	private LayoutInflater inflater;

	public ListViewAdapter(Context context) {
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	public List<String> getDataSet() {
		return dataSet;
	}

	public void setData(List<String> dataSet) {

	}

	@Override
	public int getCount() {
		return dataSet.size();
	}

	@Override
	public Object getItem(int position) {
		return dataSet.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_list_single_textview,
					null);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView
					.findViewById(R.id.txt_item_name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(dataSet.get(position));
		return convertView;
	}

	private class ViewHolder {
		TextView textView;

	}

}
