package com.terebenin.vkclient.newsfeed;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.adapter.RecyclerViewAdapter;
import com.terebenin.vkclient.models.newsItem.Item;
import com.terebenin.vkclient.models.newsItem.Response;
import com.terebenin.vkclient.models.newsItem.ResponseHolder;
import com.terebenin.vkclient.rest.RetrofitSingleton;
import com.vk.sdk.VKAccessToken;

import java.util.ArrayList;
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
    static final String TYPE_PHOTO = "photo";

    @BindView(R.id.uiRecyclerView) RecyclerView recyclerView;
    RecyclerViewAdapter rvAdapter;
    ProgressDialog progressDialog;
    private Subscription mItemsSubscription;
    String token;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news);
        ButterKnife.bind(this);
        token = VKAccessToken.currentToken().accessToken;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);

        progressDialog = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle(getString(R.string.progDialTitle));
        progressDialog.setMessage(getString(R.string.progDialMsg));
        progressDialog.setIndeterminate(true);

        mItemsSubscription = RetrofitSingleton.getInstance().getRequest().getResponseHolder("post", 100, token, 5.62)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(progressDialog::show)
                .doAfterTerminate(progressDialog::dismiss)
                .subscribe(new Subscriber<ResponseHolder>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(LOG_TAG, e.getMessage());
                    }


                    @Override
                    public void onNext(ResponseHolder responseHolder) {
                        rvAdapter = new RecyclerViewAdapter(getSortResponseOnlyWIthPhoto(responseHolder.getResponse()), NewsActivity.this);
                        recyclerView.setAdapter(rvAdapter);
                    }
                });
    }

    public Response getSortResponseOnlyWIthPhoto(Response response) {
        List<Item> itemList = response.getItems();
        List<Item> itemListOnlyWithPhoto = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getAttachments() != null) {
                for (int j = 0; j < itemList.get(i).getAttachments().size(); j++) {
                    if (itemList.get(i).getAttachments().get(j).getType().equals(TYPE_PHOTO)) {
                        itemListOnlyWithPhoto.add(itemList.get(i));
                        break;
                    }
                }
            }
        }
        response.setItems(itemListOnlyWithPhoto);
        return response;
    }


    @Override
    protected void onStop() {
        super.onStop();
        mItemsSubscription.unsubscribe();
    }
}
