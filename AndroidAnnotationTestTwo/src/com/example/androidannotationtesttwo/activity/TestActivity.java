package com.example.androidannotationtesttwo.activity;

import com.example.androidannotationtesttwo.R;
import com.example.androidannotationtesttwo.R.id;
import com.example.androidannotationtesttwo.R.layout;
import com.example.androidannotationtesttwo.fragment.Fragment_home_;
import com.example.androidannotationtesttwo.fragment.Fragment_mine;
import com.example.androidannotationtesttwo.fragment.Fragment_topic;
import com.example.androidannotationtesttwo.fragment.Fragment_video;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TestActivity extends BaseActivity {

	Fragment_home_ fragment_home_;
	Fragment_video fragment_video;
	Fragment_topic fragment_topic;
	Fragment_mine fragment_mine;
	RadioGroup mRadioGroup;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup_main);
		mRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.radioButton_home:
					// mViewPager.setCurrentItem(0);
					showFragment(0);
					break;
				case R.id.radioButton_video:
					// mViewPager.setCurrentItem(1);
					showFragment(1);
					break;
				case R.id.radioButton_topic:
					// mViewPager.setCurrentItem(2);
					showFragment(2);
					break;
				case R.id.radioButton_mine:
					// mViewPager.setCurrentItem(3);
					showFragment(3);
					break;
				}
				
			}
		});
		showFragment(0);

	}

	private void showFragment(int index) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction ft = fragmentManager.beginTransaction();
		// ft.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left);
		hideFragment(ft);
		switch (index) {
		case 0:
			if (fragment_home_ != null)
				ft.show(fragment_home_);
			else {
				fragment_home_ = new Fragment_home_();
				ft.add(R.id.framelayout_main, fragment_home_);
			}
			break;
			case 1:
			if (fragment_video != null)
				ft.show(fragment_video);
			else {
				fragment_video = new Fragment_video();
				ft.add(R.id.framelayout_main, fragment_video);
			}
			break;
			case 2:
			if (fragment_topic != null)
				ft.show(fragment_topic);
			else {
				fragment_topic = new Fragment_topic();
				ft.add(R.id.framelayout_main, fragment_topic);
			}
			break;
			case 3:
			if (fragment_mine != null)
				ft.show(fragment_mine);
			else {
				fragment_mine = new Fragment_mine();
				ft.add(R.id.framelayout_main, fragment_mine);
			}
			break;
		}
		ft.commitAllowingStateLoss();
	}

	private void hideFragment(FragmentTransaction ft) {
		if (fragment_home_ != null)
			ft.hide(fragment_home_);
		if (fragment_video != null)
			ft.hide(fragment_video);
		if (fragment_topic != null)
			ft.hide(fragment_topic);
		if (fragment_mine != null)
			ft.hide(fragment_mine);
	}
//	@Override
//	public void onBackPressed() {
//		// TODO Auto-generated method stub
//		super.onBackPressed();
//	}

}
