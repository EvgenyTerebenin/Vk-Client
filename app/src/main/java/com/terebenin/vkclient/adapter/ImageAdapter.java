package com.terebenin.vkclient.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.terebenin.vkclient.models.newsItem.Photo;

import java.util.List;

/**
 * Created by evgeny on 08.02.17.
 */

public class ImageAdapter extends BaseAdapter {
    Context mContext;
    List<Photo> photosList;
    private static final float GESTURE_THRESHOLD_DP = 150.0f;

    public ImageAdapter(Context c, List<Photo> photosList) {
        mContext = c;
        this.photosList = photosList;
    }

    @Override
    public int getCount() {
        return photosList.size();
    }

    @Override
    public Object getItem(int position) {
        return photosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return photosList.get(position).getId();
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the screen's density scale
        final float scale = mContext.getResources().getDisplayMetrics().density;
// Convert the dps to pixels, based on density scale
        int mGestureThreshold = (int) (GESTURE_THRESHOLD_DP * scale + 0.5f);

        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mGestureThreshold));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext).load(photosList.get(position).getPhoto_130()).into(imageView);
        return imageView;
    }

}
