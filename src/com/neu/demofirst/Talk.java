package com.neu.demofirst;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Talk extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk);
	}
	public void jump2Main(View v) {
		Intent it = new Intent();
//		Intent it = getIntent();
		it.setClass(Talk.this, TalkList.class);
		it.putExtra("word", "AAAAAA");
		Talk.this.setResult(0, it);
//		Talk.this.startActivity(it);
	}
}
