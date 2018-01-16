package com.neu.demofirst;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.neu.demoUtil.MyBaseAdapter;
import com.neu.demoUtil.TalkData;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class TalkList extends Activity {
	private TextView tv1;
	private LinearLayout ll0;
	private RelativeLayout rl0;
	private ListView talksLV;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("live", "create");
		setContentView(R.layout.activity_talk_list);
		
		ll0 = (LinearLayout)findViewById(R.id.ll0);
		rl0 = (RelativeLayout)findViewById(R.id.rl0);
		talksLV = (ListView)findViewById(R.id.talksLV);
		
		Random rd = new Random();
		List<TalkData> talks = new ArrayList<TalkData>();
		for(int i = 0; i < 100; ++i) {
			talks.add(new TalkData(null, "Name:"+i, "M:"+i,
//					rd.nextInt()%120, Calendar.getInstance().getTimeInMillis()));
					Math.abs(rd.nextInt()%120), rd.nextLong()));
		}
		
		MyBaseAdapter mba = new MyBaseAdapter(talks, TalkList.this);
		
		talksLV.setAdapter(mba);

		//��̬����LinearLayout
//		for(int i = 0; i < ll0.getChildCount(); ++i) {
//			tv0 = (TextView)((RelativeLayout)ll0.getChildAt(i)).getChildAt(0);
//			tv0.setText("AAAA");
//		}
//		tv0 = new TextView(MainActivity.this);
//		tv0.setWidth(100);
//		tv0.setHeight(50);
//		tv0.setText("ASASAS");
//		ll0.addView(tv0, 1);

//		//timer+post��̬ʡ�Ժ�
//		Timer tm = new Timer();
//		tm.schedule(new TimerTask() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				String now = tv0.getText().toString();aaaaaaa
//				if(now.length() >= 3) {
//					now = "";
//				}
//				final String res = now + ".";
//				tv0.post(new Runnable() {
//					
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						tv0.setText(res);
//					}
//				});
//			}
//		}, 1000);
		
//		//handler��̬ʡ�Ժ�
//		final Handler hdl = new Handler();
//		Runnable mR =  new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//
//				hdl.postDelayed(this, 1000);
//				String now = tv0.getText().toString();
//				if(now.length() >= 3) {
//					now = "";
//				}
//				final String res = now + ".";
//				tv0.setText(res);
//			}
//		};
//		
//		hdl.post(mR);
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				Message msg = hdl.obtainMessage();
//				msg.arg1 = 1;
//				while(true){
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					hdl.sendMessage(msg);
//				}
//			}
//		}).start();
//	}
//
//	Handler hdl = new Handler(Looper.getMainLooper()){
//			public void handleMessage(android.os.Message msg) {
//				if(tv0.getText().length() >= 3) {
//					tv0.setText("");
//				}
//				tv0.append(".");
//		}
//	};
		
//		tv0.setOnTouchListener(new OnTouchListener() {
//			
//			@SuppressLint("ClickableViewAccessibility")
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				// TODO Auto-generated method stub
//				switch(event.getAction()) {
//				case MotionEvent.ACTION_DOWN:
//					tv0.setText("AAAA");
//					break;
//				case MotionEvent.ACTION_UP:
//					tv0.setText("SSSS");
//					break;
//				}
//				return true;
//			}
//		});
		
//		Log.e("test", tv0.getMaxWidth()+"");
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i("live", "start");
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i("live", "restart");
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("live", "resume");
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("live", "pause");
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("live", "stop");
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("live", "destory");
	}
	public void clickToSee(View v) {
		// TODO Auto-generated method stub
//				((TextView)v).setText("XXXX");;
	}
	public void jump2Login(View v) {
		Intent it = new Intent();
		it.setClass(TalkList.this, Login.class);
		TalkList.this.startActivity(it);
	}
	public void jump2Talk(View v) {
		ObjectAnimator oa = ObjectAnimator.ofFloat(v, "scaleX", 1, 1.5f, 1);
		oa.setDuration(618);
		oa.start();
//
		ObjectAnimator oa0 = ObjectAnimator.ofFloat(v, "scaleY", 1, 1.5f, 1);
		oa0.setDuration(618);
		oa0.start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(618);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Intent it = new Intent();
				it.setClass(TalkList.this, Talk.class);
				TalkList.this.startActivityForResult(it, 0);
			}
		}).start();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.i("TlLive", "getExtras");
		tv1.setText(data.getExtras().getString("word"));
//		tv1.setText("SSSSS");
	}
}
