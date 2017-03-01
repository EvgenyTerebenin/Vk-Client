package com.terebenin.vkclient.viewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.models.newsItem.Photo;

import java.util.ArrayList;

/**
 * Created by evgeny on 16.02.17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Photo> photos;
    Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Photo> photos, Context context) {
        super(fm);
        this.photos = photos;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return PhotoItemFragment.newInstance(photos.get(position).getPhoto604());
    }


    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(R.string.page_title) + position;
    }

}