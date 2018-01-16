package com.neu.demofirst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.neu.demoUtil.OneSentence;
import com.neu.demoUtil.TalkBaseAdapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class Talk extends Activity {
	private ListView stLl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk);
		
		stLl = (ListView)Talk.this.findViewById(R.id.sentencesLl);
		
		
		Resources rs = Talk.this.getResources();
		Bitmap bm = new BitmapDrawable(rs.openRawResource(R.drawable.timg)).getBitmap();
		
		List<OneSentence>sts = new ArrayList<OneSentence>();
		Random rd = new Random();
		OneSentence tempSt;
		Bitmap myIcon = bm,
				otherIcon = bm;
		for(int i = 0; i < 100; ++i) {
			tempSt = new OneSentence();
			if(rd.nextBoolean()) {
				tempSt.setMyIcon(myIcon);
			}
			else {
				tempSt.setOtherIcon(otherIcon);
			}
			tempSt.setSentence(i+" fjklsd fjkds jkfjk dsjkf jkdsj fjdsk jfksdaj lkjfkdsj klfjlkdsaj lkfjsdakl jfkldsj klfjdskl fjflkds jkfjds jfdsj fjdsk jfkdsj lkfjdslk jfklds sdf");
			sts.add(tempSt);
		}
		
		stLl.setAdapter(new TalkBaseAdapter(sts, Talk.this));
	}
	public void jump2Main(View v) {
		Intent it = new Intent();
//		Intent it = getIntent();
		it.setClass(Talk.this, TalkList.class);
		it.putExtra("word", "AAAAAA");
		Log.i("TalkLive", "putExtra");
		Talk.this.setResult(0, it);
//		Talk.this.startActivity(it);
	}

//	public void clickToSee(View v) {
//		// TODO Auto-generated method stub
////				((TextView)v).setText("XXXX");;
//	}

//	@Override
//	protected void onStart() {
//		// TODO Auto-generated method stub
//		super.onStart();
//		Log.i("TalkLive", "start");
//	}
//	@Override
//	protected void onRestart() {
//		// TODO Auto-generated method stub
//		super.onRestart();
//		Log.i("TalkLive", "restart");
//	}
//	@Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//		super.onResume();
//		Log.i("TalkLive", "resume");
//	}
//	@Override
//	protected void onPause() {
//		// TODO Auto-generated method stub
//		super.onPause();
//		Log.i("TalkLive", "pause");
//	}
//	@Override
//	protected void onStop() {
//		// TODO Auto-generated method stub
//		super.onStop();
//		Log.i("TalkLive", "stop");
//	}
//	@Override
//	protected void onDestroy() {
//		// TODO Auto-generated method stub
//		super.onDestroy();
//		Log.i("TalkLive", "destory");
//	}
}
