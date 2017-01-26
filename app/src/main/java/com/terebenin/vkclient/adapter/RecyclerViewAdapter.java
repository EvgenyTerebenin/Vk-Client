package com.terebenin.vkclient.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terebenin.vkclient.R;

/**
 * Created by evgeny on 25.01.17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<NewsItemHolder> {
    @Override
    public NewsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.id.ui, parent, false);
        NewsItemHolder newsitemHolder = new NewsItemHolder(v);
        return newsitemHolder;
        return null;
    }

    @Override
    public void onBindViewHolder(NewsItemHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
