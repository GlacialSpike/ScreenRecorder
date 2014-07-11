package com.lge.d3.screenrecorder;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("ValidFragment")
public class VideoFragment extends Fragment {
		private Context mContext;
		private Button mBtnRec;
		private Button mBtnStop;
		private List<String> mVideos;
		
		public VideoFragment() {
		}
		
		public VideoFragment(Context context) {
			mContext = context;
		}
		
		@SuppressLint("InflateParams")
		@Override
		public View onCreateView(LayoutInflater inflater, 
				ViewGroup container, Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.activity_tab1, null);
			
			mBtnRec = (Button) view.findViewById(R.id.btn1);
			mBtnStop = (Button) view.findViewById(R.id.btn2);
			
			mBtnRec.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// mContext = getActivity().getApplicationContext();
					RecRunnable.RECORD = true;					
					mBtnRec.setEnabled(false);
					mBtnStop.setEnabled(true);
					getActivity().startService(new Intent(getActivity(), com.lge.d3.screenrecorder.RecordService.class));
				}
			});
			
			mBtnStop.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					mBtnRec.setEnabled(true);
					mBtnStop.setEnabled(false);
					getActivity().stopService(new Intent(getActivity(), com.lge.d3.screenrecorder.RecordService.class));
				}
			});
			
	    	return view;
		}
		
		void startRecordService() {
			
		}

		void stopRecordService() {
			
		}
		
		@Override
		public void onDestroy() {
			getActivity().stopService(new Intent(getActivity(), com.lge.d3.screenrecorder.RecordService.class));
			super.onDestroy();
		}

		void scanVideo() {
			
		}

}