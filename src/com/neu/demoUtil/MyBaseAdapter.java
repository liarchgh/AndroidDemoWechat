package com.neu.demoUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.neu.demofirst.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter {
	private List<TalkData>talks;
	private Context inContext;

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return talks.size();
	}

	public MyBaseAdapter(List<TalkData>tempTalks, Context inContext) {
		// TODO Auto-generated constructor stub
		this.talks = tempTalks;
		this.inContext = inContext;
	}
	
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return talks.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if(convertView == null) {
			convertView = createView(parent);
		}
		
		BindDataAndView(convertView, position);
		
		return convertView;
	}
	
	private View createView(ViewGroup parent) {
		View v = LayoutInflater.from(inContext).inflate(R.layout.activity_one_talk, parent, false);
		Content ct = new Content();
		ct.name = (TextView)v.findViewById(R.id.userName);
		ct.lastMessage = (TextView)v.findViewById(R.id.lastMessage);
		ct.time = (TextView)v.findViewById(R.id.time);
		ct.num = (TextView)v.findViewById(R.id.num);
		v.setTag(ct);
		return v;
	}
	private void BindDataAndView(View convertView, int position) {
		Content ct = (Content)convertView.getTag();
		TalkData td = talks.get(position);
		
		Calendar.getInstance();

		ct.lastMessage.setText(td.getLastMessage());
		ct.name.setText(td.getUserName());
		ct.time.setText(new SimpleDateFormat("hh:mm:ss").format(new Date(td.getTime())));
		int num = td.getMessageNum();
		String showNum = null;
		if(num >= 100) {
			showNum = "...";
		}
		else {
			showNum = ""+num;
		}
		ct.num.setText(showNum);
	}
	class Content{
		TextView name;
		TextView lastMessage;
		TextView time;
		TextView num;
	}
}
