package com.neu.demofirst;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	
	private MyBinder mBinder = new MyBinder();
	public class MyBinder extends Binder {  
		public MyService getService() {
			Log.i("Service live", "getService");
			 return MyService.this;
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i("Service live", "onDestory");
		super.onDestroy();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i("Service live", "onUnbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i("Service live", "onCreate");
		super.onCreate();
	}

//	@Override
//	public int onStartCommand(Intent intent, int flags, int startId) {
//		// TODO Auto-generated method stub
//		Log.i("Service live", "onStartCommand");
//		return super.onStartCommand(intent, flags, startId);
//	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.i("Service live", "onBind");
		return mBinder;
	}
}
