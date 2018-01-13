package com.neu.demofirst;

import java.util.Timer;
import java.util.TimerTask;
import java.util.jar.Attributes;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnTouchModeChangeListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Login extends Activity {
	TextView tv0;
	TextView tv2;
	TextView tv3;
	LinearLayout ll0;
	RelativeLayout rl0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}
	public void login(View v) {
		Intent it = new Intent();
		it.setClass(Login.this, TalkList.class);
		it.putExtra("username", "ssss");
		Login.this.startActivity(it);
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
