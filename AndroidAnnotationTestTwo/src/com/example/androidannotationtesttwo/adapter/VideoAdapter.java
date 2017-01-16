
package com.example.androidannotationtesttwo.adapter;

import java.util.ArrayList;
import java.util.List;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.androidannotationtesttwo.bean.VideoModle;
import com.example.androidannotationtesttwo.view.VideoItemView;
import com.example.androidannotationtesttwo.view.VideoItemView_;

@EBean
public class VideoAdapter extends BaseAdapter {
    public List<VideoModle> lists = new ArrayList<VideoModle>();

    public void appendList(List<VideoModle> list) {
        if (!lists.containsAll(list) && list != null && list.size() > 0) {
            lists.addAll(list);
        }
        notifyDataSetChanged();
    }

    @RootContext
    Context context;

    public void clear() {
        lists.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        VideoItemView videoItemView;

        if (convertView == null) {
            videoItemView = VideoItemView_.build(context);
        } else {
            videoItemView = (VideoItemView) convertView;
        }

        VideoModle videoModle = lists.get(position);
        videoItemView.setData(videoModle);

        return videoItemView;
    }
}
