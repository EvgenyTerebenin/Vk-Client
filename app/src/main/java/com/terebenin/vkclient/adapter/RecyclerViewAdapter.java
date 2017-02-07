package com.terebenin.vkclient.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.terebenin.vkclient.R;
import com.terebenin.vkclient.models.newsItem.Group;
import com.terebenin.vkclient.models.newsItem.Item;
import com.terebenin.vkclient.models.newsItem.Profile;
import com.terebenin.vkclient.models.newsItem.Response;

import java.util.List;

/**
 * Created by evgeny on 25.01.17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<NewsItemHolder> {

    Context mContext;
    int itemSourceId;
    String itemText;

    List<Item> mItemList;
    List<Group> mGroupList;
    List<Profile> mProfileList;


    public RecyclerViewAdapter(Response response, Context context) {

        mItemList = response.getItems();
        mGroupList = response.getGroups();
        mProfileList = response.getProfiles();
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

    private Profile getProfileById(int itemSourceId, List<Profile> profileList) {
        for (int i = 0; i < profileList.size(); i++) {
            if (itemSourceId == profileList.get(i).getId()) return profileList.get(i);
        }
        return null;
    }

    private Group getGroupById(int itemSourceId, List<Group> groupList) {
        for (int i = 0; i < groupList.size(); i++) {
            if (Math.abs(itemSourceId) == groupList.get(i).getId()) return groupList.get(i);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(NewsItemHolder holder, int position) {

        itemSourceId = mItemList.get(position).getSource_id();
        itemText = mItemList.get(position).getText();

        if (itemSourceId < 0) {
            Group group = getGroupById(itemSourceId, mGroupList);
            holder.tvPostOwner.setText(fromHtml(group.getName()));
            Picasso.with(mContext).load(group.getPhoto_100()).into(holder.ivPostAvatar);
        } else {
            Profile profile = getProfileById(itemSourceId, mProfileList);
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
        return mItemList.size();
    }
}
