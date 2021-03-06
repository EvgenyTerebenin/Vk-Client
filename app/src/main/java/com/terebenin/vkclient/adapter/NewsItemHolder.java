package com.terebenin.vkclient.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.newsfeed.MyGridView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsItemHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.uiCardView) CardView cardView;
    @BindView(R.id.uiImagePostAvatar) ImageView ivPostAvatar;
    @BindView(R.id.uiTextPostOwner) TextView tvPostOwner;
    @BindView(R.id.uiTextPostText) TextView tvPostText;
    @BindView(R.id.uiGridViewPhoto) MyGridView gvPhoto;

    public NewsItemHolder(View newsItemView) {
        super(newsItemView);
        ButterKnife.bind(this, newsItemView);


    }

}
