package com.example.androidannotationtesttwo.fragment.subfragment;

import com.example.androidannotationtesttwo.R;
import com.example.androidannotationtesttwo.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AAAFragmetn extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.aaa_fragment, null);
		return view;
	}

}