//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package com.example.androidannotationtesttwo.adapter;

import android.content.Context;

public final class VideoAdapter_
    extends VideoAdapter
{

    private Context context_;

    private VideoAdapter_(Context context) {
        context_ = context;
        init_();
    }

    public static VideoAdapter_ getInstance_(Context context) {
        return new VideoAdapter_(context);
    }

    private void init_() {
        context = context_;
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

}