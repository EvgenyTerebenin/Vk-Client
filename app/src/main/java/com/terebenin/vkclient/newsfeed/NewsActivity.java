package com.terebenin.vkclient.newsfeed;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.terebenin.vkclient.R;
import com.terebenin.vkclient.adapter.RecyclerViewAdapter;
import com.terebenin.vkclient.models.newsItem.Group;
import com.terebenin.vkclient.models.newsItem.Item;
import com.terebenin.vkclient.models.newsItem.Profile;
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

    //    private SwipeRefreshLayout swipeContainer;
    private Subscription mItemsSubscription;
    private static final String LOG_TAG = "LOG_TAG";
    static final String TYPE_PHOTO = "photo";
    @BindView(R.id.uiRecyclerView) RecyclerView recyclerView;
    @BindView(R.id.swipeContainer) SwipeRefreshLayout swipeContainer;
    RecyclerViewAdapter rvAdapter;
    String token;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_news);
        ButterKnife.bind(this);

        swipeContainer.setOnRefreshListener(() -> fetchItemsFromWeb());
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        token = VKAccessToken.currentToken().accessToken;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);


        int databaseItemCount = new Select().from(Item.class).execute().size();
        if (databaseItemCount != 0) {
            rvAdapter = new RecyclerViewAdapter(getItemsFromDB(), NewsActivity.this);
            recyclerView.setAdapter(rvAdapter);
            fetchItemsFromWeb();
        } else {
            fetchItemsFromWeb();
        }

    }


    public void fetchItemsFromWeb() {
        mItemsSubscription = RetrofitSingleton.getInstance().getRequest().getResponseHolder("post", 100, token, 5.62)
                .map(responseHolder -> getSortResponseOnlyWIthPhoto(responseHolder.getResponse()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Response>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(NewsActivity.this, R.string.cant_receive_data, Toast.LENGTH_SHORT).show();
                        swipeContainer.setRefreshing(false);
                        Log.e(LOG_TAG, e.getMessage());
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Response response) {
                        new Delete().from(Item.class).execute();
                        new Delete().from(Group.class).execute();
                        new Delete().from(Profile.class).execute();
                        saveEachItemToDB(response);
                        rvAdapter = new RecyclerViewAdapter(response, NewsActivity.this);
                        rvAdapter.notifyDataSetChanged();
                        recyclerView.setAdapter(rvAdapter);
                        Toast.makeText(NewsActivity.this, "Saved to DB " + new Select().from(Item.class).execute().size() + " items", Toast.LENGTH_SHORT).show();
                        swipeContainer.setRefreshing(false);
                    }
                });

    }

    private Response getItemsFromDB() {
        Response responseDB = new Response();
        responseDB.setItems(getItemList());
        responseDB.setGroups(getGroupList());
        responseDB.setProfiles(getProfileList());
        return responseDB;
    }

    public static List<Item> getItemList() {
        return new Select()
                .from(Item.class)
                .execute();
    }

    public static List<Group> getGroupList() {
        return new Select()
                .from(Group.class)
                .execute();
    }

    public static List<Profile> getProfileList() {
        return new Select()
                .from(Profile.class)
                .execute();
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

    public void saveEachItemToDB(Response response) {

        ActiveAndroid.beginTransaction();
        try {

            for (int i = 0; i < response.getItems().size(); i++) {
                Item item = response.getItems().get(i);
                item.save();
            }
            for (int i = 0; i < response.getGroups().size(); i++) {
                Group group = response.getGroups().get(i);
                group.save();
            }
            for (int i = 0; i < response.getProfiles().size(); i++) {
                Profile profile = response.getProfiles().get(i);
                profile.save();
            }

            ActiveAndroid.setTransactionSuccessful();
        } finally {
            ActiveAndroid.endTransaction();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        mItemsSubscription.unsubscribe();
    }
}
