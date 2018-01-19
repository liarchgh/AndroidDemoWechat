package com.neu.demofirst;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;

import com.neu.demoUtil.OneTalkViewContent;
import com.neu.demoUtil.TalkData;
import com.neu.demoUtil.TalkListBaseAdapter;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.renderscript.ScriptGroup.Input;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TalkList extends Activity {
	private ListView talksLV;
	private List<TalkData> talks = null;
	private TalkListBaseAdapter mba;
//	private String path =  Environment.getExternalStorageDirectory().getPath()+File.separator+"talklist.ls";
	private String path = null;
	private String srcPath = null;

	//处理服务信息
//	private MyService.MyBinder mBinder;
//	private MyService mService;
//	private ServiceConnection mServiceConnection = new ServiceConnection() { 
//		@Override
//		public void onServiceConnected(ComponentName name, IBinder service) {
//			// TODO Auto-generated method stub
////			Log.i("Service live", "connect");
//			mBinder = (MyService.MyBinder) service;
//			mService = mBinder.getService();
//			
////			updateTextView();
//		}
//
//		@Override
//		public void onServiceDisconnected(ComponentName name) {
//			// TODO Auto-generated method stub
////			Log.i("Service live", "disconnect");
////			mIsBind = false;
//		}
//		
//	};

	private BroadcastReceiver bcReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			long userID = intent.getLongExtra("userID", -1);
			String retMsg = intent.getExtras().getString("word");
//			Log.i("return message", retMsg);
			if(retMsg.length() > 0) {
				for(Iterator<TalkData>it = talks.iterator(); it.hasNext(); ) {
					TalkData temp = it.next();
					if(temp.getUserId() == userID) {
						temp.setLastMessage(retMsg);
						break;
					}
				}
				mba.notifyDataSetChanged();
			}
		}
	};

		
//	//用于接收线程发来的Message
//	Handler hd = new Handler() {
//		@Override
//		public void handleMessage(Message msg) {
//			// TODO Auto-generated method stub
//			super.handleMessage(msg);
//			Dialog dl = new Dialog(TalkList.this);
//			dl.setTitle(msg.arg1 + "");
//			dl.show();
//		}
//	};
	
	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk_list);

//		//启动服务
//		Intent it0 = new Intent();
//		it0.setClass(TalkList.this, MyService.class);
////		bindService(it0, mServiceConnection, Context.BIND_AUTO_CREATE);
//		startService(it0);
		
		init();
		setTalkList();
	}
		

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

//	@Override
//	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//		// TODO Auto-generated method stub
//		super.onActivityResult(requestCode, resultCode, data);
//		String retMsg = data.getExtras().getString("word");
//		if(retMsg.length() > 0) {
//			talks.get(requestCode).setLastMessage(retMsg);
//			mba.notifyDataSetChanged();
//		}
//	}
	
	//申请和解除监听广播
	private void registerBroadcastReceiver() {
		IntentFilter it = new IntentFilter();
		it.addAction("TalkMessage");

		this.registerReceiver(bcReceiver, it);
	}
	private void unRegisterBroidcastReceiver() {
		this.unregisterReceiver(bcReceiver);
	}

//	@Override
//	protected void onStart() {
//		// TODO Auto-generated method stub
//		super.onStart();
//		Log.i("live", "start");
//	}
//	@Override
//	protected void onRestart() {
//		// TODO Auto-generated method stub
//		super.onRestart();
//		Log.i("live", "restart");
//	}
//	@Override
//	protected void onResume() {
//		// TODO Auto-generated method stub
//		super.onResume();
//		Log.i("live", "resume");
//	}
//	@Override
//	protected void onPause() {
//		// TODO Auto-generated method stub
//		super.onPause();
//		Log.i("live", "pause");
//	}
//	@Override
//	protected void onStop() {
//		// TODO Auto-generated method stub
//		super.onStop();
//		Log.i("live", "stop");
//	}
//	@Override
//	protected void onDestroy() {
//		// TODO Auto-generated method stub
//		super.onDestroy();
//		Log.i("live", "destory");
//	}
//	public void clickToSee(View v) {
//		// TODO Auto-generated method stub
////				((TextView)v).setText("XXXX");;
//	}

//	public void jump2Login(View v) {
//		Intent it = new Intent();
//		it.setClass(TalkList.this, Login.class);
//		TalkList.this.startActivity(it);
//	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				unRegisterBroidcastReceiver();
				ObjectOutputStream oos;
				try {
					oos = new ObjectOutputStream(new FileOutputStream(path));
					oos.writeObject(talks);
//					Log.i("talks2file", "save success");
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		super.finish();
	}
	
	private void init() {
		talksLV = (ListView)findViewById(R.id.talksLV);
		srcPath = TalkList.this.getFilesDir().getPath();
		path = srcPath+File.separator+"talklist.ls";
	}
	private void setTalkList() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
//					//向UI线程发送Message
//					Message ms = new Message();
//					ms.arg1 = 22;
//					hd.sendMessage(ms);

//					Log.i("talks2file", "start");
					if(!(new File(path).exists())) {
						Random rd = new Random();
						talks = new ArrayList<TalkData>();
						for(int i = 0; i < 100; ++i) {
							//保证ID唯一
							Long id = rd.nextLong();
							for(Iterator<TalkData> it = talks.iterator(); it.hasNext(); ) {
								if(id == it.next().getUserId()) {
									id = rd.nextLong();
									it = talks.iterator();
								}
							}
							talks.add(new TalkData(id, rd.nextLong(), null,
								0, "Name:"+i, "M:"+i, Math.abs(rd.nextInt()%120)));
						}
				
//						Log.i("talks2file", "has not file");
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
						oos.writeObject(talks);
//						Log.i("talks2file", "success");
						oos.close();
					}
					else {
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
						Object tempO = ois.readObject();
						if(tempO instanceof List<?>) {
							List<?> tempL = (List<?>) tempO;
							if(tempL.size()>0
									&& tempL.get(0) instanceof TalkData)
							talks = (List<TalkData>)tempO;
						}
						ois.close();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
//					Log.i("talks2file", "file not found error");
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
//					Log.i("talks2file", "io error");
					e1.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				mba = new TalkListBaseAdapter(talks, TalkList.this);
				talksLV.setAdapter(mba);
			}
		}).start();

		talksLV.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, final View view, final int position, long id) {
				// TODO Auto-generated method stub
//		//解除绑定服务
//		Intent its = new Intent();
//		its.setClass(TalkList.this, MyService.class);
//		unbindService(mServiceConnection);
//		//解除绑定服务
//		Intent its = new Intent();
//		its.setClass(TalkList.this, MyService.class);
//		stopService(its);
				
				ObjectAnimator oa = ObjectAnimator.ofFloat(view, "scaleX", 1, 1.5f, 1);
				oa.setDuration(618);
				oa.start();
		//
				ObjectAnimator oa0 = ObjectAnimator.ofFloat(view, "scaleY", 1, 1.5f, 1);
				oa0.setDuration(618);
				oa0.start();
				
		//		talks.get(20).setUserName("FFFFFFFF");
		//		mba.UpdateView(20);
		//		mba.notifyDataSetChanged();
				
		//		mba = new TalkListBaseAdapter(talks, TalkList.this);
		//		talksLV.setAdapter(mba);
		//		talksLV.notify();
				
				final long userID = ((OneTalkViewContent)view.getTag()).userID;
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						for(Iterator<TalkData>it = talks.iterator(); it.hasNext(); ) {
							TalkData temp = it.next();
							if(temp.getUserId() == userID) {
								temp.setMessageNum(0);
								break;
							}
						}

						talksLV.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								mba.notifyDataSetChanged();
							}
						});
						try {
							Thread.sleep(618);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						registerBroadcastReceiver();
						
						Intent it = new Intent();
						it.setClass(TalkList.this, Talk.class);
						it.putExtra("userID", userID);
						it.putExtra("path", TalkList.this.srcPath);
						TalkList.this.startActivity(it);
					}
				}).start();
			}
		});
	}
}
