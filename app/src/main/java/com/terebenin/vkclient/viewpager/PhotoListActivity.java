package com.terebenin.vkclient.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.models.newsItem.Photo;

import java.util.ArrayList;

import static com.terebenin.vkclient.adapter.RecyclerViewAdapter.EXTRA_PHOTOLIST;
import static com.terebenin.vkclient.adapter.RecyclerViewAdapter.EXTRA_POSITION;

/**
 * Created by evgeny on 15.02.17.
 */

public class PhotoListActivity extends FragmentActivity {

    static final String TAG = "myLogs";
    static final int PAGE_COUNT = 10;

    ViewPager pager;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_viewpager);
        Bundle bundle = getIntent().getExtras();
        ArrayList<Photo> photos = bundle.getParcelableArrayList(EXTRA_PHOTOLIST);
        int position = bundle.getInt(EXTRA_POSITION);

        pager = (ViewPager) findViewById(R.id.uiViewPager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }


}
//
//    @BindView(R.id.uiImageViewPhotoItem) ImageView ivPhotoItem;
//    @BindView(R.id.uiViewPager) ViewPager viewPager;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout_viewpager);
//        ButterKnife.bind(this, viewPager);
//        Bundle bundle = getIntent().getExtras();
//        String EXTRA_PHOTOLIST = bundle.getString("EXTRA_PHOTOLIST");
//        Toast.makeText(this, EXTRA_PHOTOLIST, Toast.LENGTH_SHORT).show();
//        Picasso.with(getApplicationContext()).load(EXTRA_PHOTOLIST).into(ivPhotoItem);
//    }


