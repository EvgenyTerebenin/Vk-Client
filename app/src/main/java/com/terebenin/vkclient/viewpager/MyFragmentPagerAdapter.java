package com.terebenin.vkclient.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.terebenin.vkclient.models.newsItem.Photo;

import java.util.ArrayList;

/**
 * Created by evgeny on 16.02.17.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Photo> photos;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Photo> photos) {
        super(fm);
        this.photos = photos;
    }

    @Override
    public Fragment getItem(int position) {
        return PhotoItemFragment.newInstance(photos.get(position).getPhoto_604());
    }


    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + position;
    }

}