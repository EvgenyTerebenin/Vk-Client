package com.terebenin.vkclient.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.models.newsItem.ItemsBean;
import com.terebenin.vkclient.models.newsItem.ResponseBean;
import com.terebenin.vkclient.models.newsItem.ResponseHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by evgeny on 25.01.17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<NewsItemHolder> {

    private static final String LOG_SIZE = "LOG_SIZE";
    ResponseBean mResponseBean;
    Context mContext;
    List<ItemsBean> items;
//    ResponseHolder responseHolder;

    public RecyclerViewAdapter(ResponseBean responseBean, Context context) {
        mResponseBean = responseBean;
        mContext = context;
        items = mResponseBean.getItems();


    }

    @Override
    public NewsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_newsitem, parent, false);
        return new NewsItemHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsItemHolder holder, int position) {
        if ((mResponseBean.getItems().get(position).getSource_id()) < 0) {
            holder.tvPostOwner.setText((mResponseBean.getGroups().get(position).getName()));
//            holder.ivPostAvatar.setImageURI(Uri.parse(mResponseBean.getGroups().get(position).getPhoto_200()));
        } else {
            holder.tvPostOwner.setText((String.format("%s %s", mResponseBean.getProfiles().get(position).getFirst_name(), mResponseBean.getProfiles().get(position).getLast_name())));
//            holder.ivPostAvatar.setImageURI(Uri.parse(mResponseBean.getProfiles().get(position).getPhoto_100()));
        }
        holder.tvPostText.setText(mResponseBean.getItems().get(position).getText());
    }

    @Override
    public int getItemCount() {
        Log.d(LOG_SIZE, String.valueOf(items.size()));
        return mResponseBean.getItems().size();
    }
}
