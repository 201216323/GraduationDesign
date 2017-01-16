package com.example.androidannotationtesttwo.activity;

import com.example.androidannotationtesttwo.R;
import com.example.androidannotationtesttwo.util.MyConfig;
import com.example.androidannotationtesttwo.util.SharedPreferencesHelper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

/**
 * 实现每次启动软件显示1秒界面，并判断是否是第一次运行，是否要开启引导页。
 * @author 常灿光
 */
public class StartActivity extends BaseActivity {
	/** 日志标记 */
	private final String TAG = "StartActivity";
	/** SharedPreferences操作,功能判断是否是首次运行 */
	private SharedPreferencesHelper sph;
	/** 主要功能，跳转到不同的界面 */
	private Handler mHandler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		sph = new SharedPreferencesHelper(StartActivity.this);
		mHandler = new Handler() {
			/**
			 * 0：跳转到用户首页；1：跳转到引导页。
			 */
			public void handleMessage(android.os.Message msg) {
				super.handleMessage(msg);
				Log.i(TAG, "==handleMessage(),msg=" + msg);
				switch (msg.what) {
				case 0:
					goActivity(TestActivity.class);
					break;
				case 1:
					goActivity(TestActivity.class);
					break;
				}
			};
		};
		int isFirst = sph.getInt(MyConfig.IS_FIRST_RUN);// 由key
														// isFirstRun来取出值，进而判断是否是第一次启动
		if (isFirst == MyConfig.NOT_FIRST) {// NOT_FIRST 的值是1
			mHandler.sendEmptyMessageDelayed(0, 1000);// 使用Handler来判断程序应该跳转到哪个页面。不是第一次启动就没有引导页了
		} else {
			mHandler.sendEmptyMessageDelayed(1, 1000);
		}

	}

	/**
	 * 路转到某个Activity，不用多次重复写Intent的跳转
	 */
	protected void goActivity(Class<?> cls) {
		Log.i(TAG, "==goActivity()");
		Intent intent = new Intent(this, cls);
		startActivity(intent);
		this.finish();
	}

}
