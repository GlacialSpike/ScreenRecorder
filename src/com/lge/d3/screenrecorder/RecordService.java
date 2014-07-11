package com.lge.d3.screenrecorder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

public class RecordService extends Service {
	private String mFileName;
	private RecRunnable mRecRunnable = new RecRunnable();
	private TextView mRecView;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		Log.d("RecordService", "***** RecordService : start");
		startRecording();
		super.onCreate();
	}
	@Override
	public void onDestroy() {
		Log.d("RecordService", "***** RecordService : destroy");
		RecRunnable.RECORD = false;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		super.onDestroy();
	}
	
	public void startRecording() {
		setShowTouch(true);
		new Thread(mRecRunnable).start();
	}
	
	public void stopRecording() {
		setShowTouch(false);
	}
	
	public void setShowTouch(boolean isEnable) {
		
	}
	
	public void generateFileNameByTime() {
		mFileName = "";
	}
}
