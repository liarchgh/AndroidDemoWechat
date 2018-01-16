package com.neu.demoUtil;

import java.util.List;

import com.neu.demofirst.R;

import android.app.SharedElementCallback.OnSharedElementsReadyListener;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TalkBaseAdapter extends BaseAdapter {
	private List<OneSentence>sentences;
	private Context inContext;
	
	public TalkBaseAdapter(List<OneSentence>sentences, Context inContext) {
		// TODO Auto-generated constructor stub
		this.sentences = sentences;
		this.inContext = inContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return sentences.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return sentences.get(position);
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
		bindDataAndView(position, convertView);
		return convertView;
		
//		if(convertView == null) {
//			TextView tv = new TextView(inContext);
//			tv.setText("SASAS");
//			convertView = tv;
//		}
//		return convertView;
	}
	private void bindDataAndView(int position, View v) {
		Content ct = (Content)v.getTag();
		OneSentence as = sentences.get(position);
		
		ct.sentence.setText(as.getSentence());
		ct.myIcon.setImageBitmap(as.getMyIcon());
		ct.otherIcon.setImageBitmap(as.getOtherIcon());
		if(as.getMyIcon() == null) {
			ct.toMe.setVisibility(View.INVISIBLE);
		}
		else {
			ct.toMe.setVisibility(View.VISIBLE);
		}
		if(as.getOtherIcon() == null) {
			ct.toOther.setVisibility(View.INVISIBLE);
		}
		else {
			ct.toOther.setVisibility(View.VISIBLE);
		}
	}
	
	private View createView(ViewGroup parent) {
		Content ct = new Content();
		View v = (LinearLayout)LayoutInflater.from(inContext).inflate(R.layout.activity_one_sentence, parent, false);
		ct.sentence = (TextView)v.findViewById(R.id.sentence);
		ct.toMe = (TextView)v.findViewById(R.id.toMe);
		ct.toOther = (TextView)v.findViewById(R.id.toOther);
		ct.otherIcon = ((ImageView)v.findViewById(R.id.otherIcon));
		ct.myIcon = ((ImageView)v.findViewById(R.id.myIcon));
		v.setTag(ct);
		return v;
	}
	
	class Content{
		TextView sentence;
		ImageView myIcon;
		TextView toMe;
		ImageView otherIcon;
		TextView toOther;
	}
}
