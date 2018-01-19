package com.neu.demofirst;

import java.util.ArrayList;
import java.util.List;

import com.neu.demoUtil.PageSlide;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentShowPage extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_show_page, container, false);

		ViewGroup vg = (ViewGroup)v;
		ViewPager vp = (ViewPager)v.findViewById(R.id.slidePages);
		
		List<View>vs = new ArrayList<View>();
		vs.add(inflater.inflate(R.layout.login, null, false));
		vs.add(inflater.inflate(R.layout.activity_one_sentence, null, false));
		
		PagerAdapter pa = new PageSlide(vs);
		vp.setAdapter(pa);

//		return super.onCreateView(inflater, container, savedInstanceState);
		return v;
	}
}
