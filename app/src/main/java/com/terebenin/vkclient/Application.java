package com.terebenin.vkclient;

import android.content.Intent;

import com.terebenin.vkclient.login.LoginActivity;
import com.terebenin.vkclient.models.newsItem.DaoMaster;
import com.terebenin.vkclient.models.newsItem.DaoSession;
import com.terebenin.vkclient.models.newsItem.PhotoDao;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.internal.DaoConfig;

public class Application extends android.app.Application {

    VKAccessTokenTracker vkAccessTokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Intent intent = new Intent(Application.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "items-db", null);
        Database db = helper.getWritableDb();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession  = daoMaster.newSession();
        PhotoDao photoDao = daoSession.getPhotoDao();
        vkAccessTokenTracker.startTracking();
        VKSdk.initialize(this);
    }
}