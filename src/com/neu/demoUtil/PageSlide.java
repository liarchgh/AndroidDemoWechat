package com.neu.demoUtil;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class PageSlide extends PagerAdapter {
	private List<View>vs = null;

	public PageSlide(List<View> vs) {
		super();
		this.vs = vs;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		container.removeView(vs.get(position));
//		super.destroyItem(container, position, object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// TODO Auto-generated method stub
		View v = vs.get(position);
		container.addView(v);
		return v;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return vs.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

}
