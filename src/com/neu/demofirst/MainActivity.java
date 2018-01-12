package com.neu.demofirst;

import java.util.Timer;
import java.util.TimerTask;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Relation;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tv0;
	LinearLayout ll0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ll0 = (LinearLayout)findViewById(R.id.ll0);
//		tv0 = (TextView)findViewById(R.id.tv0);
		
		//动态设置LinearLayout
//		for(int i = 0; i < ll0.getChildCount(); ++i) {
//			tv0 = (TextView)((RelativeLayout)ll0.getChildAt(i)).getChildAt(0);
//			tv0.setText("AAAA");
//		}
//		tv0 = new TextView(MainActivity.this);
//		tv0.setWidth(100);
//		tv0.setHeight(50);
//		tv0.setText("ASASAS");
//		ll0.addView(tv0, 1);

//		//timer+post动态省略号
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
		
//		//handler动态省略号
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
	public void clickToSee(View v) {
		// TODO Auto-generated method stub
//				((TextView)v).setText("XXXX");;
		ObjectAnimator oa = ObjectAnimator.ofFloat(v, "scaleX", 1, 1.5f, 1);
		oa.setDuration(1000);
		oa.start();
//
		ObjectAnimator oa0 = ObjectAnimator.ofFloat(v, "scaleY", 1, 1.5f, 1);
		oa0.setDuration(1000);
		oa0.start();
	}
}
