package com.terebenin.vkclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
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

    private static final String GROUP_ID = "GROUP_ID";
    Context mContext;
    int itemSourceId;
    String itemText;

    List<ItemsBean> itemsList;
    List<GroupsBean> groupsList;
    List<ProfilesBean> profilesList;


    public RecyclerViewAdapter(ResponseBean responseBean, Context context) {

        itemsList = responseBean.getItems();
        groupsList = responseBean.getGroups();
        profilesList = responseBean.getProfiles();
        mContext = context;
    }

    @Override
    public NewsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_newsitem, parent, false);
        return new NewsItemHolder(v);
    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }

    private ProfilesBean getProfileById(int itemSourceId, List<ProfilesBean> profilesList) {
        for (int i = 0; i < profilesList.size(); i++) {
            if (itemSourceId == profilesList.get(i).getId()) return profilesList.get(i);
        }
        return null;
    }

    private GroupsBean getGroupById(int itemSourceId, List<GroupsBean> groupsList) {
        for (int i = 0; i < groupsList.size(); i++) {
            if (Math.abs(itemSourceId) == groupsList.get(i).getId()) return groupsList.get(i);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(NewsItemHolder holder, int position) {

        itemSourceId = itemsList.get(position).getSource_id();
        itemText = itemsList.get(position).getText();

        if (itemSourceId < 0) {
            GroupsBean group = getGroupById(itemSourceId, groupsList);
            holder.tvPostOwner.setText(fromHtml(group.getName()));
            Picasso.with(mContext).load(group.getPhoto_100()).into(holder.ivPostAvatar);
        } else {
            ProfilesBean profile = getProfileById(itemSourceId, profilesList);
            holder.tvPostOwner.setText(fromHtml(String.format("%s %s", profile.getFirst_name(), profile.getLast_name())));
            Picasso.with(mContext).load(profile.getPhoto_100()).into(holder.ivPostAvatar);
        }

        if (itemText != null) {
            holder.tvPostText.setText(fromHtml(itemText));
        } else {
            holder.tvPostText.setText(R.string.text_null);
        }
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
