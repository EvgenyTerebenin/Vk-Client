package com.terebenin.vkclient.viewpager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.models.newsItem.Photo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.terebenin.vkclient.adapter.RecyclerViewAdapter.EXTRA_PHOTOLIST;
import static com.terebenin.vkclient.adapter.RecyclerViewAdapter.EXTRA_POSITION;

/**
 * Created by evgeny on 15.02.17.
 */

public class PhotoListActivity extends FragmentActivity {

    private static final String TAG_SIZE = "TAG_SIZE";
    @BindView(R.id.uiViewPager) ViewPager viewPager;
    PagerAdapter pagerAdapter;

    ArrayList<Photo> photos = null;
    int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);
        ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        photos = bundle.getParcelableArrayList(EXTRA_PHOTOLIST);
        Log.d(TAG_SIZE, String.valueOf(photos.size()));
        position = bundle.getInt(EXTRA_POSITION);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), photos, this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(position);

    }
}

