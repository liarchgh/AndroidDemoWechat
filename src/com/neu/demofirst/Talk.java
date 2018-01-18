package com.neu.demofirst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.neu.demoUtil.OneSentence;
import com.neu.demoUtil.TalkBaseAdapter;
import com.neu.demoUtil.TalkListBaseAdapter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class Talk extends Activity {
	private ListView stLl;
	private EditText toSend;
	private List<OneSentence>sts = null;
	private Bitmap bm = null;
	public static int Status_LastMessage;
	private Intent it = null;
	private int position;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk);
		
		this.position = getIntent().getIntExtra("position", -1);
		stLl = (ListView)Talk.this.findViewById(R.id.sentencesLl);
		toSend = (EditText)Talk.this.findViewById(R.id.toSend);
		
		Resources rs = Talk.this.getResources();
		bm = new BitmapDrawable(rs.openRawResource(R.drawable.timg)).getBitmap();
		
		sts = new ArrayList<OneSentence>();
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
	public void sendMessage(View v) {
		String toSendString = toSend.getText().toString();
		toSend.setText("");
		sts.add(new OneSentence(null, bm, toSendString));
		((TalkBaseAdapter)stLl.getAdapter()).notifyDataSetChanged();

		it = new Intent();
		it.setAction("TalkMessage");
		it.putExtra("word", toSendString);
		it.putExtra("position", position);
		sendBroadcast(it);
	}

//	@Override
//	public void finish() {
//		// TODO Auto-generated method stub
//		if(it == null) {
//			it = new Intent();
//			it.setClass(Talk.this, TalkList.class);
//			it.putExtra("word", "");
//			Talk.this.setResult(Talk.Status_LastMessage, it);
//		}
//		super.finish();
//	}

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
