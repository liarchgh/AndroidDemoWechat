package com.neu.demofirst;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.neu.demoUtil.BitmapUtil;
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
	private long userID;
	private String path = null;
	private TalkBaseAdapter tba = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk);
	
		this.userID = getIntent().getLongExtra("userID", -1);
		this.path = getIntent().getStringExtra("path")+File.separator+userID;
		stLl = (ListView)Talk.this.findViewById(R.id.sentencesLl);
		toSend = (EditText)Talk.this.findViewById(R.id.toSend);
	
		Resources rs = Talk.this.getResources();
		bm = new BitmapDrawable(rs.openRawResource(R.drawable.timg)).getBitmap();
	
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Log.i("path", path);
				File fl = new File(path);
				if(fl.exists()) {
					try {
						FileInputStream fis = new FileInputStream(fl);
						ObjectInputStream ois = new ObjectInputStream(fis);
						Object temp = ois.readObject();
						if(temp instanceof List<?>) {
							Log.i("talk adapter", "instance success");
							sts = (List<OneSentence>)temp;
						}
						else {
							sts = new ArrayList<OneSentence>();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				else {
					sts = new ArrayList<OneSentence>();
//					Random rd = new Random();
//					OneSentence tempSt;
//					Bitmap myIcon = bm,
//							otherIcon = bm;
//					for(int i = 0; i < 10; ++i) {
//						tempSt = new OneSentence();
//						if(rd.nextBoolean()) {
//							tempSt.setMyIcon(myIcon);
//						}
//						else {
//							tempSt.setOtherIcon(otherIcon);
//						}
//						tempSt.setSentence(i+" fjklsd fjkds jkfjk dsjkf jkdsj fjdsk jfksdaj lkjfkdsj klfjlkdsaj lkfjsdakl jfkldsj klfjdskl fjflkds jkfjds jfdsj fjdsk jfkdsj lkfjdslk jfklds sdf");
//						sts.add(tempSt);
//					}
				}
				tba = new TalkBaseAdapter(sts, Talk.this);
				stLl.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Log.i("talk adapter", "start");
						stLl.setAdapter(tba);
						Log.i("talk adapter", "success");
					}
				});
			}
		}).start();
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Log.i("send", "file start");
					FileOutputStream fis = new FileOutputStream(path);
					ObjectOutputStream ois = new ObjectOutputStream(fis);
					Log.i("send", "write");
					ois.writeObject(sts);
					ois.close();
					Log.i("send", "write over");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		super.finish();
	}
	
	public void sendMessage(View v) {
		Log.i("send", "start");
		String toSendString = toSend.getText().toString();
		toSend.setText("");
		Log.i("send", "prepare to add");
		byte[] tempBA = BitmapUtil.toByteArray(bm);
		Log.i("send", "add");
		OneSentence aos = new OneSentence(new byte[0], tempBA, toSendString);
		Log.i("send", "add1");
		sts.add(aos);
		Log.i("send", "add2");
//		((TalkBaseAdapter)stLl.getAdapter()).notifyDataSetChanged();
		tba.notifyDataSetChanged();
		Log.i("send", "add over");

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Log.i("send", "file start");
					FileOutputStream fis = new FileOutputStream(path);
					ObjectOutputStream ois = new ObjectOutputStream(fis);
					Log.i("send", "write");
					ois.writeObject(sts);
					ois.close();
					Log.i("send", "write over");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		it = new Intent();
		it.setAction("TalkMessage");
		it.putExtra("word", toSendString);
		it.putExtra("userID", userID);
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
