package com.terebenin.vkclient.adapter;

import android.content.Context;
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
    private Context mContext;
    List<Photo> photosList;

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
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(130, 150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 4, 4, 0);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext).load(photosList.get(position).getPhoto_130()).into(imageView);
        return imageView;
    }

}
