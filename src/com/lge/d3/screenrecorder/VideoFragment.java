package com.lge.d3.screenrecorder;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

@SuppressLint("ValidFragment")
public class VideoFragment extends Fragment {
		private Context mContext;
		private Button mBtnRec;
		private Button mBtnStop;
		private List<String> mVideos;
		private ListView mVideoListView;
		private ScrollView mVideoScrollView;
		private boolean mIsVideoInDir;
		
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
			mVideoListView = (ListView) view.findViewById(R.id.video_listview);
			mVideoScrollView = (ScrollView) view.findViewById(R.id.video_scrollview);
			mVideos = new ArrayList<String>();
			
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
			
			mVideoListView.setOnTouchListener(new OnTouchListener() {
				public boolean onTouch(View v, MotionEvent event) {
					mVideoListView.requestDisallowInterceptTouchEvent(true);
					return false;
				}

			});
			
	    	return view;
		}
		@Override
		public void onResume() {
			super.onResume();
			scanVideo();
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
			mVideos.clear();
			mIsVideoInDir = false;
			File file = new File(Configs.VIDEO_FILES_DIR);
			if (!file.exists()) {
				file.mkdirs();
			}
			
			File[] files = file.listFiles(new FilenameFilter() {
				@SuppressLint("DefaultLocale")
				@Override
				public boolean accept(File dir, String filename) {
					return filename.toLowerCase().endsWith(".mp4");
				}
			});

			if (files != null) {
				mIsVideoInDir = true;
				for (File f : files) {
					mVideos.add(Configs.VIDEO_FILES_DIR + f.getName());
				}
				Collections.sort(mVideos);
			} else {
				mVideos.add("No video found");
			}
			
			ArrayAdapter<String> fileListAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mVideos);
			mVideoListView.setAdapter(fileListAdapter);
		}
}