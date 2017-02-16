package com.terebenin.vkclient.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import static com.terebenin.vkclient.adapter.RecyclerViewAdapter.EXTRA_PHOTOLIST;

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
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + position;
    }

}