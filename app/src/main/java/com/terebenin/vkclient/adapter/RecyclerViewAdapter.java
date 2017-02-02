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
import com.terebenin.vkclient.models.newsItem.ItemsBean;
import com.terebenin.vkclient.models.newsItem.ResponseBean;

import java.util.List;

/**
 * Created by evgeny on 25.01.17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<NewsItemHolder> {

    private static final String LOG_SIZE = "LOG_SIZE";
    ResponseBean mResponseBean;
    Context mContext;
    List<ItemsBean> items;

    int currentPosition;

    String itemText;
    int itemSourceId;

    int groupId;
    String groupName;
    String groupPhoto100;

    String profileFirstName;
    String profileLastName;


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


    @Override
    public void onBindViewHolder(NewsItemHolder holder, int position) {

        currentPosition = position;
        itemSourceId = mResponseBean.getItems().get(position).getSource_id();
        itemText = mResponseBean.getItems().get(position).getText();
        groupId = mResponseBean.getGroups().get(position).getId();
        groupName = mResponseBean.getGroups().get(position).getName();
        groupPhoto100 = mResponseBean.getGroups().get(position).getPhoto_100();
        profileFirstName = mResponseBean.getProfiles().get(position).getFirst_name();
        profileLastName = mResponseBean.getProfiles().get(position).getLast_name();

        if ((itemSourceId) < 0) {
            holder.tvPostOwner.setText(fromHtml(groupName));

//            *********************************************
            if (itemSourceId * (-1) == groupId) {
                Picasso.with(mContext).load(groupPhoto100).into(holder.ivPostAvatar);
            } else {

                for (int i = 0; i < 100; i++) {
                    if (itemSourceId == groupId) {
                        position = currentPosition;
                        Picasso.with(mContext).load(groupPhoto100).into(holder.ivPostAvatar);
                    }
                }

            }
//            *********************************************

        } else {
            holder.tvPostOwner.setText(fromHtml(String.format("%s %s", profileFirstName,
                    profileLastName)));
//            Picasso.with(mContext).load(mResponseBean.getProfiles().get(position).getPhoto_100()).into(holder.ivPostAvatar);
        }

        if (itemText != null) {
            holder.tvPostText.setText(fromHtml(itemText));
        } else {
            holder.tvPostText.setText(R.string.text_null);
        }
    }

    @Override
    public int getItemCount() {
        Log.d(LOG_SIZE, String.valueOf(items.size()));
        return mResponseBean.getItems().size();
    }
}
