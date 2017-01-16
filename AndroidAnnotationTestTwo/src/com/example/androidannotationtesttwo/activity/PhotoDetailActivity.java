package com.example.androidannotationtesttwo.activity;

import java.util.List;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import com.example.androidannotationtesttwo.R;
import com.example.androidannotationtesttwo.adapter.PhotoDetailAdapter;
import com.example.androidannotationtesttwo.bean.PhotoDetailModle;
import com.example.androidannotationtesttwo.http.HttpUtil;
import com.example.androidannotationtesttwo.util.SplitNetStringUtils;
import com.example.androidannotationtesttwo.util.StringUtils;
import com.example.androidannotationtesttwo.widget.flipview.FlipView;
import com.example.androidannotationtesttwo.widget.flipview.FlipView.OnFlipListener;
import com.example.androidannotationtesttwo.widget.flipview.FlipView.OnOverFlipListener;
import com.example.androidannotationtesttwo.widget.flipview.OverFlipMode;


@EActivity(R.layout.activity_photo)
public class PhotoDetailActivity extends BaseActivity implements OnFlipListener,
        OnOverFlipListener {
    @ViewById(R.id.flip_view)
    protected FlipView mFlipView;

    @Bean
    protected PhotoDetailAdapter photoDetailAdapter;

    private String imgUrl;

    @AfterInject
    public void init() {
        try {
            if (getIntent().getExtras().getString("photoUrl") != null) {
                imgUrl = getIntent().getExtras().getString("photoUrl");
                showProgressDialog();
                loadData(imgUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterViews
    public void initView() {
        // imageAdapter.appendList(imgList);
        try {
            mFlipView.setOnFlipListener(this);
            mFlipView.setAdapter(photoDetailAdapter);
            mFlipView.peakNext(false);
            mFlipView.setOverFlipMode(OverFlipMode.RUBBER_BAND);
            mFlipView.setOnOverFlipListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadData(String url) {
        if (hasNetWork()) {
            loadPhotoList(url);
        } else {
            dismissProgressDialog();
            showShortToast(getString(R.string.not_network));
            String result = getCacheStr(imgUrl);
            if (!StringUtils.isEmpty(result)) {
                getResult(result);
            }
        }
    }

    @Background
    void loadPhotoList(String url) {
        String result;
        try {
            result = HttpUtil.getByHttpClient(this, url);
            getResult(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @UiThread
    public void getResult(String result) {
        setCacheStr(imgUrl, result);
        dismissProgressDialog();
        try {
            List<PhotoDetailModle> list = SplitNetStringUtils.getPhotoDetailModles(result);
            photoDetailAdapter.appendList(list);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onOverFlip(FlipView v, OverFlipMode mode, boolean overFlippingPrevious,
            float overFlipDistance, float flipDistancePerPage) {

    }

    @Override
    public void onFlippedToPage(FlipView v, int position, long id) {

    }

    @Override
    public void onResume() {
        super.onResume();
//        MobclickAgent.onResume(this);
    }

    @Override
    public void onPause() {
        super.onPause();
//        MobclickAgent.onPause(this);
    }
}