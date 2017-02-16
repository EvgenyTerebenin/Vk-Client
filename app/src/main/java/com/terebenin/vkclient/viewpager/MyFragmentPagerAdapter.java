package com.terebenin.vkclient.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.terebenin.vkclient.models.newsItem.Photo;

import java.util.ArrayList;

import static com.terebenin.vkclient.viewpager.PhotoListActivity.PAGE_COUNT;

/**
 * Created by evgeny on 16.02.17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PhotoItemFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

}
