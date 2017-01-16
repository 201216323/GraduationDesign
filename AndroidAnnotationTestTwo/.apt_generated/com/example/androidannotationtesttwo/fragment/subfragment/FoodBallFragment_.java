//
// DO NOT EDIT THIS FILE.Generated using AndroidAnnotations 3.3.2.
//  You can create a larger work that contains this file and distribute that work under terms of your choice.
//


package com.example.androidannotationtesttwo.fragment.subfragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import com.example.androidannotationtesttwo.R.layout;
import com.example.androidannotationtesttwo.adapter.NewAdapter_;
import com.example.androidannotationtesttwo.widget.swiptlistview.SwipeListView;
import org.androidannotations.api.BackgroundExecutor;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class FoodBallFragment_
    extends com.example.androidannotationtesttwo.fragment.subfragment.FoodBallFragment
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private View contentView_;
    private Handler handler_ = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    @Override
    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(layout.fragment_main, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        contentView_ = null;
        super.onDestroyView();
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
        newAdapter = NewAdapter_.getInstance_(getActivity());
        init();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static FoodBallFragment_.FragmentBuilder_ builder() {
        return new FoodBallFragment_.FragmentBuilder_();
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        swipeLayout = ((SwipeRefreshLayout) hasViews.findViewById(com.example.androidannotationtesttwo.R.id.swipe_container));
        mListView = ((SwipeListView) hasViews.findViewById(com.example.androidannotationtesttwo.R.id.listview));
        mProgressBar = ((ProgressBar) hasViews.findViewById(com.example.androidannotationtesttwo.R.id.progressBar));
        if (mListView!= null) {
            mListView.setOnItemClickListener(new OnItemClickListener() {


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    FoodBallFragment_.this.onItemClick(position);
                }

            }
            );
        }
        initView();
    }

    @Override
    public void getResult(final String result) {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                FoodBallFragment_.super.getResult(result);
            }

        }
        );
    }

    @Override
    public void loadNewList(final String url) {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    FoodBallFragment_.super.loadNewList(url);
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<FoodBallFragment_.FragmentBuilder_, com.example.androidannotationtesttwo.fragment.subfragment.FoodBallFragment>
    {


        @Override
        public com.example.androidannotationtesttwo.fragment.subfragment.FoodBallFragment build() {
            FoodBallFragment_ fragment_ = new FoodBallFragment_();
            fragment_.setArguments(args);
            return fragment_;
        }

    }

}
