package com.neu.demofirst;

import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.Attributes;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.drm.DrmStore.RightsStatus;
import android.media.midi.MidiDeviceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract.CommonDataKinds.Relation;
import android.text.Layout.Alignment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {
	private EditText userName;
	private EditText passWord;
	private LinearLayout userNameLl;
	private int finishSum = 0;

	//分发事件
//	@Override
//	public boolean dispatchTouchEvent(MotionEvent ev) {
//		// TODO Auto-generated method stub
//		Dialog dl = new Dialog(Login.this);
//		dl.setTitle("touch");
//		dl.show();
////		return super.dispatchTouchEvent(ev);
//		return true;
//	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		userName = (EditText)findViewById(R.id.userName);
		passWord = (EditText)findViewById(R.id.passWord);
		userNameLl = (LinearLayout)findViewById(R.id.userNameLl);
		
		SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
		Editor etSp = sp.edit();
		etSp.putString("lisu", "lisu");
		etSp.apply();
	}
	public void login(View v) {
		SharedPreferences sp = getSharedPreferences("login", MODE_PRIVATE);
		if(sp.getString(userName.getText().toString(), "\t").equals(passWord.getText().toString())) {
			Intent it = new Intent();
			it.setClass(Login.this, TalkList.class);
			it.putExtra("userName", userName.getText().toString());
			Login.this.startActivity(it);
		}
		else {
//			Dialog dl = new Dialog(Login.this);
//			dl.setTitle(userName.getText().toString() + " " + sp.getString(userName.getText().toString(), ""));
//			dl.show();
			
			Toast.makeText(Login.this.getApplicationContext(),
					"Password or username is wrong!\nPlease check and try again.",
					Toast.LENGTH_SHORT).show();
		}
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
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		if(event.getKeyCode() == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_UP) {
			clickFinish();
			Log.i("finishSum", "finishSum:"+finishSum);
		}
		return true;
//		return super.dispatchKeyEvent(event);
	}
	private void clickFinish() {
		++finishSum;
		if(finishSum >= 2) {
			Login.this.finish();
		}

		Timer tm = new Timer(true);
		tm.schedule(new TimerTask() {
			
			@Override
			public void run() {
				--finishSum;
				Log.i("finishSum", "finishSum:"+finishSum);
			}
		}, 3000);
	}
}
