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
import com.terebenin.vkclient.models.newsItem.Groups;
import com.terebenin.vkclient.models.newsItem.Items;
import com.terebenin.vkclient.models.newsItem.Profiles;
import com.terebenin.vkclient.models.newsItem.Response;

import java.util.List;

/**
 * Created by evgeny on 25.01.17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<NewsItemHolder> {

    Context mContext;
    int itemSourceId;
    String itemText;

    List<Items> itemsList;
    List<Groups> groupsList;
    List<Profiles> profilesList;


    public RecyclerViewAdapter(Response response, Context context) {

        itemsList = response.getItems();
        groupsList = response.getGroups();
        profilesList = response.getProfiles();
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

    private Profiles getProfileById(int itemSourceId, List<Profiles> profilesList) {
        for (int i = 0; i < profilesList.size(); i++) {
            if (itemSourceId == profilesList.get(i).getId()) return profilesList.get(i);
        }
        return null;
    }

    private Groups getGroupById(int itemSourceId, List<Groups> groupsList) {
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
            Groups group = getGroupById(itemSourceId, groupsList);
            holder.tvPostOwner.setText(fromHtml(group.getName()));
            Picasso.with(mContext).load(group.getPhoto_100()).into(holder.ivPostAvatar);
        } else {
            Profiles profile = getProfileById(itemSourceId, profilesList);
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
