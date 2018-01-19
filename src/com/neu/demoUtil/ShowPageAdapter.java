package com.neu.demoUtil;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;

public class ShowPageAdapter extends PagerAdapter {
		private List<View>vs = null;
		
		public ShowPageAdapter(List<View>vs){
			this.vs = vs;
		}
		
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return vs.size();
		}
}
