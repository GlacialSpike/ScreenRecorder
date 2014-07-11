package com.lge.d3.screenrecorder;

import android.util.Log;

public class RecRunnable implements Runnable {

	static public boolean RECORD = true;
	@Override
	public void run() {
		while(RECORD) {
			Log.d("RecRunnable", "***** RecRunnable : run(recording)");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Log.d("RecRunnable", "***** RecRunnable : stop(save and close)");
	}

}
