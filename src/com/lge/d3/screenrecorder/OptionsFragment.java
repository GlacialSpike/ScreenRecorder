package com.lge.d3.screenrecorder;

import com.lge.d3.screenrecorder.R;
import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class OptionsFragment extends Fragment {
		private Context mContext;
		private int mResolutionWidth;
		private int mResolutionHeight;
		private int mBitRate;
		private int mTimeLimit;
		
		public OptionsFragment() {
		}
		public OptionsFragment(Context context) {
			mContext = context;
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, 
				ViewGroup container, Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.activity_tab2, null);
			
	    	return view;
		}
		public Context getmContext() {
			return mContext;
		}
		public void setmContext(Context mContext) {
			this.mContext = mContext;
		}
		public int getmResolutionWidth() {
			return mResolutionWidth;
		}
		public void setmResolutionWidth(int mResolutionWidth) {
			this.mResolutionWidth = mResolutionWidth;
		}
		public int getmResolutionHeight() {
			return mResolutionHeight;
		}
		public void setmResolutionHeight(int mResolutionHeight) {
			this.mResolutionHeight = mResolutionHeight;
		}
		public int getmBitRate() {
			return mBitRate;
		}
		public void setmBitRate(int mBitRate) {
			this.mBitRate = mBitRate;
		}
		public int getmTimeLimit() {
			return mTimeLimit;
		}
		public void setmTimeLimit(int mTimeLimit) {
			this.mTimeLimit = mTimeLimit;
		}
}