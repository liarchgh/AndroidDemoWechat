package com.neu.demofirst;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class InAPP extends Activity {
	private Fragment showPage = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_in_app);

		jump2Contacts();
	}
	
	public void jump2Talks(View v) {jump2Talks();}

	public void jump2Talks() {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.showPage, new FragmentShowPage());
		ft.commit();
	}
	
	public void jump2Contacts(View v) {
		jump2Contacts();
	}

	public void jump2Contacts() {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.showPage, new TestFragment());
		ft.commit();
	}
}
