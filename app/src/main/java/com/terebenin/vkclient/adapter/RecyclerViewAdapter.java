package com.terebenin.vkclient.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.models.newsItem.GroupsBean;
import com.terebenin.vkclient.models.newsItem.ItemsBean;
import com.terebenin.vkclient.models.newsItem.ProfilesBean;
import com.terebenin.vkclient.models.newsItem.ResponseBean;

import java.util.List;

/**
 * Created by evgeny on 25.01.17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<NewsItemHolder> {

    ResponseBean mResponseBean;
    List<ItemsBean> mItemsBeanList;
    List<ProfilesBean> mProfilesBeanList;
    List<GroupsBean> mGroupsBeanList;
    Context mContext;

    public RecyclerViewAdapter(ResponseBean responseBean, List<ItemsBean> itemsBeanList, List<ProfilesBean> profilesBeanList, List<GroupsBean> groupsBeanList, Context context) {
        mResponseBean = responseBean;
        mItemsBeanList = itemsBeanList;
        mProfilesBeanList = profilesBeanList;
        mGroupsBeanList = groupsBeanList;
        mContext = context;
    }

    @Override
    public NewsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_newsitem, parent, false);
        return new NewsItemHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsItemHolder holder, int position) {
//        Resources res = mContext.getResources();
        if ((mResponseBean.getItems().get(position).getSource_id()) < 0) {
            holder.tvPostOwner.setText((mGroupsBeanList.get(position).getName()));
            holder.ivPostAvatar.setImageURI(Uri.parse(mGroupsBeanList.get(position).getPhoto_200()));
        } else {
            holder.tvPostOwner.setText((mProfilesBeanList.get(position).getFirst_name() + mResponseBean.getProfiles().get(position).getLast_name()));
            holder.ivPostAvatar.setImageURI(Uri.parse(mProfilesBeanList.get(position).getPhoto_100()));
        }
        holder.tvPostText.setText(mItemsBeanList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mItemsBeanList.size();
    }
}
