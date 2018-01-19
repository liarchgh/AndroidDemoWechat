package com.neu.demofirst;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.neu.demoUtil.PageSlide;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

public class Slide extends Activity {
	private PageSlide ps = null;
	private ViewPager vp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide);
		
		vp = (ViewPager)Slide.this.findViewById(R.id.pageSlide);
		List<View>vs = new ArrayList<View>();
		LayoutInflater ift = Slide.this.getLayoutInflater();
		vs.add(ift.inflate(R.layout.activity_one_sentence, null));
		vs.add(ift.inflate(R.layout.login, null));
		vs.add(ift.inflate(R.layout.activity_talk, null));
		ps = new PageSlide(vs);
		vp.setAdapter(ps);
	}
}
