package com.terebenin.vkclient.newsfeed;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.adapter.RecyclerViewAdapter;
import com.terebenin.vkclient.models.newsItem.GroupsBean;
import com.terebenin.vkclient.models.newsItem.ItemsBean;
import com.terebenin.vkclient.models.newsItem.ProfilesBean;
import com.terebenin.vkclient.models.newsItem.ResponseBean;
import com.terebenin.vkclient.rest.RetrofitSingleton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by evgeny on 25.01.17.
 */

public class NewsActivity extends AppCompatActivity {

    private static final String LOG_TAG = "LOG_TAG";
    @BindView(R.id.uiRecyclerView) RecyclerView recyclerView;
    RecyclerViewAdapter rvAdapter;
    ProgressDialog progressDialog;
    private Subscription mItemsSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news);
        ButterKnife.bind(this);


        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);
//
//        progressDialog = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
//        progressDialog.setTitle(getString(R.string.progDialTitle));
//        progressDialog.setMessage(getString(R.string.progDialMsg));
//        progressDialog.setIndeterminate(true);

        mItemsSubscription = RetrofitSingleton.getInstance().getRequest().getResponseBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(progressDialog::show)
                .doAfterTerminate(progressDialog::dismiss)
                .subscribe(new Subscriber<ResponseBean>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(LOG_TAG, e.getMessage());
//                        showDialog();
                    }

                    @Override
                    public void onNext(ResponseBean responseBean, List<ItemsBean> itemsBeanList, List<ProfilesBean> profilesBeanList, List<GroupsBean> groupsBeanList, Context context) {
                        rvAdapter = new RecyclerViewAdapter(responseBean, itemsBeanList, profilesBeanList, groupsBeanList, NewsActivity.this);
                        recyclerView.setAdapter(rvAdapter);
//                        rvAdapter.setListener((int position) -> {
//                            Intent intent = new Intent(MainActivity.this, ItemActivity.class);
//                            intent.putExtra(Intent.EXTRA_UID, items.get(position).getId());
//                            startActivity(intent);
//                        });
                    }
                });
    }
}
